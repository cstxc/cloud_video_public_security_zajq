package com.zjxc.video.etldata.online.sparkStreaming.operate

import java.sql.{Connection, DriverManager, ResultSet, Statement}

import cn.hutool.core.date.{DateField, DateUtil}
import cn.hutool.core.date.DateUtil.{endOfMonth, rangeToList}

import scala.io.StdIn

/*
*
    *@author    Whoami
    *@description   todo 聚合昨日主题入库条数
    *@date     15:51
    *@param
    *@return

 */

object clear_alarm {
  val connP: Connection = DriverManager.getConnection("jdbc:phoenix:172.18.248.212:2181")
  val stat: Statement = connP.createStatement
  var rs: ResultSet = null

  val arr_topic = Array(
    "faceListMessagePooldb"
    , "imageListMessagePooldb"
    , "personListMessagePooldb"
    , "MotorVehicleListMessagePooldb"
    , "NonMotorVehicleListMessagePooldb"
    , "ThingListMessagePooldb"
    , "SceneListMessagePooldb"
    , "FileListMessagePooldb"
    , "VideoSliceListMessagePooldb"
    , "CaseListMessagePooldb"
    , "ZA_FaceCaptureListdb"
    , "ZA_MotorVehicleEventListdb"
  )

  /*
  idx_MotorVehicleListMessagePooldb_all_row
  idx_ZA_FaceCaptureListdb_all_row
  idx_ZA_MotorVehicleEventListdb_all_row
  idx_faceListMessagePooldb_all_row
  idx_imageListMessagePooldb_all_row
  idx_personListMessagePooldb_all_row


  MotorVehicleListMessagePooldb
  ZA_FaceCaptureListdb
  ZA_MotorVehicleEventListdb
  faceListMessagePooldb
  imageListMessagePooldb
  CaseListMessagePooldb
  personListMessagePooldb


  NonMotorVehicleListMessagePooldb
  SceneListMessagePooldb
  ThingListMessagePooldb
  VideoSliceListMessagePooldb
  FileListMessagePooldb




    * */


  def main(args: Array[String]): Unit = {

    try {

      println("请输入需要计算的时间起始时间 例如2021-02-25")
      val input_str = StdIn.readLine()
      val day_now = DateUtil.parse(input_str)
      println("默认计算时间范围为" + input_str + "-" + endOfMonth(day_now).toString.substring(0, 10))
      val rang = rangeToList(day_now, endOfMonth(day_now), DateField.DAY_OF_YEAR).toArray()


      for (y <- rang) {
        val date_re = y.toString.substring(0, 10).replace("-", "").reverse.substring(0, 6)
        for (table <- arr_topic) {

          try {
            val del_table = stat.executeUpdate(
              s"""
                 |delete from "$table" where "row" like '$date_re%'
                 |""".stripMargin)
            connP.commit()

            val index_ = "idx_" + table + "_all_row"

            val del_index_ = stat.executeUpdate(
              s"""
                 |delete from "$index_" where ":row" like '$date_re%'
                 |""".stripMargin)
            connP.commit()
            println(s"$date_re 数据清除完毕 包括数据表$table 索引表$index_")
          } catch {
            case e: Exception => println("出错 正在跳出逻辑")
          }
        }
      }
    } catch {
      case e: Exception => println("出错 正在跳出逻辑")
    }
    finally {
      if (rs != null) {
        rs.close()
      }
      if (stat != null) {
        stat.close()
      }
      if (connP != null) {
        connP.close()
      }
    }
  }
}

package com.zjxc.video.etldata.online.phoenix

import java.sql.{Connection, DriverManager, ResultSet, Statement}

import cn.hutool.core.date.DateUtil

/*
       *@ClassName  Calculate_all_data
       *@description    TODO
       *@author     Whoami
       *@date   2020/12/17
       *@version 1.0
/opt/app/jdk1.8.0/bin/java -classpath /opt/project/zgjq_spark/mysql-connector-java-5.1.32.jar:/opt/project/zgjq_spark/cloud_video_public_security_zajq.jar   com.zjxc.video.etldata.online.phoenix.Calculate_all_data

 */
object Calculate_all_data {

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

  def main(args: Array[String]): Unit = {

    val arr_y = Array("2020")
    val arr_m = Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")
    val arr_d = Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31")

    try {

      for (y <- arr_y) {
        //月
        for (m <- arr_m) {
          //日
          for (d <- arr_d) {
            val str_today = y + "-" + m + "-" + d
            try {
              val today = DateUtil.parse(str_today)
              if (!today.toString.isEmpty) {
                //                      val tomorrow = DateUtil.offsetDay(today, 1).toString.substring(0, 10)
                val yestoday = today.toString.substring(0, 10).replace("-", "").substring(2, 8).reverse
                val yestoday_str = today.toString.substring(0, 10).replace("-", "")

                count_message(yestoday, yestoday_str)
                count_device_message(yestoday)
                println(yestoday + "_" + yestoday_str + "_" + "完毕")

              }


            } catch {
              case e: Exception => e.printStackTrace()
            }

          }
        }
      }

    } catch {
      case e: Exception => e.printStackTrace()
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

  def count_message(yestoday: String, yestoday_str: String): Unit = {

    //    println(yestoday)

    for (k <- arr_topic) {
      rs = stat.executeQuery(
        s"""
           |select  '20'||REVERSE(SUBSTR("row",0,6)) "date",count(1) "count" from "$k" where "row" like '$yestoday%'  group by SUBSTR("row",0,6)
           |""".stripMargin)

      if (rs.next()) {
        val date = rs.getString("date")
        val count = rs.getInt("count")
        println(s"'$k'+'$date'+$count")
        val insert = stat.executeUpdate(s"upsert into MASSAGE_COUNT (MASSAGENAME,DATESTR,COUNT) values ('$k', '$date',$count)")
        connP.commit()
      } else {
        val insert = stat.executeUpdate(s"upsert into MASSAGE_COUNT (MASSAGENAME,DATESTR,COUNT) values ('$k', '$yestoday_str',0)")
        connP.commit()
      }
    }
  }

  def count_device_message(yestoday: String): Unit = {

    val insert_device_alarm_ZA = stat.executeUpdate(
      s"""
         |upsert into MASSAGE_DEVICE_COUNT (DATESTR,DEVICEID,COUNT)
         |   select a.DATE,a.DEVICEID,sum(a.NUM) from (
         |   select '20'||REVERSE(SUBSTR("row",0,6)) "date","DeviceID" as "DEVICEID",count(1) as "NUM" from "faceListMessagePooldb" where "row" like '$yestoday%' group by SUBSTR("row",0,6),"DeviceID"
         |   union all
         |   select '20'||REVERSE(SUBSTR("row",0,6)) "date","CJSBXXBZ" as "DEVICEID" ,count(1) as "NUM"  from "ZA_FaceCaptureListdb" where "row" like '$yestoday%' group by SUBSTR("row",0,6),"CJSBXXBZ"
         |   union all
         |   select '20'||REVERSE(SUBSTR("row",0,6)) "date","CJSBXXBZ" as "DEVICEID" ,count(1) as "NUM"  from "ZA_MotorVehicleEventListdb" where "row" like '$yestoday%' group by SUBSTR("row",0,6),"CJSBXXBZ"
         |   )a group by a.DATE,a.DEVICEID
         |""".stripMargin)
    connP.commit()

    println("每日设备告警数 统计完毕(人脸,机动车)")
  }
}

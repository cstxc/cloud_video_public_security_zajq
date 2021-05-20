package com.zjxc.video.etldata.online.phoenix

import java.sql.{Connection, DriverManager, ResultSet, Statement}
import cn.hutool.core.date.DateUtil

/*
*
    *@author    Whoami
    *@description   todo 聚合昨日主题入库条数
    *@date     15:51
    *@param
    *@return

 */

object count_alarm {

  //
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

    try {

      //select  '20'||REVERSE(SUBSTR("row",0,6)) "date",count(1) "count" from "$k" group by SUBSTR("row",0,6)
      //select  '20'||REVERSE(SUBSTR("row",0,6)) "date",count(1) "count" from "$k" where "row" like '$yestoday%'  group by SUBSTR("row",0,6)

      val yestoday = DateUtil.yesterday().toString.substring(0, 10).replace("-", "").substring(2, 8).reverse
      val yestoday_str = DateUtil.yesterday().toString.substring(0, 10).replace("-", "")

      println(yestoday)

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


      //todo 每日设备告警数
      // 1400协议
      // 智安主题 该标准中有较多的设备标识可做统计
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
}

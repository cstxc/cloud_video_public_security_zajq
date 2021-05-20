package com.zjxc.video.etldata.online.sparkStreaming.allToHbase

import java.util.UUID

import cn.hutool.core.date.DateUtil
import com.zjxc.video.etldata.online.Utils.tUtils._
import com.rabbitmq.client.{Address, ConnectionFactory}

import scala.util.Random

/*
       *@ClassName  producer
       *@description    TODO
       *@author     Whoami
       *@date   2020/11/11
       *@version 1.0
*/
object producer {

  val EXCHANGE_NAME = "allMessagePool"
  val factory = new ConnectionFactory()

  factory.setPort(5672)
  factory.setVirtualHost("/")
  factory.setUsername("admin")
  factory.setPassword("admin@zajq")
  val host1 = new Address("60.191.244.36", 5672)

  val site: Array[Address] = Array(host1)
  val conn = factory.newConnection(site)
  val channel = conn.createChannel()

  val arry_device = Array(
    "1CDZEN59SBWJDCHAR9KV",
    "BV0YAOATDIHYB1YCX0DS",
    "FVRWA7ZJ2OZ1ZMPP06XX"
  )


  def main(args: Array[String]): Unit = {


    random_ZA

  }

  def random_ZA(): Unit = {


    var count = 0
    while (true) {

      val create_date = DateUtil.now()
      val XXBZ = UUID.randomUUID().toString.replace("-", "")
      val CJSBXXBZ = arry_device(Random.nextInt(arry_device.length))


      var msg = ""
      if (Random.nextInt(4) % 2 == 0) {
        msg =
          s"""
             |{
             |    "MotorVehicleEventList":[
             |        {
             |            "RecordStartNo":1,
             |            "PageRecordNum":2,
             |            "TotalNum":1,
             |            "MotorVehicleEventObject":{
             |                "JDCGCXXBZ" :"$XXBZ",
             |                "GCFX" :"xxx",
             |                "JDCHPHM" :"xxx",
             |                "ZSJ_ZXDHZB":"xxx",
             |                "ZSJ_ZXDZZB":"xxx",
             |                "YXJ_ZXDHZB":"xxx",
             |                "YXJ_ZXDZZB":"xxx",
             |                "JDCCLLXDM" :"xxx",
             |                "CLPP" :"xxx",
             |                "JDCCSYSDM" :"xxx",
             |                "CLXH" :"xxx",
             |                "FXCDBH" :"xxx",
             |		            "CJSBXXBZ" :"$CJSBXXBZ",
             |                "SFTGC_PDBZ" :"xxx",
             |                "ZJSR_RLBZ" :"xxx",
             |                "CLQJTXBZ" :"xxx",
             |                "CLHPTXBZ" :"xxx",
             |                "HCTXBZ" :"xxx",
             |                "FJSR_RLBZ" :"xxx",
             |                "JDCHPZLDM" :"xxx",
             |                "SFWZDCL_PDBZ" :"xxx",
             |                "JDCHPYSDM" :"xxx",
             |                "CJSJ":'$create_date'
             |            }
             |        }
             |    ]
             |}
             |""".stripMargin
      } else {
        msg =
          s"""
             |{
             |    "FaceCaptureList":[
             |        {
             |            "RecordStartNo":1,
             |            "PageRecordNum":2,
             |            "TotalNum":1,
             |            "FaceCaptureObject":{
             |                "RLZPXXBZ" :"$XXBZ",
             |                "SPTXXXYYSXDXBZ":"xxx",
             |                "SPTXXXCJFSDM":"xxx",
             |                "NLSX":"xxx",
             |                "NLXX":"xxx",
             |                "XBDM":"xxx",
             |                "MZDM":"xxx",
             |                "SFBKRY_PDBZ":"xxx",
             |                "SFGZRY_PDBZ":"xxx",
             |                "CJSBXXBZ" :'$CJSBXXBZ',
             |                "ZSJ_ZXDHZB":"xxx",
             |                "ZSJ_ZXDZZB":"xxx",
             |                "YXJ_ZXDHZB":"xxx",
             |                "YXJ_ZXDZZB":"xxx",
             |                "TXR_RS":1,
             |                "SFDKZ_PDBZ":"xxx",
             |                "ZMTZDM":"xxx",
             |                "SFJSY_PDBZ":"xxx",
             |                "PDYJTZDM":"xxx",
             |                "XBTZDM":"xxx",
             |                "SSZZTZDM":"xxx",
             |                "XSZZTZDM":"xxx",
             |                "ZXTZDM":"xxx",
             |                "SY_YS":"xxx",
             |                "KZ_YS":"xxx",
             |                "XZ_YS":"xxx",
             |                "MZ_YS":"xxx",
             |                "TP":"x",
             |                "CJSJ":'$create_date'
             |            }
             |        }
             |    ]
             |}
             |""".stripMargin
      }

      println(parseJsonDistinguish(msg))

      channel.basicPublish("", EXCHANGE_NAME, null, msg.getBytes())
      println("消息已发送" + msg)
      count = count + 1
      println(count)
      Thread.sleep(2000)
    }
    channel.close()
  }

  def random_1400(): Unit = {
    var count = 0
    //  channel.exchangeDeclare(EXCHANGE_NAME,"direct",true)
    while (true) {
      //val msg = "dataPool.faces"+count

      val FaceID = UUID.randomUUID()
      val DeviceID = arry_device(Random.nextInt(arry_device.length))

      val msg: String =
        s"""
           |{
           |   "MotorVehicleListObject": {
           |       "MotorVehicleObject": [
           |          {
           |               "MotorVehicleID": "$FaceID",
           |               "InfoKind": 1,
           |               "SourceID": "33010101001210000001022017101808060802206",
           |               "TollgateID": "2141245",
           |               "DeviceID": "$DeviceID",
           |               "StorageUrl1": "9527/upload/122/20130901/00/0524-NAS221-50151415-AS.jpg",
           |               "StorageUrl3": "3",
           |               "StorageUrl5": "1",
           |               "LeftTopX": 1,
           |               "LeftTopY": 2,
           |               "RightBtmX": 3,
           |               "RightBtmY": 4,
           |               "LaneNo": 1,
           |               "HasPlate": "1",
           |               "PlateClass": "99",
           |               "PlateColor": "99",
           |               "PlateNo": "苏NF5676",
           |               "PlateNoAttach": "1",
           |               "PlateDescribe": "12",
           |               "IsDecked": "1",
           |               "IsAltered": "1",
           |               "IsCovered": "1",
           |               "Speed": 8,
           |               "Direction": "0",
           |               "DrivingStatusCode": "1",
           |               "UsingPropertiesCode": "1",
           |               "VehicleClass": "1",
           |               "VehicleBrand": "1",
           |               "VehicleModel": "1",
           |               "VehicleStyles": "12",
           |               "VehicleLength": 0,
           |               "VehicleWidth": 23,
           |               "VehicleHeight": 31,
           |               "VehicleColor": "1",
           |               "VehicleColorDepth": "2",
           |               "VehicleHood": "4",
           |               "VehicleTrunk": "5",
           |               "VehicleWheel": "1",
           |               "WheelPrintedPattern": "1",
           |               "VehicleWindow": "1",
           |               "VehicleRoof": "1",
           |               "VehicleDoor": "1",
           |               "SideOfVehicle": "1",
           |               "CarOfVehicle": "1",
           |               "RearviewMirror": "1",
           |               "VehicleChassis": "1",
           |               "VehicleShielding": "1",
           |               "FilmColor": "1",
           |               "IsModified": "1",
           |               "HitMarkInfo": "1",
           |               "VehicleBodyDesc": "1",
           |               "VehicleFrontItem": "1",
           |               "DescOfFrontItem": "1",
           |               "VehicleRearItem": "4",
           |               "DescOfRearItem": "3",
           |               "NumOfPassenger": 2,
           |               "PassTime": "20160912220107",
           |               "NameOfPassedRoad": "12",
           |               "IsSuspicious": "1",
           |               "PlateReliability": "1",
           |               "PlateCharReliability": "苏-80,B-90,1-90,2-88,3-90,4-67,5-87",
           |               "BrandReliability": "1",
           |               "SubImageList": {
           |                   "SubImageInfoObject": [
           |                      {
           |                           "ImageID": "33020300001190000001022017122111111100001",
           |                           "EventSort": 4,
           |                           "DeviceID": "55220299011190000253",
           |                           "StoragePath": "http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg",
           |                           "Type": "01",
           |                           "FileFormat": "Jpeg",
           |                           "ShotTime": "20170925032455",
           |                           "Width": 437,
           |                           "Height": 350
           |                      }
           |                  ]
           |              }
           |          }
           |      ]
           |  }
           |}
           |""".stripMargin

      channel.basicPublish("", EXCHANGE_NAME, null, msg.getBytes())
      println("消息已发送" + msg)
      count = count + 1
      println(count)
      Thread.sleep(2000)
    }
    channel.close()
  }
}

/*
    {
   "MotorVehicleListObject": {
       "MotorVehicleObject": [
          {
               "MotorVehicleID": "330101010012100000010220171018080608022060269899",
               "InfoKind": 1,
               "SourceID": "33010101001210000001022017101808060802206",
               "TollgateID": "2141245",
               "DeviceID": "65010000001190000001",
               "StorageUrl1": "9527/upload/122/20130901/00/0524-NAS221-50151415-AS.jpg",
               "StorageUrl3": "3",
               "StorageUrl5": "1",
               "LeftTopX": 1,
               "LeftTopY": 2,
               "RightBtmX": 3,
               "RightBtmY": 4,
               "LaneNo": 1,
               "HasPlate": "1",
               "PlateClass": "99",
               "PlateColor": "99",
               "PlateNo": "苏NF5676",
               "PlateNoAttach": "1",
               "PlateDescribe": "12",
               "IsDecked": "1",
               "IsAltered": "1",
               "IsCovered": "1",
               "Speed": 8,
               "Direction": "0",
               "DrivingStatusCode": "1",
               "UsingPropertiesCode": "1",
               "VehicleClass": "1",
               "VehicleBrand": "1",
               "VehicleModel": "1",
               "VehicleStyles": "12",
               "VehicleLength": 0,
               "VehicleWidth": 23,
               "VehicleHeight": 31,
               "VehicleColor": "1",
               "VehicleColorDepth": "2",
               "VehicleHood": "4",
               "VehicleTrunk": "5",
               "VehicleWheel": "1",
               "WheelPrintedPattern": "1",
               "VehicleWindow": "1",
               "VehicleRoof": "1",
               "VehicleDoor": "1",
               "SideOfVehicle": "1",
               "CarOfVehicle": "1",
               "RearviewMirror": "1",
               "VehicleChassis": "1",
               "VehicleShielding": "1",
               "FilmColor": "1",
               "IsModified": "1",
               "HitMarkInfo": "1",
               "VehicleBodyDesc": "1",
               "VehicleFrontItem": "1",
               "DescOfFrontItem": "1",
               "VehicleRearItem": "4",
               "DescOfRearItem": "3",
               "NumOfPassenger": 2,
               "PassTime": "20160912220107",
               "NameOfPassedRoad": "12",
               "IsSuspicious": "1",
               "PlateReliability": "1",
               "PlateCharReliability": "苏-80,B-90,1-90,2-88,3-90,4-67,5-87",
               "BrandReliability": "1",
               "SubImageList": {
                   "SubImageInfoObject": [
                      {
                           "ImageID": "33020300001190000001022017122111111100001",
                           "EventSort": 4,
                           "DeviceID": "55220299011190000253",
                           "StoragePath": "http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg",
                           "Type": "01",
                           "FileFormat": "Jpeg",
                           "ShotTime": "20170925032455",
                           "Width": 437,
                           "Height": 350
                      }
                  ]
              }
          }
      ]
  }
}

{
   "FaceListObject": {
       "FaceObject": [
          {
               "FaceID": "$FaceID",
               "InfoKind": 1,
               "SourceID": "66000000001190123456022017120110101000007",
               "DeviceID": "$DeviceID",
               "LeftTopX": 1,
               "LeftTopY": 1,
               "RightBtmX": 1,
               "RightBtmY": 1,
               "LocationMarkTime": "19981230010000",
               "FaceAppearTime": "19981230010000",
               "FaceDisAppearTime": "19981230010000",
               "IDType": "111",
               "IDNumber": "1",
               "Name": "大华",
               "UsedName": "dahua",
               "Alias": "dahua",
               "GenderCode": "1",
               "AgeUpLimit": 10,
               "AgeLowerLimit": 20,
               "EthicCode": "01",
               "NationalityCode": "CHN",
               "NativeCityCode": "330108",
               "ResidenceAdminDivision": "330100",
               "ChineseAccentCode": "1",
               "JobCategory": "1",
               "AccompanyNumber": 1,
               "SkinColor": "1",
               "HairStyle": "1",
               "HairColor": "1",
               "FaceStyle": "1",
               "FacialFeature": "1",
               "PhysicalFeature": "1",
               "RespiratorColor": "1",
               "CapStyle": "1",
               "CapColor": "1",
               "GlassStyle": "1",
               "GlassColor": "1",
               "IsDriver": 1,
               "IsForeigner": 1,
               "PassportType": "1",
               "ImmigrantTypeCode": "1",
               "IsSuspectedTerrorist": 1,
               "SuspectedTerroristNumber": "1",
               "IsCriminalInvolved": 1,
               "CriminalInvolvedSpecilisationCode": "1",
               "BodySpeciallMark": "1",
               "CrimeMethod": "1",
               "CrimeCharacterCode": "111",
               "EscapedCriminalNumber": "11111111111111111111111",
               "IsDetainees": 1,
               "DetentionHouseCode": "111111111",
               "DetaineesIdentity": "1",
               "DetaineesSpecialIdentity": "1",
               "MemberTypeCode": "1",
               "IsVictim": 1,
               "VictimType": "1",
               "InjuredDegree": "1",
               "CorpseConditionCode": "1",
               "IsSuspiciousPerson": 1,
               "Attitude": 1,
               "Similaritydegree": 1,
               "EyebrowStyle": "1",
               "NoseStyle": "1",
               "MustacheStyle": "1",
               "LipStyle": "1",
               "WrinklePouch": "1",
               "AcneStain": "1",
               "FreckleBirthmark": "1",
               "ScarDimple": "1",
               "OtherFeature": "1",
               "SubImageList": {
                   "SubImageInfoObject": [
                      {
                           "ImageID": "33020300001190000001022017122111111100001",
                           "EventSort": 11,
                           "DeviceID": "33070299011190000253",
                           "StoragePath": "http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg",
                           "Type": "01",
                           "FileFormat": "Jpeg",
                           "ShotTime": "20170825032455",
                           "Width": 437,
                           "Height": 350
                      }
                  ]
              }
          }
      ]
  }
}
 */
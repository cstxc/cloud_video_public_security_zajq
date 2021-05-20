package com.zjxc.video.etldata.online.sparkStreaming.allToHbase

import java.text.SimpleDateFormat
import java.util.{ArrayList, Date}

import com.zjxc.video.etldata.online.Utils.{RabbitMQUtils, RedisConnect, tUtils}
import com.zjxc.video.etldata.online.Utils.tUtils._
import org.apache.commons.lang.ArrayUtils
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{HConnectionManager, Put}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.elasticsearch.spark.rdd.EsSpark
import redis.clients.jedis.Jedis


/*
       *@ClassName  MessagePoolToHbase
       *@description    TODO n points lead to strength
       *@author     Whoami
       *@date   2020/07/10
       *@version 1.0

*/

object allMessagePoolToHbase {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName(s"${this.getClass.getSimpleName}".replace("$", ""))
    //      .set("es.index.auto.create", "true")
    //      .set("es.index.read.missing.as.empty", "true")
    //      .set("es.nodes", "172.18.248.212")
    //      .set("es.port", "9200")

    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)


    val ssc = new StreamingContext(conf, Seconds(5))
    ssc.sparkContext.setLogLevel("ERROR") // ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN


    val lines = RabbitMQUtils.createStreamFromAQueue(ssc,
      "172.18.248.212",
      5672,
      "/",
      "admin",
      "admin@zajq",
      "allMessagePool",
      true,
      true,
      1000,
      3, StorageLevel.MEMORY_AND_DISK_SER_2
    )


    //todo n points return to vitality   1400协议
    val ds_face = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "faceListMessagePooldb")
    val ds_image = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "imageListMessagePooldb")
    val ds_person = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "personListMessagePooldb")
    val ds_moto = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "MotorVehicleListMessagePooldb")
    val ds_nmoto = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "NonMotorVehicleListMessagePooldb")
    val ds_thing = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "ThingListMessagePooldb")
    val ds_scene = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "SceneListMessagePooldb")
    val ds_file = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "FileListMessagePooldb")
    val ds_Video = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "VideoSliceListMessagePooldb")
    val ds_Case = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "CaseListMessagePooldb")


    //todo 金华ZA  主题
    val ds_faceZA_ = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "ZA_FaceCaptureListdb")
    val ds_motoZA_ = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "ZA_MotorVehicleEventListdb")





    //    ds_face.print(1)
    //    ds_image.print(1)
    //    ds_person.print(1)
    //    ds_moto.print(1)
    //    ds_nmoto.print(1)
    //    ds_thing.print(1)
    //    ds_scene.print(1)
    //    ds_file.print(1)
    //    ds_Video.print(1)
    //    ds_Case.print(1)
    //
    //    ds_faceZA_.print(1)
    //    ds_motoZA_.print(1)


    ds_face.foreachRDD(
      r => r.foreachPartition {
        p =>
          val conf = HBaseConfiguration.create()
          val connection = HConnectionManager.createConnection(conf)
          val table = connection.getTable("faceListMessagePooldb")
          val table_index = connection.getTable("idx_faceListMessagePooldb_all_row")
          val puts = new ArrayList[Put]
          val puts_index = new ArrayList[Put]
          val jedis2: Jedis = RedisConnect.pool.getResource

          p.foreach(
            n => {
              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
              val row = String.valueOf(String.valueOf(newtime.substring(4) + '-' + n(0) + '-' + n(5) + (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
              val put = new Put(Bytes.toBytes(row))
              //              val put_idex = new Put(Bytes.toBytes(row))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceID"), Bytes.toBytes(n(0)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SourceID"), Bytes.toBytes(n(4)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DeviceID"), Bytes.toBytes(n(5)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopX"), Bytes.toBytes(n(6)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopY"), Bytes.toBytes(n(7)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmX"), Bytes.toBytes(n(8)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmY"), Bytes.toBytes(n(9)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LocationMarkTime"), Bytes.toBytes(n(10)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceAppearTime"), Bytes.toBytes(n(11)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceDisAppearTime"), Bytes.toBytes(n(12)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IDType"), Bytes.toBytes(n(13)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IDNumber"), Bytes.toBytes(n(14)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Name"), Bytes.toBytes(n(15)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("UsedName"), Bytes.toBytes(n(16)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Alias"), Bytes.toBytes(n(17)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GenderCode"), Bytes.toBytes(n(18)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AgeUpLimit"), Bytes.toBytes(n(19)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AgeLowerLimit"), Bytes.toBytes(n(20)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EthicCode"), Bytes.toBytes(n(21)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NationalityCode"), Bytes.toBytes(n(22)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NativeCityCode"), Bytes.toBytes(n(23)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ResidenceAdminDivision"), Bytes.toBytes(n(24)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ChineseAccentCode"), Bytes.toBytes(n(25)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JobCategory"), Bytes.toBytes(n(26)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AccompanyNumber"), Bytes.toBytes(n(27)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SkinColor"), Bytes.toBytes(n(28)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HairStyle"), Bytes.toBytes(n(29)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HairColor"), Bytes.toBytes(n(30)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceStyle"), Bytes.toBytes(n(31)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FacialFeature"), Bytes.toBytes(n(32)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PhysicalFeature"), Bytes.toBytes(n(33)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RespiratorColor"), Bytes.toBytes(n(34)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CapStyle"), Bytes.toBytes(n(35)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CapColor"), Bytes.toBytes(n(36)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GlassStyle"), Bytes.toBytes(n(37)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GlassColor"), Bytes.toBytes(n(38)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDriver"), Bytes.toBytes(n(39)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsForeigner"), Bytes.toBytes(n(40)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PassportType"), Bytes.toBytes(n(41)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImmigrantTypeCode"), Bytes.toBytes(n(42)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsSuspectedTerrorist"), Bytes.toBytes(n(43)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SuspectedTerroristNumber"), Bytes.toBytes(n(44)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsCriminalInvolved"), Bytes.toBytes(n(45)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CriminalInvolvedSpecilisationCode"), Bytes.toBytes(n(46)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BodySpeciallMark"), Bytes.toBytes(n(47)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CrimeMethod"), Bytes.toBytes(n(48)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CrimeCharacterCode"), Bytes.toBytes(n(49)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EscapedCriminalNumber"), Bytes.toBytes(n(50)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDetainees"), Bytes.toBytes(n(51)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetentionHouseCode"), Bytes.toBytes(n(52)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetaineesIdentity"), Bytes.toBytes(n(53)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetaineesSpecialIdentity"), Bytes.toBytes(n(54)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("MemberTypeCode"), Bytes.toBytes(n(55)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsVictim"), Bytes.toBytes(n(56)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VictimType"), Bytes.toBytes(n(57)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InjuredDegree"), Bytes.toBytes(n(58)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CorpseConditionCode"), Bytes.toBytes(n(59)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsSuspiciousPerson"), Bytes.toBytes(n(60)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Attitude"), Bytes.toBytes(n(61)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Similaritydegree"), Bytes.toBytes(n(62)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EyebrowStyle"), Bytes.toBytes(n(63)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NoseStyle"), Bytes.toBytes(n(64)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("MustacheStyle"), Bytes.toBytes(n(65)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LipStyle"), Bytes.toBytes(n(66)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("WrinklePouch"), Bytes.toBytes(n(67)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AcneStain"), Bytes.toBytes(n(68)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FreckleBirthmark"), Bytes.toBytes(n(69)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ScarDimple"), Bytes.toBytes(n(70)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("OtherFeature"), Bytes.toBytes(n(71)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoImageID"), Bytes.toBytes(n(72)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoEventSort"), Bytes.toBytes(n(73)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoDeviceID"), Bytes.toBytes(n(74)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoStoragePath"), Bytes.toBytes(n(75)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoType"), Bytes.toBytes(n(76)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoFileFormat"), Bytes.toBytes(n(77)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoShotTime"), Bytes.toBytes(n(78)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoWidth"), Bytes.toBytes(n(79)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoHeight"), Bytes.toBytes(n(80)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
              puts.add(put)

              tUtils.hincrByRedis(jedis2, n(5))

              //更新索引
              //更新索引  解决api插入hbase \x00 无法解析问题
              val union_ = 0.toByte
              val union = Array[Byte](union_)

              val a = Bytes.toBytes(row)
              val b = Bytes.toBytes(n(5))
              val c = Bytes.toBytes(n(78))

              val d = ArrayUtils.addAll(a, union)
              val e = ArrayUtils.addAll(d, b)
              val f = ArrayUtils.addAll(e, union)
              val row_all = ArrayUtils.addAll(f, c)

              val put_idex = new Put(row_all)

              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
              puts_index.add(put_idex)

              if (puts.size % 1000 == 0) {
                table.put(puts)
                table_index.put(puts_index)
                puts.clear()
              }
            }
          )
          if (puts.size() > 0) {
            table.put(puts)
            table_index.put(puts_index)
            puts.clear()
          }

          jedis2.close()
          table.close()
          connection.close()
      }
    )

    ds_image.foreachRDD(
      r => r.foreachPartition {
        p =>
          val conf = HBaseConfiguration.create()
          val connection = HConnectionManager.createConnection(conf)
          val table = connection.getTable("imageListMessagePooldb")
          val table_index = connection.getTable("idx_imageListMessagePooldb_all_row")
          val puts = new ArrayList[Put]
          val puts_index = new ArrayList[Put]

          p.foreach(
            n => {

              //              val salt = Random.nextInt(9)
              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
              //              val put = new Put(Bytes.toBytes(String.valueOf(salt + newtime.substring(4)  + "-" + n(0) + "-" +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4))))

              val row = String.valueOf(String.valueOf(newtime.substring(4) + "-" + n(0) + "-" + (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
              val put = new Put(Bytes.toBytes(row))
              //              val put_idex = new Put(Bytes.toBytes(row))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageID"), Bytes.toBytes(n(0)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageSource"), Bytes.toBytes(n(4)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EventSort"), Bytes.toBytes(n(5)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("StoragePath"), Bytes.toBytes(n(6)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotTime"), Bytes.toBytes(n(7)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotPlaceFullAdress"), Bytes.toBytes(n(8)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotPlaceLongitude"), Bytes.toBytes(n(9)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotPlaceLatitude"), Bytes.toBytes(n(10)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EntryClerkOrg"), Bytes.toBytes(n(11)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EntryTime"), Bytes.toBytes(n(12)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileHash"), Bytes.toBytes(n(13)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileFormat"), Bytes.toBytes(n(14)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Title"), Bytes.toBytes(n(15)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ContentDescription"), Bytes.toBytes(n(16)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Width"), Bytes.toBytes(n(17)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Height"), Bytes.toBytes(n(18)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SecurityLevel"), Bytes.toBytes(n(19)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileSize"), Bytes.toBytes(n(20)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))

              puts.add(put)

              //更新索引
              //更新索引  解决api插入hbase \x00 无法解析问题
              val union_ = 0.toByte
              val union = Array[Byte](union_)

              val a = Bytes.toBytes(row)
              val b = Bytes.toBytes(n(7))

              val d = ArrayUtils.addAll(a, union)
              val row_all = ArrayUtils.addAll(d, b)

              val put_idex = new Put(row_all)
              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
              puts_index.add(put_idex)

              if (puts.size % 1000 == 0) {
                table.put(puts)
                table_index.put(puts_index)
                puts.clear()
              }
            }
          )
          if (puts.size() > 0) {
            table.put(puts)
            table_index.put(puts_index)
            puts.clear()
          }

          table.close()
          connection.close()

      }
    )

    ds_person.foreachRDD(
      r => r.foreachPartition {
        p =>
          val conf = HBaseConfiguration.create()
          val connection = HConnectionManager.createConnection(conf)
          val table = connection.getTable("personListMessagePooldb")
          val table_index = connection.getTable("idx_personListMessagePooldb_all_row")
          val puts = new ArrayList[Put]
          val puts_index = new ArrayList[Put]
          val jedis2: Jedis = RedisConnect.pool.getResource

          p.foreach(
            n => {
              //              val salt = Random.nextInt(9)
              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
              //              val put = new Put(Bytes.toBytes(String.valueOf(salt + newtime.substring(4) + "-" +   n(0) + "-" + n(3) + "-" +   (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4))))

              val row = String.valueOf(newtime.substring(4) + "-" + n(0) + "-" + n(5) + "-" + (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4))
              val put = new Put(Bytes.toBytes(row))
              //              val put_idex = new Put(Bytes.toBytes(row))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PersonID"), Bytes.toBytes(n(0)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SourceID"), Bytes.toBytes(n(4)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DeviceID"), Bytes.toBytes(n(5)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopX"), Bytes.toBytes(n(6)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopY"), Bytes.toBytes(n(7)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmX"), Bytes.toBytes(n(8)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmY"), Bytes.toBytes(n(9)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LocationMarkTime"), Bytes.toBytes(n(10)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PersonAppearTime"), Bytes.toBytes(n(11)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PersonDisAppearTime"), Bytes.toBytes(n(12)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IDType"), Bytes.toBytes(n(13)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IDNumber"), Bytes.toBytes(n(14)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Name"), Bytes.toBytes(n(15)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("UsedName"), Bytes.toBytes(n(16)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Alias"), Bytes.toBytes(n(17)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GenderCode"), Bytes.toBytes(n(18)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AgeUpLimit"), Bytes.toBytes(n(19)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AgeLowerLimit"), Bytes.toBytes(n(20)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EthicCode"), Bytes.toBytes(n(21)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NationalityCode"), Bytes.toBytes(n(22)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NativeCityCode"), Bytes.toBytes(n(23)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ResidenceAdminDivision"), Bytes.toBytes(n(24)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ChineseAccentCode"), Bytes.toBytes(n(25)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PersonOrg"), Bytes.toBytes(n(26)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JobCategory"), Bytes.toBytes(n(27)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AccompanyNumber"), Bytes.toBytes(n(28)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HeightUpLimit"), Bytes.toBytes(n(29)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HeightLowerLimit"), Bytes.toBytes(n(30)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BodyType"), Bytes.toBytes(n(31)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SkinColor"), Bytes.toBytes(n(32)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HairStyle"), Bytes.toBytes(n(33)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HairColor"), Bytes.toBytes(n(34)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Gesture"), Bytes.toBytes(n(35)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Status"), Bytes.toBytes(n(36)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceStyle"), Bytes.toBytes(n(37)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FacialFeature"), Bytes.toBytes(n(38)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PhysicalFeature"), Bytes.toBytes(n(39)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BodyFeature"), Bytes.toBytes(n(40)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HabitualMovement"), Bytes.toBytes(n(41)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Behavior"), Bytes.toBytes(n(42)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BehaviorDescription"), Bytes.toBytes(n(43)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Appendant"), Bytes.toBytes(n(44)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AppendantDescription"), Bytes.toBytes(n(45)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("UmbrellaColor"), Bytes.toBytes(n(46)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RespiratorColor"), Bytes.toBytes(n(47)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CapStyle"), Bytes.toBytes(n(48)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CapColor"), Bytes.toBytes(n(49)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GlassStyle"), Bytes.toBytes(n(50)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GlassColor"), Bytes.toBytes(n(51)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ScarfColor"), Bytes.toBytes(n(52)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BagStyle"), Bytes.toBytes(n(53)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BagColor"), Bytes.toBytes(n(54)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CoatStyle"), Bytes.toBytes(n(55)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CoatLength"), Bytes.toBytes(n(56)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CoatColor"), Bytes.toBytes(n(57)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("TrousersStyle"), Bytes.toBytes(n(58)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("TrousersColor"), Bytes.toBytes(n(59)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("TrousersLen"), Bytes.toBytes(n(60)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShoesStyle"), Bytes.toBytes(n(61)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShoesColor"), Bytes.toBytes(n(62)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDriver"), Bytes.toBytes(n(63)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsForeigner"), Bytes.toBytes(n(64)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PassportType"), Bytes.toBytes(n(65)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImmigrantTypeCode"), Bytes.toBytes(n(66)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsSuspectedTerrorist"), Bytes.toBytes(n(67)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SuspectedTerroristNumber"), Bytes.toBytes(n(68)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsCriminalInvolved"), Bytes.toBytes(n(69)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CriminalInvolvedSpecilisationCode"), Bytes.toBytes(n(70)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BodySpeciallMark"), Bytes.toBytes(n(71)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CrimeMethod"), Bytes.toBytes(n(72)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CrimeCharacterCode"), Bytes.toBytes(n(73)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EscapedCriminalNumber"), Bytes.toBytes(n(74)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDetainees"), Bytes.toBytes(n(75)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetentionHouseCode"), Bytes.toBytes(n(76)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetaineesIdentity"), Bytes.toBytes(n(77)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetaineesSpecialIdentity"), Bytes.toBytes(n(78)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("MemberTypeCode"), Bytes.toBytes(n(79)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsVictim"), Bytes.toBytes(n(80)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VictimType"), Bytes.toBytes(n(81)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InjuredDegree"), Bytes.toBytes(n(82)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CorpseConditionCode"), Bytes.toBytes(n(83)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsSuspiciousPerson"), Bytes.toBytes(n(84)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoImageID"), Bytes.toBytes(n(85)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoEventSort"), Bytes.toBytes(n(86)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoDeviceID"), Bytes.toBytes(n(87)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoStoragePath"), Bytes.toBytes(n(88)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoType"), Bytes.toBytes(n(89)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoFileFormat"), Bytes.toBytes(n(90)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoShotTime"), Bytes.toBytes(n(91)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoWidth"), Bytes.toBytes(n(92)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SubImageInfoHeight"), Bytes.toBytes(n(93)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
              puts.add(put)

              tUtils.hincrByRedis(jedis2, n(5))

              //更新索引
              //更新索引  解决api插入hbase \x00 无法解析问题
              val union_ = 0.toByte
              val union = Array[Byte](union_)

              val a = Bytes.toBytes(row)
              val b = Bytes.toBytes(n(5))
              val c = Bytes.toBytes(n(91))

              val d = ArrayUtils.addAll(a, union)
              val e = ArrayUtils.addAll(d, b)
              val f = ArrayUtils.addAll(e, union)
              val row_all = ArrayUtils.addAll(f, c)

              val put_idex = new Put(row_all)

              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
              puts_index.add(put_idex)

              if (puts.size % 1000 == 0) {
                table.put(puts)
                table_index.put(puts_index)
                puts.clear()
              }
            }
          )
          if (puts.size() > 0) {
            table.put(puts)
            table_index.put(puts_index)
            puts.clear()
          }

          jedis2.close()
          table.close()
          connection.close()
      }
    )

    ds_moto.foreachRDD(
      r => r.foreachPartition {
        p =>
          val conf = HBaseConfiguration.create()
          val connection = HConnectionManager.createConnection(conf)
          val table = connection.getTable("MotorVehicleListMessagePooldb")
          val table_index = connection.getTable("idx_MotorVehicleListMessagePooldb_all_row")
          val puts = new ArrayList[Put]
          val puts_index = new ArrayList[Put]
          val jedis2: Jedis = RedisConnect.pool.getResource

          p.foreach(
            n => {
              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
              val row = String.valueOf(String.valueOf(newtime.substring(4) + '-' + n(0) + '-' + n(6) + (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
              val put = new Put(Bytes.toBytes(row))
              //              val put_idex = new Put(Bytes.toBytes(row))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("MotorVehicleID"), Bytes.toBytes(n(0)))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SourceID"), Bytes.toBytes(n(4)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("TollgateID"), Bytes.toBytes(n(5)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DeviceID"), Bytes.toBytes(n(6)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("StorageUrl1"), Bytes.toBytes(n(7)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("StorageUrl3"), Bytes.toBytes(n(8)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("StorageUrl5"), Bytes.toBytes(n(9)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopX"), Bytes.toBytes(n(10)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopY"), Bytes.toBytes(n(11)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmX"), Bytes.toBytes(n(12)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmY"), Bytes.toBytes(n(13)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LaneNo"), Bytes.toBytes(n(14)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HasPlate"), Bytes.toBytes(n(15)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateClass"), Bytes.toBytes(n(16)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateColor"), Bytes.toBytes(n(17)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateNo"), Bytes.toBytes(n(18)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateNoAttach"), Bytes.toBytes(n(19)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateDescribe"), Bytes.toBytes(n(20)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDecked"), Bytes.toBytes(n(21)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsAltered"), Bytes.toBytes(n(22)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsCovered"), Bytes.toBytes(n(23)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Speed"), Bytes.toBytes(n(24)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Direction"), Bytes.toBytes(n(25)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DrivingStatusCode"), Bytes.toBytes(n(26)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("UsingPropertiesCode"), Bytes.toBytes(n(27)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleClass"), Bytes.toBytes(n(28)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleBrand"), Bytes.toBytes(n(29)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleModel"), Bytes.toBytes(n(30)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleStyles"), Bytes.toBytes(n(31)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleLength"), Bytes.toBytes(n(32)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleWidth"), Bytes.toBytes(n(33)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleHeight"), Bytes.toBytes(n(34)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleColor"), Bytes.toBytes(n(35)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleColorDepth"), Bytes.toBytes(n(36)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleHood"), Bytes.toBytes(n(37)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleTrunk"), Bytes.toBytes(n(38)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleWheel"), Bytes.toBytes(n(39)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("WheelPrintedPattern"), Bytes.toBytes(n(40)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleWindow"), Bytes.toBytes(n(41)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleRoof"), Bytes.toBytes(n(42)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleDoor"), Bytes.toBytes(n(43)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SideOfVehicle"), Bytes.toBytes(n(44)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CarOfVehicle"), Bytes.toBytes(n(45)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RearviewMirror"), Bytes.toBytes(n(46)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleChassis"), Bytes.toBytes(n(47)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleShielding"), Bytes.toBytes(n(48)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FilmColor"), Bytes.toBytes(n(49)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsModified"), Bytes.toBytes(n(50)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HitMarkInfo"), Bytes.toBytes(n(51)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleBodyDesc"), Bytes.toBytes(n(52)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleFrontItem"), Bytes.toBytes(n(53)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DescOfFrontItem"), Bytes.toBytes(n(54)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleRearItem"), Bytes.toBytes(n(55)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DescOfRearItem"), Bytes.toBytes(n(56)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NumOfPassenger"), Bytes.toBytes(n(57)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PassTime"), Bytes.toBytes(n(58)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NameOfPassedRoad"), Bytes.toBytes(n(59)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsSuspicious"), Bytes.toBytes(n(60)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateReliability"), Bytes.toBytes(n(61)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateCharReliability"), Bytes.toBytes(n(62)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BrandReliability"), Bytes.toBytes(n(63)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoImageID"), Bytes.toBytes(n(64)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoEventSort"), Bytes.toBytes(n(65)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoDeviceID"), Bytes.toBytes(n(66)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoStoragePath"), Bytes.toBytes(n(67)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoType"), Bytes.toBytes(n(68)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoFileFormat"), Bytes.toBytes(n(69)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoShotTime"), Bytes.toBytes(n(70)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoWidth"), Bytes.toBytes(n(71)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoHeight"), Bytes.toBytes(n(72)))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
              puts.add(put)

              tUtils.hincrByRedis(jedis2, n(6))

              //更新索引
              //更新索引  解决api插入hbase \x00 无法解析问题
              val union_ = 0.toByte
              val union = Array[Byte](union_)

              val a = Bytes.toBytes(row)
              val b = Bytes.toBytes(n(6))
              val c = Bytes.toBytes(n(70))

              val d = ArrayUtils.addAll(a, union)
              val e = ArrayUtils.addAll(d, b)
              val f = ArrayUtils.addAll(e, union)
              val row_all = ArrayUtils.addAll(f, c)

              val put_idex = new Put(row_all)

              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
              puts_index.add(put_idex)

              if (puts.size % 1000 == 0) {
                table.put(puts)
                table_index.put(puts_index)
                puts.clear()
              }
            }
          )
          if (puts.size() > 0) {
            table.put(puts)
            table_index.put(puts_index)
            puts.clear()

          }

          jedis2.close()
          table.close()
          connection.close()
      }
    )


    //    ds_nmoto.foreachRDD(
    //      r => r.foreachPartition {
    //        p =>
    //          val conf = HBaseConfiguration.create()
    //          val connection = HConnectionManager.createConnection(conf)
    //          val table = connection.getTable("NonMotorVehicleListMessagePooldb")
    //          val table_index = connection.getTable("idx_NonMotorVehicleListMessagePooldb_row")
    //          val puts = new ArrayList[Put]
    //          val puts_index = new ArrayList[Put]
    //          val jedis2:Jedis = RedisConnect.pool.getResource
    //
    //          p.foreach(
    //            n => {
    //              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
    //              val row = String.valueOf( String.valueOf(newtime.substring(4) + '-' +  n(0) + '-' + n(5) +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
    //              val put = new Put(Bytes.toBytes(row))
    //              val put_idex = new Put(Bytes.toBytes(row))
    //
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NonMotorVehicleID"), Bytes.toBytes(n(0)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SourceID"), Bytes.toBytes(n(4)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DeviceID"), Bytes.toBytes(n(5)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopX"), Bytes.toBytes(n(6)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopY"), Bytes.toBytes(n(7)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmX"), Bytes.toBytes(n(8)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmY"), Bytes.toBytes(n(9)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HasPlate"), Bytes.toBytes(n(10)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateClass"), Bytes.toBytes(n(11)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateColor"), Bytes.toBytes(n(12)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateNo"), Bytes.toBytes(n(13)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateNoAttach"), Bytes.toBytes(n(14)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlateDescribe"), Bytes.toBytes(n(15)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDecked"), Bytes.toBytes(n(16)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsAltered"), Bytes.toBytes(n(17)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsCovered"), Bytes.toBytes(n(18)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DrivingStatusCode"), Bytes.toBytes(n(19)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("UsingPropertiesCode"), Bytes.toBytes(n(20)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleBrand"), Bytes.toBytes(n(21)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleType"), Bytes.toBytes(n(22)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleLength"), Bytes.toBytes(n(23)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleWidth"), Bytes.toBytes(n(24)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleHeight"), Bytes.toBytes(n(25)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleColor"), Bytes.toBytes(n(26)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleHood"), Bytes.toBytes(n(27)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleTrunk"), Bytes.toBytes(n(28)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleWheel"), Bytes.toBytes(n(29)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("WheelPrintedPattern"), Bytes.toBytes(n(30)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleWindow"), Bytes.toBytes(n(31)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleRoof"), Bytes.toBytes(n(32)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleDoor"), Bytes.toBytes(n(33)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SideOfVehicle"), Bytes.toBytes(n(34)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CarOfVehicle"), Bytes.toBytes(n(35)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RearviewMirror"), Bytes.toBytes(n(36)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleChassis"), Bytes.toBytes(n(37)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VehicleShielding"), Bytes.toBytes(n(38)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FilmColor"), Bytes.toBytes(n(39)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoImageID"), Bytes.toBytes(n(40)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoEventSort"), Bytes.toBytes(n(41)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoDeviceID"), Bytes.toBytes(n(42)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoStoragePath"), Bytes.toBytes(n(43)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoType"), Bytes.toBytes(n(44)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoFileFormat"), Bytes.toBytes(n(45)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoShotTime"), Bytes.toBytes(n(46)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoWidth"), Bytes.toBytes(n(47)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoHeight"), Bytes.toBytes(n(48)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
    //              puts.add(put)
    //
    //              tUtils.hincrByRedis( jedis2, n(5))
    //              //更新索引
    //              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
    //              puts_index.add(put_idex)
    //
    //              if (puts.size % 1000 == 0) {
    //                table.put(puts)
    //                table_index.put(puts_index)
    //                puts.clear()
    //              }
    //            }
    //          )
    //          if (puts.size() > 0)
    //          {
    //            table.put(puts)
    //            table_index.put(puts_index)
    //            puts.clear()
    //          }
    //
    //          jedis2.close()
    //          table.close()
    //          connection.close()
    //      }
    //    )
    //
    //    ds_thing.foreachRDD(
    //      r => r.foreachPartition {
    //        p =>
    //          val conf = HBaseConfiguration.create()
    //          val connection = HConnectionManager.createConnection(conf)
    //          val table = connection.getTable("ThingListMessagePooldb")
    //          val table_index = connection.getTable("idx_ThingListMessagePooldb_row")
    //          val puts = new ArrayList[Put]
    //          val puts_index = new ArrayList[Put]
    //          val jedis2:Jedis = RedisConnect.pool.getResource
    //
    //          p.foreach(
    //            n => {
    //              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
    //              val row = String.valueOf( String.valueOf(newtime.substring(4) + '-' +  n(0) + '-' + n(5) +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
    //              val put = new Put(Bytes.toBytes(row))
    //              val put_idex = new Put(Bytes.toBytes(row))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ThingID"), Bytes.toBytes(n(0)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SourceID"), Bytes.toBytes(n(4)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DeviceID"), Bytes.toBytes(n(5)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopX"), Bytes.toBytes(n(6)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopY"), Bytes.toBytes(n(7)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmX"), Bytes.toBytes(n(8)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmY"), Bytes.toBytes(n(9)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LocationMarkTime"), Bytes.toBytes(n(10)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AppearTime"), Bytes.toBytes(n(11)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DisappearTime"), Bytes.toBytes(n(12)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Name"), Bytes.toBytes(n(13)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Shape"), Bytes.toBytes(n(14)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Color"), Bytes.toBytes(n(15)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Size"), Bytes.toBytes(n(16)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Material"), Bytes.toBytes(n(17)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Characteristic"), Bytes.toBytes(n(18)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Propertiy"), Bytes.toBytes(n(19)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InvolvedObjType"), Bytes.toBytes(n(20)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FirearmsAmmunitionType"), Bytes.toBytes(n(21)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ToolTraceType"), Bytes.toBytes(n(22)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EvidenceType"), Bytes.toBytes(n(23)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CaseEvidenceType"), Bytes.toBytes(n(24)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoImageID"), Bytes.toBytes(n(25)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoEventSort"), Bytes.toBytes(n(26)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoDeviceID"), Bytes.toBytes(n(27)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoStoragePath"), Bytes.toBytes(n(28)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoType"), Bytes.toBytes(n(29)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoFileFormat"), Bytes.toBytes(n(30)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoShotTime"), Bytes.toBytes(n(31)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoWidth"), Bytes.toBytes(n(32)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoHeight"), Bytes.toBytes(n(33)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
    //              puts.add(put)
    //
    //              tUtils.hincrByRedis( jedis2, n(5))
    //
    //              //更新索引
    //              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
    //              puts_index.add(put_idex)
    //
    //              if (puts.size % 1000 == 0) {
    //                table.put(puts)
    //                table_index.put(puts_index)
    //                puts.clear()
    //              }
    //            }
    //          )
    //          if (puts.size() > 0)
    //          {
    //            table.put(puts)
    //            table_index.put(puts_index)
    //            puts.clear()
    //          }
    //
    //          jedis2.close()
    //          table.close()
    //          connection.close()
    //      }
    //    )
    //
    //    ds_scene.foreachRDD(
    //      r => r.foreachPartition {
    //        p =>
    //          val conf = HBaseConfiguration.create()
    //          val connection = HConnectionManager.createConnection(conf)
    //          val table = connection.getTable("SceneListMessagePooldb")
    //          val table_index = connection.getTable("idx_SceneListMessagePooldb_row")
    //          val puts = new ArrayList[Put]
    //          val puts_index = new ArrayList[Put]
    //          val jedis2:Jedis = RedisConnect.pool.getResource
    //
    //          p.foreach(
    //            n => {
    //              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
    //              val row = String.valueOf( String.valueOf(newtime.substring(4) + '-' +  n(0) + '-' + n(5) +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
    //              val put = new Put(Bytes.toBytes(row))
    //              val put_idex = new Put(Bytes.toBytes(row))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SceneID"), Bytes.toBytes(n(0)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SourceID"), Bytes.toBytes(n(4)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DeviceID"), Bytes.toBytes(n(5)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BeginTime"), Bytes.toBytes(n(6)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlaceType"), Bytes.toBytes(n(7)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("WeatherType"), Bytes.toBytes(n(8)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SceneDescribe"), Bytes.toBytes(n(9)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SceneType"), Bytes.toBytes(n(10)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RoadAlignmentType"), Bytes.toBytes(n(11)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RoadTerrainType"), Bytes.toBytes(n(12)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RoadSurfaceType"), Bytes.toBytes(n(13)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RoadCoditionType"), Bytes.toBytes(n(14)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RoadJunctionSectionType"), Bytes.toBytes(n(15)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RoadLightingType"), Bytes.toBytes(n(16)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Illustration"), Bytes.toBytes(n(17)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("WindDirection"), Bytes.toBytes(n(18)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Illumination"), Bytes.toBytes(n(19)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FieldCondition"), Bytes.toBytes(n(20)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Temperature"), Bytes.toBytes(n(21)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Humidity"), Bytes.toBytes(n(22)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PopulationDensity"), Bytes.toBytes(n(23)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DenseDegree"), Bytes.toBytes(n(24)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Importance"), Bytes.toBytes(n(25)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoImageID"), Bytes.toBytes(n(26)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoEventSort"), Bytes.toBytes(n(27)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoDeviceID"), Bytes.toBytes(n(28)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoStoragePath"), Bytes.toBytes(n(29)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoType"), Bytes.toBytes(n(30)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoFileFormat"), Bytes.toBytes(n(31)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoShotTime"), Bytes.toBytes(n(32)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoWidth"), Bytes.toBytes(n(33)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoHeight"), Bytes.toBytes(n(34)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
    //              puts.add(put)
    //
    //              tUtils.hincrByRedis( jedis2, n(5))
    //
    //              //更新索引
    //              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
    //              puts_index.add(put_idex)
    //
    //              if (puts.size % 1000 == 0) {
    //                table.put(puts)
    //                table_index.put(puts_index)
    //                puts.clear()
    //              }
    //            }
    //          )
    //          if (puts.size() > 0)
    //          {
    //            table.put(puts)
    //            table_index.put(puts_index)
    //            puts.clear()
    //          }
    //
    //          jedis2.close()
    //          table.close()
    //          connection.close()
    //      }
    //    )
    //
    //    ds_file.foreachRDD(
    //      r => r.foreachPartition {
    //        p =>
    //          val conf = HBaseConfiguration.create()
    //          val connection = HConnectionManager.createConnection(conf)
    //          val table = connection.getTable("FileListMessagePooldb")
    //          val table_index = connection.getTable("idx_FileListMessagePooldb_row")
    //          val puts = new ArrayList[Put]
    //          val puts_index = new ArrayList[Put]
    //
    //          p.foreach(
    //            n => {
    //              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
    //              val row = String.valueOf( String.valueOf(newtime.substring(4) + '-' +  n(0) + '-' +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
    //              val put = new Put(Bytes.toBytes(row))
    //              val put_idex = new Put(Bytes.toBytes(row))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileID"), Bytes.toBytes(n(0)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Source"), Bytes.toBytes(n(4)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileName"), Bytes.toBytes(n(5)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("StoragePath"), Bytes.toBytes(n(6)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileHash"), Bytes.toBytes(n(7)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileFormat"), Bytes.toBytes(n(8)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Title"), Bytes.toBytes(n(9)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EntryTime"), Bytes.toBytes(n(10)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileSize"), Bytes.toBytes(n(11)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
    //              puts.add(put)
    //
    //
    //              //更新索引
    //              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
    //              puts_index.add(put_idex)
    //
    //              if (puts.size % 1000 == 0) {
    //                table.put(puts)
    //                table_index.put(puts_index)
    //                puts.clear()
    //              }
    //            }
    //          )
    //          if (puts.size() > 0)
    //          {
    //            table.put(puts)
    //            table_index.put(puts_index)
    //            puts.clear()
    //          }
    //
    //          table.close()
    //          connection.close()
    //      }
    //    )
    //
    //    ds_Video.foreachRDD(
    //      r => r.foreachPartition {
    //        p =>
    //          val conf = HBaseConfiguration.create()
    //          val connection = HConnectionManager.createConnection(conf)
    //          val table = connection.getTable("VideoSliceListMessagePooldb")
    //          val table_index = connection.getTable("idx_VideoSliceListMessagePooldb_row")
    //          val puts = new ArrayList[Put]
    //          val puts_index = new ArrayList[Put]
    //
    //          p.foreach(
    //            n => {
    //              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
    //              val row = String.valueOf( String.valueOf(newtime.substring(4) + '-' +  n(0) + '-' +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
    //              val put = new Put(Bytes.toBytes(row))
    //              val put_idex = new Put(Bytes.toBytes(row))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VideoID" ), Bytes.toBytes(n(0)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind" ), Bytes.toBytes(n(3)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VideoSource" ), Bytes.toBytes(n(4)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileHash" ), Bytes.toBytes(n(5)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileFormat" ), Bytes.toBytes(n(6)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CodedFormat" ), Bytes.toBytes(n(7)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AudioFlag" ), Bytes.toBytes(n(8)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Title" ), Bytes.toBytes(n(9)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ContentDescription" ), Bytes.toBytes(n(10)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotPlaceCode" ), Bytes.toBytes(n(11)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VideoLen" ), Bytes.toBytes(n(12)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BeginTime" ), Bytes.toBytes(n(13)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EndTime" ), Bytes.toBytes(n(14)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("StoragePath" ), Bytes.toBytes(n(15)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ThumbnailStoragePath" ), Bytes.toBytes(n(16)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotPlaceFullAdress" ), Bytes.toBytes(n(17)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotPlaceLongitude" ), Bytes.toBytes(n(18)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ShotPlaceLatitude" ), Bytes.toBytes(n(19)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EntryClerkOrg" ), Bytes.toBytes(n(20)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EntryTime" ), Bytes.toBytes(n(21)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileSize" ), Bytes.toBytes(n(22)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
    //              puts.add(put)
    //
    //
    //              //更新索引
    //              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
    //              puts_index.add(put_idex)
    //
    //              if (puts.size % 1000 == 0) {
    //                table.put(puts)
    //                table_index.put(puts_index)
    //                puts.clear()
    //              }
    //            }
    //          )
    //          if (puts.size() > 0)
    //          {
    //            table.put(puts)
    //            table_index.put(puts_index)
    //            puts.clear()
    //          }
    //
    //          table.close()
    //          connection.close()
    //      }
    //    )
    //
    //    ds_Case.foreachRDD(
    //      r => r.foreachPartition {
    //        p =>
    //          val conf = HBaseConfiguration.create()
    //          val connection = HConnectionManager.createConnection(conf)
    //          val table = connection.getTable("CaseListMessagePooldb")
    //          val table_index = connection.getTable("idx_CaseListMessagePooldb_row")
    //          val puts = new ArrayList[Put]
    //          val puts_index = new ArrayList[Put]
    //
    //          p.foreach(
    //            n => {
    //              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
    //              val row = String.valueOf( String.valueOf(newtime.substring(4) + '-' +  n(0) + '-' +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
    //              val put = new Put(Bytes.toBytes(row))
    //              val put_idex = new Put(Bytes.toBytes(row))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CaseID"), Bytes.toBytes(n(0)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CaseName"), Bytes.toBytes(n(3)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CaseAbstract"), Bytes.toBytes(n(4)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ClueID"), Bytes.toBytes(n(5)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("TimeUpLimit"), Bytes.toBytes(n(6)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CreateTime"), Bytes.toBytes(n(7)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlaceCode"), Bytes.toBytes(n(8)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PlaceFullAddress"), Bytes.toBytes(n(9)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("MotorVehicleIDs"), Bytes.toBytes(n(10)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NonMotorVehicleIDs"), Bytes.toBytes(n(11)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PersonIDs"), Bytes.toBytes(n(12)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceIDs"), Bytes.toBytes(n(13)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ThingIDs"), Bytes.toBytes(n(14)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SceneIDs"), Bytes.toBytes(n(15)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("State"), Bytes.toBytes(n(16)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoFileID"), Bytes.toBytes(n(17)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoInfoKind"), Bytes.toBytes(n(18)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoSource"), Bytes.toBytes(n(19)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoFileName"), Bytes.toBytes(n(20)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoStoragePath"), Bytes.toBytes(n(21)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoFileHash"), Bytes.toBytes(n(22)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoFileFormat"), Bytes.toBytes(n(23)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoTitle"), Bytes.toBytes(n(24)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoEntryTime"), Bytes.toBytes(n(25)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FileInfoFileSize"), Bytes.toBytes(n(26)))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
    //              puts.add(put)
    //
    //
    //              //更新索引
    //              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
    //              puts_index.add(put_idex)
    //
    //              if (puts.size % 1000 == 0) {
    //                table.put(puts)
    //                table_index.put(puts_index)
    //                puts.clear()
    //              }
    //            }
    //          )
    //          if (puts.size() > 0)
    //          {
    //            table.put(puts)
    //            table_index.put(puts_index)
    //            puts.clear()
    //          }
    //
    //          table.close()
    //          connection.close()
    //      }
    //    )


    //todo 智安===============================================================================================================
    ds_faceZA_.foreachRDD(
      r => r.foreachPartition {
        p =>
          val conf = HBaseConfiguration.create()
          val connection = HConnectionManager.createConnection(conf)
          val table = connection.getTable("ZA_FaceCaptureListdb")
          val table_index = connection.getTable("idx_ZA_FaceCaptureListdb_all_row")
          val puts = new ArrayList[Put]
          val puts_index = new ArrayList[Put]
          val jedis2: Jedis = RedisConnect.pool.getResource

          p.foreach(
            n => {
              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
              val row = String.valueOf(String.valueOf(newtime.substring(4) + '-' + n(0) + '-' + n(13) + '-' + n(3) + '-' + (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
              val put = new Put(Bytes.toBytes(row))
              //              val put_idex = new Put(Bytes.toBytes(row))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RLZPXXBZ"), Bytes.toBytes(n(0)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CJSJ"), Bytes.toBytes(n(3)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("isHit"), Bytes.toBytes(n(4)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SFJSY_PDBZ"), Bytes.toBytes(n(5)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Brard"), Bytes.toBytes(n(6)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("XBDM"), Bytes.toBytes(n(7)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BeginTime"), Bytes.toBytes(n(8)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ChannelCode"), Bytes.toBytes(n(9)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Mask"), Bytes.toBytes(n(10)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SFGZRY_PDBZ"), Bytes.toBytes(n(11)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SPTXXXYYSXDXBZ"), Bytes.toBytes(n(12)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CJSBXXBZ"), Bytes.toBytes(n(13))) //采集设备标识
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SY_YS"), Bytes.toBytes(n(14)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("OccurrenceCount"), Bytes.toBytes(n(15)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GlobalScenePicUrl"), Bytes.toBytes(n(16)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Eye"), Bytes.toBytes(n(17)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Mouth"), Bytes.toBytes(n(18)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceImgUrl"), Bytes.toBytes(n(19)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("XZ_YS"), Bytes.toBytes(n(20)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ChannelSeq"), Bytes.toBytes(n(21)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RLCJT_URL"), Bytes.toBytes(n(22)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EndTime"), Bytes.toBytes(n(23)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("TP"), Bytes.toBytes(n(24)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Age"), Bytes.toBytes(n(25)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SFBKRY_PDBZ"), Bytes.toBytes(n(26)))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
              puts.add(put)

              tUtils.hincrByRedis(jedis2, n(13))

              //更新索引
              //更新索引  解决api插入hbase \x00 无法解析问题
              val union_ = 0.toByte
              val union = Array[Byte](union_)

              val a = Bytes.toBytes(row)
              val b = Bytes.toBytes(n(13))
              val c = Bytes.toBytes(n(3))

              val d = ArrayUtils.addAll(a, union)
              val e = ArrayUtils.addAll(d, b)
              val f = ArrayUtils.addAll(e, union)
              val row_all = ArrayUtils.addAll(f, c)

              val put_idex = new Put(row_all)
              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
              puts_index.add(put_idex)

              if (puts.size % 1000 == 0) {
                table.put(puts)
                table_index.put(puts_index)
                puts.clear()
              }
            }
          )
          if (puts.size() > 0) {
            table.put(puts)
            table_index.put(puts_index)
            puts.clear()
          }

          jedis2.close()
          table.close()
          connection.close()
      }
    )

    ds_motoZA_.foreachRDD(
      r => r.foreachPartition {
        p =>
          val conf = HBaseConfiguration.create()
          val connection = HConnectionManager.createConnection(conf)
          val table = connection.getTable("ZA_MotorVehicleEventListdb")
          val table_index = connection.getTable("idx_ZA_MotorVehicleEventListdb_all_row")
          val puts = new ArrayList[Put]
          val puts_index = new ArrayList[Put]
          val jedis2: Jedis = RedisConnect.pool.getResource

          p.foreach(
            n => {
              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
              val row = String.valueOf(String.valueOf(newtime.substring(4) + '-' + n(0) + '-' + n(9) + '-' + n(3) + '-' + (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
              val put = new Put(Bytes.toBytes(row))
              //              val put_idex = new Put(Bytes.toBytes(row))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JDCGCXXBZ"), Bytes.toBytes(n(0)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CJSJ"), Bytes.toBytes(n(3)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CarWayCode"), Bytes.toBytes(n(4)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DevId"), Bytes.toBytes(n(5)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CLQJTXBZ"), Bytes.toBytes(n(6)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CLXH"), Bytes.toBytes(n(7)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JDCCLLXDM"), Bytes.toBytes(n(8)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CJSBXXBZ"), Bytes.toBytes(n(9)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SFWZDCL_PDBZ"), Bytes.toBytes(n(10)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JDCHPZLDM"), Bytes.toBytes(n(11)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DevName"), Bytes.toBytes(n(12)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsMotorVehicleReg"), Bytes.toBytes(n(13)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GCFX"), Bytes.toBytes(n(14)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CarImgUrl"), Bytes.toBytes(n(15)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JDCHPYSDM"), Bytes.toBytes(n(16)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CarNumPic"), Bytes.toBytes(n(17)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JDCCSYSDM"), Bytes.toBytes(n(18)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DevChnName"), Bytes.toBytes(n(19)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CLHPTXBZ"), Bytes.toBytes(n(20)))
              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JDCHPHM"), Bytes.toBytes(n(21)))

              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
              puts.add(put)

              tUtils.hincrByRedis(jedis2, n(9))

              //更新索引
              //更新索引  解决api插入hbase \x00 无法解析问题
              val union_ = 0.toByte
              val union = Array[Byte](union_)

              val a = Bytes.toBytes(row)
              val b = Bytes.toBytes(n(9))
              val c = Bytes.toBytes(n(3))

              val d = ArrayUtils.addAll(a, union)
              val e = ArrayUtils.addAll(d, b)
              val f = ArrayUtils.addAll(e, union)
              val row_all = ArrayUtils.addAll(f, c)

              val put_idex = new Put(row_all)

              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
              puts_index.add(put_idex)

              if (puts.size % 1000 == 0) {
                table.put(puts)
                table_index.put(puts_index)
                puts.clear()
              }
            }
          )
          if (puts.size() > 0) {
            table.put(puts)
            table_index.put(puts_index)
            puts.clear()
          }

          jedis2.close()
          table.close()
          connection.close()
      }
    )





    //
    //    ds_face.map(x=>x(1)).foreachRDD(rdd=>{
    //      if (!rdd.isEmpty()){
    //        EsSpark.saveJsonToEs(rdd,s"facelist/doc")
    //      }
    //    })
    //
    //    ds_image.map(x=>x(1)).foreachRDD(rdd=>{
    //      if (!rdd.isEmpty()){
    //        EsSpark.saveJsonToEs(rdd,s"imagelist/doc")
    //      }
    //    })
    //
    //    ds_person.map(x=>x(1)).foreachRDD(rdd=>{
    //      if (!rdd.isEmpty()){
    //        EsSpark.saveJsonToEs(rdd,s"personlist/doc")
    //      }
    //    })
    //
    //    ds_moto.map(x=>x(1)).foreachRDD(rdd=>{
    //      if (!rdd.isEmpty()){
    //        EsSpark.saveJsonToEs(rdd,s"motolist/doc")
    //      }
    //    })
    //
    //
    //    ds_faceZA_.map(x=>x(1)).foreachRDD(rdd=>{
    //      if (!rdd.isEmpty()){
    //        EsSpark.saveJsonToEs(rdd,s"faceZAlist/doc")
    //      }
    //    })
    //
    //    ds_motoZA_.map(x=>x(1)).foreachRDD(rdd=>{
    //      if (!rdd.isEmpty()){
    //        EsSpark.saveJsonToEs(rdd,s"motoZAlist/doc")
    //      }
    //    })
    //


    /*
+------------+--------------+-------------------------------------------+---------------+------------+
| TABLE_CAT  | TABLE_SCHEM  |                TABLE_NAME                 |  TABLE_TYPE   | INDEX_STAT |
+------------+--------------+-------------------------------------------+---------------+------------+
|            |              | idx_CaseListMessagePooldb_row             | INDEX         | ACTIVE     |
|            |              | idx_FileListMessagePooldb_row             | INDEX         | ACTIVE     |
|            |              | idx_MotorVehicleListMessagePooldb_row     | INDEX         | ACTIVE     |
|            |              | idx_NonMotorVehicleListMessagePooldb_row  | INDEX         | ACTIVE     |
|            |              | idx_SceneListMessagePooldb_row            | INDEX         | ACTIVE     |
|            |              | idx_ThingListMessagePooldb_row            | INDEX         | ACTIVE     |
|            |              | idx_VideoSliceListMessagePooldb_row       | INDEX         | ACTIVE     |
|            |              | idx_faceListMessagePooldb_row             | INDEX         | ACTIVE     |
|            |              | idx_imageListMessagePooldb_row            | INDEX         | ACTIVE     |
|            |              | idx_personListMessagePooldb_row           | INDEX         | ACTIVE     |
|            | SYSTEM       | CATALOG                                   | SYSTEM TABLE  |            |
|            | SYSTEM       | FUNCTION                                  | SYSTEM TABLE  |            |
|            | SYSTEM       | LOG                                       | SYSTEM TABLE  |            |
|            | SYSTEM       | SEQUENCE                                  | SYSTEM TABLE  |            |
|            | SYSTEM       | STATS                                     | SYSTEM TABLE  |            |
|            |              | CaseListMessagePooldb                     | TABLE         |            |
|            |              | FileListMessagePooldb                     | TABLE         |            |
|            |              | MASSAGE_COUNT                             | TABLE         |            |
|            |              | MASSAGE_DEVICE_COUNT                      | TABLE         |            |
|            |              | MotorVehicleListMessagePooldb             | TABLE         |            |
|            |              | NonMotorVehicleListMessagePooldb          | TABLE         |            |
|            |              | SceneListMessagePooldb                    | TABLE         |            |
|            |              | ThingListMessagePooldb                    | TABLE         |            |
|            |              | VideoSliceListMessagePooldb               | TABLE         |            |
|            |              | faceListMessagePooldb                     | TABLE         |            |
|            |              | imageListMessagePooldb                    | TABLE         |            |
|            |              | personListMessagePooldb                   | TABLE         |            |
+------------+--------------+-------------------------------------------+---------------+------------+


    */


    ssc.start()
    ssc.awaitTermination()
  }
}

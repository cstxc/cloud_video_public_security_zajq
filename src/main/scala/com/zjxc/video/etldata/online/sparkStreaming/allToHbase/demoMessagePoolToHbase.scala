package com.zjxc.video.etldata.online.sparkStreaming.allToHbase

import java.text.SimpleDateFormat
import java.util.{ArrayList, Date}

import com.zjxc.video.etldata.online.Utils.{RabbitMQUtils, RedisConnect, tUtils}
import com.zjxc.video.etldata.online.Utils.tUtils.parseJsonDistinguish
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
       *@ClassName  demoMessagePoolToHbase
       *@description    TODO
       *@author     Whoami
       *@date   2020/12/21
       *@version 1.0
       spark-submit \
  --class com.zjxc.video.etldata.online.sparkStreaming.allToHbase.allMessagePoolToHbase  \
  --master yarn \
  --driver-memory 2G \
  --executor-memory 2G \
  --deploy-mode client \
  --num-executors  2 \
  --executor-cores  2 \
  --jars  /opt/project/zgjq_spark/mysql-connector-java-5.1.32.jar \
  /opt/project/zgjq_spark/cloud_video_public_security_zajq.jar

*/
object demoMessagePoolToHbase {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName(s"${this.getClass.getSimpleName}".replace("$", ""))
      .set("es.index.auto.create", "true")
      .set("es.index.read.missing.as.empty", "true")
      .set("es.nodes", "172.18.248.114")
      .set("es.port", "9200")

    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)


    val ssc = new StreamingContext(conf, Seconds(5))
    ssc.sparkContext.setLogLevel("ERROR") // ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN


    val lines = RabbitMQUtils.createStreamFromAQueue(ssc,
      "172.18.248.212",
      5672,
      "/",
      "admin",
      "admin@zajq",
      "demoMessagePool",
      true,
      true,
      1000,
      3, StorageLevel.MEMORY_AND_DISK_SER_2
    )


    //todo n points return to vitality   1400协议
    val ds_face = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "faceListMessagePooldb")

    ds_face.print(1)

    //    ds_face.foreachRDD(
    //      r => r.foreachPartition {
    //        p =>
    //          val conf = HBaseConfiguration.create()
    //          val connection = HConnectionManager.createConnection(conf)
    //          val table = connection.getTable("faceListMessagePooldb")
    //          val table_index = connection.getTable("idx_faceListMessagePooldb_all_row")
    //          val puts = new ArrayList[Put]
    //          val puts_index = new ArrayList[Put]
    //          val jedis2:Jedis = RedisConnect.pool.getResource
    //
    //          p.foreach(
    //            n => {
    //              val newtime = new SimpleDateFormat("yyMMddHHmm").format(new Date).reverse
    //              val row = String.valueOf( String.valueOf(newtime.substring(4) + '-' +  n(0) + '-' + n(5) +  (new SimpleDateFormat("SSS").format(new Date)) + Math.random().toString.substring(3, 6) + newtime.substring(0, 4)))
    //              val put = new Put(Bytes.toBytes(row))
    ////              val put_idex = new Put(Bytes.toBytes(row))
    //
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceID"), Bytes.toBytes(n(0)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InfoKind"), Bytes.toBytes(n(3)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SourceID"), Bytes.toBytes(n(4)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DeviceID"), Bytes.toBytes(n(5)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopX"), Bytes.toBytes(n(6)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LeftTopY"), Bytes.toBytes(n(7)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmX"), Bytes.toBytes(n(8)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RightBtmY"), Bytes.toBytes(n(9)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LocationMarkTime"), Bytes.toBytes(n(10)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceAppearTime"), Bytes.toBytes(n(11)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceDisAppearTime"), Bytes.toBytes(n(12)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IDType"), Bytes.toBytes(n(13)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IDNumber"), Bytes.toBytes(n(14)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Name"), Bytes.toBytes(n(15)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("UsedName"), Bytes.toBytes(n(16)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Alias"), Bytes.toBytes(n(17)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GenderCode"), Bytes.toBytes(n(18)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AgeUpLimit"), Bytes.toBytes(n(19)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AgeLowerLimit"), Bytes.toBytes(n(20)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EthicCode"), Bytes.toBytes(n(21)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NationalityCode"), Bytes.toBytes(n(22)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NativeCityCode"), Bytes.toBytes(n(23)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ResidenceAdminDivision"), Bytes.toBytes(n(24)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ChineseAccentCode"), Bytes.toBytes(n(25)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JobCategory"), Bytes.toBytes(n(26)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AccompanyNumber"), Bytes.toBytes(n(27)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SkinColor"), Bytes.toBytes(n(28)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HairStyle"), Bytes.toBytes(n(29)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("HairColor"), Bytes.toBytes(n(30)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FaceStyle"), Bytes.toBytes(n(31)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FacialFeature"), Bytes.toBytes(n(32)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PhysicalFeature"), Bytes.toBytes(n(33)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("RespiratorColor"), Bytes.toBytes(n(34)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CapStyle"), Bytes.toBytes(n(35)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CapColor"), Bytes.toBytes(n(36)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GlassStyle"), Bytes.toBytes(n(37)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("GlassColor"), Bytes.toBytes(n(38)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDriver"), Bytes.toBytes(n(39)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsForeigner"), Bytes.toBytes(n(40)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("PassportType"), Bytes.toBytes(n(41)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImmigrantTypeCode"), Bytes.toBytes(n(42)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsSuspectedTerrorist"), Bytes.toBytes(n(43)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("SuspectedTerroristNumber"), Bytes.toBytes(n(44)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsCriminalInvolved"), Bytes.toBytes(n(45)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CriminalInvolvedSpecilisationCode"), Bytes.toBytes(n(46)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("BodySpeciallMark"), Bytes.toBytes(n(47)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CrimeMethod"), Bytes.toBytes(n(48)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CrimeCharacterCode"), Bytes.toBytes(n(49)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EscapedCriminalNumber"), Bytes.toBytes(n(50)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsDetainees"), Bytes.toBytes(n(51)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetentionHouseCode"), Bytes.toBytes(n(52)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetaineesIdentity"), Bytes.toBytes(n(53)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("DetaineesSpecialIdentity"), Bytes.toBytes(n(54)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("MemberTypeCode"), Bytes.toBytes(n(55)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsVictim"), Bytes.toBytes(n(56)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("VictimType"), Bytes.toBytes(n(57)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("InjuredDegree"), Bytes.toBytes(n(58)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("CorpseConditionCode"), Bytes.toBytes(n(59)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("IsSuspiciousPerson"), Bytes.toBytes(n(60)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Attitude"), Bytes.toBytes(n(61)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("Similaritydegree"), Bytes.toBytes(n(62)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("EyebrowStyle"), Bytes.toBytes(n(63)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("NoseStyle"), Bytes.toBytes(n(64)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("MustacheStyle"), Bytes.toBytes(n(65)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("LipStyle"), Bytes.toBytes(n(66)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("WrinklePouch"), Bytes.toBytes(n(67)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("AcneStain"), Bytes.toBytes(n(68)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("FreckleBirthmark"), Bytes.toBytes(n(69)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ScarDimple"), Bytes.toBytes(n(70)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("OtherFeature"), Bytes.toBytes(n(71)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoImageID"), Bytes.toBytes(n(72)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoEventSort"), Bytes.toBytes(n(73)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoDeviceID"), Bytes.toBytes(n(74)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoStoragePath"), Bytes.toBytes(n(75)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoType"), Bytes.toBytes(n(76)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoFileFormat"), Bytes.toBytes(n(77)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoShotTime"), Bytes.toBytes(n(78)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoWidth"), Bytes.toBytes(n(79)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ImageInfoHeight"), Bytes.toBytes(n(80)))
    //              put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("JSONMessage"), Bytes.toBytes(n(1)))
    //              puts.add(put)
    //
    //              tUtils.hincrByRedis( jedis2, n(5))
    //
    //              //更新索引  解决api插入hbase \x00 无法解析问题
    //              val union_ = 0.toByte
    //              val union = Array[Byte](union_)
    //
    //              val a = Bytes.toBytes(row)
    //              val b = Bytes.toBytes(n(5))
    //              val c = Bytes.toBytes(n(78))
    //
    //              val d = ArrayUtils.addAll(a,union)
    //              val e = ArrayUtils.addAll(d,b)
    //              val f = ArrayUtils.addAll(e,union)
    //              val row_all = ArrayUtils.addAll(f,c)
    //
    //              val put_idex = new Put(row_all)
    //
    //              put_idex.addColumn(Bytes.toBytes("0"), Bytes.toBytes("_0"), Bytes.toBytes("x"))
    //              puts_index.add(put_idex)
    //
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


    ds_face.map(x => x(1)).foreachRDD(rdd => {
      if (!rdd.isEmpty()) {
        EsSpark.saveJsonToEs(rdd, s"facelist/doc")
      }
    })

    ssc.start()
    ssc.awaitTermination()
  }

}

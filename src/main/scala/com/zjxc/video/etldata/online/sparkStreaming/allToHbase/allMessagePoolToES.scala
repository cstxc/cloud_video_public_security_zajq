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
       *@ClassName  demoMessagePoolToES
       *@description    TODO
       *@author     Whoami
       *@date   2020/12/21

       *@version 1.0
       nohup /opt/app/elasticsearch-7.5.1/bin/elasticsearch    2>&1 &
       nohup /opt/app/kibana-7.5.1/bin/kibana --allow-root &
       * ./kibana --allow-root &   然后exit退出

  spark-submit \
  --class com.zjxc.video.etldata.online.sparkStreaming.allToHbase.allMessagePoolToES  \
  --master yarn \
  --driver-memory 2G \
  --executor-memory 2G \
  --deploy-mode client \
  --num-executors  2 \
  --executor-cores  2 \
  --jars  /opt/project/zgjq_spark/mysql-connector-java-5.1.32.jar \
  /opt/project/zgjq_spark/es_zgjq_streaming/cloud_video_public_security_zajq.jar

*
*
* */
object allMessagePoolToES {
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
    val ds_image = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "imageListMessagePooldb")
    val ds_person = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "personListMessagePooldb")
    val ds_moto = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "MotorVehicleListMessagePooldb")


    //todo 金华ZA  主题
    val ds_faceZA_ = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "ZA_FaceCaptureListdb")
    val ds_motoZA_ = lines.map(x => parseJsonDistinguish(x)).filter(_ != null).filter(_ (2) == "ZA_MotorVehicleEventListdb")


    ds_face.print(1)
    ds_image.print(1)
    ds_person.print(1)
    ds_moto.print(1)

    ds_faceZA_.print(1)
    ds_motoZA_.print(1)

    try {
      ds_face.map(x => x(1)).foreachRDD(rdd => {
        if (!rdd.isEmpty()) {
          EsSpark.saveJsonToEs(rdd, s"facelist/doc")
        }
      })


      ds_image.map(x => x(1)).foreachRDD(rdd => {
        if (!rdd.isEmpty()) {
          EsSpark.saveJsonToEs(rdd, s"imagelist/doc")
        }
      })


      ds_person.map(x => x(1)).foreachRDD(rdd => {
        if (!rdd.isEmpty()) {
          EsSpark.saveJsonToEs(rdd, s"personlist/doc")
        }
      })

      ds_moto.map(x => x(1)).foreachRDD(rdd => {
        if (!rdd.isEmpty()) {
          EsSpark.saveJsonToEs(rdd, s"motolist/doc")
        }
      })

      ds_faceZA_.map(x => x(1)).foreachRDD(rdd => {
        if (!rdd.isEmpty()) {
          EsSpark.saveJsonToEs(rdd, s"zaface/doc")
        }
      })

      ds_motoZA_.map(x => x(1)).foreachRDD(rdd => {
        if (!rdd.isEmpty()) {
          EsSpark.saveJsonToEs(rdd, s"zamoto/doc")
        }
      })
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
    }


    ssc.start()
    ssc.awaitTermination()
  }

}

package com.zjxc.video.etldata.online.Utils

import redis.clients.jedis.{JedisPool, JedisPoolConfig}

/*
       *@ClassName  RedisConnect
       *@description    TODO
       *@author     Whoami
       *@date   2020/9/18
       *@version 1.0
*/
object RedisConnect {
  val config = new JedisPoolConfig()

  config.setMaxTotal(100)
  config.setMaxIdle(200)
  config.setMaxWaitMillis(10000)
  config.setTestOnBorrow(true)

  //6379
  val pool: JedisPool = new JedisPool(config, "172.18.248.212", 6381, 10000, "4h3hEVMWfYfZ")

}

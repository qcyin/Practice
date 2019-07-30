package com.com

import com.com.utils.DBUtil
//import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

object JdbcRDDTest {


  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("jdbcRDD")
    val sc = new SparkContext(sparkConf)

    // 获取某表中的字段
    val sql = "select id,`name` from orders where id >= ? and id < ?"
    // 取出数据库某表中的数据放到RDD里
    // 上限和下限以及分区数
    val jdbcRdd = new JdbcRDD(sc,DBUtil.getConnection,sql,1,100,1,res =>{
      val id = res.getInt("id")
      val name = res.getString("name")
      println("MaxActive --->"+DBUtil.dds.getActiveCount)
      (id,name)
    })
    jdbcRdd.foreach(println)
    println("MaxActive --->"+DBUtil.dds.getActiveCount)
    sc.stop()

  }
}

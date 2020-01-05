package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object regx_df {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession
      .builder()
      .master("local")
      .appName("Regular Expression in DataFrame")
      .getOrCreate()

    val data = spark.read.csv("C:\\Users\\91843\\Desktop\\log_data.txt")
//    data.withColumn("ip_add",reg)

  }

}

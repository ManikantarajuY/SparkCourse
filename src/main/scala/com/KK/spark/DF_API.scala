package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DF_API {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder().master("local").appName("Things can be done Using DF APIS").getOrCreate()

    val data = spark.read.option("header",true).option("inferSchema",true)
      .csv("src/resource/csv/userdata1.csv")

    data.select("gender","country").show(7)
    data.groupBy("gender","country").count().show()
    data.groupBy("country").count().show()
    data.groupBy("gender").count().show()
    data.select("gender").distinct().show()
    data.orderBy("country").groupBy("country").count().show()
    data.groupBy("country","gender").count.show
    data.sort("gender").groupBy("country").count().show()
    data.dropDuplicates("gender","country").show()
    data.dropDuplicates("comments").count()
  }

}

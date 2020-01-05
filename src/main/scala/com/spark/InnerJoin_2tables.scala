package com.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object InnerJoin_2tables {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder()
      .appName("Inner Join using two DF")
      .master("local")
      .getOrCreate()



    val df1 = spark.read.option("inferSchema","true").option("header","true").csv("src/resource/csv/userdata1.csv")
    val df2 = spark.read.option("inferSchema","true").option("header","true").csv("src/resource/csv/userdata2.csv")

    df1.createOrReplaceTempView("t1")
    df2.createOrReplaceTempView("t2")

    spark.sqlContext.sql("select t1.first_name,t2.first_name,t1.country,t2.country from t1 inner join t2 on t1.id = t2.id")
      .show(7)

  }

}

package com.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object adding_column {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder()
      .appName("Adding column from existing column")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    val df1 = spark.read.option("inferSchema","true")
      .option("header","true").csv("src/resource/csv/userdata1.csv")

    df1.show(7)
    val Year = df1.withColumn("Year",$"registration_dttm".substr(0,4))
    Year.show(9)
  }

}

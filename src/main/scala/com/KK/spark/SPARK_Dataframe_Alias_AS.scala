package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object SPARK_Dataframe_Alias_AS {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("SPARK Dataframe Alias AS")
      .master("local")
      .getOrCreate()

    import spark.implicits._

    val data = spark.read.option("header",true)
      .option("inferSchema",true)
      .csv("src/resource/csv/userdata1.csv")

    data.show(3)
    val alias_AS = data.select($"registration_dttm".alias("time"),$"email")
    alias_AS.show(3)

    println("Using alias for a table/column either using alias/as")
    val table_alias = data.as("Alias_Table")
      .select($"ip_address",$"birthdate".as("DOB"),$"salary")
    table_alias.show(3)

  }

}

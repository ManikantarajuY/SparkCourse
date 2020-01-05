package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.functions._

object win_f2 {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("Window Functions").getOrCreate()

    val sch = StructType(
      StructField("ID",IntegerType,true)::
      StructField("C_id",IntegerType,true)::
      StructField("Dept",StringType,true)::Nil
    )
    val data = spark.read.option("header",false).schema(sch).csv("src/resource/retail_db/categories/part-00000")
    data.show()
    val win = Window.partitionBy("C_id").orderBy("Dept")
    data.withColumn("rank",rank().over(win)).show()
    data.withColumn("d_rank",dense_rank().over(win)).show()

  }

}

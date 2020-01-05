package com.spark

import org.apache.spark.sql.SparkSession

object two_table_joins {
  def main(args:Array[String]):Unit ={
    val spark = SparkSession.builder()
      .master("local")
      .appName("Joining Two Json files")
      .getOrCreate()

    val f1 = spark.read
      .json("src/resource/retail_db_json/categories/part-r-00000-ce1d8208-178d-48d3-bfb2-1a97d9c05094")
    val f2 = spark.read
      .json("src/resource/retail_db_json/products/part-r-00000-158b7037-4a23-47e6-8cb3-8cbf878beff7")

    println(f1.rdd.getNumPartitions)
  }


}

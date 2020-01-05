package com.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Schema_CreateDF {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession
      .builder()
      .appName("Creating Schema and Creating DataFrame")
      .master("local")
      .getOrCreate()

    val c_schema = StructType(
      StructField("ID",IntegerType)::
      StructField("Dept_ID",IntegerType)::
      StructField("Department",StringType)::Nil
    )
    val d_schema = StructType(
        StructField("Dept_ID",IntegerType)::
        StructField("Dept_Name",StringType)::Nil
    )
    val categories = spark.read.schema(c_schema).csv("src/resource/retail_db/categories/part-00000")
    val dept = spark.read.schema(d_schema)csv("src/resource/retail_db/departments/part-00000")
    categories.show(21)
    categories.printSchema()
    dept.show()
    dept.printSchema()

  }

}

package com.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object unmatched_records {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)

    val spark = SparkSession
      .builder()
      .appName("Featching Unmatched records from tow tables")
      .master("local")
      .getOrCreate()

    val s1 = StructType(
      StructField("id",IntegerType,true)::
        StructField("dept",StringType,true)::Nil
    )
    val df = spark.read.option("header",false).schema(s1).csv("src/resource/Interview_data/table1").toDF()
    df.show()

    val s2 = StructType(
      StructField("id",IntegerType,true)::
        StructField("Name",StringType,true)::Nil
    )
    val df2 = spark.read.option("header",false).schema(s2)csv("src/resource/Interview_data/table2")

    df.createOrReplaceTempView("t1")
    df2.createOrReplaceTempView("t2")

    println("records which are unmatched from two tables")
    spark.sqlContext.sql("select * from t1 except select * from t2").show()

    }
}
/*
Note:- Two tables must have same No of columns if we want to find out unmatched records else it will give error
saying that columns are not matched.
 */
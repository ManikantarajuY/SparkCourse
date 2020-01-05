package com.KK.spark

import com.scala.traits.SparkSessionWrapper
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._
import org.apache.spark.sql.DataFrame

object sparkSession extends SparkSessionWrapper{
  def main(args: Array[String]): Unit = {
    import spark.implicits._
    val data = spark.read.option("header", true)
      .option("sep","\t")
      .option("inferSchema", true)
      .csv("src/resource/ls2014.tsv")
    data.show()
    data.printSchema()


//    println("sum of columns")
//      .withColumn(
//        "the_sum",
//        sumColumns(col("some_num"), col("another_num"))
//      )
//      .show()
  }

}

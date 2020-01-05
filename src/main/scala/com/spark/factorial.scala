package com.spark

import com.scala.traits.SparkSessionWrapper
import org.apache.spark.sql.functions._

object factorial extends SparkSessionWrapper{

  def main(args: Array[String]): Unit = {
    import spark.implicits._
//
//    val df = Seq(2, 3, 4).toDF("number")
//
//    df
//      .withColumn("number_factorial", factorial($"number"))
//      .show()
  }
}

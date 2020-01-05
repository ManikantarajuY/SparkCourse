package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object drop_dup {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder().master("local")
      .appName("Dropping and Collapsing records").getOrCreate()

    import spark.implicits._
    val df = Seq(
      ("a", "b", 1),
      ("a", "b", 2),
      ("a", "b", 3),
      ("z", "b", 4),
      ("a", "x", 5)
    ).toDF("letter1", "letter2", "number1")

    df.show()
    df.dropDuplicates("letter1","letter2").show()
    println("Collapsing records")
    df.groupBy("letter1","letter2").agg(collect_list("number1")as "numbers")
      .orderBy("numbers")
      .show(false)
  }

}

package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object broadcast_join {
  Logger.getLogger("org").setLevel(Level.OFF)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder().master("local")
      .appName("Collapsing_records to Data Marts").getOrCreate()
    import spark.implicits._

    val peopleDF = Seq(
      ("andrea", "medellin"),
      ("rodolfo", "medellin"),
      ("abdul", "bangalore")
    ).toDF("first_name", "city")

    val citiesDF = Seq(
      ("medellin", "colombia", 2.5),
      ("bangalore", "india", 12.3)
    ).toDF("city", "country", "population")

    citiesDF.show()/*TINY DATA*/
    peopleDF.show()/*HUGE DATA*/

    peopleDF.join(
      broadcast(citiesDF),
      peopleDF("city") <=> citiesDF("city")
    ).show

    peopleDF.join(
      broadcast(citiesDF),
      peopleDF("city") <=> citiesDF("city")
    )
      .drop(citiesDF("city"))
      .show()

    peopleDF.join(
      broadcast(citiesDF),
      Seq("city")
    ).show()

    peopleDF.join(
      citiesDF,
      peopleDF("city") <=> citiesDF("city")
    ).explain()

    peopleDF.join(
      broadcast(citiesDF),
      peopleDF("city") <=> citiesDF("city")
    ).explain()

    peopleDF.join(
      broadcast(citiesDF),
      peopleDF("city") <=> citiesDF("city")
    )
      .drop(citiesDF("city"))
      .explain(true)
  }
}

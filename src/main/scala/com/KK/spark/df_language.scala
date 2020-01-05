package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object df_language {
  def main(args:Array[String]):Unit= {
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    val spark = SparkSession.builder()
      .appName("DataFrame Language")
      .master("local")
      .getOrCreate()
    import spark.implicits._
    val sch = StructType(
        StructField("ID",IntegerType,true)::
        StructField("F_Name",StringType,true)::
        StructField("L_Name",StringType,true)::
        StructField("Mob1",StringType,true)::
        StructField("Mob2",StringType,true)::
        StructField("Address",StringType,true)::
        StructField("City",StringType,true)::
        StructField("P_Id",StringType,true)::
        StructField("Price",IntegerType,true)::Nil
    )
    val data = spark.read
//      .option("delimiter", ",")
      .schema(sch)
      .csv("C:\\Users\\91843\\IdeaProjects\\SparkCourse_SBT\\src\\resource" +
        "\\retail_db\\customers\\part-00000")
//    data.where("Price > 725 and price < 78521").show(7)
    data.filter("Price > 725 and price < 78521").show(7)

    data.groupBy( "City").count.show
    data.select("City").distinct().show()
  }

}
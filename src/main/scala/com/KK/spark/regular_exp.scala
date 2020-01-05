package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object regular_exp {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    val spark = SparkSession
      .builder()
      .master("local")
      .appName("Regular Expression")
      .getOrCreate()


    import spark.implicits._

    val log_data = spark.read.csv("C:\\Users\\91843\\Desktop\\log_data.txt")
    //log_data.show(7,false)
    val ip_pattern = "[0-9]{2,3}.[0-9]{2,3}.[0-9]{3}.[0-9]{1,3}"
    val time_pattern = "[0-9]{2}/[A-Za-z]{3}/[0-9]{4}:[0-9]{2}:[0-9]{2}:[0-9]{2}"

    //yyyy-mm-dd hh:mm:ss

    val abc = log_data
      .withColumn("ipAdd", regexp_extract($"_c0", ip_pattern, 0))
      .withColumn("timeStamp", regexp_extract($"_c0", time_pattern, 0))
        .drop("_c0")

    //val ext2=extr.withColumn("timeStamp",to_timestamp(col("timeStamp")))

    //ext2.printSchema()
    abc.show(false)
    //ext2.show()

//
//    log_data.withColumn("ip_add",split(regexp_extract(ip_pattern,$time_pattern)))

    /*df.withColumn("backrefReplace",split(regexp_replace('VARIABLE,"^([A-z|]+)?;?([\\d\\|]+)?;?(w.*)?$","$1"+sep+"$2"+sep+"$3"),sep))
  .withColumn("letter",explode(split('backrefReplace(0),"\\|")))
  .select('YEAR,$"FIRST NAME",$"LAST NAME",'VARIABLE,'letter,
    explode(split('backrefReplace(1),"\\|")).as("digits"),
    'backrefReplace(2).as("tags")
  )*/
  }
}

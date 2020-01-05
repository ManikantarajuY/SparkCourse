package com.KK.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object collect_list_set {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder().master("local")
      .appName("Collapsing records").getOrCreate()

    import spark.implicits._
    val ccTransactionsDF = Seq(
      ("123", "20180102", 10.49),
      ("123", "20180102", 10.49),
      ("123", "20180102", 77.33),
      ("555", "20180214", 99.99),
      ("888", "20180214", 1.23)
    ).toDF("person_id", "transaction_date", "amount")

    ccTransactionsDF.show()

    ccTransactionsDF.groupBy($"transaction_date", $"person_id").agg(collect_set($"amount") as "amounts")
      .orderBy("amounts")
      .show(false)
  }
}

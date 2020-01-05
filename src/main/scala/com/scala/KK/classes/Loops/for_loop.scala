package com.scala.KK.classes.Loops

object for_loop {
  def main(args: Array[String]): Unit = {

    var sum = 0
    for (i <- 0 to 10 by 2){
      sum = sum+i
      print(" "+i)
    }
    for (i <- 0 until 11 by 1){
      sum = sum+1
      print(" "+sum)
    }

  }

}

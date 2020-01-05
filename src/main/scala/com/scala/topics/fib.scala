package com.scala.topics

object fib {
  def main(args: Array[String]): Unit = {
    var a = 0
    var b = 1

    for( i <- 1 to 10){
      var sum = a+b
      a=b
      b=sum
      println(sum)
    }
  }

}

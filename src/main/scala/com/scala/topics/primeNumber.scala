package com.scala.topics

object primeNumber {
  def main(args: Array[String]): Unit = {
    println("enter value")
    val x:Int = scala.io.StdIn.readInt()
    var c =0

    for (i <- 2 to x/2 by 1) {
      if (x % i == 0)
        c = c + 1
    }
      if (c == 0)
        println("No is "+x+" Prime")
      else
        println("Number is "+x+" Not Prime")
    }
}

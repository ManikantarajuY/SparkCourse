package com.scala.topics

object closures {

  /*Closure:-
    A function return value which is depended on the values of a variables which id declared outside of the function.
    */
  var i = 9
  val j = 3
  def mul: Unit ={
    println(i*3)
  }
  def add: Unit = {
    println(i+j)
  }

  var factor = 3
  def multiple (i:Int)={
    println(i*factor)
  }
  def main(args: Array[String]): Unit = {
    mul
    add
    multiple(7)
  }

}

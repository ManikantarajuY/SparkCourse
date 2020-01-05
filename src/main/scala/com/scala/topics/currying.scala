package com.scala.topics

object currying {

  def mul(i:Int)(j:Int): Unit ={
    i*j
  }

  def main(args: Array[String]): Unit = {
    val res = mul(3)(7)
    println("res = "+res)
    val value1 = mul(9)_
    val result = value1(7)
    println("result of 3*7 "+ result)
  }
}

/*Currying Function:-
when we call a method we must pass all the values of the arguments which we have mentioned.
	or
passing an arguments to a function in a multiple parameters instead of putting in a single parameters.
	when we want to call a function only with less number of arguments
eg:- we have passed 2 arguments and we want to pass only one argument at present
 and the other argument while performing at the time we go with currying Function*/
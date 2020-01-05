package com.scala.traits

class developer extends p_d_trait with t2 with t3 {
  def sum: Unit = {
    println("adding")
  }
  def sub: Unit = {
    println("Subtract")
  }
  def mul: Unit = {
    println("Multiplying")
  }
  override def div: Unit = {
    println("child method in developer class")
  }
  def greetings: Unit ={
    println("hello MKR")
  }
  def hello: Unit ={
    println("may i know ur name please")
  }

}
/*
Traits:-
1.Trairt is the keyword which is used for the class name.
2.Methods which are present in Trait class, all the methods must be implemented in the inherated classes.
3.we can inherate multiple traits for a class by using keyword extends and WITH.
4.we can have methods with and with out implementation in traits.
	if we have methods with implementation in traits class that can be override in a class with the key word OVERRIDE
 */

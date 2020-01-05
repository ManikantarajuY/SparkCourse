package com.scala.traits

class deginer extends p_d_trait {
  def sum: Unit = {
    println("adding")
  }
  def sub: Unit = {
    println("adding")
  }
  def mul: Unit = {
    println("adding")
  }
  override def div: Unit ={
    println("parent method in deginer class")
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
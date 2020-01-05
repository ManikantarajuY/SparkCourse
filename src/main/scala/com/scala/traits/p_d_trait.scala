package com.scala.traits

trait p_d_trait {
  def sum
  def sub
  def mul
  def div: Unit ={
    println("parent method in trait class")
  }

}
/*
Traits:-
1.Trait is the keyword which is used for the class name.
2.Methods which are present in Trait class, all the methods must be implemented in the inherited classes.
3.we can inherit multiple traits for a class by using keyword extends and WITH.
4.we can have methods with and with out implementation in traits.
	if we have methods with implementation in traits class that can be override in a class with the key word OVERRIDE
 */
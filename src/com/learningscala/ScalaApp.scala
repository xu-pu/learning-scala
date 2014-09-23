package com.learningscala

object ScalaApp {

  def main(args: Array[String]){
    helloworld()
    ComplexTest.complexVariableTest()
    TreeTest.treeTest()
    JsonTest.jsonTest()
  }

  def helloworld() = println("HelloWorld!")

}

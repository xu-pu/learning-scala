package com.learningscala

object ScalaApp {

  def main(args: Array[String]){
    helloworld()
    complexVariableTest()
    treeTest()
  }

  def helloworld(): Unit ={
    println("HelloWorld!")
  }

  def complexVariableTest(): Unit ={
    val cv1 = new Complex(1,1)
    println(cv1)
  }

  def treeTest(): Unit ={
    val mytree =
      Node(
        Node(
          Leaf(1),
          Leaf(1)
        ),
        Node(
          Leaf(1),
          Leaf(1)
        )
      )
    println(mytree.left)
  }

}

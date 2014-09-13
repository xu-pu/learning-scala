package com.learningscala

import spray.json._

import MyJsonProtocol._

object ScalaApp {

  def main(args: Array[String]){
    helloworld()
    complexVariableTest()
    treeTest()
    jsonTest()
  }

  def helloworld() = println("HelloWorld!")

  def complexVariableTest() = {
    val cv1 = new Complex(1,1)
    println(cv1)
  }

  def arrayTest() = {
    val myarray = Array(6, 3, 4, 5, 6)
    val mapped = myarray.map(x => x + 3)
    val filtered = mapped.filter(x => x < 5)
    val myrange = (1 to 20).map(x => x + 1)
    myrange
  }

  def treeTest() = {
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

  def jsonTest() = {
    val jsonObj = Map(
      "col" -> 1,
      "row" ->2,
      "direction" -> 3,
      "scale" -> 4
    )
    val jsonAst = jsonObj.toJson
    println(jsonAst)
    val scalaObj = jsonAst.convertTo[Feature]
    println(scalaObj)
    println(scalaObj.col)
    println(scalaObj.row)
  }

}

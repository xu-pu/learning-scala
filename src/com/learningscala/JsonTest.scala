package com.learningscala

import scala.io.Source
import spray.json._
import spray.json.DefaultJsonProtocol._
import MyJsonProtocol._

class Feature(val row: Double, val col: Double, val scale: Double, val direction: Double)

class Descriptor(val row: Double, val col: Double, val scale: Double, val direction: Double, val vector: Vector[Double])

object MyJsonProtocol {

  implicit object FeatureJsonFormat extends RootJsonFormat[Feature] {

    def write(f: Feature) = JsObject(
      "row" -> JsNumber(f.row),
      "col" -> JsNumber(f.col),
      "scale" -> JsNumber(f.scale),
      "direction" -> JsNumber(f.direction)
    )

    def read(json: JsValue) = {
      json.asJsObject.getFields("row", "col", "scale", "direction", "vector") match {
        case Seq(JsNumber(row), JsNumber(col), JsNumber(scale), JsNumber(direction)) =>
          new Feature(row.toDouble, col.toDouble, scale.toDouble, direction.toDouble)
        case _ => throw new DeserializationException("value is invalid!")
      }
    }

  }

  implicit object DescriptorJsonFormat extends RootJsonFormat[Descriptor] {

    def write(f: Descriptor) = JsObject(
      "row" -> JsNumber(f.row),
      "col" -> JsNumber(f.col),
      "scale" -> JsNumber(f.scale),
      "direction" -> JsNumber(f.direction),
      "vector" -> JsArray(f.vector.map(x=>JsNumber(x)).toList)
    )

    def read(json: JsValue) = {
      json.asJsObject.getFields("row", "col", "scale", "direction") match {
        case Seq(JsNumber(row), JsNumber(col), JsNumber(scale), JsNumber(direction)) =>
          new Descriptor(row.toDouble, col.toDouble, scale.toDouble, direction.toDouble, Vector[Double](1,2,3,4))
        case _ => throw new DeserializationException("value is invalid!")
      }
    }

  }

}

object JsonTest {

  def main(args: Array[String]) = {
    featureTest()
    descriptorTest()
  }

  def descriptorTest() = {
    val desObj = new Descriptor(1, 2, 3, 4, Vector[Double](1,2,3,4,5))
    val jsonAst = desObj.toJson
    println(jsonAst)
    val objAgain = jsonAst.convertTo[Descriptor]
    println(objAgain.vector)
  }

  def featureTest() = {
    val jsonObj = Map(
      "col" -> 1,
      "row" ->2,
      "direction" -> 3,
      "scale" -> 4
    )
    val jsonAst = jsonObj.toJson
    println(jsonAst)
    println(jsonAst.asJsObject.fields("scale"))
    val scalaObj = jsonAst.convertTo[Feature]
    println(scalaObj)
  }

  def jsonFileTest() = {
    val myfile = Source.fromFile("/home/sheep/Code/Project/web-sfm/demo/Hall-Demo/sift.json/00000001.json")
    val myjson = myfile.mkString.parseJson
    println(myjson.asJsObject.getFields("features"))
  }

}
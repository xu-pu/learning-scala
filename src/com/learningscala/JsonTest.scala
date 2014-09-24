package com.learningscala

import scala.io.Source
import spray.json._
import spray.json.DefaultJsonProtocol._
import MyJsonProtocol._

class Feature(val row: Double, val col: Double, val scale: Double, val direction: Double, val descriptor: Vector[Double])

object MyJsonProtocol {

  implicit def vectorToJson(v: Vector[Double]) = {
    v.map(x=>JsNumber(x)).toList
  }

  implicit def jsarrayToVector(vector: Vector[JsValue]) = {
    vector.map {
      case JsNumber(n) => n.toDouble
      case _ => throw new DeserializationException("Vector is invalid!")
    }
  }

  implicit object DescriptorJsonFormat extends RootJsonFormat[Feature] {

    def write(f: Feature) = JsObject(
      "row" -> JsNumber(f.row),
      "col" -> JsNumber(f.col),
      "scale" -> JsNumber(f.scale),
      "direction" -> JsNumber(f.direction),
      "vector" -> JsArray(f.descriptor)
    )

    def read(json: JsValue) = {
      json.asJsObject.getFields("row", "col", "scale", "direction", "vector") match {
        case Seq(JsNumber(row), JsNumber(col), JsNumber(scale), JsNumber(direction), JsArray(vector: List[JsValue])) =>
          new Feature(row.toDouble, col.toDouble, scale.toDouble, direction.toDouble, vector.toVector)
        case _ => throw new DeserializationException("value is invalid!")
      }
    }

  }

}

object JsonTest {

  def main(args: Array[String]) = {
    descriptorTest()
  }

  def descriptorTest() = {
    val desObj = new Feature(1, 2, 3, 4, Vector[Double](1,2,3,4,5))
    val jsonAst = desObj.toJson
    println(jsonAst)
    val objAgain = jsonAst.convertTo[Feature]
    println(objAgain.descriptor)
  }

  def jsonFileTest() = {
    val myfile = Source.fromFile("/home/sheep/Code/Project/web-sfm/demo/Hall-Demo/sift.json/00000001.json")
    val myjson = myfile.mkString.parseJson
    println(myjson.asJsObject.getFields("features"))
  }

}
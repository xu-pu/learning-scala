package com.learningscala

import scala.io.Source
import spray.json._
import DefaultJsonProtocol._

object JsonTest {

  def jsonTest() = {
    val jsonObj = Map(
      "col" -> 1,
      "row" ->2,
      "direction" -> 3,
      "scale" -> 4
    )
    val jsonAst = jsonObj.toJson
    println(jsonAst)
    println(jsonAst.asJsObject.fields("vector"))
    //    val scalaObj = jsonAst.convertTo[Feature]
    //    println(scalaObaj)
    //    println(scalaObj.col)
    //    println(scalaObj.row)
    //    val myfile = Source.fromFile("/home/sheep/Code/Project/web-sfm/demo/Hall-Demo/sift.json/00000001.json")
    //    val myjson = myfile.mkString.parseJson
    //    println(myjson.asJsObject.getFields("features"))
  }

}


class Feature(val row: Double, val col: Double, val scale: Double, val direction: Double, val descriptor: Vector[Double])
/*
object MyJsonProtocol extends DefaultJsonProtocol {

  implicit object FeatureJsonFormat extends RootJsonFormat[Feature] {

    def write(f: Feature) = JsObject(
      "row" -> JsNumber(f.row),
      "col" -> JsNumber(f.col),
      "scale" -> JsNumber(f.scale),
      "direction" -> JsNumber(f.direction)
    )

    def read(json: JsValue) = {
      json.asJsObject.getFields("row", "col", "scale", "direction", "vector") match {
        case Seq(JsNumber(row), JsNumber(col), JsNumber(scale), JsNumber(direction), JsArray(vector)) =>
          new Feature(row.toDouble, col.toDouble, scale.toDouble, direction.toDouble, new Vector(vector))
        case _ => throw new DeserializationException("value is invalid!")
      }
    }

  }

}
*/
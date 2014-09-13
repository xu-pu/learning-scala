package com.learningscala

import spray.json._
import DefaultJsonProtocol._

class Feature(val row: Double, val col: Double, val scale: Double, val direction: Double)

object MyJsonProtocol extends DefaultJsonProtocol {

  implicit object FeatureJsonFormat extends RootJsonFormat[Feature] {

    def write(f: Feature) = JsObject(
      "row" -> JsNumber(f.row),
      "col" -> JsNumber(f.col),
      "scale" -> JsNumber(f.scale),
      "direction" -> JsNumber(f.direction)
    )

    def read(json: JsValue) = {
      json.asJsObject.getFields("row", "col", "scale", "direction") match {
        case Seq(JsNumber(row), JsNumber(col), JsNumber(scale), JsNumber(direction)) =>
          new Feature(row.toDouble, col.toDouble, scale.toDouble, direction.toDouble)
        case _ => throw new DeserializationException("value is invalid!")
      }
    }

  }

}

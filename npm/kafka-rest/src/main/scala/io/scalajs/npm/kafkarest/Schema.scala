package io.scalajs.npm.kafkarest

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}

/**
  * Kafka-Rest Avro Schema
  * @param name   the name of the schema
  * @param `type` the type of the schema
  * @param fields the given schema fields
  */
@js.native
@JSImport("kafka-rest", "Schema")
class Schema(val name: String, `type`: String, fields: js.Array[Schema.Field]) extends js.Object

/**
  * Schema Companion
  * @author lawrence.daniels@gmail.com
  */
object Schema {

  /**
    * Kafka-Rest Avro Schema field
    * @param name the name of the field
    * @param `type` the type of the field
    */
  @ScalaJSDefined
  class Field(val name: String, `type`: String) extends js.Object

}

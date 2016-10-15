package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Avro Schema Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AvroSchemaClass extends js.Object

/**
  * Avro Schema Class Companion
  * @author lawrence.daniels@gmail.com
  */
object AvroSchemaClass {

  /**
    * Avro Schema Class Enrichment
    * @param `class` the given [[AvroSchema Avro Schema class]]
    */
  implicit class AvroSchemaClassEnrichment(val `class`: AvroSchemaClass) extends AnyVal {

    @inline
    def apply(schema: js.Any) = `class`.New[AvroSchema](schema)

  }

}
package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Binary Schema Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BinarySchemaClass extends js.Object

/**
  * Binary Schema Class Companion
  * @author lawrence.daniels@gmail.com
  */
object BinarySchemaClass {

  /**
    * Binary Schema Class Enrichment
    * @param `class` the given [[BinarySchema Binary Schema class]]
    */
  implicit class BinarySchemaClassEnrichment(val `class`: BinarySchemaClass) extends AnyVal {

    @inline
    def apply() = `class`.New[BinarySchema]()

  }

}

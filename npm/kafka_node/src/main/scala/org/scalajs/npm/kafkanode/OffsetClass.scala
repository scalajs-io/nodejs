package org.scalajs.npm.kafkanode

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Offset Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait OffsetClass extends js.Object

/**
  * Offset Class Companion
  * @author lawrence.daniels@gmail.com
  */
object OffsetClass {

  /**
    * Offset Class Extensions
    * @param `class` the given [[OffsetClass consumer class]]
    */
  implicit class OffsetClassExtensions(val `class`: OffsetClass) extends AnyVal {

    /**
      * @example Offset(client)
      */
    def apply(client: Client) = `class`.New[Offset](client)

  }

}
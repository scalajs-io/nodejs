package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Unordered Bulk Operation Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UnorderedBulkOperationClass extends js.Object

/**
  * Unordered Bulk Operation Class Companion
  * @author lawrence.daniels@gmail.com
  */
object UnorderedBulkOperationClass {

  /**
    * Unordered Bulk Operation Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class UnorderedBulkOperationClassExtensions(val `class`: UnorderedBulkOperationClass) extends AnyVal {

    /**
      * Create a new UnorderedBulkOperation instance (INTERNAL TYPE, do not instantiate directly)
      * @return [[UnorderedBulkOperation]] instance.
      */
    @inline
    def apply() = `class`.New[UnorderedBulkOperation]()

  }

}
package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Bulk Write Result Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BulkWriteResultClass extends js.Object {
  // Did bulk operation correctly execute
  var ok: js.UndefOr[Boolean] = js.native

  // Number of inserted documents
  var nInserted: js.UndefOr[Int] = js.native

  // Number of documents updated logically
  var nUpdated: js.UndefOr[Int] = js.native

  // Number of upserted documents
  var nUpserted: js.UndefOr[Int] = js.native

  // Number of documents updated physically on disk
  var nModified: js.UndefOr[Int] = js.native

  // Number of removed documents
  var nRemoved: js.UndefOr[Int] = js.native

}

/**
  * Bulk Write Result Class Companion
  * @author lawrence.daniels@gmail.com
  */
object BulkWriteResultClass {

  /**
    * Bulk Write Result Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class BulkWriteResultClassExtensions(val `class`: BulkWriteResultClass) extends AnyVal {

    /**
      * Create a new BulkWriteResult instance (INTERNAL TYPE, do not instantiate directly)
      * @return [[BulkWriteResult]] instance.
      */
    @inline
    def apply(ok: Boolean, nInserted: Int, nUpdated: Int, nUpserted: Int, nModified: Int, nRemoved: Int) = {
      `class`.New[BulkWriteResult](ok, nInserted, nUpdated, nUpserted, nModified, nRemoved)
    }

  }

}
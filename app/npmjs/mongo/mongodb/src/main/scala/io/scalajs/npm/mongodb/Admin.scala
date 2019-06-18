package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Mongo Administrative Functions
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Admin extends js.Object {

  def profilingInfo(callback: js.Function): Unit = js.native

  def profilingLevel(callback: js.Function): Unit = js.native

  def setProfilingLevel(level: String, callback: js.Function): Unit = js.native

  def validateCollection(collectionName: String, callback: js.Function): Unit = js.native

}

/**
  * Mongo Administrative Companion
  * @author lawrence.daniels@gmail.com
  */
object Admin {

  /**
    * Mongo Administrative Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoAdminEnrichment(val admin: Admin) extends AnyVal {

    @inline
    def profilingInfoFuture(name: String): js.Promise[ProfilingInfo] =
      promiseMongoCallback1[ProfilingInfo](admin.profilingInfo)

    @inline
    def profilingLevelFuture(name: String): js.Promise[String] =
      promiseMongoCallback1[String](admin.profilingLevel)

    @inline
    def setProfilingLevelFuture(level: String): js.Promise[String] =
      promiseMongoCallback1[String](admin.setProfilingLevel(level, _))

    @inline
    def validateCollectionFuture(collectionName: String): js.Promise[ValidationResult] =
      promiseMongoCallback1[ValidationResult](admin.validateCollection(collectionName, _))

  }

}

/**
  * Validation Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ValidationResult extends js.Object
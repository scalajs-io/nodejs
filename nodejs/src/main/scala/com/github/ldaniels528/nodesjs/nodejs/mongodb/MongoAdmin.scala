package com.github.ldaniels528.nodesjs.nodejs.mongodb

import com.github.ldaniels528.nodesjs.nodejs.mongodb.MongoClient.MongoError
import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Mongo Administrative Functions
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoAdmin extends js.Object {

  def profilingInfo(callback: js.Function): Unit

  def profilingLevel(callback: js.Function): Unit

  def setProfilingLevel(level: String, callback: js.Function): Unit

  def validateCollection(collectionName: String, callback: js.Function): Unit

}

/**
  * Mongo Administrative Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoAdmin {

  /**
    * Mongo Administrative Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoAdminEnrich(val admin: MongoAdmin) extends AnyVal {

    def profilingInfoAsync(name: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[ProfilingInfo]()
      admin.profilingInfo((err: MongoError, info: ProfilingInfo) => {
        if (!isDefined(err)) promise.success(info) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def profilingLevelAsync(name: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[String]()
      admin.profilingLevel((err: MongoError, level: String) => {
        if (!isDefined(err)) promise.success(level) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def setProfilingLevelAsync(level: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[String]()
      admin.setProfilingLevel(level, (err: MongoError, level: String) => {
        if (!isDefined(err)) promise.success(level) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def validateCollection(collectionName: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[ValidationResult]()
      admin.validateCollection(collectionName, (err: MongoError, result: ValidationResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}
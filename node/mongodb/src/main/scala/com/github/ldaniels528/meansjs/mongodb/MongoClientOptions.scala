package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * MongoDB Client Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */
@ScalaJSDefined
class MongoClientOptions extends js.Object {
  var w: js.UndefOr[js.Any] = _
  var wtimeout: js.UndefOr[Int] = _
  var fsync: js.UndefOr[Boolean] = _
  var j: js.UndefOr[Boolean] = _
  var readPreference: js.UndefOr[String] = _
  var native_parser: js.UndefOr[Boolean] = _
  var forceServerObjectId: js.UndefOr[Boolean] = _
  var pkFactory: js.UndefOr[js.Object] = _
  var serializeFunctions: js.UndefOr[Boolean] = _
  var raw: js.UndefOr[Boolean] = _
  var recordQueryStats: js.UndefOr[Boolean] = _
  var retryMiliSeconds: js.UndefOr[Int] = _
  var numberOfRetries: js.UndefOr[Int] = _
  var bufferMaxEntries: js.UndefOr[Int] = _

}

/**
  * Connection Options Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoClientOptions {

  def apply(w: js.UndefOr[js.Any] = js.undefined,
            wtimeout: js.UndefOr[Int] = js.undefined,
            fsync: js.UndefOr[Boolean] = js.undefined,
            j: js.UndefOr[Boolean] = js.undefined,
            readPreference: js.UndefOr[String] = js.undefined,
            native_parser: js.UndefOr[Boolean] = js.undefined,
            forceServerObjectId: js.UndefOr[Boolean] = js.undefined,
            pkFactory: js.UndefOr[js.Object] = js.undefined,
            serializeFunctions: js.UndefOr[Boolean] = js.undefined,
            raw: js.UndefOr[Boolean] = js.undefined,
            recordQueryStats: js.UndefOr[Boolean] = js.undefined,
            retryMiliSeconds: js.UndefOr[Int] = js.undefined,
            numberOfRetries: js.UndefOr[Int] = js.undefined,
            bufferMaxEntries: js.UndefOr[Int] = js.undefined) = {
    val options = new MongoClientOptions()
    options.w = w
    options.wtimeout = wtimeout
    options.fsync = fsync
    options.j = j
    options.readPreference = readPreference
    options.native_parser = native_parser
    options.forceServerObjectId = forceServerObjectId
    options.pkFactory = pkFactory
    options.serializeFunctions = serializeFunctions
    options.raw = raw
    options.recordQueryStats = recordQueryStats
    options.retryMiliSeconds = retryMiliSeconds
    options.numberOfRetries = numberOfRetries
    options.bufferMaxEntries = bufferMaxEntries
    options
  }

}
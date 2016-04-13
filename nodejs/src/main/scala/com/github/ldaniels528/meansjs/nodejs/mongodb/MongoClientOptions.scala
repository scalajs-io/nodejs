package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * MongoDB Client Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */
@js.native
trait MongoClientOptions extends js.Object {
  var w: js.UndefOr[js.Any] = js.native
  var wtimeout: js.UndefOr[Int] = js.native
  var fsync: js.UndefOr[Boolean] = js.native
  var j: js.UndefOr[Boolean] = js.native
  var readPreference: js.UndefOr[String] = js.native
  var native_parser: js.UndefOr[Boolean] = js.native
  var forceServerObjectId: js.UndefOr[Boolean] = js.native
  var pkFactory: js.UndefOr[js.Object] = js.native
  var serializeFunctions: js.UndefOr[Boolean] = js.native
  var raw: js.UndefOr[Boolean] = js.native
  var recordQueryStats: js.UndefOr[Boolean] = js.native
  var retryMiliSeconds: js.UndefOr[Int] = js.native
  var numberOfRetries: js.UndefOr[Int] = js.native
  var bufferMaxEntries: js.UndefOr[Int] = js.native

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
    val options = makeNew[MongoClientOptions]
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
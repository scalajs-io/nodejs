package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * MongoDB Client Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */
@ScalaJSDefined
class MongoClientOptions(var w: js.UndefOr[js.Any] = js.undefined,
                         var wtimeout: js.UndefOr[Int] = js.undefined,
                         var fsync: js.UndefOr[Boolean] = js.undefined,
                         var j: js.UndefOr[Boolean] = js.undefined,
                         var readPreference: js.UndefOr[String] = js.undefined,
                         var native_parser: js.UndefOr[Boolean] = js.undefined,
                         var forceServerObjectId: js.UndefOr[Boolean] = js.undefined,
                         var pkFactory: js.UndefOr[js.Object] = js.undefined,
                         var serializeFunctions: js.UndefOr[Boolean] = js.undefined,
                         var raw: js.UndefOr[Boolean] = js.undefined,
                         var recordQueryStats: js.UndefOr[Boolean] = js.undefined,
                         var retryMiliSeconds: js.UndefOr[Int] = js.undefined,
                         var numberOfRetries: js.UndefOr[Int] = js.undefined,
                         var bufferMaxEntries: js.UndefOr[Int] = js.undefined)
    extends js.Object

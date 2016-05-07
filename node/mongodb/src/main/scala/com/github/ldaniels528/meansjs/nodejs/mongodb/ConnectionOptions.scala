package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Mongo Client Connection Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */
@ScalaJSDefined
class ConnectionOptions extends js.Object {
  var uri_decode_auth: js.UndefOr[Boolean] = _
  var db: js.UndefOr[js.Object] = _
  var server: js.UndefOr[js.Object] = _
  var replSet: js.UndefOr[js.Object] = _
  var mongos: js.UndefOr[js.Object] = _
}

/**
  * Mongo Client Connection Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ConnectionOptions {

  def apply(uri_decode_auth: js.UndefOr[Boolean] = js.undefined,
            db: js.UndefOr[js.Object] = js.undefined,
            server: js.UndefOr[js.Object] = js.undefined,
            replSet: js.UndefOr[js.Object] = js.undefined,
            mongos: js.UndefOr[js.Object] = js.undefined) = {
    val options = new ConnectionOptions()
    options.uri_decode_auth = uri_decode_auth
    options.db = db
    options.server = server
    options.replSet = replSet
    options.mongos = mongos
    options
  }

}
package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Mongo Client Connection Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */
@js.native
trait ConnectionOptions extends js.Object {
  var uri_decode_auth: js.UndefOr[Boolean] = js.native
  var db: js.UndefOr[js.Object] = js.native
  var server: js.UndefOr[js.Object] = js.native
  var replSet: js.UndefOr[js.Object] = js.native
  var mongos: js.UndefOr[js.Object] = js.native
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
    val options = makeNew[ConnectionOptions]
    options.uri_decode_auth = uri_decode_auth
    options.db = db
    options.server = server
    options.replSet = replSet
    options.mongos = mongos
    options
  }

}
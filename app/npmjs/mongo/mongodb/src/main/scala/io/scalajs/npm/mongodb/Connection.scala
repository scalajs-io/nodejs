package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * MongoDB Connection
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "Connection")
class Connection extends js.Object

/**
  * Mongo Client Connection Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */

class ConnectionOptions(var uri_decode_auth: js.UndefOr[Boolean] = js.undefined,
                        var db: js.UndefOr[js.Object] = js.undefined,
                        var server: js.UndefOr[js.Object] = js.undefined,
                        var replSet: js.UndefOr[js.Object] = js.undefined,
                        var mongos: js.UndefOr[js.Object] = js.undefined)
  extends js.Object


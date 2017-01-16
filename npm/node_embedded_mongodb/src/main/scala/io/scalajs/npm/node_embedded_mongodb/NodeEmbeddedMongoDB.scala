package io.scalajs.npm.node_embedded_mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * This is a simple module which start/stop an already installed, existing, localhost mongod server.
  * This module is very useful for running mongodb as part of a Gulp/Grunt testing task.
  * @version 0.0.3
  * @see https://www.npmjs.com/package/node-embedded-mongodb
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeEmbeddedMongoDB extends js.Object {

  def silentMode(enabled: Boolean): Unit = js.native

  def start(dbPath: String, logPath: String, callback: js.Function1[js.Error, Any]): Unit = js.native

  def stop(callback: js.Function1[js.Error, Any]): Unit = js.native

}

/**
  * NodeEmbeddedMongoDB Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("node-embedded-mongodb", JSImport.Namespace)
object NodeEmbeddedMongoDB extends NodeEmbeddedMongoDB
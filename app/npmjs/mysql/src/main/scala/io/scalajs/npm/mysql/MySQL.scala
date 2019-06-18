package io.scalajs.npm.mysql

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * mysql - A node.js driver for mysql. It is written in JavaScript, does not require compiling,
  * and is 100% MIT licensed.
  * @version 2.10.2
  * @see https://www.npmjs.com/package/mysql
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MySQL extends IEventEmitter {

  def createPoolCluster(options: PoolClusterOptions): PoolCluster = js.native

  def createConnection(connectionString: String): Connection = js.native

  def createConnection(options: ConnectionOptions): Connection = js.native

  def createPool(options: PoolOptions): Pool = js.native

}

/**
  * MySQL Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mysql", JSImport.Namespace)
object MySQL extends MySQL
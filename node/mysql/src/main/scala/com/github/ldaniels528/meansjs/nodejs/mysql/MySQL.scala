package com.github.ldaniels528.meansjs.nodejs.mysql

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * MySQL node module - A node.js driver for mysql. It is written in JavaScript, does not require compiling,
  * and is 100% MIT licensed.
  * @author lawrence.daniels@gmail.com
  * @see [[https://www.npmjs.com/package/mysql]]
  * @version 2.10.2
  */
@js.native
trait MySQL extends NodeModule with EventEmitter {

  def createPoolCluster(options: PoolClusterOptions): PoolCluster = js.native

  def createConnection(connectionString: String): Connection = js.native

  def createConnection(options: ConnectionOptions): Connection = js.native

  def createPool(options: PoolOptions): Pool = js.native

}

package com.github.ldaniels528.meansjs.nodejs.mysql

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * mysql - A node.js driver for mysql. It is written in JavaScript, does not require compiling,
  * and is 100% MIT licensed.
  * @version 2.10.2
  * @see [[https://www.npmjs.com/package/mysql]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MySQL extends NodeModule with EventEmitter {

  def createPoolCluster(options: PoolClusterOptions): PoolCluster = js.native

  def createConnection(connectionString: String): Connection = js.native

  def createConnection(options: ConnectionOptions): Connection = js.native

  def createPool(options: PoolOptions): Pool = js.native

}

/**
  * MySQL Companion
  * @author lawrence.daniels@gmail.com
  */
object MySQL {

  /**
    * Convenience method for retrieving the 'mysql' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the MySQL instance
    */
  def apply()(implicit require: NodeRequire) = require[MySQL]("mysql")

}
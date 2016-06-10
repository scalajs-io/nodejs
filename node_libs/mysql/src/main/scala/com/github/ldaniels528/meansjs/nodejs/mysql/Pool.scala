package com.github.ldaniels528.meansjs.nodejs.mysql

import com.github.ldaniels528.meansjs.nodejs.errors
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * MySQL Pool
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Pool extends EventEmitter {

  /**
    * When you are done using the pool, you have to end all the connections or the Node.js event loop will stay active
    * until the connections are closed by the MySQL server. This is typically done if the pool is used in a script or
    * when trying to gracefully shutdown a server.
    */
  def end(callback: js.Function): Unit = js.native

  def getConnection(callback: js.Function): Unit = js.native

}

/**
  * Pool Companion
  * @author lawrence.daniels@gmail.com
  */
object Pool {

  /**
    * Pool Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class PoolExtensions(val pool: Pool) extends AnyVal {

    @inline
    def getConnectionFuture = futureCallbackE1[errors.Error, Connection](pool.getConnection(_))

    /**
      * The pool will emit a connection event when a new connection is made within the pool. If you need to set
      * session variables on the connection before it gets used, you can listen to the connection event.
      */
    @inline
    def onConnection(callback: js.Function1[Connection, Any]) = pool.on("connection", callback)

    /**
      * The pool will emit an enqueue event when a callback has been queued to wait for an available connection.
      */
    @inline
    def onEnqueue(callback: js.Function) = pool.on("enqueue", callback)

  }

}
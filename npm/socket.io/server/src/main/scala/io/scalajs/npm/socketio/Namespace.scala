package io.scalajs.npm.socketio

import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.util.ScalaJsHelper._

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.Array

/**
  * Represents a pool of sockets connected under a given scope identified by a pathname (eg: /chat).
  * By default the client always connects to /.
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Namespace(socket: Socket) extends IEventEmitter {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * The namespace identifier property.
    */
  def name: String = js.native

  /**
    * Hash of Socket objects that are connected to this namespace indexed by id.
    */
  def connected: js.Dictionary[Socket] = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    * Gets a list of client IDs connected to this namespace (across all nodes if applicable).
    */
  def clients(callback: js.Function2[SocketIOError, js.Array[Socket], Any]): Unit = js.native

  /**
    * Registers a middleware, which is a function that gets executed for every incoming Socket,
    * and receives as parameters the socket and a function to optionally defer execution to
    * the next registered middleware.
    * @param fn the function that gets executed for every incoming Socket
    */
  def use(fn: js.Function): this.type = js.native

}

/**
  * Namespace Companion
  * @author lawrence.daniels@gmail.com
  */
object Namespace {

  /**
    * Namespace enrichment methods
    * @param namespace the given [[Namespace namespace]]
    */
  implicit class NamespaceEnrichment(val namespace: Namespace) extends AnyVal {

    def clientsFuture: Promise[Array[Socket]] = futureCallbackX1[SocketIOError, js.Array[Socket]](namespace.clients)

  }

}
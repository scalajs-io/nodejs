package com.github.ldaniels528.meansjs.nodejs.zookeeper

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Zookeeper State
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait State extends js.Object {

  /** the name of the state. */
  def name: String = js.native

  /** the code of the state. */
  def code: Integer = js.native

  /**
    * Return the name of the state.
    * @return the name of the state.
    */
  def getName(): String = js.native

  /**
    * Return the code of the state.
    * @return the code of the state.
    */
  def getCode(): Integer = js.native

}

/**
  * State Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("State")
object State extends js.Object {

  /** Client is connected and ready. */
  var CONNECTED: Int = js.native

  /** Client is connected to a readonly server. */
  var CONNECTED_READ_ONLY: Int = js.native

  /** The connection between client and server is dropped. */
  var DISCONNECTED: Int = js.native

  /** The client session is expired. */
  var EXPIRED: Int = js.native

  /** Failed to authenticate with the server. */
  var AUTH_FAILED: Int = js.native

}

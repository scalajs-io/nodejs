package com.github.ldaniels528.meansjs.nodejs.expressws

import com.github.ldaniels528.meansjs.nodejs.express.{Application, Router}

import scala.scalajs.js

/**
  * Web Socket Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WsInstance extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This property contains the app that express-ws was set up on.
    * @example wsInstance.app
    */
  def app: Application = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Sets up express-ws on the given router (or other Router-like object).
    * You will only need this in two scenarios:
    * <ul>
    * <li>You have enabled options.leaveRouterUntouched, or</li>
    * <li>You are using a custom router that is not based on the express.Router prototype.</li>
    * </ul>
    * In most cases, you won't need this at all.
    * @example wsInstance.applyTo(router)
    */
  def applyTo(router: Router): Unit = js.native

  /**
    * Returns the underlying WebSocket server/handler. You can use wsInstance.getWss().clients
    * to obtain a list of all the connected WebSocket clients for this server.
    * @example wsInstance.getWss()
    */
  def getWss(): WsInstance.WssInfo = js.native

}

/**
  * WsInstance Companion
  * @author lawrence.daniels@gmail.com
  */
object WsInstance {

  /**
    * Web Socket Service Information
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait WssInfo extends js.Object {
    var domain: String
    var _events: js.Object
    var _eventsCount: Int
    var _server: js.Object
    var options: WssOptions
    var path: String
    var clients: js.Array[js.Any]
  }

  /**
    * Web Socket Service Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait WssOptions extends js.Object {
    var host: String
    var port: Integer
    var server: WssServer
    var verifyClient: js.Object
    var handleProtocols: String
    var path: String
    var noServer: Boolean
    var disableHixie: Boolean
    var clientTracking: Boolean
    var perMessageDeflate: Boolean
  }

  /**
    * Web Socket Service Server
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait WssServer extends js.Object {
    var domain: String
    var _events: String
    var _eventsCount: Integer
    var _connections: Integer
    var _handle: js.Any
    var _usingSlaves: Boolean
    var _slaves: js.Array[js.Any]
    var _unref: Boolean
    var allowHalfOpen: Boolean
    var pauseOnConnect: Boolean
    var httpAllowHalfOpen: Boolean
    var timeout: Integer
    var _pendingResponseData: Integer
  }

}
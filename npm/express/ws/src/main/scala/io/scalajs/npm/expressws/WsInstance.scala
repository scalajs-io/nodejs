package io.scalajs.npm.expressws

import io.scalajs.npm.express.{Application, Router}
import io.scalajs.npm.express.Application
import io.scalajs.npm.express.Application

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
    var domain: String = js.native
    var _events: js.Object = js.native
    var _eventsCount: Int = js.native
    var _server: js.Object = js.native
    var options: WssOptions = js.native
    var path: String = js.native
    var clients: js.Array[js.Any] = js.native
  }

  /**
    * Web Socket Service Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait WssOptions extends js.Object {
    var host: String = js.native
    var port: Integer = js.native
    var server: WssServer = js.native
    var verifyClient: js.Object = js.native
    var handleProtocols: String = js.native
    var path: String = js.native
    var noServer: Boolean = js.native
    var disableHixie: Boolean = js.native
    var clientTracking: Boolean = js.native
    var perMessageDeflate: Boolean = js.native
  }

  /**
    * Web Socket Service Server
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait WssServer extends js.Object {
    var domain: String = js.native
    var _events: String = js.native
    var _eventsCount: Integer = js.native
    var _connections: Integer = js.native
    var _handle: js.Any = js.native
    var _usingSlaves: Boolean = js.native
    var _slaves: js.Array[js.Any] = js.native
    var _unref: Boolean = js.native
    var allowHalfOpen: Boolean = js.native
    var pauseOnConnect: Boolean = js.native
    var httpAllowHalfOpen: Boolean = js.native
    var timeout: Integer = js.native
    var _pendingResponseData: Integer = js.native
  }

}
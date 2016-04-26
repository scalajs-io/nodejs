package com.github.ldaniels528.meansjs.nodejs.expressws

import com.github.ldaniels528.meansjs.nodejs.express.Application
import com.github.ldaniels528.meansjs.nodejs.http.Server

import scala.scalajs.js

/**
  * WebSocket endpoints for Express applications. Lets you define WebSocket endpoints like
  * any other type of route, and applies regular Express midddleware like for anything else.
  * @author lawrence.daniels@gmail.com
  * @see [[https://www.npmjs.com/package/express-ws]]
  */
@js.native
trait ExpressWS extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Sets up express-ws on the specified app. This will modify the global Router prototype for
    * Express as well - see the [[WSConfigOptions.leaveRouterUntouched]] option for more information on disabling this.
    * @example expressWs(app[,server][, options])
    */
  def apply(app: Application, server: Server, options: WSConfigOptions): WsInstance = js.native

  /**
    * Sets up express-ws on the specified app.
    * @example expressWs(app[,server][, options])
    */
  def apply(app: Application, server: Server): WsInstance = js.native

  /**
    * Sets up express-ws on the specified app.
    * @example expressWs(app[,server][, options])
    */
  def apply(app: Application): WsInstance = js.native

}

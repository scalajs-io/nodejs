package org.scalajs.nodejs.expressws

import org.scalajs.nodejs.NodeRequire
import org.scalajs.nodejs.express.Application
import org.scalajs.nodejs.http.Server

import scala.scalajs.js

/**
  * WebSocket endpoints for Express applications. Lets you define WebSocket endpoints like
  * any other type of route, and applies regular Express midddleware like for anything else.
  * @author lawrence.daniels@gmail.com
  * @see [[https://www.npmjs.com/package/express-ws]]
  * @version 2.0.0-rc.1
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

/**
  * ExpressWS Companion
  * @author lawrence.daniels@gmail.com
  */
object ExpressWS {

  /**
    * Convenience method for retrieving the 'express-ws' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the ExpressWS instance
    */
  def apply()(implicit require: NodeRequire) = require[ExpressWS]("express-ws")

}
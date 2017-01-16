package io.scalajs.npm.expressws

import io.scalajs.nodejs.NodeOptions
import io.scalajs.nodejs.http.Server
import io.scalajs.npm.express.Application

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * WebSocket endpoints for Express applications. Lets you define WebSocket endpoints like
  * any other type of route, and applies regular Express middleware like for anything else.
  * @version 2.0.0-rc.1
  * @see [[https://www.npmjs.com/package/express-ws]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("express-ws", JSImport.Namespace)
object ExpressWS extends js.Object {

  /**
    * Sets up express-ws on the specified app. This will modify the global Router prototype for
    * Express as well - see the [[WSConfigOptions.leaveRouterUntouched]] option for more information on disabling this.
    * @param app the [[Application application]]
    * @param server the [[Server server]]
    * @param options the [[WSConfigOptions options]]
    * @return the [[WsInstance instance]]
    * @example expressWs(app[,server][, options])
    */
  def apply(app: Application, server: Server = js.native, options: WSConfigOptions | NodeOptions = js.native): WsInstance = js.native

}

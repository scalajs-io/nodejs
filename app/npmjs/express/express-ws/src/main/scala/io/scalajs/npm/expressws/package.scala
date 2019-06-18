package io.scalajs.npm

import io.scalajs.npm.express.Router

import scala.scalajs.js

/**
  * Express-WS
  * @author lawrence.daniels@gmail.com
  */
package object expressws {

  /**
    * WsRouting Extensions
    * @param router the given [[Router router]]
    */
  implicit class WsRouterExtensions[T <: Router](val router: T) extends AnyVal {

    @inline
    def withWsRouting: T with WsRouting = router.asInstanceOf[T with WsRouting]

  }

  /**
    * Web Socket Events
    * @param ws the given [[WS web-socket]]
    */
  implicit class WsEvents(val ws: WS) extends AnyVal {

    @inline
    def onMessage(message: js.Any => Any): ws.type = ws.on("message", message)

  }

}

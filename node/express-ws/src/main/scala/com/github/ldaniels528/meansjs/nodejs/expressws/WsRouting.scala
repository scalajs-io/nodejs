package com.github.ldaniels528.meansjs.nodejs.expressws

import com.github.ldaniels528.meansjs.nodejs.express.Router

import scala.scalajs.js

/**
  * Express-WS Routing Mix-in
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WsRouting extends js.Object {

  /**
    * Registers the web socket listener for the given path
    */
  def ws(path: String, callback: js.Function): Unit = js.native

}

/**
  * WsRouting Companion
  * @author lawrence.daniels@gmail.com
  */
object WsRouting {

  /**
    * WsRouting Extensions
    * @param router the given [[Router router]]
    */
  implicit class WsRouterEnrich[T <: Router](val router: T) extends AnyVal {

    @inline
    def withWsRouting = router.asInstanceOf[T with WsRouting]

  }

}
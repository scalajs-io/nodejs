package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.nodejs.express.Router

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
    def withWsRouting = router.asInstanceOf[T with WsRouting]

  }

}

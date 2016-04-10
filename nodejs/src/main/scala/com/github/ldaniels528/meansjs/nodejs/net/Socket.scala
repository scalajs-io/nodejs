package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Node.js Socket
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Socket extends js.Object {

}

/**
  * Socket Companion
  * @author lawrence.daniels@gmail.com
  */
object Socket {

  def apply(options: Options) = {

  }

  /**
    * Socket Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Options extends js.Object {
    var fd: js.UndefOr[js.Object]
    var allowHalfOpen: js.UndefOr[Boolean]
    var readable: js.UndefOr[Boolean]
    var writable: js.UndefOr[Boolean]
  }

  /**
    * Socket Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object Options {

    def apply(fd: js.UndefOr[js.Object] = js.undefined,
              allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
              readable: js.UndefOr[Boolean] = js.undefined,
              writable: js.UndefOr[Boolean] = js.undefined) = {
      val options = makeNew[Options]
      options.fd = fd
      options.allowHalfOpen = allowHalfOpen
      options.readable = readable
      options.writable = writable
      options
    }

  }

}
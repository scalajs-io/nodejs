package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Socket Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SocketClass extends js.Object {

}

/**
  * Socket Class Companion
  * @author lawrence.daniels@gmail.com
  */
object SocketClass {

  /**
    * Socket Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class SocketClassExtensions(val `class`: SocketClass) extends AnyVal {

    @inline
    def apply(options: SocketOptions) = `class`.New[Socket](options)

  }

}
package org.scalajs.nodejs.net

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * net.Socket class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SocketClass extends js.Object

/**
  * Socket-class Companion
  * @author lawrence.daniels@gmail.com
  */
object SocketClass {

  /**
    * Socket-class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class SocketClassExtensions(val `class`: SocketClass) extends AnyVal {

    /**
      * Socket Constructor
      * @example new net.Socket()
      */
    @inline
    def apply() = `class`.New[Socket]()

    /**
      * Socket Constructor
      * @example new net.Socket(options)
      */
    @inline
    def apply(options: SocketOptions) = `class`.New[Socket](options)

  }

}
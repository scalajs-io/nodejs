package org.scalajs.nodejs.net

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * net.Server class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ServerClass extends js.Object

/**
  * Server-class Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerClass {

  /**
    * Server-class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ServerClassExtensions(val `class`: ServerClass) extends AnyVal {

    /**
      * Server Constructor
      * @example new net.Server()
      */
    @inline
    def apply() = `class`.New[Server]()

  }

}

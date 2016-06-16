package org.scalajs.nodejs.azure.asm.sql

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Server Operations
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ServerOperations extends js.Object {

  def create(options: ServerOptions, callback: js.Function): Unit = js.native

}

/**
  * Server Operations Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerOperations {

  /**
    * Server Operations Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ServersExtensions(val serverOps: ServerOperations) extends AnyVal {

    @inline
    def createFuture(options: ServerOptions) = futureCallbackE1[Error, Server](serverOps.create(options, _))

  }

}
package com.github.ldaniels528.meansjs.nodejs.azure.asm.sql

import com.github.ldaniels528.meansjs.nodejs.errors
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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
    def createFuture(options: ServerOptions) = futureCallbackE1[errors.Error, Server](serverOps.create(options, _))

  }

}
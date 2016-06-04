package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Connect Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ConnectOptions extends js.Object {
  var path: String = js.native
  var host: String = js.native
  var port: Integer = js.native
}

/**
  * Connect Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ConnectOptions {

  def apply(path: String = null,
            host: String = null,
            port: Integer = null) = {
    val options = New[ConnectOptions]
    options.path = path
    options.host = host
    options.port = port
    options
  }

}
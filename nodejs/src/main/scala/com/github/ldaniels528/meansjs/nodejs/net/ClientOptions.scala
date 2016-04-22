package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Client Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ClientOptions extends js.Object {
  var port: js.UndefOr[Int]
}

/**
  * Client Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ClientOptions {

  def apply(port: js.UndefOr[Int] = js.undefined) = {
    val options = makeNew[ClientOptions]
    options.port = port
    options
  }

}
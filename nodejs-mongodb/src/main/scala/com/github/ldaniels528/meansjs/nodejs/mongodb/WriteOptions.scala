package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Write Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WriteOptions extends js.Object {
  var w: Int = js.native
}

/**
  * Write Options Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteOptions {

  def apply(w: Int): WriteOptions = {
    val options = makeNew[WriteOptions]
    options.w = w
    options
  }

}
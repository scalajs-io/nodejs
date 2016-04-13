package com.github.ldaniels528.meansjs.nodejs.net

import Net.Client
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Net Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Net extends js.Object {

  def connect(options: Net.Options, callback: js.Function): Client = js.native

}

/**
  * Net Module Companion
  * @author lawrence.daniels@gmail.com
  */
object Net {

  /**
    * Net Client
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Client extends js.Object {

    def end(): Unit

    def end(text: String): Unit

    def on(event: String, callback: js.Function)

    def write(text: String): Unit

  }

  /**
    * Net Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Options extends js.Object {
    var port: js.UndefOr[Int]
  }

  /**
    * Net Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object Options {

    def apply(port: js.UndefOr[Int] = js.undefined) = {
      val options = makeNew[Options]
      options.port = port
      options
    }

  }

}
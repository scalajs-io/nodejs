package com.github.ldaniels528.meansjs.nodejs.buffer

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Array Buffer Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ArrayBufferClass extends js.Object

/**
  * Array Buffer Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ArrayBufferClass {

  /**
    * Array Buffer Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ArrayBufferFactoryExtensions(val `class`: ArrayBufferClass) extends AnyVal {

    def apply(data: js.Any) = `class`.New[ArrayBuffer](data)

  }

}

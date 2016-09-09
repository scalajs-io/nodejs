package org.scalajs.nodejs.htmlparser2

import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * HtmlParser2 Parser Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ParserClass extends js.Object

/**
  * Parser Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ParserClass {

  implicit class ParserClassExtensions(val `class`: ParserClass) extends AnyVal {

    @inline
    def apply(handler: ParserHandler, options: ParserOptions = null) = `class`.New[Parser](handler, options)

  }

}
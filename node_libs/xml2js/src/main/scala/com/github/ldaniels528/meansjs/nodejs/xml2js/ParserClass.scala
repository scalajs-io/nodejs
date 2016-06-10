package com.github.ldaniels528.meansjs.nodejs.xml2js

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * XML2JS Parser Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ParserClass extends js.Object

/**
  * XML2JS Parser Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ParserClass {

  /**
    * XML2JS Parser Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ParserClassExtensions(val `class`: ParserClass) extends AnyVal {

    /**
      * @example Parser()
      */
    @inline
    def apply() = `class`.New[Parser]()

    /**
      * @example Parser(options)
      */
    @inline
    def apply(options: ParserOptions) = `class`.New[Parser](options)

  }

}

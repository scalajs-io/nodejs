package org.scalajs.nodejs.xml2js

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * XML2JS Builder Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BuilderClass extends js.Object

/**
  * XML2JS Builder Class Companion
  * @author lawrence.daniels@gmail.com
  */
object BuilderClass {

  /**
    * XML2JS Builder Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class BuilderClassExtensions(val `class`: BuilderClass) extends AnyVal {

    /**
      * @example Builder()
      */
    @inline
    def apply() = `class`.New[BuilderClass]()

    /**
      * @example Builder(options)
      */
    @inline
    def apply(options: BuilderOptions) = `class`.New[BuilderClass](options)

  }

}
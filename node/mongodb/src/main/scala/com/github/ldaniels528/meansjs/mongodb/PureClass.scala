package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Pure Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait PureClass extends js.Object

/**
  * Pure Class Companion
  * @author lawrence.daniels@gmail.com
  */
object PureClass {

  /**
    * Pure Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class PureClassExtensions(val `class`: PureClass) extends AnyVal {

    @inline
    def apply() = `class`.New[Pure]()

  }

}
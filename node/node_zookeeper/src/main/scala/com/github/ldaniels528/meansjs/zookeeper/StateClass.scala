package com.github.ldaniels528.meansjs.zookeeper

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * State Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait StateClass extends js.Object

/**
  * State Class Companion
  * @author lawrence.daniels@gmail.com
  */
object StateClass {

  /**
    * State Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class StateClassExtensions(val `class`: StateClass) extends AnyVal {

    /**
      * @example State(name, code)
      */
    @inline
    def apply(name: String, code: Int) = `class`.New[State](name, code)

  }

}
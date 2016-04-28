package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * BSON Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BSONClass extends js.Object

/**
  * BSON Class Companion
  * @author lawrence.daniels@gmail.com
  */
object BSONClass {

  /**
    * BSON Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class BSONClassExtensions(val `class`: BSONClass) extends AnyVal {

    @inline
    def apply() = `class`.New[BSON]()

  }

}
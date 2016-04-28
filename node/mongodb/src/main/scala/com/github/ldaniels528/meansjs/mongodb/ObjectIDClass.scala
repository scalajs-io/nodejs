package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * ObjectID Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ObjectIDClass extends js.Object

/**
  * ObjectID Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ObjectIDClass {

  /**
    * ObjectID Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ObjectIDClassExtensions(val `class`: ObjectIDClass) extends AnyVal {

    @inline
    def apply() = `class`.New[ObjectID]()

    @inline
    def apply(id: js.Any) = `class`.New[ObjectID](id)

  }

}
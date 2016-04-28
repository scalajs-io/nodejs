package com.github.ldaniels528.meansjs.mongodb.gridfs

import com.github.ldaniels528.meansjs.mongodb._
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Grid Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridClass extends js.Object

/**
  * Grid Class Companion
  * @author lawrence.daniels@gmail.com
  */
object GridClass {

  /**
    * Grid Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridClassExtensions(val `class`: GridClass) extends AnyVal {

    @inline
    def apply(db: Db, name: String) = `class`.New[Grid](db, name)

  }

}
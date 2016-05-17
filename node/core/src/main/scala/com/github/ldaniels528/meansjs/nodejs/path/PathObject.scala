package com.github.ldaniels528.meansjs.nodejs.path

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Path Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait PathObject extends js.Object {
  var root: js.UndefOr[String] = js.native
  var dir: js.UndefOr[String] = js.native
  var base: js.UndefOr[String] = js.native
  var ext: js.UndefOr[String] = js.native
  var name: js.UndefOr[String] = js.native

}

/**
  * Path Object Companion
  * @author lawrence.daniels@gmail.com
  */
object PathObject {

  def apply(root: js.UndefOr[String] = js.undefined,
            dir: js.UndefOr[String] = js.undefined,
            base: js.UndefOr[String] = js.undefined,
            ext: js.UndefOr[String] = js.undefined,
            name: js.UndefOr[String] = js.undefined) = {
    val pathObject = New[PathObject]
    pathObject.root = root
    pathObject.dir = dir
    pathObject.base = base
    pathObject.ext = ext
    pathObject.name = name
    pathObject
  }

}
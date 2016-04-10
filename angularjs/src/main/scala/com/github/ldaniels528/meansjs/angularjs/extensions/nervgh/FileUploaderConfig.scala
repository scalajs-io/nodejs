package com.github.ldaniels528.meansjs.angularjs.extensions.nervgh

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * File Uploader Config
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUploaderConfig extends js.Object {
  var url: String = js.native
  var filters: js.Array[FileFilter] = js.native
}

/**
  * File Uploader Config Companion
  * @author lawrence.daniels@gmail.com
  */
object FileUploaderConfig {

  def apply(url: String, filters: js.Array[FileFilter] = emptyArray) = {
    val config = makeNew[FileUploaderConfig]
    config.url = url
    config.filters = filters
    config
  }

}
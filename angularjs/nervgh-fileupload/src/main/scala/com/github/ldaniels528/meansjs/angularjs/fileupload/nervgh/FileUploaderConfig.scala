package com.github.ldaniels528.meansjs.angularjs.fileupload.nervgh

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Uploader Config
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileUploaderConfig extends js.Object {
  var url: String = _
  var filters: js.Array[FileUploadFilter] = _
}

/**
  * File Uploader Config Companion
  * @author lawrence.daniels@gmail.com
  */
object FileUploaderConfig {

  def apply(url: String, filters: js.Array[FileUploadFilter] = emptyArray) = {
    val config = new FileUploaderConfig()
    config.url = url
    config.filters = filters
    config
  }

}
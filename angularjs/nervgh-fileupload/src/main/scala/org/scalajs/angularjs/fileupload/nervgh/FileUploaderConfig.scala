package org.scalajs.angularjs.fileupload.nervgh

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

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
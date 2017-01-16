package io.scalajs.npm.angularjs.fileupload.nervgh

import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Uploader Config
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileUploaderConfig(var url: String,
                         var filters: js.Array[FileUploadFilter] = emptyArray) extends js.Object
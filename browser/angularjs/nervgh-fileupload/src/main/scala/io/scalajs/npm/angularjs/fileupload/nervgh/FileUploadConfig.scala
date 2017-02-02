package io.scalajs.npm.angularjs.fileupload.nervgh

import io.scalajs.dom.html.File

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Upload Configuration
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileUploadConfig(var data: js.Any = js.undefined,
                       var file: js.UndefOr[File] = js.undefined,
                       var fileName: js.Any = js.undefined,
                       var fileFormDataName: js.Any = js.undefined,
                       var method: js.UndefOr[String] = js.undefined,
                       var url: js.UndefOr[String] = js.undefined)
    extends js.Object

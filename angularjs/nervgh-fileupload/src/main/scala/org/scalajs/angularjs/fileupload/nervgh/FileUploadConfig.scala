package org.scalajs.angularjs.fileupload.nervgh

import org.scalajs.dom._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Upload Configuration
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileUploadConfig extends js.Object {
  var data: Any = _
  var file: File = _
  var fileName: js.Any = _
  var fileFormDataName: js.Any = _
  var method: String = _
  var url: String = _

}

/**
  * File Upload Configuration Singleton
  * @author lawrence.daniels@gmail.com
  */
object FileUploadConfig {

  def apply(url: String, file: File, data: js.Any = js.undefined) = {
    require(url != null || url.isEmpty, "Required property 'url' is missing")
    require(file != null, "Required property 'file' is missing")

    val config = new FileUploadConfig()
    config.url = url
    config.file = file
    config.data = data
    config
  }
}
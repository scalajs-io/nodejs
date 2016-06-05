package com.github.ldaniels528.meansjs.angularjs.fileupload.nervgh

import com.github.ldaniels528.meansjs.angularjs.http.HttpResponse
import org.scalajs.dom._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * AngularJS File Upload
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUpload extends js.Object {

  def upload[T](config: FileUploadConfig): FileUploadPromise[T] = js.native

}

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

/**
  * File Upload Promise
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUploadPromise[+T] extends HttpResponse[T] {

  def progress(listener: js.Function1[ProgressEvent, Unit]): this.type = js.native

  def abort(): Unit = js.native

}

/**
  * Progress Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
class ProgressEvent extends js.Object {

  val loaded: Double = js.native

  val total: Double = js.native

}


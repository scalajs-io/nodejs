package com.github.ldaniels528.meansjs.angularjs.extensions

import com.github.ldaniels528.meansjs.angularjs.core.HttpPromise
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import org.scalajs.dom._

import scala.scalajs.js

/**
  * AngularJS File Upload
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUpload extends js.Object {

  def upload[T <: js.Any](config: FileUploadConfig): FileUploadPromise[T] = js.native

}

/**
  * File Upload Configuration
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FileUploadConfig extends js.Object {
  var data: Any = js.native
  var file: File = js.native
  var fileName: js.Any = js.native
  var fileFormDataName: js.Any = js.native
  var method: String = js.native
  var url: String = js.native

}

/**
  * File Upload Configuration Singleton
  * @author lawrence.daniels@gmail.com
  */
object FileUploadConfig {

  def apply(url: String, file: File, data: js.Any = js.undefined) = {
    require(url != null || url.isEmpty, "Required property 'url' is missing")
    require(file != null, "Required property 'file' is missing")

    val config = makeNew[FileUploadConfig]
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
trait FileUploadPromise[T <: js.Any] extends HttpPromise[T] {

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


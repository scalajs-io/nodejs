package com.github.ldaniels528.nodesjs.angularjs.extensions

import com.github.ldaniels528.nodesjs.angularjs.core.HttpPromise
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
@js.native
object FileUploadConfig extends js.Object {

  def apply[T](url: String, file: File, data: Option[T] = None) = {
    require(url != null || url.isEmpty, "Required property 'url' is missing")
    require(file != null, "Required property 'file' is missing")

    val config = new js.Object().asInstanceOf[FileUploadConfig]
    config.url = url
    config.file = file
    data.foreach(config.data = _)
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


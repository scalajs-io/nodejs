package org.scalajs.angularjs.fileupload.nervgh

import org.scalajs.angularjs.fileupload.nervgh.FileUploadPromise.ProgressEvent
import org.scalajs.angularjs.http.HttpResponse

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

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
  * File Upload Promise Companion
  * @author lawrence.daniels@gmail.com
  */
object FileUploadPromise {

  /**
    * Progress Event
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class ProgressEvent(var loaded: js.UndefOr[Double] = js.undefined,
                      var total: js.UndefOr[Double] = js.undefined) extends js.Object

}
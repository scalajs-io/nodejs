package io.scalajs.npm.formdata

import io.scalajs.nodejs
import io.scalajs.nodejs.http.IncomingMessage

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * form-data - A library to create readable "multipart/form-data" streams. Can be used to submit forms
  * and file uploads to other web applications.
  * @see https://www.npmjs.com/package/form-data
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("form-data", JSImport.Namespace)
object FormData extends js.Object {

  @js.native
  class FormData() extends js.Object {

    def append(field: String, value: js.Any, options: FormOptions = js.native): Unit = js.native

    def getBoundary(): js.Any = js.native

    def submit(options: SubmitOptions, callback: js.Function2[nodejs.Error, IncomingMessage, Any]): Unit = js.native

    def submit(uri: String, callback: js.Function2[nodejs.Error, IncomingMessage, Any]): Unit = js.native

  }

}
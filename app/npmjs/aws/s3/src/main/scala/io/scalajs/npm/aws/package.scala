package io.scalajs.npm

import scala.scalajs.js

/**
  * aws package object
  * @author lawrence.daniels@gmail.com
  */
package object aws {

  type AWSCallback[T] = js.Function2[AWSError, T, Any]

  type AWSRequest[T] = Request[T, AWSError]

  type HttpHeaders = js.Dictionary[String]

  type StatusCode = Int

  type StatusMessage = String

}

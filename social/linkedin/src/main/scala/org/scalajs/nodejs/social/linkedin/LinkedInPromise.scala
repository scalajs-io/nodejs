package org.scalajs.nodejs.social.linkedin

import scala.concurrent.{Future, Promise}
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.runtime.wrapJavaScriptException

/**
  * LinkedIn Promise
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInPromise[T <: js.Any] extends js.Object {

  def error(callback: js.Function): LinkedInPromise[T] = js.native

  def error(callback: js.Function1[js.Any, Unit]): LinkedInPromise[T] = js.native

  def result(callback: js.Function): LinkedInPromise[T] = js.native

  def result(callback: js.Function1[T, Unit]): LinkedInPromise[T] = js.native

}

/**
  * LinkedIn Promise Companion Object
  * @author lawrence.daniels@gmail.com
  */
object LinkedInPromise {

  /**
    * Implicit conversion to transform a LinkedIn Promise into a Scala Future
    * @param inPromise the given [[LinkedInPromise LinkedIn Promise]]
    * @return the wrapped [[Future Future]]
    */
  implicit def promise2Future[T <: js.Any](inPromise: LinkedInPromise[T]): Future[T] = {
    val promise = Promise[T]()

    def onSuccess(data: T): Unit = promise.success(data)

    def onError(data: js.Any): Unit = promise.failure(wrapJavaScriptException(data))

    inPromise.result(onSuccess _).error(onError _)
    promise.future
  }

}

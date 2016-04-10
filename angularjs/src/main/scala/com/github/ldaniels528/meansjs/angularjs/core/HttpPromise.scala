package com.github.ldaniels528.meansjs.angularjs.core

import com.github.ldaniels528.meansjs.angularjs.{AngularPromise, angular}

import scala.concurrent.{Future, Promise}
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.UndefOr

/**
  * AngularJS HTTP Promise
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpPromise[T <: js.Any] extends AngularPromise {

  def error(callback: js.Function): HttpPromise[T] = js.native

  def error(callback: js.Function1[js.Any, Unit]): HttpPromise[T] = js.native

  def error(callback: js.Function2[js.Any, Int, Unit]): HttpPromise[T] = js.native

  def error(callback: js.Function3[js.Any, js.Any, Int, Unit]): HttpPromise[T] = js.native

  def error(callback: js.Function4[js.Any, Int, js.Any, js.Any, Unit]): HttpPromise[T] = js.native

  def error(callback: js.Function5[js.Any, Int, js.Any, js.Any, UndefOr[String], Unit]): HttpPromise[T] = js.native

  def success(callback: js.Function): HttpPromise[T] = js.native

  def success(callback: js.Function1[T, Unit]): HttpPromise[T] = js.native

  def success(callback: js.Function2[T, Int, Unit]): HttpPromise[T] = js.native

  def success(callback: js.Function3[T, js.Any, Int, Unit]): HttpPromise[T] = js.native

  def success(callback: js.Function4[T, Int, js.Any, js.Any, Unit]): HttpPromise[T] = js.native

  def success(callback: js.Function5[T, Int, js.Any, js.Any, js.Any, Unit]): HttpPromise[T] = js.native

  def `then`(success: js.Function1[js.Any, Unit], failure: js.Function1[js.Any, Unit] = js.native, callback: js.Function = js.native): HttpPromise[T] = js.native

}

/**
  * AngularJS HTTP Promise Singleton
  * @author lawrence.daniels@gmail.com
  */
object HttpPromise {

  /**
    * Implicit conversion to transform an AngularJS HTTP Promise into a Scala Future
    * @param httpPromise the given [[HttpPromise HTTP Promise]]
    * @return the wrapped [[Future Future]]
    */
  implicit def promise2future[T <: js.Any](httpPromise: HttpPromise[T]): Future[T] = {
    val promise = Promise[T]()

    def onSuccess(data: T): Unit = promise.success(data)

    def onError(data: js.Any, status: Int, config: js.Any, headers: js.Any, statusText: UndefOr[String]): Unit = {
      promise failure HttpError(status, statusText getOrElse s"Failed to process HTTP request: '${angular.toJson(data)}'")
    }

    httpPromise.success(onSuccess _).error(onError _)
    promise.future
  }

}

package com.github.ldaniels528.meansjs.angularjs.http

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.UndefOr

/**
  * AngularJS HTTP Promise
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpPromise[T <: js.Any] extends js.Promise[HttpResponse[T]] {

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

}


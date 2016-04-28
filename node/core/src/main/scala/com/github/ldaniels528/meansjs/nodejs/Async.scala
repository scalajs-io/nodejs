package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * NodeJS Async module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Async extends js.Object {

  def eachSeries[A <: js.Any](array: js.Array[A], callback: js.Function): Unit = js.native

  def filter[A <: js.Any](items: js.Array[A], filterFn: js.Function, callback: js.Function): Unit = js.native

  def map[A <: js.Any](items: js.Array[A], mapFn: js.Function, callback: js.Function): Unit = js.native

  def parallel(tasks: js.Array[js.Function], callback: js.Function): Unit = js.native

  def series(tasks: js.Array[js.Function]): Unit = js.native

  def setImmediate(block: js.Function): Unit = js.native

  def waterfall(tasks: js.Array[js.Function], callback: js.Function): Unit = js.native

}

/**
  * Async Companion
  * @author lawrence.daniels@gmail.com
  */
object Async {

  /**
    * Async Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class AsyncExtensions(val async: Async) extends AnyVal {

    /*
    @inline
    def eachSeries[A <: js.Any](array: js.Array[A]) = {
      callbackToFuture[js.Array[A]](async.eachSeries(array, _))
    }*/

    @inline
    def filterAsync[A <: js.Any, B <: js.Any](items: js.Array[A], filterFn: js.Function1[A, B]) = {
      callbackToFuture[js.Array[B]](async.filter(items, filterFn, _))
    }

    @inline
    def mapAsync[A <: js.Any, B <: js.Any](items: js.Array[A], mapFn: js.Function1[A, B]) = {
      callbackToFuture[js.Array[B]](async.map(items, mapFn, _))
    }

    /*
    @inline
    def parallel[A <: js.Any](tasks: js.Array[js.Function]) = {
      callbackToFuture[js.Array[A]](async.parallel(tasks, _))
    }

    @inline
    def waterfallAsync[A <: js.Any](tasks: js.Array[js.Function]) = {
      callbackToFuture[js.Array[A]](async.waterfall(tasks, _))
    }*/

  }

}
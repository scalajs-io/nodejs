package io.scalajs.npm

import io.scalajs.nodejs.Error

import scala.concurrent.{Future, Promise => ScalaPromise}
import scala.scalajs.js

/**
  * mpromise package object
  * @author lawrence.daniels@gmail.com
  */
package object mpromise {

  /**
    * Promise Enrichment
    * @param promise the given [[Promise]]
    */
  implicit class PromiseEnrichment[T](val promise: Promise[T]) extends AnyVal {

    @inline
    def toFuture: Future[T] = {
      val p = ScalaPromise[T]()
      promise.onResolve { (err: Error, result: T) =>
        if (err != null) p.failure(js.JavaScriptException(err))
        else p.success(result)
      }
      p.future
    }

  }

}

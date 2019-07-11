package io.scalajs.npm.mpromise

import io.scalajs.nodejs._
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Promise Test Suite
  * @author lawrence.daniels@gmail.com
  */
class PromiseTest extends AnyFunSpec {

  describe("Promise") {

    it("supports onFulfill(...)") {
      val promise = new Promise[(Int, Int)]()
      promise.onFulfill { case (a, b) =>
        Assert.equal(3, a + b)
      }
      promise.fulfill(1 -> 2)
    }

    it("supports onReject(...)") {
      val promise = new Promise()
      promise.onReject { reason =>
        Assert.equal("sad", reason)
      }
      promise.reject("sad")
    }

    it("supports exception handling") {
      val promise = new Promise[Unit]().`then`[Unit](_ => throw new Error("shucks"))
      setTimeout(() =>
        promise.fulfill({})
        // error was caught and swallowed by the promise returned from
        // p.then(). we either have to always register handlers on
        // the returned promises or we can do the following...
        , 10)
    }

    it("supports conversion to a Scala Future") {
      val promise = new Promise[(Int, Int)]()
      promise.fulfill((2, 3))

      promise.toFuture foreach { result =>
        info(s"result: $result")
      }
    }

    it("supports asynchronous execution pipelines") {
      val promise = new Promise[Int]()
      promise
        .`then`(arg => arg + 1)
        .`then`(arg => throw new Error(arg + " is an error!"))
        .`then`(null, { err =>
          Assert.ok(err.isInstanceOf[Error])
          Assert.equal("2 is an error", err.message)
        })
      promise.fulfill(1)
    }

    it("supports promise chaining") {

      def makeMeAPromise(i: Int) = {
        val p = new Promise[Int]()
        p.fulfill(i)
        p
      }

      val initialPromise = new Promise[Int]()
      var returnPromise = initialPromise
      for (i <- 0 until 10) {
        returnPromise = returnPromise.chain(makeMeAPromise(i))
      }

      initialPromise.fulfill(1)
      returnPromise.toFuture foreach { result =>
        info(s"returnPromise: $result")
        Assert.equal(9, result)
      }
    }

  }

}

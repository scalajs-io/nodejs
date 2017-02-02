package io.scalajs.npm.async

import io.scalajs.JSON
import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.{Error, console}
import io.scalajs.npm.async.AsyncTest._
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.util.{Failure, Success, Try}

/**
  * Async module tests
  * @author lawrence.daniels@gmail.com
  */
class AsyncTest extends FunSpec {

  describe("Async") {

    val localPath = Fs.realpathSync("./npm/async/src/test/resources")

    it("supports queue") {
      // create a queue object with concurrency 2
      val q = Async.queue[Task]((task: Task, callback: js.Function0[Any]) => {
        println("hello " + task.name)
        callback()
      }, 2)

      // assign a callback
      q.drain = () => {
        println("all items have been processed")
      }

      // add some items to the queue
      q.push(new Task(name = "foo"), (err: Error) => {
        println("finished processing foo")
      })

      q.push(new Task(name = "bar"), (err: Error) => {
        println("finished processing bar")
      })

      // add some items to the queue (batch-wise)
      q.push(js.Array(new Task(name = "baz"), new Task(name = "bay"), new Task(name = "bax")), (err: Error) => {
        println("finished processing item")
      })

      // add some items to the front of the queue
      q.unshift(new Task(name = "bar"), (err: Error) => {
        println("finished processing bar")
      })
    }

    it("supports waterfall via callbacks") {
      Async.waterfall(
        js.Array(
          (callback: js.Function3[Error, String, String, Unit]) => callback(null, "one", "two"),
          // arg1 now equals "one" and arg2 now equals "two"
          (arg1: String, arg2: String, callback: js.Function2[Error, String, Unit]) => callback(null, "three"),
          // arg1 now equals "three"
          (arg1: String, callback: js.Function2[Error, String, Unit]) => callback(null, "done")
        ),
        (err: Error, result: String) => {
          // result now equals "done"
          console.log("result = %s", result)
        }
      )
    }

    it("supports waterfall via promises (1)") {
      Async.waterfallFuture[String](
        js.Array(
          // start with two args
          (callback: js.Function3[Error, String, String, Unit]) => callback(null, "one", "two"),
          // arg1 now equals "one" and arg2 now equals "two"
          (arg1: String, arg2: String, callback: js.Function2[Error, String, Unit]) => callback(null, "three"),
          // arg1 now equals "three"
          (arg1: String, callback: js.Function2[Error, String, Unit]) => callback(null, "done")
        )) foreach (result => console.log("result = %s", result))
    }

    it("supports waterfall via promises (2)") {
      Async.waterfallFuture[Int](
        js.Array(
          // start with n = 1
          (callback: js.Function2[Error, Int, Any]) => callback(null, 1),
          // multiply by 2: n = n * 2
          (n: Int, callback: js.Function2[Error, Int, Any]) => callback(null, n * 2),
          // multiply by 10: n = n * 10
          (n: Int, callback: js.Function2[Error, Int, Any]) => callback(null, n * 10)
        )) foreach (n => console.log("n = %d", n))
    }

    it("supports forEachOf via callbacks") {
      val obj = js.Dictionary("dev" -> "/dev.json", "test" -> "/test.json", "prod" -> "/prod.json")
      val configs = js.Dictionary[js.Any]()

      Async.forEachOf(
        obj,
        (value: String, key: String, callback: js.Function1[Any, Any]) => {
          Fs.readFile(
            localPath + value,
            "utf8",
            (err: Error, data: String) => {
              if (isDefined(err)) callback(err)
              else {
                Try {
                  configs(key) = JSON.parse(data)
                } match {
                  case Success(_) => callback(null)
                  case Failure(e) => callback(e)
                }
              }
              console.log("Done A")
            }
          )
        },
        (err: Error) => {
          if (isDefined(err)) console.error(err.message)
          // configs is now a map of JSON data
          doSomethingWith("A", configs)
        }
      )
    }

    it("supports forEachOf via promises (1)") {
      val envFiles = js.Dictionary("dev" -> "/dev.json", "test" -> "/test.json", "prod" -> "/prod.json")
      val configs = js.Dictionary[js.Any]()

      Async.forEachOfFuture(envFiles) { (value: String, key: String, callback: js.Function1[Error, Any]) =>
        Fs.readFile(
          localPath + value,
          "utf8",
          (err: Error, data: String) => {
            if (isDefined(err)) callback(err)
            else {
              Try {
                configs(key) = JSON.parse(data)
              } match {
                case Success(_) => callback(null)
                case Failure(e) => callback(new Error(e.getMessage))
              }
            }
            console.log("Done B")
          }
        )
      } foreach (_ => doSomethingWith("B", configs))
    }

    it("supports forEachOf via promises (2)") {
      val envs = js.Array("dev", "test", "prod")
      val files = js.Array("/dev.json", "/test.json", "/prod.json")
      val configs = js.Dictionary[js.Any]()

      Async.forEachOfFuture(files) { (value: String, index: Int, callback: js.Function1[Error, Any]) =>
        Fs.readFile(
          localPath + value,
          "utf8",
          (err: Error, data: String) => {
            if (isDefined(err)) callback(err)
            else {
              Try {
                configs(envs(index)) = JSON.parse(data)
              } match {
                case Success(_) => callback(null)
                case Failure(e) => callback(new Error(e.getMessage))
              }
            }
            console.log("Done C")
          }
        )
      } foreach (_ => doSomethingWith("C", configs))
    }

    def doSomethingWith(label: String, configs: js.Any): Unit = {
      console.log("%s: configs = %j", label, configs)
    }

  }

}

/**
  * Async Tests Companion
  * @author lawrence.daniels@gmail.com
  */
object AsyncTest {

  @ScalaJSDefined
  class Task(val name: String) extends js.Object

}

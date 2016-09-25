package org.scalajs.npm.async

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.{console, errors}
import org.scalajs.npm.async.AsyncTests._
import utest.{TestSuite, _}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Async module tests
  * @author lawrence.daniels@gmail.com
  */
class AsyncTests extends TestSuite {
  private val async = Async()

  override val tests = this {

    "async.queue" - {
      // create a queue object with concurrency 2
      val q = async.queue[Task]((task: Task, callback: js.Function0[Any]) => {
        println("hello " + task.name)
        callback()
      }, 2)

      // assign a callback
      q.drain = () => {
        println("all items have been processed")
      }

      // add some items to the queue
      q.push(new Task(name = "foo"), (err: errors.Error) => {
        println("finished processing foo")
      })

      q.push(new Task(name = "bar"), (err: errors.Error) => {
        println("finished processing bar")
      })

      // add some items to the queue (batch-wise)
      q.push(js.Array(new Task(name = "baz"), new Task(name = "bay"), new Task(name = "bax")), (err: errors.Error) => {
        println("finished processing item")
      })

      // add some items to the front of the queue
      q.unshift(new Task(name = "bar"), (err: errors.Error) => {
        println("finished processing bar")
      })
    }

  }

}

/**
  * Async Tests Companion
  * @author lawrence.daniels@gmail.com
  */
object AsyncTests {

  @ScalaJSDefined
  class Task(val name: String) extends js.Object

}
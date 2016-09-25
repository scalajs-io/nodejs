package examples.nodejs.concurrency

import examples.nodejs.concurrency.AsyncQueueExample.Task
import org.scalajs.nodejs.{Bootstrap, console, errors}
import org.scalajs.npm.async.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Async Queue Example
  * @author lawrence.daniels@gmail.com
  */
class AsyncQueueExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val async = Async()

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

/**
  * Async Queue Example Companion
  * @author lawrence.daniels@gmail.com
  */
object AsyncQueueExample {

  @ScalaJSDefined
  class Task(val name: String) extends js.Object

}
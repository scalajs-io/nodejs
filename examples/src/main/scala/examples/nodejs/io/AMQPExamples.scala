package examples.nodejs.io

import org.scalajs.nodejs.global.process
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.amqplib.AmqpLib
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * AMQP Examples
  * @author lawrence.daniels@gmail.com
  */
class AMQPExamples(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val amqp = AmqpLib()

  // get the queue
  val queueName = process.argv.drop(3).headOption getOrElse "tasks"

  exampleA()

  def exampleA() {
    // Publisher
    for {
      conn <- amqp.connect("amqp://localhost")
      channel <- conn.createChannel()
      assertion <- channel.assertQueue(queueName)
      ok <- channel.sendToQueue(queueName, Buffer("something to do"))
      closedStatus <- conn.close()
    } yield (ok, closedStatus)

    // Consumer
    for {
      conn <- amqp.connect("amqp://localhost")
      channel <- conn.createChannel()
      assertion <- channel.assertQueue(queueName)
      ok <- channel.consumeFuture(queueName) {
        case message if message != null =>
          console.log(message.content.toString())
          channel.ack(message)
        case _ =>
      }
      closedStatus <- conn.close()
    } yield ok
  }

  def exampleB() {

  }

}

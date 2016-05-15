package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.amqplib.AmqpLib
import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, console, process}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * AMQP Examples
  * @author lawrence.daniels@gmail.com
  */
class AMQPExamples(bootstrap: Bootstrap) {
  import bootstrap._

  val amqp = require[AmqpLib]("amqplib")

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

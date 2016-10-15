package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.npm.kafkarest.KafkaRestClass._
import utest.{TestSuite, _}

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * Kafka Rest Tests
  * @author lawrence.daniels@gmail.com
  */
object KafkaRestTests extends TestSuite {

  override val tests = this {
    val KafkaRestClass = KafkaRest()
    val kafka = KafkaRestClass(new KafkaRestOptions(url = "http://localhost:8082"))

    "The Kafka object should be able to list topics" - {
      kafka.topics.listFuture foreach { topics =>
        console.log("topics => %j", topics)
      }
    }

  }

}

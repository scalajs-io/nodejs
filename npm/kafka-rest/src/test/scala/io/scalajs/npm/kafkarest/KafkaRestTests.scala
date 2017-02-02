package io.scalajs.npm.kafkarest

import java.util.UUID

import io.scalajs.nodejs.{console, process}
import io.scalajs.npm.kafkarest.KafkaRestTests.UserInfo
import io.scalajs.util.OptionHelper._
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.language.postfixOps
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * KafkaRest Tests
  * @author lawrence.daniels@gmail.com
  */
class KafkaRestTests extends FunSpec {

  describe("KafkaRest") {

    val kafka = new KafkaRest(new KafkaRestOptions(url = "http://localhost:8082"))

    it("should be able to list topics") {
      kafka.topics.listFuture foreach { topics =>
        console.log("topics => %j", topics)
      }
    }

    it("works?") {
      val kafkaUrl = (process.env.get("kafka_url") ?? process.env.get("KAFKA_URL")) getOrElse "localhost:8082"

      val kafka = new KafkaRest(new KafkaRestOptions(url = kafkaUrl))

      // first define some Avro schemas
      val (userIdSchema, userInfoSchema) = defineAvroSchemas
      console.log("userIdSchema => %j", userIdSchema)
      console.log("userInfoSchema => %j", userInfoSchema)

      // next, let's generate some data
      val entertainers = generateData
      console.log("actors => %j", entertainers)

      // finally, let's produce the data
      val topic = kafka.topic("entertainers")
      entertainers foreach { entertainer =>
        topic.produce(userInfoSchema, new KeyedMessage(key = UUID.randomUUID().toString, value = entertainer))
      }
    }

  }

  private def defineAvroSchemas = {
    val userIdSchema = new AvroSchema("int")
    val userInfoSchema = new AvroSchema(
      new Schema(name = "UserInfo",
                 `type` = "record",
                 fields = js.Array(
                   new Schema.Field(name = "id", `type` = "int"),
                   new Schema.Field(name = "name", `type` = "string")
                 )))
    (userIdSchema, userInfoSchema)
  }

  private def generateData = {
    Seq(
      "Halle Barry",
      "Idris Elba",
      "Michael Fastbender",
      "Kevin Hart",
      "John Travolta"
    ).zipWithIndex map {
      case (name, id) =>
        new UserInfo(id + 1, name)
    } toJSArray
  }

}

/**
  * KafkaRest Tests Companion
  * @author lawrence.daniels@gmail.com
  */
object KafkaRestTests {

  @ScalaJSDefined
  class UserInfo(val id: Int, val name: String) extends js.Object

}

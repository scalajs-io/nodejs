package examples.nodejs.datastores.kafka

import java.util.UUID

import examples.nodejs.datastores.kafka.KafkaRestExample._
import org.scalajs.nodejs.globals.process
import org.scalajs.nodejs.{Bootstrap, console}
import org.scalajs.npm.kafkarest._
import org.scalajs.sjs.OptionHelper._

import scala.language.postfixOps
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Kafka Rest Example
  * @author lawrence.daniels@gmail.com
  */
class KafkaRestExample(bootstrap: Bootstrap) {
  implicit val $require = bootstrap.require

  val kafkaUrl = (process.env.get("kafka_url") ?? process.env.get("KAFKA_URL")) getOrElse "localhost:8082"

  val kafkaRest = KafkaRest()
  val kafka = kafkaRest(new KafkaRestOptions(url = kafkaUrl))

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

  def defineAvroSchemas = {
    val userIdSchema = kafkaRest.AvroSchema("int")
    val userInfoSchema = kafkaRest.AvroSchema(new Schema(
      name = "UserInfo",
      `type` = "record",
      fields = js.Array(
        new Schema.Field(name = "id", `type` = "int"),
        new Schema.Field(name = "name", `type` = "string")
      )))
    (userIdSchema, userInfoSchema)
  }

  def generateData = {
    Seq(
      "Halle Barry", "Idris Elba", "Michael Fastbender", "Kevin Hart", "John Travolta"
    ).zipWithIndex map { case (name, id) =>
      new UserInfo(id + 1, name)
    } toJSArray
  }

}

/**
  * Kafka Rest Example
  * @author lawrence.daniels@gmail.com
  */
object KafkaRestExample {

  @ScalaJSDefined
  class UserInfo(val id: Int, val name: String) extends js.Object

}

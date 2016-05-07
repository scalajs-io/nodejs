package com.github.ldaniels528.meansjs.nodejs.kafkanode

import com.github.ldaniels528.meansjs.nodejs.zookeeper.ClientOptions
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Client Class
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/kafka-node
  */
@js.native
trait ClientClass extends js.Object

/**
  * Client Class Companion
  * @author lawrence.daniels@gmail.com
  */
object ClientClass {

  /**
    * Client Class Extensions
    * @param `class` the given [[ClientClass client class]]
    */
  implicit class ClientClassExtensions(val `class`: ClientClass) extends AnyVal {

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String, clientId: String, zkOptions: ClientOptions, noAckBatchOptions: NoAckBatchOptions) = {
      `class`.New[Client](connectionString, clientId, zkOptions, noAckBatchOptions)
    }

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String, clientId: String, zkOptions: ClientOptions) = {
      `class`.New[Client](connectionString, clientId, zkOptions)
    }

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String, clientId: String) = `class`.New[Client](connectionString, clientId)

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String) = `class`.New[Client](connectionString)

  }

}
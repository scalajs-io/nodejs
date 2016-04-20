package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Client Factory
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/kafka-node
  */
@js.native
trait ClientFactory extends js.Object

/**
  * Client Factory Companion
  * @author lawrence.daniels@gmail.com
  */
object ClientFactory {

  /**
    * Client Factory Enrichment
    * @param clientFactory the given [[ClientFactory client factory]]
    */
  implicit class ClientFactoryEnrichment(val clientFactory: ClientFactory) extends AnyVal {

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String, clientId: String, zkOptions: ZkOptions, noAckBatchOptions: NoAckBatchOptions) = {
      clientFactory.New[Client](connectionString, clientId, zkOptions, noAckBatchOptions)
    }

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String, clientId: String, zkOptions: ZkOptions) = {
      clientFactory.New[Client](connectionString, clientId, zkOptions)
    }

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String, clientId: String) = clientFactory.New[Client](connectionString, clientId)

    /**
      * @example Client(connectionString, clientId, [zkOptions], [noAckBatchOptions])
      */
    def apply(connectionString: String) = clientFactory.New[Client](connectionString)

  }

}
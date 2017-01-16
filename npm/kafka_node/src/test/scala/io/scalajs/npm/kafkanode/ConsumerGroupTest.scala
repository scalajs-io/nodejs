package io.scalajs.npm.kafkanode

import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Consumer Group Test
  * @author lawrence.daniels@gmail.com
  */
class ConsumerGroupTest extends FunSpec {

  describe("ConsumerGroup") {
    val options = new ConsumerGroupOptions(
      host = "zookeeper:2181",
      zk = js.undefined, // put client zk settings if you need them (see Client)
      batch = js.undefined, // put client batch settings if you need them (see Client)
      ssl = true, // optional (defaults to false) or tls options hash
      groupId = "ExampleTestGroup",
      sessionTimeout = 15000,
      // An array of partition assignment protocols ordered by preference.
      // "roundrobin" or "range" string for built ins (see below to pass in custom assignment protocol)
      protocol = js.Array("roundrobin"),

      // Offsets to use for new groups other options could be "earliest" or "none" (none will emit an error if no offsets were saved)
      // equivalent to Java client"s auto.offset.reset
      fromOffset = "latest", // default

      // how to recover from OutOfRangeOffset error (where save offset is past server retention) accepts same value as fromOffset
      outOfRangeOffset = "earliest", // default
      migrateHLC = false, // for details please see Migration section below
      migrateRolling = true
    )

    it("should be created like ConsumerGroup(options, ['RebalanceTopic', 'RebalanceTest'])") {
      new ConsumerGroup(options, js.Array("RebalanceTopic", "RebalanceTest"))
    }

    it("should be created like ConsumerGroup(options, 'RebalanceTopic')") {
      new ConsumerGroup(options, "RebalanceTopic")
    }

  }

}

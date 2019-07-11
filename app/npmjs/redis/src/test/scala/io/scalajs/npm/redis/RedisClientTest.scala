package io.scalajs.npm.redis

import org.scalatest.funspec.AnyFunSpec

/**
  * Redis Client Test Suite
  * @author lawrence.daniels@gmail.com
  */
class RedisClientTest extends AnyFunSpec {
  // TODO fix test issues

  describe("RedisClient") {
    /*
    val client = Redis.createClient(new RedisClientOptions(detect_buffers = true))
    //setTimeout(() => scala.util.Try(client.quit()), 20.seconds)

    it("supports monitoring") {
      client.monitor((err, res) => {
        info("Entering monitoring mode.")
      })
      client.set("foo", "bar")

      client.onMonitor((time, args, raw_reply) => {
        info(time + ": " + args) // 1458910076.446514:['set', 'foo', 'bar']
      })
    }

    it("supports buffers and strings") {
      client.set("foo_rand000000000000", "OK")

      // This will return a JavaScript String 
      client.get("foo_rand000000000000", (err, reply) => {
        info(reply.toString()) // Will print `OK` 
      })

      // This will return a Buffer since original key is specified as a Buffer 
      client.get(Buffer.from("foo_rand000000000000"), (err, reply) => {
        info(reply.toString()) // Will print `<Buffer 4f 4b>` 
      })
    }

    it("supports creating hashes") {
      client.hmset("AAPL", js.Array(
        "Name", "Apple Inc.",
        "LastSale", "143.34",
        "MarketCap", "752039043600",
        "IPOyear", "1980",
        "Sector", "Technology",
        "Industry", "Computer Manufacturing"))
    }

    it("supports retrieving hashes") {
      client.hgetall("AAPL", (err, obj) => {
        assert(!isDefined(err))
        info(JSON.stringify(obj)) // {"Name":"Apple Inc.","LastSale":"143.34","MarketCap":"752039043600","IPOyear":"1980","Sector":"Technology","Industry":"Computer Manufacturing"}
      })
    }

    it("supports existence of a key") {
      client.exists("AAPL", (err, result) => info(s"exists: AAPL = $result"))
    }

    it("supports existence of an array of keys") {
      client.exists(js.Array("AAPL", "AMD"), (err, result) => info(s"exists: AAPL+AMD = $result"))
    }

    it("supports SCAN") {
      client.scan(0, (err: RedisError, result: js.Any) => info(s"SCAN1: results = ${JSON.stringify(result)}"))
    }

    it("supports SCAN with COUNT") {
      client.scan(0, "COUNT", 50, (err: RedisError, result: js.Any) => info(s"SCAN2: results = ${JSON.stringify(result)}"))
    }

    it("supports SCAN with COUNT and MATCH") {
      client.scan(0, "COUNT", 50, "MATCH", "A*", (err: RedisError, result: js.Any) => info(s"SCAN3: results = ${JSON.stringify(result)}"))
    }

    it("supports multi-commands") {
      val multi = client.multi()

      // start a separate multi command queue
      multi.incr("incr thing", Redis.print)
      multi.incr("incr other thing", Redis.print)

      // runs immediately
      client.mset(js.Array("incr thing", 100, "incr other thing", 1), Redis.print)

      // drains multi queue and runs atomically
      multi.exec((err, replies) => {
        info(JSON.stringify(replies)) // 101, 2
      })
    }

    it("supports publish / subscribe") {
      val sub = Redis.createClient()
      val pub = Redis.createClient()
      var msg_count = 0

      sub.onSubscribe((channel, count) => {
        pub.publish("a nice channel", "I am sending a message.")
        pub.publish("a nice channel", "I am sending a second message.")
        pub.publish("a nice channel", "I am sending my last message.")
      })

      sub.onMessage((channel, message) => {
        info("sub channel " + channel + ": " + message)
        msg_count += 1
        if (msg_count == 3) {
          sub.unsubscribe()
          sub.quit()
          pub.quit()
        }
      })

      sub.subscribe("a nice channel")
    }*/

  }

}

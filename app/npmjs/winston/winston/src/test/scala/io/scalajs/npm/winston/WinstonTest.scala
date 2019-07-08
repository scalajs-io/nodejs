package io.scalajs.npm
package winston

import io.scalajs.nodejs.{console, setTimeout}
import io.scalajs.npm.winston.WinstonTest.MetaData
import io.scalajs.npm.winston.transports.{ConsoleTransportOptions, FileTransportOptions}
import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.language.existentials
import scala.scalajs.js


/**
  * Winston Tests
  * @author lawrence.daniels@gmail.com
  */
class WinstonTest extends FunSpec {

  describe("Winston") {

    it("has a default logger") {
      Winston.log("info", "Hello distributed log files!")
      Winston.info("Hello again distributed logs")

      Winston.level = "debug"
      Winston.log("debug", "Now my debug messages are written to console!")
    }

    it("supports adding/removing transports") {
      Winston.add(winston.transports.File, new FileTransportOptions(filename = "somefile.log"))
      Winston.remove(winston.transports.Console)
    }

    it("can also configure transports via configure()") {
      Winston.configure(new ConfigurationOptions(
        transports = js.Array(new winston.transports.File(new FileTransportOptions(filename = "somefile.log")))
      ))
    }

    it("supports instantiating logger instances") {
      val logger = new winston.Logger(new ConfigurationOptions(
        transports = js.Array(
          new winston.transports.Console(),
          new winston.transports.File(new FileTransportOptions(filename = "somefile.log"))
        )))
    }

    it("supports multiple transports of the same type") {
      val logger = new winston.Logger(new ConfigurationOptions(
        transports = js.Array(
          new winston.transports.File(new FileTransportOptions(
            name = "info-file",
            filename = "filelog-info.log",
            level = "info"
          )),
          new winston.transports.File(new FileTransportOptions(
            name = "error-file",
            filename = "filelog-error.log",
            level = "error"
          ))
        )
      ))
    }

    it("supports profiling") {
      Winston.profile("test")

      setTimeout(() => {
        //
        // Stop profile of 'test'. Logging will now take place:
        //   "17 Jan 21:00:00 - info: test duration=1000ms"
        //
        Winston.profile("test")
      }, 1000)
    }

    it("supports string interpolation") {
      val logger = new winston.Logger(new ConfigurationOptions(
        transports = js.Array(new winston.transports.Console())
      ))

      logger.log("info", "test message %s", "my string")
      // info: test message my string

      logger.log("info", "test message %d", 123)
      // info: test message 123

      logger.log("info", "test message %j", new MetaData(number = 123), new MetaData())
      // info: test message {"number":123}
      // meta = {}

      logger.log("info", "test message %s, %s", "first", "second", new MetaData(number = 123))
      // info: test message first, second
      // meta = {number: 123}

      logger.log("info", "test message", "first", "second", new MetaData(number = 123))
      // info: test message first second
      // meta = {number: 123}

      logger.log("info", "test message %s, %s", "first", "second", new MetaData(number = 123), (() => {}): js.Function)
      // info: test message first, second
      // meta = {number: 123}
      // callback = function(){}

      logger.log("info", "test message", "first", "second", new MetaData(number = 123), (() => {}): js.Function)
      // info: test message first second
      // meta = {number: 123}
      // callback = function(){}
    }

    it("supports querying of logs with Loggly-like options") {
      val options = new QueryOptions(
        from = js.Date.now - 24.hours.toMillis,
        until = new js.Date,
        limit = 10,
        start = 0,
        order = "desc",
        fields = js.Array("message")
      )

      //
      // Find items logged between today and yesterday.
      //
      Winston.query(options, (err, results) => {
        if (err != null) {
          throw new IllegalStateException(err.code)
        }

        console.log("query results:", results)
      })
    }

    it("supports streaming logs back from a chosen transport") {
      // TODO Fix timeout issue
      /*
      Winston.stream(new StreamingOptions(start = -1)).onLog { log =>
        console.log("log:", log)
      }*/
    }

    it("supports exit-on-error") {
      val logger = new winston.Logger(new ConfigurationOptions(exitOnError = false))

      //
      // or, like this:
      //
      logger.exitOnError = false
    }

    it("supports dynamically changing the log level of a transport") {
      val logger = new winston.Logger(new ConfigurationOptions(
        transports = js.Array(
          new winston.transports.Console(new ConsoleTransportOptions(level = "warn")),
          new winston.transports.File(new FileTransportOptions(
            filename = "somefile.log",
            level = "info"
          ))
        )
      ))

      logger.debug("Will not be logged in either transport!")
      logger.transports.console.level = "debug"
      logger.transports.file.level = "verbose"
      logger.verbose("Will be logged in both transports!")
    }

  }

}

/**
  * Winston Test Singleton
  * @author lawrence.daniels@gmail.com
  */
object WinstonTest {


  class MetaData(val number: Integer = null) extends js.Object

}
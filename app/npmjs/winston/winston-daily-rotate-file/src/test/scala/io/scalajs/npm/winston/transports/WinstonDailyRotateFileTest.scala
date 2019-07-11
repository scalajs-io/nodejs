package io.scalajs.npm.winston
package transports

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.process
import io.scalajs.npm.winston
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.js

/**
  * WinstonDailyRotateFile Test Suite
  * @author lawrence.daniels@gmail.com
  */
class WinstonDailyRotateFileTest extends AnyFunSpec {
  private val resourcesPath = "./src/test/resources"

  describe("WinstonDailyRotateFile") {
    if (!Fs.existsSync(resourcesPath)) Fs.mkdirSync(resourcesPath)

    it("supports log rotation") {
      WinstonDailyRotateFile
      val transport = new winston.transports.DailyRotateFile(new DailyRotateFileOptions(
        filename = "./src/test/resources/rotating.log",
        datePattern = "yyyy-MM-dd.",
        prepend = true,
        level = if (process.env.get("ENV").contains("development")) "debug" else "info"
      ))

      val logger = new winston.Logger(new ConfigurationOptions(
        transports = js.Array(transport)
      ))

      logger.info("Hello World!")
    }

  }

}

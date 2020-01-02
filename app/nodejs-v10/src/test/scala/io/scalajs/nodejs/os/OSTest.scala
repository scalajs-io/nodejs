package io.scalajs.nodejs.os

import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

/**
  * OS Tests
  */
class OSTest extends FunSpec {
  describe("OS") {
    it("supports arch()") {
      assert(OS.arch().nonEmpty)
    }

    it("supports constants") {
      assert(isDefined(OS.constants))
    }

    it("supports cpus()") {
      val cpus = OS.cpus()
      assert(isDefined(cpus))
      assert(cpus(0).model.nonEmpty)
      assert(cpus(0).speed > 0)
      assert(cpus(0).times.user > 0)
    }

    it("supports endianness()") {
      assert(OS.endianness() === "BE" || OS.endianness() === "LE")
    }

    it("supports EOL") {
      assert(OS.EOL === "\n" || OS.EOL === "\r\n")
    }

    it("supports freemem()") {
      assert(OS.freemem() > 0)
    }

    it("supports homedir()") {
      assert(isDefined(OS.homedir()))
    }

    it("supports hostname()") {
      assert(isDefined(OS.hostname()))
    }

    it("supports loadavg()") {
      assert(isDefined(OS.loadavg()))
      assert(OS.loadavg().nonEmpty)
    }

    it("supports networkInterfaces()") {
      val networkInterfaces = OS.networkInterfaces()
      assert(isDefined(networkInterfaces))
      networkInterfaces foreach {
        case (name, iface) =>
          assert(name.nonEmpty)
          assert(iface.nonEmpty)
      }
    }

    it("supports platform()") {
      assert(OS.platform().nonEmpty)
    }

    it("supports release()") {
      assert(isDefined(OS.release()))
    }

    it("supports tmpdir()") {
      assert(isDefined(OS.tmpdir()))
    }

    it("supports totalmem()") {
      assert(isDefined(OS.totalmem()))
    }

    it("supports type()") {
      assert(isDefined(OS.`type`()))
    }

    it("supports uptime()") {
      assert(isDefined(OS.uptime()))
    }

    it("supports userInfo()") {
      assert(isDefined(OS.userInfo()))
    }
  }
}

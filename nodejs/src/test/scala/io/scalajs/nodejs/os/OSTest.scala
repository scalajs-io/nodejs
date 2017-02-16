package io.scalajs.nodejs.os

import io.scalajs.JSON
import io.scalajs.util.PromiseHelper._
import org.scalatest.FunSpec

/**
  * OS Tests
  * @author lawrence.daniels@gmail.com
  */
class OSTest extends FunSpec {

  describe("OS") {

    it("supports arch()") {
      info(s"arch: ${OS.arch()}")
      assert(isDefined(OS.arch()))
    }

    it("supports constants") {
      info(s"constants: ${JSON.stringify(OS.constants)}")
      assert(isDefined(OS.constants))
    }

    it("supports cpus()") {
      val cpus = OS.cpus()
      cpus.zipWithIndex foreach {
        case (cpu, n) =>
          info(s"cpu$n: ${JSON.stringify(cpu)}")
      }
      assert(isDefined(cpus))
    }

    it("supports endianness()") {
      info(s"endianness: ${OS.endianness()}")
      assert(isDefined(OS.endianness()))
    }

    it("supports EOL") {
      info(s"EOL: ${OS.EOL}")
      assert(isDefined(OS.EOL))
    }

    it("supports freemem()") {
      info(s"freemem: ${OS.freemem()}")
      assert(isDefined(OS.freemem()))
    }

    it("supports homedir()") {
      info(s"homedir: ${OS.homedir()}")
      assert(isDefined(OS.homedir()))
    }

    it("supports hostname()") {
      info(s"hostname: ${OS.hostname()}")
      assert(isDefined(OS.hostname()))
    }

    it("supports loadavg()") {
      info(s"loadavg: ${OS.loadavg()}")
      assert(isDefined(OS.loadavg()))
    }

    it("supports networkInterfaces()") {
      OS.networkInterfaces() foreach {
        case (name, iface) =>
          info(s"$name: ${JSON.stringify(iface)}")
      }
      assert(isDefined(OS.networkInterfaces()))
    }

    it("supports platform()") {
      info(s"platform: ${OS.platform()}")
      assert(isDefined(OS.platform()))
    }

    it("supports release()") {
      info(s"release: ${OS.release()}")
      assert(isDefined(OS.release()))
    }

    it("supports tmpdir()") {
      info(s"tmpdir: ${OS.tmpdir()}")
      assert(isDefined(OS.tmpdir()))
    }

    it("supports totalmem()") {
      info(s"totalmem: ${OS.totalmem()}")
      assert(isDefined(OS.totalmem()))
    }

    it("supports type()") {
      info(s"type: ${OS.`type`()}")
      assert(isDefined(OS.`type`()))
    }

    it("supports uptime()") {
      info(s"uptime: ${OS.uptime()}")
      assert(isDefined(OS.uptime()))
    }

    it("supports userInfo()") {
      info(s"userInfo: ${JSON.stringify(OS.userInfo())}")
      assert(isDefined(OS.userInfo()))
    }

  }

}

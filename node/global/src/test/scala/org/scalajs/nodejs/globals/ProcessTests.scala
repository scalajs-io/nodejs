package org.scalajs.nodejs.globals

import org.scalajs.nodejs.console
import org.scalajs.nodejs.globals.Process.ProcessEnvExtensions
import utest._

/**
  * Process Tests
  * @author lawrence.daniels@gmail.com
  */
object ProcessTests extends TestSuite {

  override val tests = this {

    "process properties" - {
      console.log("process.arch: ", process.arch)
      console.log("process.argv: ", process.argv)
      console.log("process.config: ", process.config)
      console.log("process.connected: ", process.connected)
      console.log("process.cwd(): ", process.cwd())
      console.log("process.domain: ", process.domain)
      console.log("process.env: ", process.env)
      console.log("process.env.NODE_ENV: ", process.env.NODE_ENV)
      console.log("process.env.PATH: ", process.env.PATH)
      console.log("process.execArgv: ", process.execArgv)
      console.log("process.execPath: ", process.execPath)
      console.log("process.features: ", process.features)
      console.log("process.moduleLoadList: ", process.moduleLoadList)
      console.log("process.title: ", process.title)
      console.log("process.version: ", process.version)
      console.log("process.versions: ", process.versions)
      //console.log("process.stdout.isTTY: ", process.stdout.isTTY)
      //console.log("process.stderr.isTTY: ", process.stderr.isTTY)
    }

  }

}

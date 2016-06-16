package examples.nodejs.general

import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.global.Process.ProcessEnvExtensions
import org.scalajs.nodejs.global.process

/**
  * Process Example
  * @author lawrence.daniels@gmail.com
  */
class ProcessExample(bootstrap: Bootstrap) {

  console.log("process.arch: %j", process.arch)
  console.log("process.argv: %j", process.argv)
  console.log("process.config: %j", process.config)
  console.log("process.connected: %j", process.connected)
  console.log("process.cwd(): %j", process.cwd())
  console.log("process.domain: %j", process.domain)
  console.log("process.env: %j", process.env)
  console.log("process.env.NODE_ENV: %j", process.env.NODE_ENV)
  console.log("process.env.PATH: %j", process.env.PATH)
  console.log("process.execArgv: %j", process.execArgv)
  console.log("process.execPath: %j", process.execPath)
  console.log("process.features: %j", process.features)
  console.log("process.moduleLoadList: %j", process.moduleLoadList)
  console.log("process.title: %j", process.title)
  console.log("process.version: %j", process.version)
  console.log("process.versions: %j", process.versions)
  console.log("process.stdout.isTTY: %j", process.stdout.isTTY)
  console.log("process.stderr.isTTY: %j", process.stderr.isTTY)

}

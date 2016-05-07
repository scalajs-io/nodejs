package examples.nodejs.general

import com.github.ldaniels528.meansjs.nodejs.{Bootstrap, process}
import org.scalajs.dom.console

/**
  * Process Info
  * @author lawrence.daniels@gmail.com
  */
class ProcessInfo(bootstrap: Bootstrap) {

  console.log("process.argv: %j", process.argv)
  console.log("process.config: %j", process.config)
  console.log("process.connected: %j", process.connected)
  console.log("process.cwd(): %j", process.cwd())
  console.log("process.domain: %j", process.domain)
  console.log("process.env: %j", process.env)
  console.log("process.features: %j", process.features)
  console.log("process.title: %j", process.title)
  console.log("process.version: %j", process.version)
  console.log("process.versions: %j", process.versions)

}

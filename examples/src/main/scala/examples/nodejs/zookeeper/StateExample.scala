package examples.nodejs.zookeeper

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.buffer._
import com.github.ldaniels528.meansjs.zookeeper._
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * State Example
  * @author lawrence.daniels@gmail.com
  */
class StateExample(require: Require) {
  val zookeeper = require[NodeZookeeper]("node-zookeeper-client")

  console.log(js.Dynamic.global.module)

  val state = Buffer("test")
  console.log(state)

}

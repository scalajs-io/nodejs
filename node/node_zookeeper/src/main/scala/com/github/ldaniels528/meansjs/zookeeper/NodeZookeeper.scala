package com.github.ldaniels528.meansjs.zookeeper

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Node Zookeeper Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeZookeeper extends NodeModule with EventEmitter {

  def createClient(connectionString: String): Client = js.native

  def ACL: js.Any = js.native

  def CreateMode: js.Any = js.native

  def Exception: js.Any = js.native

  def Event: js.Any = js.native

  def Id: js.Any = js.native

  def Permission: js.Any = js.native

  def State: js.Any = js.native

}

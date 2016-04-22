package com.github.ldaniels528.meansjs.zookeeper

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Node Zookeeper Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeZookeeper extends NodeModule {

  def createClient(connectionString: String): Client = js.native

  def ACL: js.Any = js.native

  def CreateMode: js.Any = js.native

  def Exception: js.Any = js.native

  def Event: js.Any = js.native

  def Id: js.Any = js.native

  def Permission: js.Any = js.native

  def State: js.Any = js.native

}

/**
  * Zookeeper Companion
  * @author lawrence.daniels@gmail.com
  */
object NodeZookeeper {
  type ZookeeperError = js.UndefOr[String]

}
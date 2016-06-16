package org.scalajs.nodejs.zookeeper

import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Node Zookeeper Client
  * @version 0.2.2
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeZookeeperClient extends NodeModule with EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def CreateMode: js.Dictionary[Int] = js.native

  def Permission: js.Dictionary[Int] = js.native

  def State: js.Dictionary[State] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Factory method to create a new zookeeper client instance.
    * @param connectionString the  given connection string (e.g. 'localhost:2181,localhost:2182/test')
    * @param options          the given client options
    * @return a new client
    * @example client.createClient(connectionString, [options])
    */
  def createClient(connectionString: String, options: ClientOptions = null): Client = js.native

}

/**
  * NodeZookeeperClient Companion
  * @author lawrence.daniels@gmail.com
  */
object NodeZookeeperClient {

  /**
    * Convenience method for retrieving the 'node-zookeeper-client' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the NodeZookeeperClient instance
    */
  def apply()(implicit require: NodeRequire) = require[NodeZookeeperClient]("node-zookeeper-client")

}
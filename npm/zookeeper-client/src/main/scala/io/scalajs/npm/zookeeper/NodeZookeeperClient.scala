package io.scalajs.npm.zookeeper

import io.scalajs.nodejs.NodeOptions
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Node Zookeeper Client
  * @version 0.2.2
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeZookeeperClient extends IEventEmitter {

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
  def createClient(connectionString: String, options: ClientOptions | NodeOptions = null): Client = js.native

}

/**
  * NodeZookeeperClient Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("node-zookeeper-client", JSImport.Namespace)
object NodeZookeeperClient extends NodeZookeeperClient
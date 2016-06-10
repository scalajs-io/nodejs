package com.github.ldaniels528.meansjs.nodejs.zookeeper

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Node Zookeeper Client
  * @author lawrence.daniels@gmail.com
  * @version 0.2.2
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

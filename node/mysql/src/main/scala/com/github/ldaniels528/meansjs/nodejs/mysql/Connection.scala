package com.github.ldaniels528.meansjs.nodejs.mysql

import scala.scalajs.js

/**
  * MySQL Connection
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Connection extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  var config: ConnectionOptions = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def connect(callback: js.Function = null): Unit = js.native

  /**
    * An alternative way to end the connection is to call the destroy() method. This will cause an immediate
    * termination of the underlying socket. Additionally destroy() guarantees that no more events or callbacks
    * will be triggered for the connection.
    */
  def destroy(): Unit = js.native

  def end(callback: js.Function = null): Unit = js.native

  def query(queryString: String, callback: js.Function): Unit = js.native

  def query(query: QueryOptions, callback: js.Function): Unit = js.native

  def query(query: QueryOptions, values: js.Array[js.Any], callback: js.Function): Unit = js.native

  def release(): Unit = js.native

}

package org.scalajs.nodejs.datastax

import scala.scalajs.js

/**
  * Client Meta Data
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ClientMetaData extends js.Object {

  def getFunction(keyspace: String, functionName: String, args: js.Array[_ <: js.Any], callback: js.Function): Unit = js.native

}

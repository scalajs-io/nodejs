package io.scalajs.npm.cassandradriver.types

import scala.scalajs.js

/**
  * Data Types object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DataTypes extends js.Object {
  var custom: Int = js.native
  var ascii: Int = js.native
  var bigint: Int = js.native
  var blob: Int = js.native
  var boolean: Int = js.native
  var counter: Int = js.native
  var decimal: Int = js.native
  var double: Int = js.native
  var float: Int = js.native
  var int: Int = js.native
  var text: Int = js.native
  var timestamp: Int = js.native
  var uuid: Int = js.native
  var varchar: Int = js.native
  var varint: Int = js.native
  var timeuuid: Int = js.native
  var inet: Int = js.native
  var date: Int = js.native
  var time: Int = js.native
  var smallint: Int = js.native
  var tinyint: Int = js.native
  var list: Int = js.native
  var map: Int = js.native
  var set: Int = js.native
  var udt: Int = js.native
  var tuple: Int = js.native

  def getByName: js.Function1[String, Int] = js.native

}

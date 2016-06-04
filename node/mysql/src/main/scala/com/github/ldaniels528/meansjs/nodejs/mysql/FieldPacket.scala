package com.github.ldaniels528.meansjs.nodejs.mysql

import scala.scalajs.js

/**
  * Field Packet
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FieldPacket extends js.Object {
  var catalog: String = js.native

  var db: String = js.native

  var table: String = js.native

  var orgTable: String = js.native

  var name: String = js.native

  var orgName: String = js.native

  var charsetNr: Int = js.native

  var length: Int = js.native

  var `type`: Int = js.native

  var flags: Int = js.native

  var decimals: Int = js.native

  var default: js.UndefOr[String] = js.native

  var zeroFill: Boolean = js.native

  var protocol41: Boolean = js.native
}
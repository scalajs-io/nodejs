package io.scalajs.npm.cassandradriver

import io.scalajs.npm.cassandradriver.types._

import scala.scalajs.js

/**
  * Types object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Types extends js.Object {

  def consistencies: Consistencies = js.native

  def dataTypes: DataTypes = js.native

  def opcodes: OpCodes = js.native

  def protocolEvents: ProtocolEvents = js.native

  def responseErrorCodes: ResponseErrorCodes = js.native

  def getDataTypeNameByCode(code: js.Any): js.Any = js.native

  def timeuuid: js.Function0[String] = js.native

  def uuid: js.Function0[String] = js.native

}

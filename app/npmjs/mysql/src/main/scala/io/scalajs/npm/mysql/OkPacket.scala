package io.scalajs.npm.mysql

import scala.scalajs.js

/**
  * MySQL OkPacket Response
  * @author lawrence.daniels@gmail.com
  */
trait OkPacket extends js.Object {

  def fieldCount: Int

  def affectedRows: Int

  def insertId: Int

  def serverStatus: Int

  def warningCount: Int

  def message: String

  def protocol41: Boolean

  def changedRows: Int

}

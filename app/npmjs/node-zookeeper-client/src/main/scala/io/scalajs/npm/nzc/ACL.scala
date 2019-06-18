package io.scalajs.npm.nzc

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Access Control List (ACL)
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("node-zookeeper-client", "ACL")
class ACL(permission: js.Any, id: js.Any) extends js.Object

/**
  * ACL Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("node-zookeeper-client", "ACL")
object ACL extends js.Object {

  def toRecord: js.Any = js.native

}
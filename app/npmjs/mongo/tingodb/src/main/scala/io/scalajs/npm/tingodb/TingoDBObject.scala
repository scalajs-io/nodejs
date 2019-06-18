package io.scalajs.npm.tingodb

import scala.scalajs.js

/**
  * TingoDB Wrapper Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TingoDBObject extends js.Object {

  def Db: DbClass = js.native

}

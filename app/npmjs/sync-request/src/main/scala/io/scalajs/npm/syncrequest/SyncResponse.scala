package io.scalajs.npm.syncrequest

import scala.scalajs.js

/**
  * Sync-Request Response object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SyncResponse extends js.Object {

  def getBody(encoding: String = js.native): String = js.native

}

package io.scalajs.npm.cassandradriver.types

import scala.scalajs.js

/**
  * Protocol Events object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ProtocolEvents extends js.Object {
  var topologyChange: String = js.native
  var statusChange: String   = js.native
  var schemaChange: String   = js.native
}

package com.github.ldaniels528.meansjs.kafkanode

import scala.scalajs.js

/**
  * Offset Factory
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait OffsetFactory extends js.Object {

  /**
    * @example Offset(client)
    */
  def apply(client: Client): Offset = js.native

}

package com.github.ldaniels528.meansjs.nodejs.drama

import scala.scalajs.js

/**
  * Actor System
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ActorSystem extends js.Object {

  def actor(factory: js.Any): Actor = js.native

}

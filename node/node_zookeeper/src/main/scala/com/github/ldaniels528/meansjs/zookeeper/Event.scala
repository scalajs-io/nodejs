package com.github.ldaniels528.meansjs.zookeeper

import scala.scalajs.js

/**
  * Zookeeper Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Event extends js.Object {

  /**
    * Return the name of the event.
    * @example String getName()
    */
  def getName(): String = js.native

  /**
    * Return the path of the event.
    * @example Number getPath()
    */
  def getPath(): Number = js.native

  /**
    * Return the type of the event.
    * @example Number getType()
    */
  def getType(): Number = js.native

}

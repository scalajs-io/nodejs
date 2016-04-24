package com.github.ldaniels528.meansjs.zookeeper

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Zookeeper State
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait State extends js.Object {

  /**
    * Return the name of the state.
    * @return the name of the state.
    */
  def getName(): String = js.native

  /**
    * Return the code of the state.
    * @return the code of the state.
    */
  def getCode(): Int = js.native

}

/**
  * State Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("State")
object State extends StateClass

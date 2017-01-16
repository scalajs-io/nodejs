package io.scalajs.npm.drama

import scala.scalajs.js

/**
  * Drama Actor
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Actor extends js.Object {

  /**
    * Requests state of the given method the specified actor
    * @param actor    the specified actor
    * @param method   the given method
    * @param callback the response callback
    */
  def ask(actor: Actor, method: String, callback: js.Function): Unit = js.native

  /**
    * Initializes an actor with the given initial value
    * @param initialValue the given initial value
    */
  def init(initialValue: js.Any): Unit = js.native

  /**
    * Returns a proxy implementing the corresponding methods
    * @param methods the corresponding methods
    * @return the proxy
    */
  def pick(methods: String*): js.Dynamic = js.native

  /**
    * Sends the given message to the specified method
    * @param method  the given message
    * @param message the specified method
    */
  def tell(method: String, message: js.Any): Unit = js.native

}

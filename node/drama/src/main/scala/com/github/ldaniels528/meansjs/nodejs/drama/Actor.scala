package com.github.ldaniels528.meansjs.nodejs.drama

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Actor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Actor extends js.Object {

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

/**
  * Actor Companion
  * @author lawrence.daniels@gmail.com
  */
object Actor {

  /**
    * Actor Extensions
    * @param actor the given [[Actor actor]]
    */
  implicit class ActorExtensions(val actor: Actor) extends AnyVal {

    /**
      * Sends the given message to the specified method
      * @param request the method/message tuple
      */
    @inline
    def !(request: (String, js.Any)) = actor.tell(request._1, request._2)

    /**
      * Requests state of the given method the specified actor
      * @param method the given method
      * @return the promise of the state
      */
    @inline
    def ?(method: String) = askFuture(method)

    /**
      * Requests state of the given method the specified actor
      * @param method the given method
      * @return the promise of the state
      */
    @inline
    def askFuture(method: String) = callbackToFuture[js.Any](actor.ask(actor, method, _))

  }

}

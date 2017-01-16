package io.scalajs.npm

import io.scalajs.util.ScalaJsHelper.futureCallbackA1

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.Any

/**
  * drama package object
  * @author lawrence.daniels@gmail.com
  */
package object drama {

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
    def !(request: (String, js.Any)): Unit = actor.tell(request._1, request._2)

    /**
      * Requests state of the given method the specified actor
      * @param method the given method
      * @return the promise of the state
      */
    @inline
    def ?(method: String): Promise[Any] = askFuture(method)

    /**
      * Requests state of the given method the specified actor
      * @param method the given method
      * @return the promise of the state
      */
    @inline
    def askFuture(method: String): Promise[Any] = futureCallbackA1[js.Any](actor.ask(actor, method, _))

  }

}

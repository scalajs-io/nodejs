package io.scalajs.npm.drama

import io.scalajs.npm.drama.StateDrivenActor.ReplyScope

import scala.scalajs.js

/**
  * State-driven Actor
  * @author lawrence.daniels@gmail.com
  */

class StateDrivenActor[T](initialState: T) extends js.Object {
  private var state = initialState

  def get: js.ThisFunction0[ReplyScope[T], Unit] = (scope: ReplyScope[T]) => scope.reply(state)

  def set: js.Function = (newState: T) => state = newState

}

/**
  * State-driven Actor Companion
  * @author lawrence.daniels@gmail.com
  */
object StateDrivenActor {

  @js.native
  trait ReplyScope[T] extends js.Object {
    var reply: js.Function1[T, Unit] = js.native
  }

}
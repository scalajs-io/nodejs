package org.scalajs.rx

import scala.scalajs.js

/**
  * The Observer object provides support for push-style iteration over an observable sequence.
  *
  * The Observer and Objects interfaces provide a generalized mechanism for push-based notification, also known as the
  * observer design pattern. The Observable object represents the object that sends notifications (the provider);
  * the Observer object represents the class that receives them (the observer).
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Observer extends js.Object {

  /**
    * Hides the identity of an observer.
    * @return (Observer): An observer that hides the identity of the specified observer.
    * @example Rx.Observer.prototype.asObserver()
    */
  def asObserver(): this.type = js.native

  /**
    * Checks access to the observer for grammar violations. This includes checking for multiple onError or onCompleted
    * calls, as well as re-entrancy in any of the observer methods.
    *
    * If a violation is detected, an Error is thrown from the offending observer method call.
    * @return (Observer): An observer that checks callbacks invocations against the observer grammar and, if the checks
    *         pass, forwards those to the specified observer.
    * @example Rx.Observer.prototype.checked()
    */
  def checked(): this.type = js.native

  /**
    * Schedules the invocation of observer methods on the given scheduler.
    * @param scheduler (Scheduler): Scheduler to schedule observer messages on.
    * @return (Observer): Observer whose messages are scheduled on the given scheduler.
    * @example Rx.Observer.prototype.notifyOn(scheduler)
    */
  def notifyOn(scheduler: Scheduler): this.type = js.native

  /**
    * Notifies the observer of the end of the sequence.
    * @example Rx.Observer.prototype.onCompleted()
    */
  def onCompleted(): Unit = js.native

  /**
    * Notifies the observer that an exception has occurred.
    * @param error (Any): The error that has occurred.
    * @example Rx.Observer.prototype.onError(error)
    */
  def onError(error: js.Error): Unit = js.native

  /**
    * Notifies the observer of a new element in the sequence.
    * @param value (Any): Next element in the sequence.
    * @example Rx.Observer.prototype.onNext(value)
    */
  def onNext(value: js.Any): Unit = js.native

  /**
    * Creates a notification callback from an observer.
    * @return (Function): The function that forwards its input notification to the underlying observer.
    */
  def toNotifier(): js.Function = js.native

}

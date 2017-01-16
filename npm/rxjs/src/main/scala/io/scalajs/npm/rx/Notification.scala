package io.scalajs.npm.rx

import scala.scalajs.js

/**
  * Represents a notification to an observer.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Notification extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Gets the exception from the OnError notification.
    * @return (Any): The Error from the onError notification.
    */
  def error: js.Any = js.native

  /**
    * Gets the kind from the notification which denotes 'N' for OnNext, 'E' for OnError and 'C' for OnCompleted.
    * @return (String): The kind from the notification which denotes 'N' for OnNext, 'E' for OnError and 'C' for OnCompleted.
    */
  def kind: String = js.native

  /**
    * Gets the value from the onNext notification.
    * @return (Any): The value from the onNext notification.
    */
  def value: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Invokes the delegate corresponding to the notification or the observer's method corresponding to the notification
    * and returns the produced result or the individual functions given.
    * @param observer    (Observer): Observer to invoke the notification on.
    * @param onNext      (Function): Function to invoke for an onNext notification.
    * @param onError     (Function): Function to invoke for an onError notification.
    * @param onCompleted (Function): Function to invoke for an onCompleted notification.
    * @return (Any): Result produced by the observation.
    * @example Rx.Notification.prototype.accept(observer | onNext, onError, onCompleted)
    */
  def accept(observer: Observer = null, onNext: js.Function = null, onError: js.Function = null, onCompleted: js.Function = null): Unit = js.native

  /**
    * Returns an observable sequence with a single notification.
    * @param scheduler [scheduler = Rx.Scheduler.immediate] (Scheduler): Scheduler to send out the notification calls on.
    * @return (Observable): The observable sequence that surfaces the behavior of the notification upon subscription.
    * @example Rx.Notification.prototype.toObservable([scheduler])
    */
  def toObservable[T](scheduler: Scheduler = null): Observable[T] = js.native

}

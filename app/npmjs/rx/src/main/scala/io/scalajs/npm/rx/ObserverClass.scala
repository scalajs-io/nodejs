package io.scalajs.npm.rx

import scala.scalajs.js

/**
  * Observer class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ObserverClass extends js.Object {

  /**
    * Creates an observer from the specified onNext, onError, and onCompleted actions.
    * @param onNext      (Function): Observer's onNext action implementation
    * @param onError     (Function): Observer's onError action implementation.
    * @param onCompleted (Function): Observer's onCompleted action implementation.
    * @return (Observer): The observer object implemented using the given actions.
    * @example Rx.Observer.create([onNext], [onError], [onCompleted])
    */
  def create(onNext: js.Function = null, onError: js.Function = null, onCompleted: js.Function = null): Observer =
    js.native

  /**
    * Creates an observer from a notification callback.
    * @param handler (Function): Function that handles a notification.
    * @param thisArg (Any): Object to use as this when executing handler.
    * @return (Observer): The observer object that invokes the specified handler using a notification corresponding
    *         to each message it receives.
    * @example Rx.Observer.fromNotifier(handler, [thisArg])
    */
  def fromNotifier(handler: js.Function, thisArg: js.Any = null): Observer = js.native

}

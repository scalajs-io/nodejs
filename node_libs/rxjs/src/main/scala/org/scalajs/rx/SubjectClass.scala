package org.scalajs.rx

import scala.scalajs.js

/**
  * Represents an object that is both an observable sequence as well as an observer. Each notification is broadcasted
  * to all subscribed observers.
  *
  * This class inherits both from the Rx.Observable and Rx.Observer classes.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SubjectClass extends ObserverClass with ObservableClass {

  /**
    * Creates a subject from the specified observer and observable.
    * @param observer   (Observer): The observer used to send messages to the subject.
    * @param observable (Observable): The observable used to subscribe to messages sent from the subject.
    * @return (Subject): Subject implemented using the given observer and observable.
    * @example Rx.Subject.create(observer, observable)
    */
  def create[T](observer: Observer, observable: Observable[T]): Subject[T] = js.native

}
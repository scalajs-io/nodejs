package org.scalajs.rx

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Rx Module
  * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/libraries/main/rx.md]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Rx")
trait Rx extends NodeModule {

  @js.native
  @JSName("AsyncSubject")
  val AsyncSubject: AsyncSubjectClass = js.native

  @js.native
  @JSName("Disposable")
  val Disposable: DisposableClass = js.native

  @js.native
  @JSName("Notification")
  val Notification: NotificationClass = js.native

  @js.native
  @JSName("Observer")
  val Observer: ObserverClass = js.native

  @js.native
  @JSName("Observable")
  val Observable: ObservableClass = js.native

  @js.native
  @JSName("Scheduler")
  val Scheduler: SchedulerClass = js.native

  @js.native
  @JSName("Subject")
  val Subject: SubjectClass = js.native

}

/**
  * Rx Companion
  * @author lawrence.daniels@gmail.com
  */
object Rx {

  /**
    * Convenience method for retrieving the Rx module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Rx instance
    */
  @inline
  def apply()(implicit require: NodeRequire) = require[Rx]("rx")

}
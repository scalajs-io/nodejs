package io.scalajs.npm.rx

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}

/**
  * The Reactive Extensions for JavaScript's main functionality is in the main RxJS file
  * which has many core components including the Schedulers, Disposables, Observable and Observer.
  *
  * This comes with both rx.js which is for use in modern development environments such as > IE9 and
  * server-side environments such as Node.js. We also have rx.compat.js which has backwards compatibility
  * to browsers which do not support all required ES5 features.
  * @version 4.1.0
  * @see https://github.com/Reactive-Extensions/RxJS/blob/master/doc/libraries/main/rx.md
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("rx", JSImport.Namespace)
object Rx extends js.Object {

  @js.native
  @JSName("AsyncSubject")
  object AsyncSubject extends AsyncSubjectClass

  @js.native
  @JSName("Disposable")
  object Disposable extends DisposableClass

  @js.native
  @JSName("Notification")
  object Notification extends NotificationClass

  @js.native
  @JSName("Observer")
  object Observer extends ObserverClass

  @js.native
  @JSName("Observable")
  object Observable extends ObservableClass

  @js.native
  @JSName("Scheduler")
  object Scheduler extends SchedulerClass

  @js.native
  @JSName("Subject")
  object Subject extends SubjectClass

}

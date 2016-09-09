package org.scalajs.rx

import org.scalajs.{dom, sjs}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Observable class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ObservableClass extends js.Object {

  /**
    * Propagates the observable sequence or Promise that reacts first. "amb" stands for ambiguous.
    * @param args (Array|arguments): Observable sources or Promises competing to react first either as an array or arguments.
    * @return An observable sequence that surfaces any of the given sequences, whichever reacted first.
    */
  def amb[T](args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Uses selector to determine which source in sources to use. There is an alias 'switchCase' for browsers < IE9.
    * @param selector   (Function): The function which extracts the value for to test in a case statement.
    * @param sources    (Object): A object which has keys which correspond to the case statement labels.
    * @param elseSource [elseSource|scheduler] (Observable | Scheduler): The observable sequence that will be run if
    *                   the sources are not matched. If this is not provided, it defaults to Rx.Observable.empty with
    *                   the specified scheduler.
    * @return An observable sequence which is determined by a case statement.
    * @example Rx.Observable.case(selector, sources, [elseSource|scheduler])
    */
  def `case`[T](selector: js.Function, sources: js.Any = js.native, elseSource: Observable[T] | Scheduler = js.native): Observable[T] = js.native

  /**
    * Continues an observable sequence that is terminated by an exception with the next observable sequence.
    * @param args (Array | arguments): Observable sequences to catch exceptions for.
    * @return An observable sequence containing elements from consecutive source sequences until a source sequence
    *         terminates successfully.
    * @example Rx.Observable.catch(...args)
    */
  def `catch`[T](args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Concatenates all of the specified observable sequences, as long as the previous observable sequence terminated successfully.
    * @param args (Array | arguments): Observable sequences or Promises to concatenate.
    * @return (Observable): An observable sequence that contains the elements of each given sequence, in sequential order.
    * @example Rx.Observable.concat(...args)
    */
  def concat[T](args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Creates an observable sequence from a specified subscribe method implementation. This is an alias for the
    * `createWithDisposable` method
    * @param subscribe (Function): Implementation of the resulting observable sequence's subscribe method,
    *                  optionally returning a function that will be wrapped in a disposable object. This could also
    *                  be a disposable object.
    * @return (Observable): The observable sequence with the specified implementation for the subscribe method.
    */
  def create[T](subscribe: js.Function0[T]): Observable[T] = js.native

  /**
    * Returns an observable sequence that invokes the specified factory function whenever a new observer subscribes.
    * @param observableFactory (Function): Observable factory function to invoke for each observer that subscribes to the resulting sequence.
    * @return (Observable): An observable sequence whose observers trigger an invocation of the given observable factory function.
    * @example Rx.Observable.defer(observableFactory)
    */
  def defer[T](observableFactory: js.Function0[T]): Observable[T] = js.native

  /**
    * Returns an empty observable sequence, using the specified scheduler to send out the single OnCompleted message.
    * @param scheduler [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to send the termination call on.
    * @return (Observable): An observable sequence with no elements.
    * @example Rx.Observable.empty([scheduler])
    */
  def empty[T](scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Concatenates the observable sequences or Promises obtained by running the specified result selector for each
    * element in source. There is an alias for this method called forIn for browsers < IE9
    * @param sources        (Array): An array of values to turn into an observable sequence.
    * @param resultSelector (Function): A function to apply to each item in the sources array to turn it into an
    *                       observable sequence. The resultSelector is called with the following information:
    *                       <ul>
    *                       <li>the value of the element</li>
    *                       <li>the index of the element</li>
    *                       <li>the Observable object being subscribed</li>
    *                       </ul>
    * @param thisArg        (Any): Object to use as this when executing resultSelector.
    * @return (Observable): An observable sequence from the concatenated observable sequences or Promises.
    * @example Rx.Observable.for(sources, resultSelector, [thisArg])
    */
  def `for`[T](sources: js.Array[Observable[T]], resultSelector: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Runs all observable sequences in parallel and collect their last elements.
    * @param args           (Arguments | Array): An array or arguments of Observable sequences or Promises to collect
    *                       the last elements for.
    * @param resultSelector (Function): The result selector from all the values produced. If not specified, forkJoin
    *                       will return the results as an array.
    * @return (Observable): An observable sequence with an array collecting the last elements of all the input sequences
    *         or the result of the result selector if specified.
    * @example Rx.Observable.forkJoin(...args, [resultSelector])
    */
  def forkJoin[T](args: js.Array[Observable[T]], resultSelector: js.Function): Observable[T] = js.native

  /**
    * Runs all observable sequences in parallel and collect their last elements.
    * @param args (Arguments | Array): An array or arguments of Observable sequences or Promises to collect
    *             the last elements for.
    * @return (Observable): An observable sequence with an array collecting the last elements of all the input sequences
    *         or the result of the result selector if specified.
    * @example Rx.Observable.forkJoin(...args, [resultSelector])
    */
  def forkJoin[T](args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * This method creates a new Observable sequence from an array-like or iterable object.
    * @param iterable  (Array | Arguments | Iterable): An array-like or iterable object to convert to an Observable sequence.
    * @param mapFn     (Function): Map function to call on every element of the array.
    * @param thisArg   (Any): The context to use calling the mapFn if provided.
    * @param scheduler [scheduler=Rx.Scheduler.currentThread] (Scheduler): Scheduler to run the enumeration of the input sequence on.
    * @return (Observable): The observable sequence whose elements are pulled from the given iterable sequence.
    * @example Rx.Observable.from(iterable, [mapFn], [thisArg], [scheduler])
    */
  def from[T](iterable: js.Array[Observable[T]] | sjs.Iterator[Observable[T]], mapFn: js.Function = js.native, thisArg: js.Any = js.native, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Converts an array to an observable sequence, using an optional scheduler to enumerate the array.
    * @param array     (Array): An array to convert to an Observable sequence.
    * @param scheduler [scheduler=Rx.Scheduler.currentThread] (Scheduler): Scheduler to run the enumeration of the input sequence on.
    * @return (Observable): The observable sequence whose elements are pulled from the given enumerable sequence.
    * @example Rx.Observable.fromArray(array, [scheduler])
    */
  @deprecated("Use Rx.Observable.from instead", "4.0")
  def fromArray[T](array: js.Array[Observable[T]], scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Converts a callback function to an observable sequence.
    * @param func     (Function): Function with a callback as the last parameter to convert to an Observable sequence.
    * @param context  (Any): The context for the func parameter to be executed. If not specified, defaults to undefined.
    * @param selector (Function): A selector which takes the arguments from the callback to produce a single item to yield on next.
    * @return (Function): A function, when executed with the required parameters minus the callback, produces an
    *         Observable sequence with a single value of the arguments to the callback as an array if no selector
    *         given, else the object created by the selector function.
    * @example Rx.Observable.fromCallback(func, [context], [selector])
    */
  def fromCallback[T](func: js.Function, context: js.Any = js.native, selector: js.Function = js.native): Observable[T] = js.native

  /**
    * Creates an observable sequence by adding an event listener to the matching DOMElement, jQuery element,
    * Zepto Element, Angular element, Ember.js element or EventEmitter.
    *
    * Note that this uses the library approaches for jQuery, Zepto, Backbone.Marionette, AngularJS and Ember.js and
    * falls back to native binding if not present. If you are using AMD you may need to include these libraries as
    * dependencies of RxJs in your requirejs configuration file. RxJs will attempt to detect their presence when
    * deciding which library to use.
    * @param element   (Any): The DOMElement, NodeList, jQuery element, Zepto Element, Angular element, Ember.js element
    *                  or EventEmitter to attach a listener. For Backbone.Marionette this would be the application or an
    *                  EventAggregator object.
    * @param eventName (String): The event name to attach the observable sequence.
    * @param selector  (Function): A selector which takes the arguments from the event emitter so that you can return a single object.
    * @param options   (Object): An object of event listener options.
    * @return (Observable): An observable sequence of events from the specified element and the specified event.
    * @example Rx.Observable.fromEvent(element, eventName, [selector], [options])
    */
  def fromEvent(element: js.Any, eventName: String, selector: js.Function = js.native, options: ListenerOptions = js.native): Observable[dom.Event] = js.native

  /**
    * Creates an observable sequence by using the addHandler and removeHandler functions to add and remove the handlers,
    * with an optional selector function to project the event arguments.
    * @param addHandler    (Function): The DOMElement, NodeList or EventEmitter to attach a listener.
    * @param removeHandler (Function): The optional function to remove a handler from an emitter.
    * @param selector      (Function): A selector which takes the arguments from the event handler to produce a single item to yield on next.
    * @return (Observable): An observable sequence of events from the specified element and the specified event.
    * @example Rx.Observable.fromEventPattern(addHandler, [removeHandler], [selector])
    */
  def fromEventPattern[T](addHandler: js.Function, removeHandler: js.Function = js.native, selector: js.Function = js.native): Observable[T] = js.native

  /**
    * Converts a Node.js callback style function to an observable sequence. This must be in function (err, ...) format.
    * @param func     (Function): Function with a callback as the last parameter to convert to an Observable sequence.
    * @param context  (Any): The context for the func parameter to be executed. If not specified, defaults to undefined.
    * @param selector (Function): A selector which takes the arguments from callback sans the error to produce a single
    *                 item to yield on next.
    * @return (Function): A function which when applied, returns an observable sequence with the callback arguments as
    *         an array if no selector given, else the object created by the selector function on success, or an error
    *         if the first parameter is not falsy.
    * @example Rx.Observable.fromNodeCallback(func, [context], [selector])
    */
  def fromNodeCallback[T](func: js.Function, context: js.Any = js.native, selector: js.Function = js.native): Observable[T] = js.native

  /**
    * Converts a Promises/A+ spec compliant Promise and/or ES2015 compliant Promise or a factory function which returns
    * said Promise to an Observable sequence.
    * @param promise (Promise|Function): Promises/A+ spec compliant Promise to an Observable sequence or a function
    *                which returns a Promise.
    * @return (Observable): An Observable sequence which wraps the existing promise success and failure.
    */
  def fromPromise[T](promise: js.Promise[T] | js.Function): Observable[T] = js.native

  /**
    * Generates an observable sequence in a manner similar to a for loop, using an optional scheduler to enumerate the values.
    * @param initialState   (Any): Initial state.
    * @param condition      (Function): Condition to terminate generation (upon returning false).
    * @param iterate        (Function): Iteration step function.
    * @param resultSelector (Function): Selector function for results produced in the sequence.
    * @param scheduler      [scheduler=Rx.Scheduler.currentThread] (Scheduler): Scheduler on which to run the generator loop.
    *                       If not provided, defaults to Scheduler.currentThread.
    * @return (Observable): The generated sequence.
    * @example Rx.Observable.generate(initialState, condition, iterate, resultSelector, [scheduler])
    */
  def generate[T](initialState: T, condition: js.Function, iterate: js.Function, resultSelector: js.Function, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Generates an observable sequence by iterating a state from an initial state until the condition fails.
    * @param initialState   (Any): Initial state.
    * @param condition      (Function): Condition to terminate generation (upon returning false).
    * @param iterate        (Function): Iteration step function.
    * @param resultSelector (Function): Selector function for results produced in the sequence.
    * @param timeSelector   (Function): Time selector function to control the speed of values being produced each
    *                       iteration, returning Date values.
    * @param scheduler      [scheduler=Rx.Scheduler.timeout] (Scheduler): Scheduler on which to run the generator loop.
    *                       If not provided, defaults to Scheduler.timeout.
    * @return (Observable): The generated sequence.
    * @example Rx.Observable.generateWithAbsoluteTime(initialState, condition, iterate, resultSelector, timeSelector, [scheduler])
    */
  def generateWithAbsoluteTime[T](initialState: T, condition: js.Function, iterate: js.Function, resultSelector: js.Function, timeSelector: js.Function, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Generates an observable sequence by iterating a state from an initial state until the condition fails.
    * @param initialState   (Any): Initial state.
    * @param condition      (Function): Condition to terminate generation (upon returning false).
    * @param iterate        (Function): Iteration step function.
    * @param resultSelector (Function): Selector function for results produced in the sequence.
    * @param timeSelector   (Function): Time selector function to control the speed of values being produced each
    *                       iteration, returning integer values denoting milliseconds.
    * @param scheduler      [scheduler=Rx.Scheduler.timeout] (Scheduler): Scheduler on which to run the generator loop.
    *                       If not provided, defaults to Scheduler.timeout.
    * @return (Observable): The generated sequence.
    */
  def generateWithRelativeTime[T](initialState: T, condition: js.Function, iterate: js.Function, resultSelector: js.Function, timeSelector: js.Function, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Determines whether an observable collection contains values. There is an alias for this method called
    * ifThen for browsers < IE9
    * @param condition  (Function): The condition which determines if the thenSource or elseSource will be run.
    * @param thenSource (Observable): thenSource The observable sequence that will be run if the condition function returns true.
    * @param elseSource (Observable|Scheduler): The observable sequence that will be run if the condition function
    *                   returns false. If this is not provided, it defaults to Rx.Observabe.Empty with the specified scheduler.
    * @return (Observable): The generated sequence.
    * @example Rx.Observable.if(condition, thenSource, [elseSource])
    */
  def `if`[T](condition: js.Function, thenSource: Observable[T], elseSource: Observable[T] | Scheduler = js.native): Observable[T] = js.native

  /**
    * Determines whether an observable collection contains values. There is an alias for this method called
    * ifThen for browsers < IE9
    * @param condition  (Function): The condition which determines if the thenSource or elseSource will be run.
    * @param thenSource (Observable): thenSource The observable sequence that will be run if the condition function returns true.
    * @param elseSource (Observable|Scheduler): The observable sequence that will be run if the condition function
    *                   returns false. If this is not provided, it defaults to Rx.Observabe.Empty with the specified scheduler.
    * @return (Observable): The generated sequence.
    * @example Rx.Observable.ifThen(condition, thenSource, [elseSource])
    */
  @deprecated("Use Rx.Observable.if instead", since = "4.0")
  def ifThen[T](condition: js.Function, thenSource: Observable[T], elseSource: Observable[T] | Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that produces a value after each period.
    * @param period    (Number): Period for producing the values in the resulting sequence
    *                  (specified as an integer denoting milliseconds).
    * @param scheduler Scheduler=Rx.Scheduler.timeout): Scheduler to run the timer on. If not specified,
    *                  Rx.Scheduler.timeout is used.
    * @return (Observable): An observable sequence that produces a value after each period. Each value produced
    *         will default to a Number denoting its order in the timeline. (e.g. 0, 1, 2...)
    * @example Rx.Observable.interval(period, [scheduler])
    */
  def interval[T](period: Period, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that contains a single element, using the specified scheduler to send out observer messages.
    *
    * There is an alias called returnValue for browsers < IE9 and a regular alias called just.
    * @param value     (Any): Single element in the resulting observable sequence.
    * @param scheduler [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to send the single element on.
    *                  If not specified, defaults to Scheduler.immediate.
    * @return (Observable): An observable sequence with the single element.
    * @example Rx.Observable.just(value, [scheduler])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/return.md]]
    */
  def just[T](value: T, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Merges all the observable sequences and Promises into a single observable sequence.
    * @param scheduler (Scheduler=Rx.Scheduler.immediate): Scheduler to run the timer on. If not specified, Rx.Scheduler.immediate is used.
    * @param args      (Array|arguments): Observable sequences to merge into a single sequence.
    * @return (Observable): An observable sequence that produces a value after each period.
    * @example Rx.Observable.merge([scheduler], ...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/merge.md]]
    */
  def merge[T](scheduler: Scheduler, args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Merges all the observable sequences and Promises into a single observable sequence.
    * @param args (Array|arguments): Observable sequences to merge into a single sequence.
    * @return (Observable): An observable sequence that produces a value after each period.
    * @example Rx.Observable.merge([scheduler], ...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/merge.md]]
    */
  def merge[T](args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Flattens an Observable that emits Observables into one Observable, in a way that allows an Observer to receive all
    * successfully emitted items from all of the source Observables without being interrupted by an error notification
    * from one of them.
    *
    * This behaves like Observable.prototype.mergeAll except that if any of the merged Observables notify of an error
    * via the Observer's onError, mergeDelayError will refrain from propagating that error notification until all of
    * the merged Observables have finished emitting items.
    * @param args (Array|arguments): Arguments or an array of Observable sequences to merge.
    * @return (Observable): An Observable that emits all of the items emitted by the Observables emitted by the Observable
    * @example Rx.Observable.mergeDelayError(...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/mergedelayerror.md]]
    */
  def mergeDelayError[T](args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Returns a non-terminating observable sequence, which can be used to denote an infinite duration (e.g. when using reactive joins).
    * @return (Observable): An observable sequence whose observers will never get called.
    * @example Rx.Observable.never()
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/never.md]]
    */
  def never[T](): Observable[T] = js.native

  /**
    * Converts arguments to an observable sequence.
    * @param args (Arguments): A list of arguments to turn into an Observable sequence.
    * @return (Observable): The observable sequence whose elements are pulled from the given arguments.
    * @example Rx.Observable.of(...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/of.md]]
    */
  def of[T](args: js.Array[T]): Observable[T] = js.native

  /**
    * Converts arguments to an observable sequence.
    * @param args (Arguments): A list of arguments to turn into an Observable sequence.
    * @return (Observable): The observable sequence whose elements are pulled from the given arguments.
    * @example Rx.Observable.of(...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/of.md]]
    */
  def of[T](args: T*): Observable[T] = js.native

  /**
    * Converts arguments to an observable sequence, using an optional scheduler to enumerate the arguments.
    * @param scheduler (Scheduler): An optional scheduler used to enumerate the arguments.
    * @param args      (Arguments): A list of arguments to turn into an Observable sequence.
    * @return (Observable): The observable sequence whose elements are pulled from the given arguments.
    * @example Rx.Observable.ofWithScheduler([scheduler], ...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/ofwithscheduler.md]]
    */
  def ofWithScheduler[T](scheduler: Scheduler, args: js.Array[js.Any] | js.Any*): Observable[T] = js.native

  /**
    * Converts arguments to an observable sequence, using an optional scheduler to enumerate the arguments.
    * @param args (Arguments): A list of arguments to turn into an Observable sequence.
    * @return (Observable): The observable sequence whose elements are pulled from the given arguments.
    * @example Rx.Observable.ofWithScheduler([scheduler], ...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/ofwithscheduler.md]]
    */
  def ofWithScheduler[T](args: js.Array[js.Any] | js.Any*): Observable[T] = js.native

  /**
    * Continues an observable sequence that is terminated normally or by an exception with the next observable sequence or Promise.
    * @param args (Array|arguments): Observable sequences to concatenate.
    * @return (Observable): An observable sequence that concatenates the source sequences, even if a sequence terminates exceptionally.
    * @example Rx.Observable.onErrorResumeNext(...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/onerrorresumenext.md]]
    */
  def onErrorResumeNext[T](args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Convert an object into an observable sequence of [key, value] pairs using an optional Scheduler to enumerate the object.
    * @param obj       (Object): The object to inspect and turn into an Observable sequence.
    * @param scheduler (Scheduler): Scheduler to run the enumeration of the input sequence on.
    *                  If not specified, defaults to Rx.Scheduler.currentThread
    * @return (Observable): An observable sequence of [key, value] pairs from the object.
    * @example Rx.Observable.pairs(obj, [scheduler])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/pairs.md]]
    */
  def pairs[T](obj: js.Any, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Generates an observable sequence of integral numbers within a specified range, using the specified scheduler to
    * send out observer messages.
    * @param start     (Number): The value of the first integer in the sequence.
    * @param count     (Number): The number of sequential integers to generate.
    * @param scheduler [scheduler=Rx.Scheduler.currentThread] (Scheduler): Scheduler to run the generator loop on.
    *                  If not specified, defaults to Scheduler.currentThread.
    * @return (Observable): An observable sequence that contains a range of sequential integral numbers.
    * @example Rx.Observable.range(start, count, [scheduler])
    */
  def range(start: Int, count: Int, scheduler: Scheduler = js.native): RangeObservable[Int] = js.native

  /**
    * Generates an observable sequence that repeats the given element the specified number of times, using the specified scheduler to send out observer messages.
    * @param value       (Any): Element to repeat.
    * @param repeatCount [repeatCount=-1] (Number):Number of times to repeat the element. If not specified, repeats indefinitely.
    * @param scheduler   [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to run the producer loop on. If not
    *                    specified, defaults to Scheduler.immediate.
    * @return (Observable): An observable sequence that repeats the given element the specified number of times.
    * @example Rx.Observable.repeat(value, [repeatCount], [scheduler])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/repeat.md]]
    */
  def repeat[T](value: T, repeatCount: Int = -1, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that contains a single element, using the specified scheduler to send out observer messages.
    *
    * There is an alias called returnValue for browsers < IE9 and a regular alias called just.
    * @param value     (Any): Single element in the resulting observable sequence.
    * @param scheduler [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to send the single element on.
    *                  If not specified, defaults to Scheduler.immediate.
    * @return (Observable): An observable sequence with the single element.
    * @example Rx.Observable.return(value, [scheduler])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/return.md]]
    */
  def `return`[T](value: T, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that produces a value after dueTime has elapsed and then after each period.
    * <b>Note</b> for rx.lite.js, only relative time is supported.
    * @param dueTime   (Date|Number): Absolute (specified as a Date object) or relative time (specified as an integer
    *                  denoting milliseconds) at which to produce the first value.
    * @param period    [period|scheduler=Rx.Scheduler.timeout] (Number|Scheduler): Period to produce subsequent values
    *                  (specified as an integer denoting milliseconds), or the scheduler to run the timer on. If not
    *                  specified, the resulting timer is not recurring.
    * @param scheduler [scheduler=Rx.Scheduler.timeout] (Scheduler): Scheduler to run the timer on. If not specified,
    *                  the timeout scheduler is used.
    * @return (Observable): An observable sequence that produces a value after due time has elapsed and then each period.
    * @example Rx.Observable.timer(dueTime, [period], [scheduler])
    */
  def timer[T](dueTime: RelativeTime | js.Date, period: Period | Scheduler = js.native, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Converts the function into an asynchronous function. Each invocation of the resulting asynchronous function causes
    * an invocation of the original synchronous function on the specified scheduler.
    * @param func      (Function): Function to convert to an asynchronous function.
    * @param context   (Any): The context for the func parameter to be executed. If not specified, defaults to undefined.
    * @param scheduler [scheduler=Rx.Scheduler.timeout] (Scheduler): Scheduler to run the function on. If not specified,
    *                  defaults to Scheduler.timeout.
    * @return (Function): Asynchronous function.
    * @example Rx.Observable.toAsync(func, [context], [scheduler])
    */
  def toAsync(func: js.Function, context: js.Any = js.native, scheduler: Scheduler = js.native): js.Function = js.native

  /**
    * Returns an observable sequence that terminates with an exception, using the specified scheduler to send out the single onError message.
    * @param exception the given exception
    * @param scheduler [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to send the exceptional termination
    *                  call on. If not specified, defaults to the immediate scheduler.
    * @return (Observable): The observable sequence that terminates exceptionally with the specified exception object.
    * @example Rx.Observable.throw(exception, [scheduler])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/throw.md]]
    */
  def `throw`[T](exception: js.Error, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that terminates with an exception, using the specified scheduler to send out the single onError message.
    * @param exception the given exception
    * @param scheduler [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to send the exceptional termination
    *                  call on. If not specified, defaults to the immediate scheduler.
    * @return (Observable): The observable sequence that terminates exceptionally with the specified exception object.
    * @example Rx.Observable.throwError(exception, [scheduler])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/throw.md]]
    */
  def throwError[T](exception: js.Error, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that terminates with an exception, using the specified scheduler to send out the single onError message.
    * @param exception the given exception
    * @param scheduler [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to send the exceptional termination
    *                  call on. If not specified, defaults to the immediate scheduler.
    * @return (Observable): The observable sequence that terminates exceptionally with the specified exception object.
    * @example Rx.Observable.throwException(exception, [scheduler])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/throw.md]]
    */
  @deprecated("Use RX.Observable.throwError instead", "4.0")
  def throwException[T](exception: js.Error, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Merges the specified observable sequences or Promises into one observable sequence by using the selector function
    * whenever all of the observable sequences or an array have produced an element at a corresponding index.
    * @param args           (Arguments | Array): Arguments or an array of observable sequences.
    * @param resultSelector (Function): A function which takes the inputs at the specified index and combines them together.
    *                       If omitted, a list with the elements of the observable sequences at corresponding indexes will be yielded.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the
    *         specified result selector function.
    * @example Rx.Observable.prototype.zip(...args, [resultSelector])
    */
  def zip[T](args: js.Array[Observer], resultSelector: js.Function = js.native): Observable[T] = js.native

  /**
    * Merges the specified observable sequences or Promises into one observable sequence by using the selector function
    * whenever all of the observable sequences or an array have produced an element at a corresponding index.
    * @param args (Arguments | Array): Arguments or an array of observable sequences.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the
    *         specified result selector function.
    * @example Rx.Observable.prototype.zip(...args, [resultSelector])
    */
  def zip[T](args: js.Array[Observer] | Observable[T]*): Observable[T] = js.native

}

package org.scalajs.rx

import org.scalajs.sjs

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.runtime._

/**
  * Represents an RxJs observable
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Observable[T] extends js.Object {

  /**
    * Determines whether all elements of an observable sequence satisfy a condition.
    * @param predicate (Function): A function to test each element for a condition.
    * @param thisArg   (Function): Object to use as this when executing callback.
    * @return An observable sequence containing a single element determining whether all elements in the source
    *         sequence pass the test in the specified predicate.
    * @see [[Observable.every()]]
    * @example Rx.Observable.prototype.every(predicate, [thisArg])
    */
  def all(predicate: js.Function, thisArg: js.Function = js.native): Observable[T] = js.native

  /**
    * Propagates the observable sequence that reacts first.
    * @param rightSource (Observable): Second observable sequence.
    * @return An observable sequence that surfaces either of the given sequences, whichever reacted first.
    * @example Rx.Observable.prototype.amb(rightSource)
    */
  def amb(rightSource: Observable[T]): Observable[T] = js.native

  /**
    * Propagates the observable sequence that reacts first.
    * @param rightSource (Observable): Observable sequence to match with the current sequence.
    * @return (Pattern): Pattern object that matches when both observable sequences have an available value.
    * @example Rx.Observable.prototype.and(rightSource)
    */
  def and(rightSource: Observable[T]): Pattern[T] = js.native

  /**
    * Determines whether any element of an observable sequence satisfies a condition if present, else if any items are in the sequence.
    * @param predicate (Function): A function to test each element for a condition.
    * @param thisArg   (Any): Object to use as this when executing callback.
    * @return (Observable): An observable sequence containing a single element determining whether one of the elements
    *         in the source sequence pass the test in the specified predicate.
    * @see [[Observable.some()]]
    * @example Rx.Observable.prototype.any([predicate], [thisArg])
    */
  def any(predicate: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Hides the identity of an observable sequence.
    * @return (Observable): An observable sequence that hides the identity of the source sequence.
    * @example Rx.Observable.asObservable()
    */
  def asObservable(): Observable[T] = js.native

  /**
    * Computes the average of an observable sequence of values that are in the sequence or obtained by invoking a
    * transform function on each element of the input sequence if present.
    * @param selector (Function): A transform function to apply to each element.
    * @param thisArg  (Any): Object to use as this when executing selector.
    * @return (Observable): An observable sequence containing a single element with the average of the sequence of values.
    * @example Rx.Observable.prototype.average([selector], [thisArg])
    */
  def average(selector: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * The buffer method periodically gathers items emitted by a source Observable into buffers, and emits these buffers
    * as its own emissions.
    *
    * Note that if the source Observable issues an onError notification, buffer will pass on this notification immediately
    * without first emitting the buffer it is in the process of assembling, even if that buffer contains items that were
    * emitted by the source Observable before it issued the error notification.
    * @return (Observable): An observable sequence of windows.
    * @example Rx.Observable.prototype.buffer([bufferClosingSelector])
    */
  def buffer(bufferClosingSelector: js.Function = js.native): Observable[T] = js.native

  /**
    * Projects each element of an observable sequence into zero or more buffers which are produced based on element count information.
    * @param count (Function): Length of each buffer.
    * @param skip  (Function): Number of elements to skip between creation of consecutive buffers. If not provided, defaults to the count.
    * @return (Observable): An observable sequence of buffers.
    * @example Rx.Observable.prototype.bufferWithCount(count, [skip])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/bufferwithcount.md]]
    */
  def bufferWithCount(count: js.Function, skip: js.Function = js.native): Observable[T] = js.native

  /**
    * Continues an observable sequence that is terminated by an exception with the next observable sequence.
    * @param args (Array | arguments): Observable sequences to catch exceptions for.
    * @return (Observable): An observable sequence containing elements from consecutive source sequences until a source sequence terminates successfully.
    * @example Rx.Observable.catch(...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/catch.md]]
    */
  def `catch`(args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Merges the specified observable sequences into one observable sequence by using the selector function whenever any
    * of the observable sequences produces an element. This can be in the form of an argument list of observables or an
    * array. If the result selector is omitted, a list with the elements will be yielded.
    * @param args           (arguments | Array): An array or arguments of Observable sequences.
    * @param resultSelector (Function): Function to invoke whenever either of the sources produces an element.
    *                       If omitted, a list with the elements will be yielded.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    * @example Rx.Observable.combineLatest(...args, [resultSelector])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/combinelatest.md]]
    */
  def combineLatest(args: js.Array[Observable[T]], resultSelector: js.Function = js.native): Observable[T] = js.native

  /**
    * Merges the specified observable sequences into one observable sequence by using the selector function whenever any
    * of the observable sequences produces an element. This can be in the form of an argument list of observables or an
    * array. If the result selector is omitted, a list with the elements will be yielded.
    * @param args (arguments | Array): An array or arguments of Observable sequences.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    * @example Rx.Observable.combineLatest(...args, [resultSelector])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/combinelatest.md]]
    */
  def combineLatest(args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Concatenates all the observable sequences. This takes in either an array or variable arguments to concatenate.
    * @param args (arguments | Array): An array or arguments of Observable sequences.
    * @return (Observable): An observable sequence that contains the elements of each given sequence, in sequential order.
    * @example Rx.Observable.prototype.concat(...args)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/concatproto.md]]
    */
  def concat(args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Concatenates a sequence of observable sequences or promises into a single observable sequence.
    * @return (Observable): The observable sequence that merges the elements of the inner sequences.
    * @example Rx.Observable.prototype.concatAll()
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/concatall.md]]
    */
  def concatAll(): Observable[T] = js.native

  /**
    * Concatenates a sequence of observable sequences or promises into a single observable sequence.
    * @return (Observable): The observable sequence that merges the elements of the inner sequences.
    * @example Rx.Observable.prototype.concatObservable()
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/concatall.md]]
    */
  @deprecated("Use concatAll()", since = "4.0")
  def concatObservable(): Observable[T] = js.native

  /**
    * This is an alias for the selectConcat method. This can be one of the following:
    *
    * Projects each element of an observable sequence to an observable sequence and concatenates the resulting observable
    * sequences or Promises or array/iterable into one observable sequence.
    * {{{
    *   source.concatMap(function (x, i) { return Rx.Observable.range(0, x); });
    *   source.concatMap(function (x, i) { return Promise.resolve(x + 1); });
    *   source.concatMap(function (x, i) { return [x, i]; });
    * }}}
    *
    * Projects each element of an observable sequence or Promise to an observable sequence, invokes the result selector
    * for the source element and each of the corresponding inner sequence's elements, and concatenates the results into
    * one observable sequence.
    * {{{
    *   source.concatMap(function (x, i) { return Rx.Observable.range(0, x); }, function (x, y, ix, iy) { return x + y + ix + iy; });
    *   source.concatMap(function (x, i) { return Promise.resolve(x + i); }, function (x, y, ix, iy) { return x + y + ix + iy; });
    *   source.concatMap(function (x, i) { return [x, i];  }, function (x, y, ix, iy) { return x + y + ix + iy; });
    * }}}
    *
    * Projects each element of the source observable sequence to the other observable sequence or Promise or
    * array/iterable and merges the resulting observable sequences into one observable sequence.
    * {{{
    *   source.concatMap(Rx.Observable.of(1,2,3));
    *   source.concatMap(Promise.resolve(42));
    *   source.concatMap([1,2,3]);
    * }}}
    * @param selector       (Function | Iterable | Promise): An Object to project to the sequence or a transform function to
    *                       apply to each element or an observable sequence to project each element from the source sequence onto.
    *                       The selector is called with the following information:
    *                       <ul>
    *                       <li>the value of the element</li>
    *                       <li>the index of the element</li>
    *                       <li>the Observable object being subscribed</li>
    *                       </ul>
    * @param resultSelector [resultSelector] (Function): A transform function to apply to each element of the intermediate
    *                       sequence. The resultSelector is called with the following information:
    *                       <ul>
    *                       <li>the value of the outer element</li>
    *                       <li>the value of the inner element</li>
    *                       <li>the index of the outer element</li>
    *                       <li>the index of the inner element</li>
    *                       </ul>
    * @param thisArg        (Any): If resultSelector is not Function, Object to use as this when executing selector.
    * @return (Observable): An observable sequence whose elements are the result of invoking the one-to-many transform
    *         function collectionSelector on each element of the input sequence and then mapping each of those sequence
    *         elements and their corresponding source element to a result element.
    * @example Rx.Observable.prototype.concatMap(selector, [resultSelector], [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/concatmap.md]]
    */
  def concatMap(selector: js.Function | sjs.Iterator[_] | js.Promise[_], resultSelector: js.Function = js.native, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Returns the elements of the specified sequence or the specified value in a singleton sequence if the sequence is empty.
    * @param defaultValue [defaultValue=null] (Any): The value to return if the sequence is empty. If not provided, this defaults to null.
    * @return (Observable): An observable sequence that contains the specified default value if the source is empty;
    *         otherwise, the elements of the source itself.
    * @example Rx.Observable.prototype.defaultIfEmpty([defaultValue])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/defaultifempty.md]]
    */
  def defaultIfEmpty(defaultValue: js.Any = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that contains only distinct elements according to the keySelector and the comparer.
    * Usage of this operator should be considered carefully due to the maintenance of an internal lookup structure which
    * can grow large.
    * @param keySelector (Function): A function to compute the comparison key for each element.
    * @param comparer    (Function): Used to compare objects for equality. If not provided, defaults to an equality comparer function.
    * @return (Observable): An observable sequence only containing the distinct elements, based on a computed key value,
    *         from the source sequence.
    * @example Rx.Observable.prototype.distinct([keySelector], [comparer])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/distinct.md]]
    */
  def distinct(keySelector: js.Function = js.native, comparer: js.Function = js.native): Observable[T] = js.native

  /**
    * Returns an observable sequence that contains only distinct contiguous elements according to the keySelector and the comparer.
    * @param keySelector (Function): A function to compute the comparison key for each element. If not provided, it projects the value.
    * @param comparer    (Function): Equality comparer for computed key values. If not provided, defaults to an equality comparer function.
    * @return (Observable): An observable sequence only containing the distinct contiguous elements, based on a computed key value, from the source sequence.
    * @example Rx.Observable.prototype.distinctUntilChanged([keySelector], [comparer])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/distinctuntilchanged.md]]
    */
  def distinctUntilChanged(keySelector: js.Function = js.native, comparer: js.Function = js.native): Observable[T] = js.native

  /**
    * Invokes an action for each element in the observable sequence and invokes an action upon graceful or exceptional
    * termination of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    *
    * There is an alias to this method doAction for browsers < IE9 and tap as well.
    * @param observer    (Observer): An observer to invoke for each element in the observable sequence.
    * @param onNext      (Function): Function to invoke for each element in the observable sequence.
    * @param onError     (Function): Function to invoke upon exceptional termination of the observable sequence. Used if only the first parameter is also a function.
    * @param onCompleted (Function): Function to invoke upon graceful termination of the observable sequence. Used if only the first parameter is also a function.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.do([observer] | [onNext], [onError], [onCompleted])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/do.md]]
    */
  def `do`(observer: Observer = null, onNext: js.Function = null, onError: js.Function = null, onCompleted: js.Function = null): Observable[T] = js.native

  /**
    * Invokes an action upon graceful termination of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    * @param onCompleted (Function): Function to invoke upon graceful termination of the observable sequence.
    * @param thisArg     (Any): Object to use as this when executing callback.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.doOnCompleted(onCompleted, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/dooncompleted.md]]
    */
  def doOnCompleted(onCompleted: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Invokes an action upon exceptional termination of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    * @param onError (Function): Function to invoke upon exceptional termination of the observable sequence.
    * @param thisArg (Any): Object to use as this when executing callback.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.doOnError(onError, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/doonerror.md]]
    */
  def doOnError(onError: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Invokes an action for each element of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    * @param onNext  (Function): Function to invoke for each element in the observable sequence.
    * @param thisArg (Any): Object to use as this when executing callback.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.doOnNext(onNext, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/doonnext.md]]
    */
  def doOnNext(onNext: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Determines whether all elements of an observable sequence satisfy a condition.
    * @param predicate (Function): A function to test each element for a condition.
    * @param thisArg   (Function): Object to use as this when executing callback.
    * @return An observable sequence containing a single element determining whether all elements in the source
    *         sequence pass the test in the specified predicate.
    * @example Rx.Observable.prototype.every(predicate, [thisArg])
    */
  def every(predicate: js.Function, thisArg: js.Function = js.native): Observable[T] = js.native

  /**
    * Filters the elements of an observable sequence based on a predicate.
    * @param predicate predicate (Function): A function to test each source element for a condition.
    *                  The callback is called with the following information:
    *                  <ul>
    *                  <li>the value of the element</li>
    *                  <li>the index of the element</li>
    *                  <li>the Observable object being subscribed</li>
    *                  </ul>
    * @param thisArg   (Any): Object to use as this when executing the predicate.
    * @return An observable sequence that contains elements from the input sequence that satisfy the condition.
    * @example Rx.Observable.prototype.filter(predicate, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/where.md]]
    */
  def filter(predicate: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Invokes a specified action after the source observable sequence terminates gracefully or exceptionally.
    * There is an alias called finallyAction for browsers < IE9
    * @param action (Function): A function to invoke after the source observable sequence terminates.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.finally(action)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/finally.md]]
    */
  def `finally`(action: js.Function): Observable[T] = js.native

  /**
    * Aliases: Rx.Observable.prototype.flatMap and Rx.Observable.prototype.selectMany are equivalent.
    * @param selector       selector (Function | Iterable | Promise): An Object to project to the sequence or a transform
    *                       function to apply to each element or an observable sequence to project each element from the source
    *                       sequence onto. The selector is called with the following information:
    *                       <ul>
    *                       <li>the value of the element</li>
    *                       <li>the index of the element</li>
    *                       <li>the Observable object being subscribed</li>
    *                       </ul>
    * @param resultSelector (Function): A transform function to apply to each element of the intermediate sequence.
    *                       The resultSelector is called with the following information:
    *                       <ul>
    *                       <li>the value of the outer element</li>
    *                       <li>the value of the inner element</li>
    *                       <li>the index of the outer element</li>
    *                       <li>the index of the inner element</li>
    *                       </ul>
    * @return An observable sequence whose elements are the result of invoking the one-to-many transform function
    *         collectionSelector on each element of the input sequence and then mapping each of those sequence elements
    *         and their corresponding source element to a result element.
    * @example Rx.Observable.prototype.flatMap(selector, [resultSelector])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/selectmany.md]]
    */
  def flatMap[A, B](selector: js.Function, resultSelector: js.Function4[A, A, Int, Int, B] = js.native): Observable[B] = js.native

  /**
    * Transform the items emitted by an Observable into Observables, and mirror those items emitted by the most-recently
    * transformed Observable.
    *
    * The flatMapLatest operator is similar to the flatMap and concatMap methods described above, however, rather than
    * emitting all of the items emitted by all of the Observables that the operator generates by transforming items from
    * the source Observable, flatMapLatest instead emits items from each such transformed Observable only until the next
    * such Observable is emitted, then it ignores the previous one and begins emitting items emitted by the new one.
    * @param selector (Function): A transform function to apply to each source element. The callback has the following information:
    *                 <ul>
    *                 <li>the value of the element</li>
    *                 <li>the index of the element</li>
    *                 <li>the Observable object being subscribed</li>
    *                 </ul>
    * @param thisArg  (Any): Object to use as this when executing the predicate.
    * @return (Observable): An observable sequence which transforms the items emitted by an Observable into Observables,
    *         and mirror those items emitted by the most-recently transformed Observable.
    * @example Rx.Observable.prototype.flatMapLatest(selector, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/flatmaplatest.md]]
    */
  def flatMapLatest(selector: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Projects each notification of an observable sequence to an observable sequence and merges the resulting observable sequences into one observable sequence.
    * @param onNext      (Function): A transform function to apply to each element. The selector is called with the following information:
    *                    <ul>
    *                    <li>the value of the element</li>
    *                    <li>the index of the element</li>
    *                    </ul>
    * @param onError     (Function): A transform function to apply when an error occurs in the source sequence.
    * @param onCompleted (Function): A transform function to apply when the end of the source sequence is reached.
    * @param thisArg     (Any): Object to use as this when executing the transform functions.
    * @return (Observable): An observable sequence whose elements are the result of invoking the one-to-many transform
    *         function corresponding to each notification in the input sequence.
    * @example Rx.Observable.prototype.flatMapObserver(onNext, onError, onCompleted, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/flatmapobserver.md]]
    */
  def flatMapObserver(onNext: js.Function, onError: js.Function, onCompleted: js.Function, thisArg: js.Any): Observable[T] = js.native

  /**
    * Subscribes an observer to the observable sequence.
    * @param onNext      (Function | Observable): Function to invoke for each element in the observable sequence.
    * @param onError     (Function): Function to invoke upon exceptional termination of the observable sequence.
    * @param onCompleted (Function): Function to invoke upon graceful termination of the observable sequence.
    * @return (Disposable): The source sequence whose subscriptions and unsubscriptions happen on the specified scheduler.
    * @example Rx.Observable.prototype.forEach([observer] | [onNext], [onError], [onCompleted])
    */
  def forEach(onNext: js.Function | Observable[T], onError: js.Function = js.native, onCompleted: js.Function = js.native): Disposable = js.native

  /**
    * Runs all observable sequences in parallel and collect their last elements.
    * @param args           (Arguments | Array): An array or arguments of Observable sequences or Promises to collect
    *                       the last elements for.
    * @param resultSelector (Function): The result selector from all the values produced. If not specified, forkJoin
    *                       will return the results as an array.
    * @return (Observable): An observable sequence with an array collecting the last elements of all the input sequences
    *         or the result of the result selector if specified.
    */
  def forkJoin(args: js.Array[Observable[T]], resultSelector: js.Function): Observable[T] = js.native

  /**
    * Runs all observable sequences in parallel and collect their last elements.
    * @param args (Arguments | Array): An array or arguments of Observable sequences or Promises to collect the last elements for.
    * @return (Observable): An observable sequence with an array collecting the last elements of all the input sequences
    *         or the result of the result selector if specified.
    */
  def forkJoin(args: js.Array[Observable[T]] | Observable[T]*): Observable[T] = js.native

  /**
    * Ignores all elements in an observable sequence leaving only the termination messages.
    * @return (Observable): An empty observable sequence that signals termination, successful or exceptional, of the source sequence.
    * @example Rx.Observable.prototype.ignoreElements()
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/ignoreelements.md]]
    */
  def ignoreElements(): Observable[T] = js.native

  /**
    * Projects each element of an observable sequence into a new form by incorporating the element's index.
    * There is an alias for this method called map.
    * @param selector (Function | Object): Transform function to apply to each source element or an element to yield.
    *                 If selector is a function, it is called with the following information:
    * @param thisArg  (Any): Object to use as this when executing the predicate.
    * @return An observable sequence which results from the co-monadic bind operation.
    * @example Rx.Observable.prototype.map(selector, [thisArg])
    */
  def map[S](selector: js.Function | js.Any, thisArg: js.Any = null): Observable[S] = js.native

  /**
    * Merges an observable sequence of observable sequences into an observable sequence, limiting the number of concurrent
    * subscriptions to inner sequences. Or merges two observable sequences into a single observable sequence.
    * @param maxConcurrent (Number): Maximum number of inner observable sequences being subscribed to concurrently.
    * @return (Observable): The observable sequence that merges the elements of the inner sequences.
    * @example Rx.Observable.prototype.merge(maxConcurrent | other)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/mergeproto.md]]
    */
  def merge(maxConcurrent: Int): Observable[T] = js.native

  /**
    * Merges an observable sequence of observable sequences into an observable sequence, limiting the number of concurrent
    * subscriptions to inner sequences. Or merges two observable sequences into a single observable sequence.
    * @param other (Observable): The second observable sequence to merge into the first.
    * @return (Observable): The observable sequence that merges the elements of the inner sequences.
    * @example Rx.Observable.prototype.merge(maxConcurrent | other)
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/mergeproto.md]]
    */
  def merge(other: Observable[T]): Observable[T] = js.native

  /**
    * Merges an observable sequence of observable sequences into an observable sequence.
    * @return (Observable): The observable sequence that merges the elements of the inner sequences.
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/mergeall.md]]
    */
  def mergeAll(): T = js.native

  /**
    * Merges an observable sequence of observable sequences into an observable sequence.
    * @return (Observable): The observable sequence that merges the elements of the inner sequences.
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/mergeall.md]]
    */
  @deprecated("Use Rx.Observable.mergeAll() instead", "4.0")
  def mergeObservable(): T = js.native

  /**
    * Returns two observables which partition the observations of the source by the given function. The first will
    * trigger observations for those values for which the predicate returns true. The second will trigger observations
    * for those values where the predicate returns false. The predicate is executed once for each subscribed observer.
    * Both also propagate all error observations arising from the source and each completes when the source completes.
    * @param predicate (Function): Selector function to invoke for each produced element, resulting in another sequence
    *                  to which the selector will be invoked recursively again. The callback is called with the following
    *                  information:
    *                  <ul>
    *                  <li>the value of the element</li>
    *                  <li>the index of the element</li>
    *                  <li>the Observable object being subscribed</li>
    *                  </ul>
    * @param thisArg   (Any): Object to use as this when executing the predicate.
    * @return (Array): An array of observables. The first triggers when the predicate returns true, and the second
    *         triggers when the predicate returns false.
    * @example Rx.Observable.prototype.partition(predicate, [thisArg])
    */
  def partition(predicate: js.Function, thisArg: js.Any = js.native): js.Array[Observable[T]] = js.native

  /**
    * Pauses the underlying observable sequence based upon the observable sequence which yields true/false.
    * Note that this only works on hot observables.
    * @param pauser (Observable): The observable sequence used to pause the underlying sequence.
    * @return (Observable): The observable sequence which is paused based upon the pauser.
    * @example Rx.Observable.prototype.pausable(pauser)
    */
  def pausable(pauser: Observable[T]): Observable[T] = js.native

  /**
    * Pauses the underlying observable sequence based upon the observable sequence which yields true/false, and yields
    * the values that were buffered while paused. Note that this only works on hot observables.
    * @param pauser (Observable): The observable sequence used to pause the underlying sequence.
    * @return (Observable): The observable sequence which is paused based upon the pauser.
    * @example Rx.Observable.prototype.pausableBuffered(pauser)
    */
  def pausableBuffered(pauser: Observable[T]): Observable[T] = js.native

  /**
    * Returns an Observable containing the value of a specified nested property from all elements in the Observable
    * sequence. If a property can't be resolved, it will return undefined for that value.
    * @param property (String): The property or properties to pluck. pluck accepts an unlimited number of nested property parameters.
    * @return (Observable): Returns a new Observable sequence of property values.
    * @example Rx.Observable.prototype.pluck(property)
    */
  def pluck(property: String): Observable[T] = js.native

  /**
    * Returns an observable sequence that is the result of invoking the selector on a connectable observable sequence
    * that shares a single subscription to the underlying sequence.
    * @param selector (Function): Selector function which can use the multicasted source sequence as many times as needed,
    *                 without causing multiple subscriptions to the source sequence. Subscribers to the given source will
    *                 receive all notifications of the source from the time of the subscription on.
    * @return (ConnectableObservable): An observable sequence that contains the elements of a sequence produced by multicasting the source sequence
    *         within a selector function.
    * @example Rx.Observable.prototype.publish([selector])
    */
  def publish(selector: js.Function = js.native): ConnectableObservable[T] = js.native

  /**
    * Applies an accumulator function over an observable sequence, returning the result of the aggregation as a single
    * element in the result sequence. The specified seed value is used as the initial accumulator value.
    *
    * For aggregation behavior with incremental intermediate results, see the scan method.
    * @param accumulator (Function): An accumulator function to be invoked on each element with the following arguments:
    *                    <ul>
    *                    <li>acc: Any - the accumulated value.</li>
    *                    <li>currentValue: Any - the current value</li>
    *                    <li>index: Number - the current index</li>
    *                    <li>source: Observable - the current observable instance</li>
    *                    </ul>
    * @param seed        (Any): The initial accumulator value.
    * @return An observable sequence containing a single element with the final accumulator value.
    * @example Rx.Observable.prototype.reduce(accumulator, [seed])
    */
  def reduce(accumulator: js.Function, seed: js.Any = js.native): Observable[T] = js.native

  /**
    * Generates an observable sequence that repeats the given element the specified number of times, using the specified
    * scheduler to send out observer messages.
    * @param value       (Any): Element to repeat.
    * @param repeatCount (Number):Number of times to repeat the element. If not specified, repeats indefinitely.
    * @param scheduler   [scheduler=Rx.Scheduler.immediate] (Scheduler): Scheduler to run the producer loop on. If not
    *                    specified, defaults to Scheduler.immediate.
    * @return (Observable): An observable sequence that repeats the given element the specified number of times.
    * @example Rx.Observable.repeat(value, [repeatCount], [scheduler])
    */
  def repeat(value: js.Any, repeatCount: Int = js.native, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Applies an accumulator function over an observable sequence and returns each intermediate result.
    * The optional seed value is used as the initial accumulator value.
    * @param accumulator accumulator (Function): An accumulator function to be invoked on each element with the following arguments:
    *                    <ul>
    *                    <li>acc: Any - the accumulated value.</li>
    *                    <li>currentValue: Any - the current value</li>
    *                    <li>index: Number - the current index</li>
    *                    <li>source: Observable - the current observable instance</li>
    *                    </ul>
    * @param seed        (Any): The initial accumulator value.
    * @return An observable sequence which results from the comonadic bind operation.
    * @example Rx.Observable.prototype.scan(accumulator, [seed])
    */
  def scan(accumulator: js.Function, seed: js.Any = js.native): Observable[T] = js.native

  /**
    * Projects each element of an observable sequence into a new form by incorporating the element's index.
    * There is an alias for this method called map.
    * @param selector (Function | Object): Transform function to apply to each source element or an element to yield.
    *                 If selector is a function, it is called with the following information:
    *                 <ul>
    *                 <li>the value of the element</li>
    *                 <li>the index of the element</li>
    *                 <li>the Observable object being subscribed</li>
    *                 </ul>
    * @param thisArg  (Any): Object to use as this when executing the predicate.
    * @return An observable sequence which results from the co-monadic bind operation.
    * @example Rx.Observable.prototype.select(selector, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/select.md]]
    */
  def select(selector: js.Function | js.Any, thisArg: js.Function = js.native): Observable[T] = js.native

  /**
    * This is an alias for the selectConcat method. This can be one of the following:
    *
    * Projects each element of an observable sequence to an observable sequence and concatenates the resulting observable
    * sequences or Promises or array/iterable into one observable sequence.
    * {{{
    *   source.concatMap(function (x, i) { return Rx.Observable.range(0, x); });
    *   source.concatMap(function (x, i) { return Promise.resolve(x + 1); });
    *   source.concatMap(function (x, i) { return [x, i]; });
    * }}}
    *
    * Projects each element of an observable sequence or Promise to an observable sequence, invokes the result selector
    * for the source element and each of the corresponding inner sequence's elements, and concatenates the results into
    * one observable sequence.
    * {{{
    *   source.concatMap(function (x, i) { return Rx.Observable.range(0, x); }, function (x, y, ix, iy) { return x + y + ix + iy; });
    *   source.concatMap(function (x, i) { return Promise.resolve(x + i); }, function (x, y, ix, iy) { return x + y + ix + iy; });
    *   source.concatMap(function (x, i) { return [x, i];  }, function (x, y, ix, iy) { return x + y + ix + iy; });
    * }}}
    *
    * Projects each element of the source observable sequence to the other observable sequence or Promise or
    * array/iterable and merges the resulting observable sequences into one observable sequence.
    * {{{
    *   source.concatMap(Rx.Observable.of(1,2,3));
    *   source.concatMap(Promise.resolve(42));
    *   source.concatMap([1,2,3]);
    * }}}
    * @param selector       (Function | Iterable | Promise): An Object to project to the sequence or a transform function to
    *                       apply to each element or an observable sequence to project each element from the source sequence onto.
    *                       The selector is called with the following information:
    *                       <ul>
    *                       <li>the value of the element</li>
    *                       <li>the index of the element</li>
    *                       <li>the Observable object being subscribed</li>
    *                       </ul>
    * @param resultSelector [resultSelector] (Function): A transform function to apply to each element of the intermediate
    *                       sequence. The resultSelector is called with the following information:
    *                       <ul>
    *                       <li>the value of the outer element</li>
    *                       <li>the value of the inner element</li>
    *                       <li>the index of the outer element</li>
    *                       <li>the index of the inner element</li>
    *                       </ul>
    * @param thisArg        (Any): If resultSelector is not Function, Object to use as this when executing selector.
    * @return (Observable): An observable sequence whose elements are the result of invoking the one-to-many transform
    *         function collectionSelector on each element of the input sequence and then mapping each of those sequence
    *         elements and their corresponding source element to a result element.
    * @example Rx.Observable.prototype.selectConcat(selector, [resultSelector], [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/concatmap.md]]
    */
  def selectConcat(selector: js.Function | sjs.Iterator[_] | js.Promise[_], resultSelector: js.Function = js.native, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Aliases: Rx.Observable.prototype.flatMap and Rx.Observable.prototype.selectMany are equivalent.
    * @param selector       selector (Function | Iterable | Promise): An Object to project to the sequence or a transform
    *                       function to apply to each element or an observable sequence to project each element from the source
    *                       sequence onto. The selector is called with the following information:
    *                       <ul>
    *                       <li>the value of the element</li>
    *                       <li>the index of the element</li>
    *                       <li>the Observable object being subscribed</li>
    *                       </ul>
    * @param resultSelector (Function): A transform function to apply to each element of the intermediate sequence.
    *                       The resultSelector is called with the following information:
    *                       <ul>
    *                       <li>the value of the outer element</li>
    *                       <li>the value of the inner element</li>
    *                       <li>the index of the outer element</li>
    *                       <li>the index of the inner element</li>
    *                       </ul>
    * @return An observable sequence whose elements are the result of invoking the one-to-many transform function
    *         collectionSelector on each element of the input sequence and then mapping each of those sequence elements
    *         and their corresponding source element to a result element.
    * @example Rx.Observable.prototype.selectMany(selector, [resultSelector])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/selectmany.md]]
    */
  def selectMany(selector: js.Function, resultSelector: js.Any = js.native): Observable[T] = js.native

  /**
    * Projects each notification of an observable sequence to an observable sequence and merges the resulting observable sequences into one observable sequence.
    * @param onNext      (Function): A transform function to apply to each element. The selector is called with the following information:
    *                    <ul>
    *                    <li>the value of the element</li>
    *                    <li>the index of the element</li>
    *                    </ul>
    * @param onError     (Function): A transform function to apply when an error occurs in the source sequence.
    * @param onCompleted (Function): A transform function to apply when the end of the source sequence is reached.
    * @param thisArg     (Any): Object to use as this when executing the transform functions.
    * @return (Observable): An observable sequence whose elements are the result of invoking the one-to-many transform
    *         function corresponding to each notification in the input sequence.
    * @example Rx.Observable.prototype.selectManyObserver(onNext, onError, onCompleted, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/flatmapobserver.md]]
    */
  def selectManyObserver(onNext: js.Function, onError: js.Function, onCompleted: js.Function, thisArg: js.Any): Observable[T] = js.native

  /**
    * Returns a single element of an observable sequence that satisfies the condition in the predicate, or a default
    * value if no such element exists. If no default value is given, then onError will be called. If there are more than
    * one element that matches, then onError will be called.
    * @param predicate    (Function): A predicate function to evaluate for elements in the source sequence. The callback is
    *                     called with the following information:
    *                     i. the value of the element
    *                     ii. the index of the element
    *                     iii. the Observable object being subscribed
    * @param thisArg      (Any): Object to use as this when executing the predicate.
    * @param defaultValue (Any): Default value if no such element exists.
    * @return (Observable): An observable sequence that contains elements from the input sequence that satisfy the condition.
    * @example Rx.Observable.prototype.single([predicate], [thisArg], [defaultValue])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/single.md]]
    */
  def single(predicate: js.Function = js.native, thisArg: js.Any = js.native, defaultValue: T = js.native): Observable[T] = js.native

  /**
    * Returns a single element of an observable sequence that satisfies the condition in the predicate, or a default
    * value if no such element exists. If no default value is given, then onError will be called. If there are more than
    * one element that matches, then onError will be called.
    * @param settings   (Object): An object with the following fields:
    *                  1. [predicate] (Function): A predicate function to evaluate for elements in the source sequence.
    *                   The callback is called with the following information:
    *                   i. the value of the element
    *                   ii. the index of the element
    *                   iii. the Observable object being subscribed
    *                  2. [thisArg] (Any): Object to use as this when executing the predicate.
    *                  3. [defaultValue] (Any): Default value if no such element exists.
    * @return (Observable): An observable sequence that contains elements from the input sequence that satisfy the condition.
    * @example Rx.Observable.prototype.single([settings])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/single.md]]
    */
  def single(settings: SingleSettings): Observable[T] = js.native

  /**
    * Bypasses a specified number of elements in an observable sequence and then returns the remaining elements.
    * @param count (Number): The number of elements to skip before returning the remaining elements.
    * @return (Observable): An observable sequence that contains the elements that occur after the specified index in the input sequence.
    * @example Rx.Observable.prototype.skip(count)
    */
  def skip(count: Int): Observable[T] = js.native

  /**
    * The slice method returns a shallow copy of a portion of an Observable into a new Observable object. Unlike the
    * Array version, this does not support negative numbers for being or end.
    * @param begin (Any): Zero-based index at which to begin extraction. If omitted, this will default to zero.
    * @param end   (Number): Zero-based index at which to end extraction. slice extracts up to but not including end.
    * @return (Observable): A shallow copy of a portion of an Observable into a new Observable object.
    * @example Rx.Observable.prototype.slice([begin], [end])
    */
  def slice(begin: Int = 0, end: Int = js.native): Observable[T] = js.native

  /**
    * Determines whether any element of an observable sequence satisfies a condition if present, else if any items are in the sequence.
    * @param predicate (Function): A function to test each element for a condition.
    * @param thisArg   (Any): Object to use as this when executing callback.
    * @return (Observable): An observable sequence containing a single element determining whether one of the elements
    *         in the source sequence pass the test in the specified predicate.
    * @example Rx.Observable.prototype.some([predicate], [thisArg])
    */
  def some(predicate: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Subscribes an observer to the observable sequence.
    * @param onNext      (Observer/Function): The object that is to receive notifications.
    * @param onError     (Function): Function to invoke upon exceptional termination of the observable sequence.
    * @param onCompleted (Function): Function to invoke upon graceful termination of the observable sequence.
    * @return (Disposable): The source sequence whose subscriptions and unsubscriptions happen on the specified scheduler.
    * @example Rx.Observable.prototype.subscribe([observer] | [onNext], [onError], [onCompleted])
    */
  def subscribe(onNext: js.Function | Observable[T] = js.native, onError: js.Function = js.native, onCompleted: js.Function = js.native): Disposable = js.native

  /**
    * Returns a specified number of contiguous elements from the start of an observable sequence, using the specified
    * scheduler for the edge case of take(0).
    * @param count     (Number): The number of elements to return.
    * @param scheduler (Scheduler): Scheduler used to produce an onCompleted message in case count is set to 0.
    * @return (Observable): An observable sequence that contains the elements before and including the specified index
    *         in the input sequence.
    * @example Rx.Observable.prototype.take(count, [scheduler])
    */
  def take(count: Int, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns a specified number of contiguous elements from the end of an observable sequence, using an optional
    * scheduler to drain the queue.
    * *
    * This operator accumulates a buffer with a length enough to store elements count elements. Upon completion of the
    * source sequence, this buffer is drained on the result sequence. This causes the elements to be delayed.
    * @param count (Number): Number of elements to bypass at the end of the source sequence.
    * @return (Observable): An observable sequence containing the source sequence elements except for the bypassed ones at the end.
    * @example Rx.Observable.prototype.takeLast(count)
    */
  def takeLast(count: Int): Observable[T] = js.native

  /**
    * Returns an array with the specified number of contiguous elements from the end of an observable sequence.
    * @param count (Number): Number of elements to bypass at the end of the source sequence.
    * @return (Observable): An observable sequence containing a single array with the specified number of elements from
    *         the end of the source sequence.
    * @example Rx.Observable.prototype.takeLastBuffer(count)
    */
  def takeLastBuffer(count: Int): Observable[T] = js.native

  /**
    * Returns an array with the elements within the specified duration from the end of the observable source sequence,
    * using the specified scheduler to run timers.
    *
    * This operator accumulates a queue with a length enough to store elements received during the initial duration
    * window. As more elements are received, elements older than the specified duration are taken from the queue and
    * produced on the result sequence. This causes elements to be delayed with duration.
    * @param duration  (Number): Duration for taking elements from the end of the sequence.
    * @param scheduler [scheduler=Rx.Scheduler.timeout] (Scheduler): Scheduler to run the timer on. If not specified,
    *                  defaults to timeout scheduler.
    * @return (Observable): An observable sequence containing a single array with the elements taken during the
    *         specified duration from the end of the source sequence.
    * @example Rx.Observable.prototype.takeLastBufferWithTime(duration, [scheduler])
    */
  def takeLastBufferWithTime(duration: Int, scheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns elements within the specified duration from the end of the observable source sequence, using the specified
    * schedulers to run timers and to drain the collected elements.
    * @param duration      (Number): Duration for taking elements from the end of the sequence.
    * @param timeScheduler [timeScheduler=Rx.Scheduler.timeout] (Scheduler): Scheduler to run the timer on. If not
    *                      specified, defaults to timeout scheduler.
    * @param loopScheduler [loopScheduler=Rx.Scheduler.currentThread] (Scheduler): Scheduler to drain the collected
    *                      elements. If not specified, defaults to current thread scheduler.
    * @return (Observable): An observable sequence with the elements taken during the specified duration from the end
    *         of the source sequence.
    * @example Rx.Observable.prototype.takeLastWithTime(duration, [timeScheduler], [loopScheduler])
    */
  def takeLastWithTime(duration: Int, timeScheduler: Scheduler, loopScheduler: Scheduler = js.native): Observable[T] = js.native

  /**
    * Returns the values from the source observable sequence until the other observable sequence or Promise produces a value.
    * @param other (Observable | Promise): Observable sequence or Promise that terminates propagation of elements of
    *              the source sequence.
    * @return (Observable): An observable sequence containing the elements of the source sequence up to the point the
    *         other sequence or Promise interrupted further propagation.
    * @example Rx.Observable.prototype.takeUntil([other])
    */
  def takeUntil(other: Observable[T] | js.Promise[T]): Observable[T] = js.native

  /**
    * Returns elements from an observable sequence as long as a specified condition is true.
    * @param predicate (Function): A function to test each source element for a condition. The callback is called with
    *                  the following information:
    *                  <ul>
    *                  <li>the value of the element</li>
    *                  <li>the index of the element</li>
    *                  <li>the Observable object being subscribed.</li>
    *                  </ul>
    * @param thisArg   (Any): Object to use as this when executing callback.
    * @return (Observable): An observable sequence that contains the elements from the input sequence that occur before
    *         the element at which the test no longer passes.
    * @example Rx.Observable.prototype.takeWhile(predicate, [thisArg])
    */
  def takeWhile(predicate: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Invokes an action for each element in the observable sequence and invokes an action upon graceful or exceptional
    * termination of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    *
    * There is an alias to this method doAction for browsers < IE9 and tap as well.
    * @param observer    (Observer): An observer to invoke for each element in the observable sequence.
    * @param onNext      (Function): Function to invoke for each element in the observable sequence.
    * @param onError     (Function): Function to invoke upon exceptional termination of the observable sequence. Used if only the first parameter is also a function.
    * @param onCompleted (Function): Function to invoke upon graceful termination of the observable sequence. Used if only the first parameter is also a function.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.tap([observer] | [onNext], [onError], [onCompleted])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/do.md]]
    */
  def tap(observer: Observer = null, onNext: js.Function = null, onError: js.Function = null, onCompleted: js.Function = null): Observable[T] = js.native

  /**
    * Invokes an action upon graceful termination of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    * @param onCompleted (Function): Function to invoke upon graceful termination of the observable sequence.
    * @param thisArg     (Any): Object to use as this when executing callback.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.tapOnCompleted(onCompleted, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/dooncompleted.md]]
    */
  def tapOnCompleted(onCompleted: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Invokes an action upon exceptional termination of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    * @param onError (Function): Function to invoke upon exceptional termination of the observable sequence.
    * @param thisArg (Any): Object to use as this when executing callback.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.tapOnError(onError, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/doonerror.md]]
    */
  def tapOnError(onError: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Invokes an action for each element of the observable sequence.
    *
    * This method can be used for debugging, logging, etc. of query behavior by intercepting the message stream to run
    * arbitrary actions for messages on the pipeline.
    * @param onNext  (Function): Function to invoke for each element in the observable sequence.
    * @param thisArg (Any): Object to use as this when executing callback.
    * @return (Observable): The source sequence with the side-effecting behavior applied.
    * @example Rx.Observable.prototype.tapOnNext(onNext, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/doonnext.md]]
    */
  def tapOnNext(onNext: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Executes a transducer to transform the observable sequence.
    *
    * Transducers are composable algorithmic transformations. They are independent from the context of their input and
    * output sources and specify only the essence of the transformation in terms of an individual element. Because
    * transducers are decoupled from input or output sources, they can be used in many different processes such as
    * Observable sequences. Transducers compose directly, without awareness of input or creation of intermediate aggregates.
    *
    * Such examples of transducers libraries are transducers-js from Cognitect and transducers.js from James Long.
    * @param transducer (Transducer): A transducer to execute.
    * @return (Observable): An observable sequence that results from the transducer execution.
    */
  def transduce(transducer: Transducer | js.Function): Observable[T] = js.native

  /**
    * Creates a list from an observable sequence.
    * @return (Observable): An observable sequence containing a single element with a list containing all the elements
    *         of the source sequence.
    * @example Rx.Observable.prototype.toArray()
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/toarray.md]]
    */
  def toArray(): Observable[js.Array[T]] = js.native

  /**
    * Filters the elements of an observable sequence based on a predicate.
    * @param predicate predicate (Function): A function to test each source element for a condition.
    *                  The callback is called with the following information:
    *                  <ul>
    *                  <li>the value of the element</li>
    *                  <li>the index of the element</li>
    *                  <li>the Observable object being subscribed</li>
    *                  </ul>
    * @param thisArg   (Any): Object to use as this when executing the predicate.
    * @return An observable sequence that contains elements from the input sequence that satisfy the condition.
    * @example Rx.Observable.prototype.where(predicate, [thisArg])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/where.md]]
    */
  def where(predicate: js.Function, thisArg: js.Any = js.native): Observable[T] = js.native

  /**
    * Projects each element of an observable sequence into zero or more windows which are produced based on element count information.
    * @param count (Number): Length of each buffer.
    * @param skip  (Number): Number of elements to skip between creation of consecutive windows. If not provided, defaults to the count.
    * @return (Observable): An observable sequence of windows.
    * @example Rx.Observable.prototype.windowWithCount(count, [skip])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/windowwithcount.md]]
    */
  def windowWithCount(count: Int, skip: Int = js.native): Observable[T] = js.native

  /**
    * Merges the specified observable sequences into one observable sequence by using the selector function only when
    * the source observable sequence (the instance) produces an element. The other observables can be in the form of an
    * argument list of observables or an array. If the result selector is omitted, a list with the elements will be yielded.
    * @param args           (arguments | Array): An array or arguments of Observable sequences.
    * @param resultSelector (Function): Function to invoke when the instance source observable produces an element.
    *                       If omitted, a list with the elements will be yielded.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the
    *         specified result selector function.
    * @example Rx.Observable.prototype.withLatestFrom(...args, [resultSelector])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/withlatestfrom.md]]
    */
  def withLatestFrom(args: js.Array[Observable[T]], resultSelector: js.Function = js.native): Observable[T] = js.native

  /**
    * Merges the specified observable sequences into one observable sequence by using the selector function only when
    * the source observable sequence (the instance) produces an element. The other observables can be in the form of an
    * argument list of observables or an array. If the result selector is omitted, a list with the elements will be yielded.
    * @param args (arguments | Array): An array or arguments of Observable sequences.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the
    *         specified result selector function.
    * @example Rx.Observable.prototype.withLatestFrom(...args, [resultSelector])
    * @see [[https://github.com/Reactive-Extensions/RxJS/blob/master/doc/api/core/operators/withlatestfrom.md]]
    */
  def withLatestFrom(args: Observable[T]*): Observable[T] = js.native

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
  def zip(args: js.Array[Observer], resultSelector: js.Function = js.native): Observable[T] = js.native

  /**
    * Merges the specified observable sequences or Promises into one observable sequence by using the selector function
    * whenever all of the observable sequences or an array have produced an element at a corresponding index.
    * @param args (Arguments | Array): Arguments or an array of observable sequences.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the
    *         specified result selector function.
    * @example Rx.Observable.prototype.zip(...args, [resultSelector])
    */
  def zip(args: js.Any*): Observable[T] = js.native

  /**
    * Merges the current observable sequence with iterables such as Map, Array, Set into one observable sequence by
    * using the selector function whenever all of the observable sequences or an array have produced an element at a
    * corresponding index.
    * @param args           (Arguments): Arguments of Arrays, Maps, Sets or other iterables.
    * @param resultSelector (Function): A function which takes the inputs at the specified index and combines them
    *                       together. If omitted, a list with the elements of the observable sequences at corresponding
    *                       indexes will be yielded.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the
    *         specified result selector function. If omitted, a list with the elements of the observable sequences at
    *         corresponding indexes will be yielded.
    * @example Rx.Observable.prototype.zipIterable(...args, [resultSelector])
    */
  def zipIterable(args: js.Array[Observer], resultSelector: js.Function = js.native): Observable[T] = js.native

  /**
    * Merges the current observable sequence with iterables such as Map, Array, Set into one observable sequence by
    * using the selector function whenever all of the observable sequences or an array have produced an element at a
    * corresponding index.
    * @param args (Arguments): Arguments of Arrays, Maps, Sets or other iterables.
    * @return (Observable): An observable sequence containing the result of combining elements of the sources using the
    *         specified result selector function. If omitted, a list with the elements of the observable sequences at
    *         corresponding indexes will be yielded.
    * @example Rx.Observable.prototype.zipIterable(...args, [resultSelector])
    */
  def zipIterable(args: js.Any*): Observable[T] = js.native

}

/**
  * RX::Observable Companion
  * @author lawrence.daniels@gmail.com
  */
object Observable {

  /**
    * Observable Extensions
    * @param observable the given [[Observable observable]]
    */
  implicit class ObservableExtensions[A](val observable: Observable[A]) extends AnyVal {

    /**
      * Drains the observable and returns the contents as a promised array
      * @return the promised array
      */
    @inline
    def drainFuture: Promise[js.Array[A]] = {
      val promise = Promise[js.Array[A]]()
      val list = js.Array[A]()
      val subscription = observable.forEachWith(
        onNext = { value => list.push(value) },
        onError = { err => promise.failure(wrapJavaScriptException(err)) },
        onCompleted = { () => promise.success(list) }
      )
      subscription.dispose()
      promise
    }

    /**
      * @see [[Observable.filter()]]
      */
    @inline
    def filterWith(predicate: A => Boolean) = observable.filter(predicate: js.Function)

    /**
      * @see [[Observable.filter()]]
      */
    @inline
    def filterWith(predicate: (A, Int) => Boolean) = observable.filter(predicate: js.Function)

    /**
      * @see [[Observable.filter()]]
      */
    @inline
    def filterWith(predicate: (A, Int, Observable[A]) => Boolean, thisArg: js.Any) = observable.filter(predicate: js.Function, thisArg)

    /**
      * @see [[Observable.flatMap()]]
      */
    @inline
    def flatMapWith[B](selector: A => B) = observable.flatMap(selector: js.Function)

    /**
      * @see [[Observable.flatMap()]]
      */
    @inline
    def flatMapWith[B](selector: (A, Int) => B) = observable.flatMap(selector: js.Function)

    /**
      * @see [[Observable.flatMap()]]
      */
    @inline
    def flatMapWith[B, C](selector: (A, Int, Observable[A]) => B, resultSelector: (A, A, Int, Int) => C = null) = {
      observable.flatMap(selector: js.Function, resultSelector: js.Function4[A, A, Int, Int, C])
    }

    /**
      * @see [[Observable.forEach()]]
      */
    @inline
    def forEachWith(onNext: A => Any, onError: js.Error => Any = null, onCompleted: () => Any = null) = {
      observable.forEach(onNext = onNext: js.Function, onError = onError: js.Function, onCompleted = onCompleted: js.Function)
    }

    /**
      * @see [[Observable.map()]]
      */
    @inline
    def mapWith[B](selector: A => B) = observable.map[B](selector = selector: js.Function)

    /**
      * @see [[Observable.map()]]
      */
    @inline
    def mapWith[B](selector: (A, Int) => B) = observable.map[B](selector = selector: js.Function)

    /**
      * @see [[Observable.map()]]
      */
    @inline
    def mapWith[B](selector: (A, Int, Observable[A]) => B, thisArg: js.Any = null) = {
      observable.map[B](selector = selector: js.Function, thisArg)
    }

  }

}
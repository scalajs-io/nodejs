package io.scalajs.npm.transducers

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Transducers-Js
  * @see [[https://github.com/cognitect-labs/transducers-js]]
  * @see [[http://cognitect-labs.github.io/transducers-js/classes/transducers.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TransducersJs extends js.Object {

  /**
    * Given a transformer return a concatenating transformer
    * @param xf a [[ITransformer transformer]]
    * @return a concatenating [[ITransformer transformer]]
    * @see [[http://cognitect-labs.github.io/transducers-js/classes/transducers.html#methods_transducers.cat]]
    */
  def cat(xf: ITransformer): ITransformer = js.native

  /**
    * Function composition. Take N function and return their composition.
    * @param args N functions
    * @return (Function): composition.
    */
  def comp(args: js.Function*): js.Function = js.native

  /**
    * Take a predicate function and return its complement.
    * @param predicate (Function): predicate function
    * @return (Function): the complement predicate function
    */
  def complement(predicate: js.Function): js.Function = js.native

  /**
    * A completing transducer constructor. Useful to provide cleanup logic at the end of a reduction/transduction.
    * @param xf (ITransformer): a transducer
    * @param cf (Function): a function to apply at the end of the reduction/transduction
    * @return (ITransformer): a transducer
    */
  def completing(xf: ITransformer, cf: js.Function): js.Function = js.native

  /**
    * A dropping transducer constructor
    * @param n an integer, the number of inputs to drop.
    * @return a dropping transducer
    */
  def drop(n: Int): Drop = js.native

  /**
    * A dropping transducer that drop inputs as long as pred is true.
    * @param predicate a predicate function
    * @return a dropWhile transducer
    */
  def dropWhile(predicate: js.Function): DropWhile = js.native

  /**
    * Ensure that a value is reduced. If already reduced will not re-wrap.
    * @param value any JavaScript value
    * @return a reduced value.
    */
  def ensureReduced(value: js.Any): IReduced = js.native

  /**
    * Filtering transducer constructor
    * @param predicate a predicate function
    * @return a filtering transducer
    */
  def filter(predicate: js.Function): Filter = js.native

  /**
    * A transformer which simply returns the first input.
    * @return a transducer transformer
    */
  def first(): ITransformer = js.native

  /**
    * Identity function.
    * @param value vany JavaScript value
    * @return a JavaScript value
    */
  def identity(value: js.Any): js.Any = js.native

  /**
    * Reduce a value into the given empty value using a transducer.
    * @param empty (String | Array | Object): a JavaScript collection
    * @param xf    a transducer
    * @param coll  (Object): any iterable JavaScript value: array, string, object, or iterable.
    * @return a JavaScript value.
    */
  def into(empty: String | js.Any, xf: ITransformer, coll: js.Any): js.Any = js.native

  /**
    * Check if a value is reduced.
    * @param value (Object): any JavaScript value
    * @return true if the value is an instance of transducers.Reduced false otherwise
    * @see [[http://cognitect-labs.github.io/transducers-js/classes/transducers.html#methods_transducers.isReduced]]
    */
  def isReduced(value: js.Any): Boolean = js.native

  /**
    * A keeping transducer. Keep inputs as long as the provided function does not return null or undefined.
    * @param f a function
    * @return a keep transducer
    */
  def keep(f: js.Function): Keep = js.native

  /**
    * Like keep but the provided function will be passed the index as the second argument.
    * @param f a function
    * @return a keep-indexed transducer
    */
  def keepIndexed(f: js.Function): KeepIndexed = js.native

  /**
    * Mapping transducer constructor
    * @param f a function
    * @return a mapping transducer
    */
  def map(f: js.Function): Map = js.native

  /**
    * A mapping concatenating transformer
    * @param f a function
    * @return a mapping concatenating transducer
    */
  def mapcat(f: js.Function): ITransformer = js.native

  /**
    * A partitioning transducer. Collects inputs into arrays of size N.
    * @param n an integer
    * @return a partitionAll transducer
    */
  def partitionAll(n: Int): PartitionAll = js.native

  /**
    * A partitioning transducer. Collects inputs into arrays as long as predicate remains true for contiguous inputs.
    * @param f a partition function. When the result for an input changes from the previous result will create a partition.
    * @return a partitionBy transducer
    */
  def partitionBy(f: js.Function): js.Any = js.native

  /**
    * Given a transformer returns a transformer which preserves reduced by wrapping one more time. See cat.
    * @param xf a transformer
    * @return a transformer which preserves reduced
    */
  def preservingReduced(xf: ITransformer): ITransformer = js.native

  /**
    * Given a transducer, an intial value and a collection - returns the reduction.
    * @param xf   (ITransformer | Function): a transducer or two-arity function
    * @param init (Object): any JavaScript value
    * @param coll (String | Array | Object): any iterable JavaScript value
    * @return (Object): an iterable JavaScript value: string, array iterable, or object.
    */
  def reduce(xf: ITransformer | js.Function, init: js.Any, coll: String | js.Any): ITransformer = js.native

  /**
    * Return a reduced value. Reduced values short circuit transduce.
    * @param value (Object): any JavaScript value
    * @return (IReduced): a reduced value
    */
  def reduced(value: js.Any): IReduced = js.native

  /**
    * Similar to filter except the predicate is used to eliminate values.
    * @param predicate (Function): a predicate function
    * @return (Filter): a removing transducer
    */
  def remove(predicate: js.Function): Filter = js.native

  /**
    * A take transducer constructor. Will take n values before returning a reduced result.
    * @param n the number of inputs to receive.
    * @return a take transducer
    */
  def take(n: Int): Take = js.native

  /**
    * A transducer that takes every Nth input
    * @param n an integer
    * @return a takeNth transducer
    */
  def takeNth(n: Int): TakeNth = js.native

  /**
    * Like the take transducer except takes as long as the pred return true for inputs.
    * @param predicate (Function): a predicate function
    * @return a takeWhile transducer
    */
  def takeWhile(predicate: js.Function): TakeWhile = js.native

  /**
    * Convert a transducer transformer object into a function so that it can be used with existing reduce implementation
    * i.e. native, Underscore, lodash
    * @param xf      a [[ITransformer transducer]]
    * @param builder a [[js.Function function]] which take the accumulator and the the next input and return a new accumulator value.
    * @return a two-arity function compatible with existing reduce implementations
    */
  def toFn(xf: ITransformer, builder: js.Function): js.Function = js.native

  /**
    * Given a transducer, a builder function, an initial value and a iterable collection - returns the reduction.
    * collection - returns the reduction.
    * @param xf   a transducer
    * @param f    (ITransformer | Function): a transducer or two-arity function
    * @param init any JavaScript value
    * @param coll (String | Array | Object): any iterable JavaScript value
    * @return a JavaScript value.
    */
  def transduce(xf: ITransformer, f: ITransformer | js.Function, init: js.Any, coll: String | js.Any): js.Any = js.native

  /**
    * Ensure a value is not reduced. Unwraps if reduced.
    * @param value any JavaScript value
    * @return a JavaScript value
    */
  def unreduced(value: js.Any): js.Any = js.native

  /**
    * Take a two-arity reducing function where the first argument is the accumluation and the second argument is the
    * next input and convert it into a transducer transformer object.
    * @param stepFn a two-arity reducing function
    * @return a transducer transformer object
    */
  def wrap(stepFn: js.Function): Wrap = js.native

}

/**
  * Transducers-Js Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("transducers-js", JSImport.Namespace)
object TransducersJs extends TransducersJs
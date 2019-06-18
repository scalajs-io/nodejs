package io.scalajs.npm.mongoose

import io.scalajs.RawOptions
import io.scalajs.npm.mongodb.Cursor

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Mongoose Aggregate
  * @see http://mongoosejs.com/docs/api.html#aggregate_Aggregate
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongoose", "Aggregate")
class Aggregate[T]() extends QueryExecutable[T] {

  /**
    * Aggregate constructor used for building aggregation pipelines.
    * @param ops aggregation operator(s) or operator array
    * @return a new [[Aggregate]] instance
    * @example new Aggregate();
    * @example new Aggregate({ $project: { a: 1, b: 1 } });
    * @example new Aggregate({ $project: { a: 1, b: 1 } }, { $skip: 5 });
    * @example new Aggregate([{ $project: { a: 1, b: 1 } }, { $skip: 5 }]);
    */
  def this(ops: js.Any) = this()

  /**
    * Adds a cursor flag
    * @param flag  the flag
    * @param value the value
    */
  def addCursorFlag(flag: String, value: Boolean): this.type = js.native

  /**
    * Sets the allowDiskUse option for the aggregation query (ignored for < 2.6.0)
    * @param value Should tell server it can use hard drive to store data during aggregation.
    * @param tags  optional tags for this query
    * @return
    */
  def allowDiskUse(value: Boolean, tags: js.Any): this.type = js.native

  /**
    * Appends new operators to this aggregate pipeline
    * @param ops the operator(s) to append
    */
  def append(ops: js.Any): this.type = js.native

  /**
    * Adds a collation
    * @param collation the collation options
    * @param value     the boolean indicator
    */
  def collation(collation: RawOptions, value: Boolean): this.type = js.native

  /**
    * Sets the cursor option option for the aggregation query (ignored for < 2.6.0).
    * Note the different syntax below: .exec() returns a cursor object, and no callback
    * is necessary.
    * @param options the set the cursor batch size
    * @return
    * @example {{{
    *   var cursor = Model.aggregate(..).cursor({ batchSize: 1000 }).exec();
    *     cursor.each(function(error, doc) {
    *     // use doc
    *   });
    * }}}
    */
  def cursor(options: RawOptions): AggregateCursor[T] = js.native

  /**
    * Execute the aggregation with explain
    * @param callback the callback
    * @return a promise of the results
    */
  def explain(callback: js.Function2[MongooseError, T, Any] = js.native): js.Promise[T] = js.native

  /**
    * Combines multiple aggregation pipelines.
    * @param facet the options
    */
  def facet(facet: RawOptions): this.type = js.native

  /**
    * Appends new custom $graphLookup operator(s) to this aggregate pipeline,
    * performing a recursive search on a collection.
    * <b>Note</b> that graphLookup can only consume at most 100MB of memory, and does not allow disk use
    * even if { allowDiskUse: true } is specified.
    * @param options to $graphLookup as described in the above link
    */
  def graphLookup(options: RawOptions): this.type = js.native

  /**
    * Appends a new custom $group operator to this aggregate pipeline.
    * @param arg the  $group operator contents
    */
  def group(arg: js.Any): this.type = js.native

  /**
    * Appends a new $limit operator to this aggregate pipeline.
    * @param num the maximum number of records to pass to the next stage
    */
  def limit(num: Int): this.type = js.native

  /**
    * Appends new custom $lookup operator(s) to this aggregate pipeline.
    * @param options to $lookup as described in the above link
    */
  def lookup(options: RawOptions): this.type = js.native

  /**
    * Appends a new custom $match operator to this aggregate pipeline.
    * @param arg the $match operator contents
    */
  def `match`(arg: js.Any): this.type = js.native

  /**
    * Binds this aggregate to a model.
    * @param model the model to which the aggregate is to be bound
    * @return the [[Aggregate]]
    */
  def model[A](model: MongooseModel[A]): this.type = js.native

  /**
    * Appends a new $geoNear operator to this aggregate pipeline.
    * <b>NOTE</b>: MUST be used as the first operator in the pipeline.
    * @param parameters the given parameters
    */
  def near(parameters: RawOptions): this.type = js.native

  /**
    * Appends a new $project operator to this aggregate pipeline.
    * @param arg the field specification
    * @return the [[Aggregate]]
    */
  def project(arg: String | js.Any): this.type = js.native

  /**
    * Sets the readPreference option for the aggregation query.
    * @param pref one of the listed preference options or their aliases
    * @param tags optional tags for this query
    * @return the [[Aggregate]]
    */
  def read(pref: String, tags: js.Any = js.native): this.type = js.native

  /**
    * Appepnds new custom $sample operator(s) to this aggregate pipeline.
    * @param size the  number of random documents to pick
    * @return the [[Aggregate]]
    */
  def sample(size: Int): this.type = js.native

  /**
    * Appends a new $skip operator to this aggregate pipeline.
    * @param num the  number of records to skip before next stage
    * @return the [[Aggregate]]
    */
  def skip(num: Int): this.type = js.native

  /**
    * Appends a new $sort operator to this aggregate pipeline.
    * @param arg the sorting arguments
    * @return the [[Aggregate]]
    * @example aggregate.sort({ field: 'asc', test: -1 });
    * @example aggregate.sort('field -test');
    */
  def sort(arg: String | js.Any): this.type = js.native

  /**
    * Provides promise for aggregate.
    * @param resolve the  success callback
    * @param reject  the error callback
    * @return a promise
    * @example Model.aggregate(..).then(successCallback, errorCallback);
    */
  def `then`(resolve: js.Function = js.native, reject: js.Function = js.native): js.Promise[T] = js.native

  /**
    * Appends new custom $unwind operator(s) to this aggregate pipeline.
    * <p/><b>Note</b> that the $unwind operator requires the path name to start with '$'.
    * Mongoose will prepend '$' if the specified field doesn't start '$'.
    * @param fields the field(s) to unwind
    * @return the [[Aggregate]]
    */
  def unwind(fields: String): this.type = js.native

}

/**
  * Aggregation Cursor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AggregateCursor[T] extends js.Object {

  def exec(): Cursor[T] = js.native

}
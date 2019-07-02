package io.scalajs.npm.mongoose

import io.scalajs.RawOptions
import io.scalajs.npm.mongodb.UpdateWriteResult
import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * Mongoose Model
  * @author lawrence.daniels@gmail.com
  */
@JSGlobal
@js.native
class MongooseModel[T](val doc: js.Any,
                       val fields: js.Array[String] = js.native,
                       val skipId: Boolean = js.native) extends js.Object {

  ///////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////

  /**
    * Additional properties to attach to the query when calling save() and isNew is false.
    */
  var $where: js.Any = js.native

  /**
    * Base Mongoose instance the model uses.
    */
  def base: String = js.native

  /**
    * If this is a discriminator model, baseModelName is the name of the base model.
    */
  def baseModelName: String = js.native

  /**
    * Collection the model uses.
    */
  def collection: js.Any = js.native

  /**
    * Connection the model uses.
    */
  def db: Connection = js.native

  /**
    * Registered discriminators for this model.
    */
  def discriminators: js.Any = js.native

  /**
    * The name of the model
    */
  def modelName: String = js.native

  /**
    * The [[Schema]] the model uses.
    */
  def schema: Schema[T] = js.native

  ///////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////

  /**
    * Performs aggregations on the models collection.
    * @param pipeline aggregation pipeline operator(s) or operator array
    * @return the [[Aggregate]]
    * @example aggregate([...], [callback])
    */
  def aggregate[A](pipeline: js.Any): Aggregate[A] = js.native

  /**
    * Performs aggregations on the models collection.
    * @param pipeline aggregation pipeline operator(s) or operator array
    * @param callback the callback
    * @example aggregate([...], [callback])
    */
  def aggregate[A](pipeline: js.Any, callback: MongooseCallback[A]): Unit = js.native

  /**
    * Counts number of matching documents in a database collection.
    * @param conditions the given query/conditions
    * @return the promise of the count
    * @example count(conditions, [callback])
    */
  def count(conditions: js.Any): js.Promise[Int] = js.native

  /**
    * Counts number of matching documents in a database collection.
    * @param conditions the given query/conditions
    * @param callback   the callback
    * @example count(conditions, [callback])
    */
  def count(conditions: js.Any, callback: js.Function2[MongooseError, Int, Any]): Unit = js.native

  /**
    * Shortcut for saving one or more documents to the database.
    * MyModel.create(docs) does new MyModel(doc).save() for every doc in docs.
    * @param doc a document to create
    * @return the created documents
    */
  def create(doc: T): js.Promise[T] = js.native

  /**
    * Shortcut for saving one or more documents to the database.
    * MyModel.create(docs) does new MyModel(doc).save() for every doc in docs.
    * @param docs an array of documents to create
    * @return the created documents
    */
  def create(docs: js.Array[T]): js.Promise[js.Array[T]] = js.native

  /**
    * Shortcut for saving one or more documents to the database.
    * MyModel.create(docs) does new MyModel(doc).save() for every doc in docs.
    * @param doc      a document or array of documents
    * @param callback the  callback
    */
  def create(doc: T, callback: js.Function2[MongooseError, T, Any]): Unit = js.native

  /**
    * Shortcut for saving one or more documents to the database.
    * MyModel.create(docs) does new MyModel(doc).save() for every doc in docs.
    * @param docs     a document or array of documents
    * @param callback the  callback
    */
  def create(docs: js.Array[T], callback: MongooseCallback[js.Array[T]]): Unit = js.native

  /**
    * Adds a discriminator type.
    * @param name   the discriminator model name
    * @param schema the discriminator model schema
    */
  def discriminator(name: String, schema: Schema[T]): Unit = js.native

  /**
    * Creates a Query for a distinct operation.
    * @param field      the field
    * @param conditions the optional condition
    * @return the resulting query
    */
  def distinct(field: String, conditions: js.Any = js.native): Query[js.Array[T]] = js.native

  /**
    * Creates a Query for a distinct operation.
    * @param field      the field
    * @param conditions the optional condition
    * @param callback   the callback
    */
  def distinct(field: String, conditions: js.Any, callback: MongooseCallback[js.Array[T]]): Unit = js.native

  /**
    * Creates a Query for a distinct operation.
    * @param field    the field
    * @param callback the callback
    */
  def distinct(field: String, callback: MongooseCallback[js.Array[T]]): Unit = js.native

  /**
    * Sends ensureIndex commands to mongo for each index declared in the schema.
    * @param options the internal options
    * @return a promise of the completion
    */
  def ensureIndexes(options: RawOptions): js.Promise[Unit] = js.native

  /**
    * Sends ensureIndex commands to mongo for each index declared in the schema.
    * @param options the internal options
    * @param calback the  optional callback
    */
  def ensureIndexes(options: RawOptions, calback: js.Function1[MongooseError, Any]): Unit = js.native

  /**
    * Finds documents
    * @param conditions the given conditions/query
    * @return a [[Query]]
    */
  def find(conditions: js.Any): Query[js.Array[Model[T]]] = js.native

  /**
    * Finds documents
    * @param conditions the given conditions/query
    * @param callback   the optional callback
    */
  def find(conditions: js.Any, callback: MongooseModelArrayCallback[T]): Unit = js.native

  /**
    * Finds a single document by its _id field. findById(id) is almost*
    * equivalent to findOne({ _id: id }). If you want to query by a document's
    * _id, use findById() instead of findOne().
    * @param id         the value of <code>_id</code> to query by
    * @param projection the optional fields to return
    * @return the [[Query]]
    */
  def findById(id: ObjectId | String | Int, projection: RawOptions = js.native): Query[Model[T]] = js.native

  /**
    * Finds a single document by its _id field. findById(id) is almost*
    * equivalent to findOne({ _id: id }). If you want to query by a document's
    * _id, use findById() instead of findOne().
    * @param id         the value of <code>_id</code> to query by
    * @param projection the optional fields to return
    * @param callback   the optional callback
    */
  def findById(id: ObjectId | String | Int,
               projection: RawOptions,
               callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Finds a single document by its _id field. findById(id) is almost*
    * equivalent to findOne({ _id: id }). If you want to query by a document's
    * _id, use findById() instead of findOne().
    * @param id       the value of <code>_id</code> to query by
    * @param callback the optional callback
    */
  def findById(id: ObjectId | String | Int, callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issue a mongodb findAndModify remove command by a document's _id field. findByIdAndRemove(id, ...)
    * is equivalent to findOneAndRemove({ _id: id }, ...).
    * @param id      the value of <code>_id</code> to query by
    * @param options the optional options
    * @return a promise of the results
    * @example findByIdAndRemove(id, [options], [callback])
    */
  def findByIdAndRemove(id: ObjectId | String | Int, options: RawOptions = js.native): js.Promise[Model[T]] = js.native

  /**
    * Issue a mongodb findAndModify remove command by a document's _id field. findByIdAndRemove(id, ...)
    * is equivalent to findOneAndRemove({ _id: id }, ...).
    * @param id       the value of <code>_id</code> to query by
    * @param options  the optional options
    * @param callback the optional callback
    * @example findByIdAndRemove(id, [options], [callback])
    */
  def findByIdAndRemove(id: ObjectId | String | Int,
                        options: RawOptions,
                        callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issue a mongodb findAndModify remove command by a document's _id field. findByIdAndRemove(id, ...)
    * is equivalent to findOneAndRemove({ _id: id }, ...).
    * @param id       the value of <code>_id</code> to query by
    * @param callback the optional callback
    * @example findByIdAndRemove(id, [options], [callback])
    */
  def findByIdAndRemove(id: ObjectId | String | Int,
                        callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issues a mongodb findAndModify update command by a document's _id field.
    * findByIdAndUpdate(id, ...) is equivalent to findOneAndUpdate({ _id: id }, ...).
    * @param id      the value of <code>_id</code> to query by
    * @param update  the update sub-document
    * @param options the optional options
    * @return the promise of the document
    */
  def findByIdAndUpdate(id: ObjectId | String | Int,
                        update: js.Any,
                        options: RawOptions = js.native): js.Promise[Model[T]] = js.native

  /**
    * Issues a mongodb findAndModify update command by a document's _id field.
    * findByIdAndUpdate(id, ...) is equivalent to findOneAndUpdate({ _id: id }, ...).
    * @param id       the value of <code>_id</code> to query by
    * @param update   the update sub-document
    * @param callback the optional callback
    */
  def findByIdAndUpdate(id: ObjectId | String | Int,
                        update: js.Any,
                        callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issues a mongodb findAndModify update command by a document's _id field.
    * findByIdAndUpdate(id, ...) is equivalent to findOneAndUpdate({ _id: id }, ...).
    * @param id       the value of <code>_id</code> to query by
    * @param update   the update sub-document
    * @param options  the optional options
    * @param callback the optional callback
    */
  def findByIdAndUpdate(id: ObjectId | String | Int,
                        update: js.Any,
                        options: RawOptions,
                        callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Finds one document.
    * @param conditions the conditions/query
    * @param projection the optional fields to return
    * @return the [[Query]]
    */
  def findOne(conditions: js.Any, projection: js.Any = js.native): Query[Model[T]] = js.native

  /**
    * Finds one document.
    * @param conditions the conditions/query
    * @param callback   the option callback
    */
  def findOne(conditions: js.Any,
              callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Finds one document.
    * @param conditions the conditions/query
    * @param projection the optional fields to return
    * @param callback   the option callback
    */
  def findOne(conditions: js.Any,
              projection: js.Any,
              callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issue a mongodb findAndModify remove command.
    * @param conditions the conditions/query
    * @param options    the optional options
    * @return the promise of the removed document
    */
  def findOneAndRemove(conditions: js.Any, options: RawOptions = js.native): js.Promise[Model[T]] = js.native

  /**
    * Issue a mongodb findAndModify remove command.
    * @param conditions the conditions/query
    * @param options    the optional options
    * @param callback   the option callback
    */
  def findOneAndRemove(conditions: js.Any,
                       options: RawOptions,
                       callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issue a mongodb findAndModify remove command.
    * @param conditions the conditions/query
    * @param callback   the option callback
    */
  def findOneAndRemove(conditions: js.Any,
                       callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issues a mongodb findAndModify update command.
    * @param conditions the conditions/query
    * @param update     the sub-document update
    * @param options    the optional options
    * @return the promise of the updated document
    */
  def findOneAndUpdate(conditions: js.Any,
                       update: js.Any,
                       options: RawOptions = js.native): js.Promise[Model[T]] = js.native

  /**
    * Issues a mongodb findAndModify update command.
    * @param conditions the conditions/query
    * @param update     the sub-document update
    * @param options    the optional options
    * @param callback   the option callback
    */
  def findOneAndUpdate(conditions: js.Any,
                       update: js.Any,
                       options: RawOptions,
                       callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Issues a mongodb findAndModify update command.
    * @param conditions the conditions/query
    * @param update     the sub-document update
    * @param callback   the option callback
    */
  def findOneAndUpdate(conditions: js.Any,
                       update: js.Any,
                       callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Shortcut for validating an array of documents and inserting them into
    * MongoDB if they're all valid. This function is faster than .create()
    * because it only sends one operation to the server, rather than one for each document.
    * @param docs    the documents to insert
    * @param options the optional options
    * @return a promise of the inserted documents
    */
  def insertMany(docs: js.Array[T], options: RawOptions = js.native): js.Promise[js.Array[Model[T]]] = js.native

  /**
    * Shortcut for validating an array of documents and inserting them into
    * MongoDB if they're all valid. This function is faster than .create()
    * because it only sends one operation to the server, rather than one for each document.
    * @param docs     the documents to insert
    * @param options  the optional options
    * @param callback the option callback
    */
  def insertMany(docs: js.Array[T],
                 options: RawOptions,
                 callback: MongooseModelArrayCallback[T]): Unit = js.native

  /**
    * Shortcut for validating an array of documents and inserting them into
    * MongoDB if they're all valid. This function is faster than .create()
    * because it only sends one operation to the server, rather than one for each document.
    * @param docs     the documents to insert
    * @param callback the option callback
    */
  def insertMany(docs: js.Array[T],
                 callback: MongooseModelArrayCallback[T]): Unit = js.native

  /**
    * Executes a mapReduce command.
    * @param obj an object specifying map-reduce options
    * @return the promise of the results
    */
  def mapReduce[A](obj: js.Any): js.Promise[A] = js.native

  /**
    * Executes a mapReduce command.
    * @param obj      an object specifying map-reduce options
    * @param callback the  optional callback
    */
  def mapReduce[A](obj: js.Any, callback: js.Function2[MongooseError, A, T]): Unit = js.native

  /**
    * Returns another Model instance.
    * @param name the model name
    * @tparam A the model type
    * @return the [[MongooseModel model]]
    */
  def model[A](name: String): MongooseModel[A] = js.native

  /**
    * Populates document references.
    * @param doc     a single document to populate.
    * @param options A hash of key/val (path, options) used for population.
    * @return the <code>doc(s)</code>.
    */
  def populate(doc: T, options: js.Dictionary[js.Any]): js.Promise[Model[T]] = js.native

  /**
    * Populates document references.
    * @param docs     Either a single document or array of documents to populate.
    * @param options  A hash of key/val (path, options) used for population.
    * @param callback Optional callback, executed upon completion. Receives <code>err</code> and the <code>doc(s)</code>.
    */
  def populate(docs: T,
               options: js.Dictionary[js.Any],
               callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Populates document references.
    * @param docs    an array of documents to populate.
    * @param options A hash of key/val (path, options) used for population.
    * @return the <code>doc(s)</code>.
    */
  def populate(docs: js.Array[T], options: js.Dictionary[js.Any]): js.Promise[js.Array[Model[T]]] = js.native

  /**
    * Populates document references.
    * @param docs     Either a single document or array of documents to populate.
    * @param options  A hash of key/val (path, options) used for population.
    * @param callback Optional callback, executed upon completion. Receives <code>err</code> and the <code>doc(s)</code>.
    */
  def populate(docs: js.Array[T],
               options: js.Dictionary[js.Any],
               callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Removes documents from the collection.
    * @param conditions the conditions/query
    * @return the promise of the removed document
    */
  def remove(conditions: js.Any): js.Promise[UpdateWriteResult] = js.native

  /**
    * Removes documents from the collection.
    * @param conditions the conditions/query
    * @param callback   the optional callback
    */
  def remove(conditions: js.Any, callback: js.Function2[MongooseError, UpdateWriteResult, Any]): Unit = js.native

  /**
    * Updates documents in the database without returning them.
    * @param doc     the sub-document to use in the update
    * @param options the optional options
    * @return the promise of the updated document
    */
  def update(conditions: js.Any,
             doc: js.Any,
             options: RawOptions = js.native): js.Promise[js.Array[Model[T]]] = js.native

  /**
    * Updates documents in the database without returning them.
    * @param conditions the conditions/query
    * @param doc        the sub-document to use in the update
    * @param options    the optional options
    * @param callback   the optional callback
    */
  def update(conditions: js.Any,
             doc: js.Any,
             options: RawOptions,
             callback: MongooseModelArrayCallback[T]): Unit = js.native

  /**
    * Updates documents in the database without returning them.
    * @param conditions the conditions/query
    * @param doc        the sub-document to use in the update
    * @param callback   the optional callback
    */
  def update(conditions: js.Any,
             doc: js.Any,
             callback: MongooseModelArrayCallback[T]): Unit = js.native

  /**
    * Same as update(), except MongoDB will update all documents that match
    * criteria (as opposed to just the first one) regardless of the value of
    * the multi option.
    * @param doc     the sub-document to use in the update
    * @param options the optional options
    * @return the promise of the updated document
    */
  def updateMany(conditions: js.Any, doc: js.Any, options: RawOptions = js.native): js.Promise[js.Array[Model[T]]] = js.native

  /**
    * Same as update(), except MongoDB will update all documents that match
    * criteria (as opposed to just the first one) regardless of the value of
    * the multi option.
    * @param conditions the conditions/query
    * @param doc        the sub-document to use in the update
    * @param options    the optional options
    * @param callback   the optional callback
    */
  def updateMany(conditions: js.Any,
                 doc: js.Any,
                 options: RawOptions,
                 callback: MongooseModelArrayCallback[T]): Unit = js.native

  /**
    * Same as update(), except MongoDB will update all documents that match
    * criteria (as opposed to just the first one) regardless of the value of
    * the multi option.
    * @param conditions the conditions/query
    * @param doc        the sub-document to use in the update
    * @param callback   the optional callback
    */
  def updateMany(conditions: js.Any,
                 doc: js.Any,
                 callback: MongooseModelArrayCallback[T]): Unit = js.native

  /**
    * Same as update(), except MongoDB will update only the first document that
    * matches criteria regardless of the value of the multi option.
    * @param conditions the conditions/query
    * @param doc        the sub-document to use in the update
    * @param options    the optional options
    * @return the promise of the updated document
    */
  def updateOne(conditions: js.Any, doc: js.Any, options: RawOptions = js.native): js.Promise[Model[T]] = js.native

  /**
    * Same as update(), except MongoDB will update only the first document that
    * matches criteria regardless of the value of the multi option.
    * @param conditions the conditions/query
    * @param doc        the sub-document to use in the update
    * @param options    the optional options
    * @param callback   the optional callback
    */
  def updateOne(conditions: js.Any,
                doc: js.Any,
                options: RawOptions,
                callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Same as update(), except MongoDB will update only the first document that
    * matches criteria regardless of the value of the multi option.
    * @param conditions the conditions/query
    * @param doc        the sub-document to use in the update
    * @param callback   the optional callback
    */
  def updateOne(conditions: js.Any,
                doc: js.Any,
                callback: MongooseModelCallback[T]): Unit = js.native

  /**
    * Creates a Query, applies the passed conditions, and returns the Query.
    * @param path  the given path/field
    * @param value the optional value
    * @return the [[QueryOperator]]
    */
  def where(path: String, value: js.Any = js.native): QueryOperator[js.Array[T]] = js.native

}

/**
  * Mongoose Model Singleton
  * @author lawrence.daniels@gmail.com
  */
object MongooseModel {

  /**
    * Model CRUD Mix-in
    */
  @js.native
  trait CRUD[T] extends js.Object {

    var _id: js.UndefOr[ObjectId] = js.native

    var __v: Int = js.native

    /**
      * Signal that we desire an increment of this documents version.
      */
    def increment(): Model[T] = js.native

    def remove(): js.Promise[Model[T]] = js.native

    def remove(callback: MongooseModelCallback[T]): Unit = js.native

    /**
      * Saves this document.
      * @param options                   the optional options
      * @param optionsSafe               overrides schema's safe option
      * @param optionsValidateBeforeSave set to false to save without validating.
      * @return the promise of the saved document.
      * @example save([options], [options.safe], [options.validateBeforeSave], [fn])
      */
    def save(options: RawOptions = js.native,
             optionsSafe: RawOptions = js.native,
             optionsValidateBeforeSave: Boolean = js.native): js.Promise[Model[T]] = js.native

    /**
      * Saves this document.
      * @param options                   the optional options
      * @param optionsSafe               overrides schema's safe option
      * @param optionsValidateBeforeSave set to false to save without validating.
      * @param callback                  the callback
      * @example save([options], [options.safe], [options.validateBeforeSave], [fn])
      */
    def save(options: RawOptions,
             optionsSafe: RawOptions,
             optionsValidateBeforeSave: Boolean,
             callback: js.Function3[MongooseError, Model[T], Int, Any]): Unit = js.native

    /**
      * Saves this document.
      * @param callback the callback
      * @example save([options], [options.safe], [options.validateBeforeSave], [fn])
      */
    def save(callback: js.Function3[MongooseError, Model[T], Int, Any]): Unit = js.native

    def update(updateDoc: js.Any): js.Promise[UpdateWriteResult] = js.native

    def update(updateDoc: js.Any, callback: js.Function2[MongooseError, UpdateWriteResult, Any]): Unit = js.native

  }

  ///////////////////////////////////////////////////////////////////
  //    Implicit Classes
  ///////////////////////////////////////////////////////////////////

  /**
    * Mongoose Model Enrichment
    * @param model the given [[MongooseModel]]
    */
  implicit class MongooseModelEnrichment[A](val model: MongooseModel[A]) extends AnyVal {

    @inline
    def apply(): Model[A] = model.New[Model[A]]()

  }

}

/**
  * @param path    space delimited path(s) to populate
  * @param select  optional fields to select
  * @param match   optional query conditions to match
  * @param model   optional name of the model to use for population
  * @param options optional query options like sort, limit, etc
  */
class PopulateOptions(val path: js.UndefOr[String] = js.undefined,
                      val select: js.UndefOr[String | js.Array[String]] = js.undefined,
                      val `match`: js.UndefOr[js.Any] = js.undefined,
                      val model: js.UndefOr[String] = js.undefined,
                      val options: js.UndefOr[js.Any] = js.undefined) extends js.Object
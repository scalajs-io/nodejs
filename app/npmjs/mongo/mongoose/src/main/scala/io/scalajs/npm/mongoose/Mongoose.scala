package io.scalajs.npm.mongoose

import io.scalajs.RawOptions
import io.scalajs.npm.mongodb.{ConnectionOptions, MongoDB}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Mongoose provides a straight-forward, schema-based solution to model your application data. It includes
  * built-in type casting, validation, query building, business logic hooks and more, out of the box.
  * @see http://mongoosejs.com/
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongoose", "Mongoose")
class Mongoose extends js.Object

/**
  * Mongoose Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongoose", JSImport.Namespace)
object Mongoose extends Connectable {

  ///////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////

  /**
    * This is the connection used by default for every model created using mongoose.model.
    */
  def connection: Connection = js.native

  /**
    * The MongoDB instance
    */
  def mongo: MongoDB = js.native

  /**
    * The promises library in use by Mongoose
    */
  var Promise: js.Any = js.native

  ///////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////

  /**
    *
    * @param url
    * @param options
    * @return
    */
  def createConnection(url: String, options: ConnectionOptions | RawOptions = js.native): Connection = js.native

  /**
    * Disconnects all connections.
    */
  def disconnect(): MongooseThenable[Unit] = js.native

  /**
    * Disconnects all connections.
    * @param callback the call back
    */
  def disconnect(callback: js.Function1[Error, Any]): Unit = js.native

  /**
    * Gets mongoose options
    * @param key the given key
    * @return the associated value
    */
  def get[T](key: String): js.UndefOr[T] = js.native

  /**
    *
    * @param modelName      the name of the model
    * @param schema         the [[Schema]]
    * @param collectionName the collection name
    * @return the [[MongooseModel model]]
    */
  def model[A](modelName: String,
               schema: Schema[A] = js.native,
               collectionName: String = js.native): MongooseModel[A] = js.native

  /**
    * Returns an array of model names created on this instance of Mongoose.
    * @return an array of model names
    */
  def modelNames(): js.Array[String] = js.native

  /**
    *
    * @param host
    * @param database
    * @param port
    * @param options
    */
  def open(host: String, database: String, port: Int, options: RawOptions = js.native): Unit = js.native

  /**
    * Declares a global plugin executed on all Schemas.
    * @param callback the  plugin callback
    * @param options  the optional options
    */
  def plugin(callback: js.Function, options: RawOptions = js.native): Unit = js.native

  /**
    * Sets mongoose options
    * @param key   the options key
    * @param value the the value to set or function
    */
  def set(key: String, value: js.Any): Unit = js.native

  ///////////////////////////////////////////////////////////////////////////////////////
  //    Schema.Types package
  ///////////////////////////////////////////////////////////////////////////////////////

  @js.native
  object Schema extends js.Object {

    @js.native
    object Types extends js.Object {

      def Array: ArrayFieldType = js.native

      def Boolean: BooleanFieldType = js.native

      def Buffer: BufferFieldType = js.native

      def Date: DateFieldType = js.native

      def Mixed: MixedFieldType = js.native

      def Number: NumberFieldType = js.native

      def ObjectId: ObjectIdFieldType = js.native

      def String: StringFieldType = js.native

    }

  }

}

/**
  * Mongoose Connectable Object
  */
@js.native
trait Connectable extends js.Object {

  /**
    * Opens the default mongoose connection.
    * @param uri     the connection URI
    * @param options the optional options
    * @return the mongoose connection
    */
  def connect(uri: String, options: ConnectionOptions | RawOptions = js.native): Connection = js.native

  /**
    * Opens the default mongoose connection.
    * @param uri        the connection URI
    * @param collection the collection
    * @return the mongoose connection
    */
  def connect(uri: String, collection: String): Connection = js.native

  /**
    * Opens the default mongoose connection.
    * @param uri      the connection URI
    * @param options  the optional options
    * @param callback the optional callback
    */
  def connect(uri: String,
              options: ConnectionOptions | RawOptions,
              callback: js.Function2[MongooseError, Connection, Any]): Unit = js.native

  /**
    * Opens the default mongoose connection.
    * @param uri        the connection URI
    * @param collection the collection
    * @param callback   the optional callback
    */
  def connect(uri: String,
              collection: String,
              callback: js.Function2[MongooseError, Connection, Any]): Unit = js.native

  /**
    * Opens the default mongoose connection.
    * @param uri      the connection URI
    * @param callback the optional callback
    */
  def connect(uri: String, callback: js.Function2[MongooseError, Connection, Any]): Unit = js.native

}
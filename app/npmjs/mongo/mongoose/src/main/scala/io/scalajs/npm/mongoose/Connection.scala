package io.scalajs.npm.mongoose

import io.scalajs.RawOptions
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.npm.mongodb.Db

import scala.scalajs.js

/**
  * Mongoose Connection
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Connection extends IEventEmitter {

  ///////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////

  /**
    * A hash of the collections associated with this connection
    */
  def collections: js.Dictionary[Collection] = js.native

  /**
    * A hash of the global options that are associated with this connection
    */
  def config: js.Dictionary[js.Any] = js.native

  /**
    * The mongodb.Db instance, set when the connection is opened
    */
  def db: Db = js.native

  /**
    * Connection ready state
    * <ul>
    * <li>0 = disconnected</li>
    * <li>1 = connected</li>
    * <li>2 = connecting</li>
    * <li>3 = disconnecting</li>
    * </ul>
    * Each state change emits its associated event name.
    * @return
    */
  def readyState: Int = js.native

  ///////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////

  /**
    * Closes the connection
    */
  def close(): js.Promise[js.Any] = js.native

  /**
    * Closes the connection
    */
  def close(callback: js.Function1[MongooseError, Any]): Unit = js.native

  /**
    * Retrieves a collection, creating it if not cached.
    * @param name    of the collection
    * @param options optional collection options
    * @return the [[Collection collection]] instance
    */
  def collection(name: String, options: RawOptions = js.native)

  /**
    * Models defined on the mongoose instance are available to all connection created by the same mongoose instance.
    * @param name       the model name or class extending Model
    * @param schema     the schema
    * @param collection the name (optional, inferred from model name)
    * @param skipInit   indicates whether to skip initialization (defaults to false)
    * @return the [[MongooseModel model]]
    */
  def model[A](name: String,
               schema: Schema[A] = js.native,
               collection: String = js.native,
               skipInit: Boolean = js.native): MongooseModel[A] = js.native

  /**
    * Returns an array of model names created on this instance of Mongoose.
    * @return an array of model names
    */
  def modelNames(): js.Array[String] = js.native

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

}

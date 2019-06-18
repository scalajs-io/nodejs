package io.scalajs.npm.mongodb

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Mongo Database
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "Db")
class Db(val databaseName: String, val replicaSet: ReplSet, val options: DbOptions) extends js.Object {

  def this() = this(js.native, js.native, js.native)

  def this(databaseName: String, server: Server) = this(databaseName, js.native, js.native)

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  // Server | ReplSet | Mongos  - Get the current db topology.
  var serverConfig: js.Any = js.native

  // Current bufferMaxEntries value for the database.
  var bufferMaxEntries: Int = js.native

  // The name of the database this instance represents.
  //var databaseName: String = js.native

  // The options associated with the db instance.
  //var options: js.Any = js.native

  // The current value of the parameter native_parser.
  var native_parser: Boolean = js.native

  // The current slaveOk value for the db instance.
  var slaveOk: Boolean = js.native

  // The current write concern values.
  var writeConcern: js.Any = js.native

  // Access the topology object (single server, replicaset or mongos).
  var topology: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Add a user to the database.
    * @param username the username.
    * @param password the password.
    * @param options  the optional settings.
    * @return the promise of the result
    */
  def addUser(username: String, password: String, options: RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Add a user to the database.
    * @param username the username.
    * @param password the password.
    * @param options  the optional settings.
    * @param callback the results callback
    */
  def addUser(username: String, password: String, options: RawOptions, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Add a user to the database.
    * @param username the username.
    * @param password the password.
    * @param callback the results callback
    */
  def addUser(username: String, password: String, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Returns the Admin db instance
    * @return the Admin db instance
    */
  def admin(): Admin = js.native

  /**
    * Authenticate a user against the server.
    * @param username the username.
    * @param password the password.
    * @param options  the optional settings.
    * @return the promise of the result
    */
  def authenticate(username: String,
                   password: String,
                   options: RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Authenticate a user against the server.
    * @param username the username.
    * @param password the password.
    * @param options  the optional settings.
    * @param callback the results callback
    */
  def authenticate(username: String,
                   password: String,
                   options: RawOptions,
                   callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Authenticate a user against the server.
    * @param username the username.
    * @param password the password.
    * @param callback the results callback
    */
  def authenticate(username: String, password: String, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Close the db and its underlying connections
    * @param force Force close, emitting no events
    * @return the promise of the result
    */
  def close(force: Boolean = js.native): js.Promise[Null] = js.native

  /**
    * Close the db and its underlying connections
    * @param force    Force close, emitting no events
    * @param callback the results callback
    */
  def close(force: Boolean, callback: MongoCallback1[Null]): Unit = js.native

  /**
    * Close the db and its underlying connections
    * @param callback the results callback
    */
  def close(callback: MongoCallback1[Null]): Unit = js.native

  /**
    * Fetch a specific collection (containing the actual collection information).
    * If the application does not use strict mode you can can use it without a callback in the following way:
    * {{{ var collection = db.collection('mycollection'); }}}
    * @param name the collection name we wish to access.
    * @return the collection
    */
  def collection(name: String, options: CollectionOptions | RawOptions = js.native): Collection = js.native

  /**
    * Fetch a specific collection (containing the actual collection information).
    * If the application does not use strict mode you can can use it without a callback in the following way:
    * {{{ var collection = db.collection('mycollection'); }}}
    * @param name     the collection name we wish to access.
    * @param callback the collection result callback
    */
  def collection(name: String, callback: MongoCallback1[Collection]): Unit = js.native

  /**
    * Fetch a specific collection (containing the actual collection information).
    * If the application does not use strict mode you can can use it without a callback in the following way:
    * {{{ var collection = db.collection('mycollection'); }}}
    * @param name     the collection name we wish to access.
    * @param options  the optional settings.
    * @param callback the collection result callback
    */
  def collection(name: String,
                 options: CollectionOptions | RawOptions,
                 callback: MongoCallback1[Collection]): Unit = js.native

  /**
    * Fetch all collections for the current db.
    * @return the promise of an array of collections
    */
  def collections(): js.Promise[js.Array[Collection]] = js.native

  /**
    * Fetch all collections for the current db.
    * @param callback the collections result callback
    */
  def collections(callback: MongoCallback1[js.Array[Collection]]): Unit = js.native

  /**
    * Execute a command
    * @param command the command hash
    * @param options the optional settings.
    * @return the promise of the result
    */
  def command(command: js.Any, options: RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Execute a command
    * @param command  the command hash
    * @param options  the optional settings.
    * @param callback the results callback
    */
  def command(command: js.Any, options: RawOptions, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Execute a command
    * @param command  the command hash
    * @param callback the results callback
    */
  def command(command: js.Any, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Create a new collection on a server with the specified options. Use this to create capped collections.
    * More information about command options available at https://docs.mongodb.com/manual/reference/command/create/
    * @param name    the collection name we wish to access.
    * @param options the optional settings
    * @return a promise of the result
    */
  def createCollection(name: String,
                       options: CollectionOptions | RawOptions = js.native): js.Promise[Collection] = js.native

  /**
    * Create a new collection on a server with the specified options. Use this to create capped collections.
    * More information about command options available at https://docs.mongodb.com/manual/reference/command/create/
    * @param name     the collection name we wish to access.
    * @param options  the optional settings
    * @param callback the results callback
    */
  def createCollection(name: String,
                       options: CollectionOptions | RawOptions,
                       callback: MongoCallback1[Collection]): Unit = js.native

  /**
    * Create a new collection on a server with the specified options. Use this to create capped collections.
    * More information about command options available at https://docs.mongodb.com/manual/reference/command/create/
    * @param name     the collection name we wish to access.
    * @param callback the results callback
    */
  def createCollection(name: String, callback: MongoCallback1[Collection]): Unit = js.native

  /**
    * Creates an index on the db and collection collection.
    * @param name        the name of the collection to create the index on.
    * @param fieldOrSpec defines the index.
    * @param options     the optional settings.
    * @return the promise of the result
    */
  def createIndex(name: String,
                  fieldOrSpec: String | js.Any,
                  options: IndexOptions | RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Creates an index on the db and collection collection.
    * @param name        the name of the collection to create the index on.
    * @param fieldOrSpec defines the index.
    * @param options     the optional settings.
    * @param callback    the results callback
    */
  def createIndex(name: String,
                  fieldOrSpec: String | js.Any,
                  options: IndexOptions | RawOptions,
                  callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Creates an index on the db and collection collection.
    * @param name        the name of the collection to create the index on.
    * @param fieldOrSpec defines the index.
    * @param callback    the results callback
    */
  def createIndex(name: String,
                  fieldOrSpec: String | js.Any,
                  callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Create a new Db instance sharing the current socket connections. Be aware that the new db instances are
    * related in a parent-child relationship to the original instance so that events are correctly emitted on child
    * db instances. Child db instances are cached so performing db('db1') twice will return the same instance.
    * You can control these behaviors with the options noListener and returnNonCachedInstance.
    * @param databaseName the name of the database we want to use.
    * @param options      the optional settings.
    */
  def db(databaseName: String, options: DbSharingOptions = js.native): Db = js.native

  /**
    * Drop a collection from the database, removing it permanently. New accesses will create a new collection.
    * @param name the name of collection to drop
    * @return the promise of the result
    */
  def dropCollection(name: String): js.Promise[CommandResult] = js.native

  /**
    * Drop a collection from the database, removing it permanently. New accesses will create a new collection.
    * @param name     the name of collection to drop
    * @param callback the results callback
    */
  def dropCollection(name: String, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Drop a database, removing it permanently from the server.
    * @return the promise of the result
    */
  def dropDatabase(): js.Promise[CommandResult] = js.native

  /**
    * Drop a database, removing it permanently from the server.
    * @param callback the callback containing a reference to this instance
    */
  def dropDatabase(callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Ensures that an index exists, if it does not it creates it
    * @param name        the name of the collection to create the index on.
    * @param fieldOrSpec defines the index.
    * @param options     the optional settings.
    * @return the promise of the result
    */
  def ensureIndex(name: String,
                  fieldOrSpec: String | js.Any,
                  options: IndexOptions | RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Ensures that an index exists, if it does not it creates it
    * @param name        the name of the collection to create the index on.
    * @param fieldOrSpec defines the index.
    * @param options     the optional settings.
    * @param callback    the results callback
    */
  def ensureIndex(name: String,
                  fieldOrSpec: String | js.Any,
                  options: IndexOptions | RawOptions,
                  callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Ensures that an index exists, if it does not it creates it
    * @param name        the name of the collection to create the index on.
    * @param fieldOrSpec defines the index.
    * @param callback    the results callback
    */
  def ensureIndex(name: String,
                  fieldOrSpec: String | js.Any,
                  callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Evaluate JavaScript on the server
    * @param code       JavaScript to execute on server.
    * @param parameters The parameters for the call.
    * @param options    the optional settings.
    * @return the promise of the result
    */
  def eval(code: Code,
           parameters: js.Array[String] | js.Any,
           options: RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Evaluate JavaScript on the server
    * @param code       JavaScript to execute on server.
    * @param parameters The parameters for the call.
    * @param options    the optional settings.
    * @param callback   the results callback
    */
  def eval(code: Code,
           parameters: js.Array[String] | js.Any,
           options: RawOptions,
           callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Evaluate JavaScript on the server
    * @param code       JavaScript to execute on server.
    * @param parameters The parameters for the call.
    * @param callback   the results callback
    */
  def eval(code: Code,
           parameters: js.Array[String] | js.Any,
           callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Runs a command on the database as admin.
    * @param command the command hash
    * @param options the optional settings.
    * @return the promise of the result
    */
  def executeDbAdminCommand(command: js.Any,
                            options: ReadPreferenceOptions | RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Runs a command on the database as admin.
    * @param command  the command hash
    * @param options  the optional settings.
    * @param callback the results callback
    */
  def executeDbAdminCommand(command: js.Any,
                            options: ReadPreferenceOptions | RawOptions,
                            callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Runs a command on the database as admin.
    * @param command  the command hash
    * @param callback the results callback
    */
  def executeDbAdminCommand(command: js.Any,
                            callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Retrieves this collections index info.
    * @param name    the name of the collection.
    * @param options the optional settings.
    * @return a promise of the index information
    */
  def indexInformation(name: String,
                       options: IndexInformationOptions | RawOptions = js.native): js.Promise[js.Any] = js.native

  /**
    * Retrieves this collections index info.
    * @param name     the name of the collection.
    * @param options  the optional settings.
    * @param callback the callback containing the index information
    */
  def indexInformation(name: String,
                       options: IndexInformationOptions | RawOptions,
                       callback: js.Function2[MongoError, js.Any, Any]): Unit = js.native

  /**
    * Retrieves this collections index info.
    * @param name     the name of the collection.
    * @param callback the callback containing the index information
    */
  def indexInformation(name: String, callback: js.Function2[MongoError, js.Any, Any]): Unit = js.native

  /**
    * Get the list of all collection information for the specified db.
    * @param filter  query to filter collections by
    * @param options the qptional settings.
    * @return a [[CommandCursor]] containing the results
    */
  def listCollections(filter: js.Any = js.native,
                      options: ListCollectionsOptions | RawOptions = js.native): CommandCursor[CollectionInfo] = js.native


  /**
    * Logout user from server, fire off on all connections and remove all auth info
    * @param options the optional settings.
    * @return the promise of the result
    */
  def logout(options: RawOptions): js.Promise[CommandResult] = js.native

  /**
    * Logout user from server, fire off on all connections and remove all auth info
    * @param options  the optional settings.
    * @param callback the command result callback
    */
  def logout(options: RawOptions, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Logout user from server, fire off on all connections and remove all auth info
    * @param callback the command result callback
    */
  def logout(callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Open the database
    * @return the promise of a [[Db]]
    */
  def open(): js.Promise[Db] = js.native

  /**
    * Open the database
    * @param callback the callback
    */
  def open(callback: MongoCallback1[Db]): Unit = js.native

  /**
    * Remove a user from a database
    * @param username the username.
    * @param options  the optional settings.
    * @return the promise of the result
    */
  def removeUser(username: String,
                 options: RemoveUserOptions | RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Remove a user from a database
    * @param username the username.
    * @param options  the optional settings.
    * @param callback the command result callback
    */
  def removeUser(username: String,
                 options: RemoveUserOptions | RawOptions,
                 callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Remove a user from a database
    * @param username the username.
    * @param callback the command result callback
    */
  def removeUser(username: String, callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Rename a collection.
    * @param fromCollection the name of current collection to rename.
    * @param toCollection   the new name of of the collection.
    * @param options        the optional settings.
    * @return the promise of the result
    */
  def renameCollection(fromCollection: String,
                       toCollection: String,
                       options: RenameOptions | RawOptions = js.native): js.Promise[CommandResult] = js.native

  /**
    * Rename a collection.
    * @param fromCollection the name of current collection to rename.
    * @param toCollection   the new name of of the collection.
    * @param options        the optional settings.
    * @param callback       the results callback
    */
  def renameCollection(fromCollection: String,
                       toCollection: String,
                       options: RenameOptions | RawOptions,
                       callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Rename a collection.
    * @param fromCollection the name of current collection to rename.
    * @param toCollection   the new name of of the collection.
    * @param callback       the results callback
    */
  def renameCollection(fromCollection: String,
                       toCollection: String,
                       callback: MongoCallback1[CommandResult]): Unit = js.native

  /**
    * Get all the db statistics.
    * @param options the optional settings.
    */
  def stats(options: DbStatsOptions | RawOptions = js.native): MongoCallback1[DbStats] = js.native

  /**
    * Get all the db statistics.
    * @param options  the optional settings.
    * @param callback the collection result callback
    */
  def stats(options: DbStatsOptions | RawOptions, callback: MongoCallback1[DbStats]): Unit = js.native

  /**
    * Get all the db statistics.
    * @param callback the collection result callback
    */
  def stats(callback: MongoCallback1[DbStats]): Unit = js.native

  /**
    * Unref all sockets
    */
  def unref(): Unit = js.native

}

/**
  * {"name":"listing_activity",
  * "type":"collection",
  * "options":{},
  * "info":{"readOnly":false},
  * "idIndex":{"v":2,"key":{"_id":1},"name":"_id_","ns":"mi.listing_activity"}}
  */

class CollectionInfo(val name: String,
                     val `type`: String,
                     val options: RawOptions,
                     val info: CollectionInfo_Info,
                     val idIndex: CollectionInfo_IdIndex) extends js.Object

/**
  * CollectionInfo IdIndex
  * @author lawrence.daniels@gmail.com
  */

class CollectionInfo_IdIndex(val v: Int,
                             val key: js.Any,
                             val name: String,
                             val ns: String) extends js.Object

/**
  * CollectionInfo Info
  * @author lawrence.daniels@gmail.com
  */

class CollectionInfo_Info(val readOnly: Boolean) extends js.Object

/**
  * List Collections Options
  * @param batchSize      The batchSize for the returned command cursor or if pre 2.8 the systems batch collection
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */

class ListCollectionsOptions(val batchSize: js.UndefOr[Int] = js.undefined,
                             val readPreference: js.UndefOr[ReadPreference] = js.undefined) extends js.Object

/**
  * Index Information Options
  * @param full           returns the full raw index information.
  * @param readPreference the preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */

class IndexInformationOptions(val full: js.UndefOr[Boolean] = js.undefined,
                              val readPreference: js.UndefOr[ReadPreference] = js.undefined) extends js.Object

/**
  * Command Result
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CommandResult extends js.Object

/**
  * Database Statistics
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DbStats extends js.Object

/**
  * Database Options
  * @param authSource          string	null	optional If the database authentication is dependent on another databaseName.
  * @param w                   number | string	null	optional The write concern.
  * @param wtimeout            number	null	optional The write concern timeout.
  * @param j                   boolean	false	optional Specify a journal write concern.
  * @param forceServerObjectId boolean	false	optional Force server to assign _id values instead of driver.
  * @param serializeFunctions  boolean	false	optional Serialize functions on any object.
  * @param ignoreUndefined     Boolean	false	optional Specify if the BSON serializer should ignore undefined fields.
  * @param raw                 boolean	false	optional Return document results as raw BSON buffers.
  * @param promoteLongs        boolean	true	optional Promotes Long values to number if they fit inside the 53 bits resolution.
  * @param promoteBuffers      boolean	false	optional Promotes Binary BSON values to native Node Buffers.
  * @param promoteValues       boolean	true	optional Promotes BSON values to native types where possible, set to false to only receive wrapper types.
  * @param bufferMaxEntries    number	-1	optional Sets a cap on how many operations the driver will buffer up before giving up on getting a working connection, default is -1 which is unlimited.
  * @param readPreference      ReadPreference | string	null	optional The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED, ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  * @param  pkFactory          object	null	optional A primary key factory object for generation of custom _id keys.
  * @param  promiseLibrary     object	null	optional A Promise library class the application wishes to use such as Bluebird, must be ES6 compatible
  * @param  readConcern        object	null	optional Specify a read concern for the collection. (only MongoDB 3.2 or higher supported)
  *                            Name	Type	Default	Description
  * @param  level              object	'local'	optional
  *                            Specify a read concern level for the collection operations, one of [local|majority]. (only MongoDB 3.2 or higher supported)
  */

class DbOptions(val authSource: js.UndefOr[String] = js.undefined,
                val w: js.UndefOr[Int | String] = js.undefined,
                val wtimeout: js.UndefOr[Int] = js.undefined,
                val j: js.UndefOr[Boolean] = js.undefined,
                val forceServerObjectId: js.UndefOr[Boolean] = js.undefined,
                val serializeFunctions: js.UndefOr[Boolean] = js.undefined,
                val ignoreUndefined: js.UndefOr[Boolean] = js.undefined,
                val raw: js.UndefOr[Boolean] = js.undefined,
                val promoteLongs: js.UndefOr[Boolean] = js.undefined,
                val promoteBuffers: js.UndefOr[Boolean] = js.undefined,
                val promoteValues: js.UndefOr[Boolean] = js.undefined,
                val bufferMaxEntries: js.UndefOr[Int] = js.undefined,
                val readPreference: js.UndefOr[ReadPreference] = js.undefined,
                val pkFactory: js.UndefOr[js.Any] = js.undefined,
                val promiseLibrary: js.UndefOr[js.Any] = js.undefined,
                val readConcern: js.UndefOr[js.Any] = js.undefined,
                val level: js.UndefOr[js.Any] = js.undefined) extends js.Object

/**
  * Database Clone Options
  * @param noListener              Do not make the db an event listener to the original connection.
  * @param returnNonCachedInstance Control if you want to return a cached instance or have a new one created
  */

class DbSharingOptions(val noListener: js.UndefOr[Boolean] = js.undefined,
                       val returnNonCachedInstance: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Database Statistics Options
  * @param scale Divide the returned sizes by scale value.
  */

class DbStatsOptions(val scale: js.UndefOr[Double] = js.undefined) extends js.Object

/**
  * Read Preference Options
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */

class ReadPreferenceOptions(val readPreference: js.UndefOr[ReadPreference | String] = js.undefined) extends js.Object

/**
  * Remove User Options.
  * @param w        The write concern
  * @param wtimeout The write concern timeout.
  * @param j        Specify a journal write concern..
  */

class RemoveUserOptions(val w: js.UndefOr[Int | String] = js.undefined,
                        val wtimeout: js.UndefOr[Int] = js.undefined,
                        val j: js.UndefOr[Boolean] = js.undefined) extends js.Object
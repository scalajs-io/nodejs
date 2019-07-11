package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

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
class DbOptions(var authSource: js.UndefOr[String] = js.undefined,
                var w: js.UndefOr[Int | String] = js.undefined,
                var wtimeout: js.UndefOr[Int] = js.undefined,
                var j: js.UndefOr[Boolean] = js.undefined,
                var forceServerObjectId: js.UndefOr[Boolean] = js.undefined,
                var serializeFunctions: js.UndefOr[Boolean] = js.undefined,
                var ignoreUndefined: js.UndefOr[Boolean] = js.undefined,
                var raw: js.UndefOr[Boolean] = js.undefined,
                var promoteLongs: js.UndefOr[Boolean] = js.undefined,
                var promoteBuffers: js.UndefOr[Boolean] = js.undefined,
                var promoteValues: js.UndefOr[Boolean] = js.undefined,
                var bufferMaxEntries: js.UndefOr[Int] = js.undefined,
                var readPreference: js.UndefOr[ReadPreference] = js.undefined,
                var pkFactory: js.UndefOr[js.Any] = js.undefined,
                var promiseLibrary: js.UndefOr[js.Any] = js.undefined,
                var readConcern: js.UndefOr[js.Any] = js.undefined,
                var level: js.UndefOr[js.Any] = js.undefined) extends js.Object

/**
  * Db Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DbOptions extends FlexibleOptions[DbOptions]

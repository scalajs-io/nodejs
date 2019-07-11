package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Mongo Collection Retrieval Options
  * @param w                   number | string	null	optional - The write concern.
  * @param wtimeout            number	null	optional - The write concern timeout.
  * @param j                   boolean	false	optional - Specify a journal write concern.
  * @param raw                 boolean	false	optional - Return document results as raw BSON buffers.
  * @param pkFactory           object	null	optional - A primary key factory object for generation of custom _id keys.
  * @param readPreference      ReadPreference | string	null	optional - The preferred read preference
  *                            (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED, ReadPreference.SECONDARY,
  *                         ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  * @param serializeFunctions  boolean	false	optional - Serialize functions on any object.
  * @param strict              boolean	false	optional - Returns an error if the collection does not exist
  * @param capped              boolean	false	optional - Create a capped collection.
  * @param autoIndexId         boolean	true	optional - Create an index on the _id field of the document, True by default on MongoDB 2.2 or higher off for version < 2.2.
  * @param size                number	null	optional - The size of the capped collection in bytes.
  * @param max                 number	null	optional - The maximum number of documents in the capped collection.
  * @param flags               number	null	optional - Optional. Available for the MMAPv1 storage engine only to
  *                            set the usePowerOf2Sizes and the noPadding flag.
  * @param storageEngine       object	null	optional - Allows users to specify configuration to the storage engine on
  *                            a per-collection basis when creating a collection on MongoDB 3.0 or higher.
  * @param validator           object	null	optional - Allows users to specify validation rules or expressions for
  *                            the collection. For more information, see Document Validation on MongoDB 3.2 or higher.
  * @param validationLevel     string	null	optional - Determines how strictly MongoDB applies the validation rules
  *                            to existing documents during an update on MongoDB 3.2 or higher.
  * @param validationAction    string	null	optional - Determines whether to error on invalid documents or just warn
  *                            about the violations but allow invalid documents to be inserted on MongoDB 3.2 or higher.
  * @param indexOptionDefaults object	null	optional - Allows users to specify a default configuration for indexes
  *                            when creating a collection on MongoDB 3.2 or higher.
  * @param  viewOn             string	null	optional - The name of the source collection or view from which to create
  *                            the view. The name is not the full namespace of the collection or view; i.e. does not
  *                            include the database name and implies the same database as the view to create
  *                            on MongoDB 3.4 or higher.
  * @param   pipeline          array	null	optional - An array that consists of the aggregation pipeline stage.
  *                            create creates the view by applying the specified pipeline to the viewOn collection
  *                            or view on MongoDB 3.4 or higher.
  * @param  collation          object	null	optional - Specify collation (MongoDB 3.4 or higher) settings for update
  *                            operation (see 3.4 documentation for available fields).
  */
class CollectionOptions(var w: js.UndefOr[String] = js.undefined,
                        var wtimeout: js.UndefOr[Boolean] = js.undefined,
                        var j: js.UndefOr[Boolean] = js.undefined,
                        var raw: js.UndefOr[Boolean] = js.undefined,
                        var pkFactory: js.UndefOr[Boolean] = js.undefined,
                        var readPreference: js.UndefOr[Boolean] = js.undefined,
                        var serializeFunctions: js.UndefOr[Boolean] = js.undefined,
                        var strict: js.UndefOr[Boolean] = js.undefined,
                        var capped: js.UndefOr[Boolean] = js.undefined,
                        var autoIndexId: js.UndefOr[String] = js.undefined,
                        var size: js.UndefOr[Boolean] = js.undefined,
                        var max: js.UndefOr[Boolean] = js.undefined,
                        var flags: js.UndefOr[Boolean] = js.undefined,
                        var storageEngine: js.UndefOr[Boolean] = js.undefined,
                        var validator: js.UndefOr[Boolean] = js.undefined,
                        var validationLevel: js.UndefOr[Boolean] = js.undefined,
                        var validationAction: js.UndefOr[Boolean] = js.undefined,
                        var indexOptionDefaults: js.UndefOr[Boolean] = js.undefined,
                        var viewOn: js.UndefOr[Boolean] = js.undefined,
                        var pipeline: js.UndefOr[Boolean] = js.undefined,
                        var collation: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Collection Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CollectionOptions extends FlexibleOptions[CollectionOptions]
package io.scalajs.npm.mongodb.gridfs

import io.scalajs.nodejs.stream.IDuplex

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Create a new GridStoreStream instance (INTERNAL TYPE, do not instantiate directly)
  * @return [[GridStoreStream]] instance.
  */
@js.native
@JSImport("mongodb", "GridStoreStream")
@deprecated("Use GridFSBucket API instead", since = "2.1")
class GridStoreStream() extends IDuplex
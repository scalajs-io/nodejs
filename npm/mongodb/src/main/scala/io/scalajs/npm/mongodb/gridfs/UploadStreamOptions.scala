package io.scalajs.npm.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Upload Stream Options
  * @param chunkSizeBytes Optional - overwrite this bucket's chunkSizeBytes for this file
  * @param metadata       Optional - object to store in the file document's metadata field
  * @param contentType    Optional - string to store in the file document's contentType field
  * @param aliases        Optional - array of strings to store in the file document's aliases field
  */
@ScalaJSDefined
class UploadStreamOptions(var chunkSizeBytes: Integer = null,
                          var metadata: js.Any = null,
                          var contentType: String = null,
                          var aliases: js.Array[js.Any] = null)
    extends js.Object

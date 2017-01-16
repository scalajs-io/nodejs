package io.scalajs.npm.mongodb.gridfs

import io.scalajs.npm.mongodb.ObjectID
import io.scalajs.nodejs.stream

import scala.scalajs.js

/**
  * GridFS Bucket Write Stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridFSBucketWriteStream extends stream.Writable {

  def id: ObjectID = js.native

}

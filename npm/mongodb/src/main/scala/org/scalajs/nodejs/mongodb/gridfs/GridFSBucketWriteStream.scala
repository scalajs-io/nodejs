package org.scalajs.nodejs.mongodb.gridfs

import org.scalajs.nodejs.mongodb.ObjectID
import org.scalajs.nodejs.stream

import scala.scalajs.js

/**
  * GridFS Bucket Write Stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridFSBucketWriteStream extends stream.Writable {

  def id: ObjectID = js.native

}

package com.github.ldaniels528.meansjs.nodejs.mongodb.gridfs

import com.github.ldaniels528.meansjs.nodejs.mongodb.ObjectID
import com.github.ldaniels528.meansjs.nodejs.stream

import scala.scalajs.js

/**
  * GridFS Bucket Write Stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridFSBucketWriteStream extends stream.Writable {

  def id: ObjectID = js.native

}

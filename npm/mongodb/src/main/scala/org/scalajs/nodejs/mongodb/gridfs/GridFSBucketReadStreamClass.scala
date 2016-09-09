package org.scalajs.nodejs.mongodb.gridfs

import org.scalajs.nodejs.mongodb._
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.mongodb.Collection
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * GridFS Bucket Read Stream Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridFSBucketReadStreamClass extends js.Object

/**
  * GridFS Bucket Read Stream Class Companion
  * @author lawrence.daniels@gmail.com
  */
object GridFSBucketReadStreamClass {

  /**
    * GridFS Bucket Read Stream Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridFSBucketReadStreamClassExtensions(val `class`: GridFSBucketReadStreamClass) extends AnyVal {

    @inline
    def apply(chunks: Collection, files: Collection, readPreference: js.Any, filter: js.Any, options: ReadStreamOptions) = {
      `class`.New[GridFSBucketReadStream](chunks, files, readPreference, filter, options)
    }
  }

}
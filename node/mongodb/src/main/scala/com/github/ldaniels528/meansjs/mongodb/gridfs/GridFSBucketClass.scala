package com.github.ldaniels528.meansjs.mongodb.gridfs

import com.github.ldaniels528.meansjs.mongodb.Db
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * GridFS Bucket Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridFSBucketClass extends js.Object

/**
  * GridFS Bucket Class Companion
  * @author lawrence.daniels@gmail.com
  */
object GridFSBucketClass {

  /**
    * GridFS Bucket Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridFSBucketClassExtensions(val `class`: GridFSBucketClass) extends AnyVal {

    @inline
    def apply(db: Db) = `class`.New[GridFSBucket](db)

    @inline
    def apply(db: Db, options: GridFSBucketOptions) = `class`.New[GridFSBucket](db, options)

  }

}
package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.mongodb.gridfs.{Grid, GridFSBucketClass, GridStoreClass}
import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.NodeModule
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.mongodb.gridfs.{GridFSBucketClass, GridStoreClass}

import scala.scalajs.js

/**
  * MongoDB Module for Node.js
  * @author lawrence.daniels@gmail.com
  * @see http://mongodb.github.io/node-mongodb-native/2.1/api/index.html
  * @version 2.1
  */
@js.native
trait MongoDB extends NodeModule with EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Classes and Properties
  /////////////////////////////////////////////////////////////////////////////////

  def pure: js.Function0[Pure] = js.native

  def Binary: js.Function0[js.Dynamic] = js.native

  def Code: js.Function0[js.Dynamic] = js.native

  def Connection: js.Function0[Connection] = js.native

  def Db: DbClass = js.native

  def Grid: js.Function2[Db, String, Grid] = js.native

  def GridFSBucket: GridFSBucketClass = js.native

  def GridStore: GridStoreClass = js.native

  def MongoClient: MongoClientClass = js.native

  def ObjectID: ObjectIDClass = js.native

  def ReplSetServers: js.Function1[js.Array[Server], ReplSetServers] = js.native

  def Server: ServerClass = js.native

}

/**
  * MongoDB Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoDB {

  /**
    * Convenience method for retrieving the 'mongodb' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the MongoDB instance
    */
  def apply()(implicit require: NodeRequire) = require[MongoDB]("mongodb")

}
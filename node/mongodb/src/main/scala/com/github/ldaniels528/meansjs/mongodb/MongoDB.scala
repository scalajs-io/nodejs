package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.mongodb.gridfs.{Grid, GridFSBucketClass, GridStoreClass}
import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * MongoDB Module for Node.js
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoDB extends NodeModule with EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
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

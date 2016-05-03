package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.mongodb.gridfs.{GridClass, GridFSBucketClass, GridStoreClass}
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

  def pure: PureClass = js.native

  def Binary: js.Dynamic = js.native

  def Code: js.Dynamic = js.native

  def Connection: js.Dynamic = js.native

  def Db: DbClass = js.native

  def Grid: GridClass = js.native

  def GridFSBucket: GridFSBucketClass = js.native

  def GridStore: GridStoreClass = js.native

  def MongoClient: MongoClientClass = js.native

  def ObjectID: ObjectIDClass = js.native

  def ReplSetServers: ReplSetServersClass = js.native

  def Server: ServerClass = js.native

}

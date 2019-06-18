package io.scalajs.npm.tingodb

import io.scalajs.RawOptions
import io.scalajs.npm.mongodb
import io.scalajs.npm.mongodb.{CollectionInfo, Cursor, DbOptions, _}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * TingoDB Database
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tingodb", "Db")
class Db(databaseName: String, options: DbOptions | RawOptions = js.native) extends mongodb.Db() {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  override def admin(): Admin = js.native

  def close(): Unit = js.native

  def collection(name: String): Collection = js.native

  def collection(name: String, callback: js.Function): Unit = js.native

  def collection(name: String, options: CollectionOptions | js.Any, callback: js.Function): Unit = js.native

  def collectionsInfo(): Cursor[CollectionInfo] = js.native

  def collectionNames(callback: js.Function): Unit = js.native

  def createCollection(name: String, callback: js.Function): Unit = js.native

  def createCollection(name: String, options: CollectionOptions | js.Any, callback: js.Function): Unit = js.native

  def createIndex(name: String, flag: Char, callback: js.Function): Unit = js.native

  def dropCollection(name: String, callback: js.Function): Unit = js.native

  def dropDatabase(callback: js.Function): Unit = js.native

  def indexInformation(name: String, callback: js.Function): Unit = js.native

  def open(callback: js.Function): Unit = js.native

}

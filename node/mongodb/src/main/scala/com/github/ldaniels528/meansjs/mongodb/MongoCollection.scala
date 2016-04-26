package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Mongo Collection
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
trait MongoCollection extends js.Object {

  def drop(callback: js.Function): Unit = js.native

  def find(): MongoCursor = js.native

  def find(selector: js.Any): MongoCursor = js.native

  def findOne(selector: js.Any, callback: js.Function): Unit = js.native

  def insert(doc: js.Any): Unit = js.native

  def insert(doc: js.Any, callback: js.Function): Unit = js.native

  def insert(doc: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

  def insert(docs: js.Array[js.Any], options: WriteOptions, callback: js.Function): Unit = js.native

  def remove(): Unit = js.native

  def remove(selector: js.Any): Unit = js.native

  def remove(selector: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

  def update(selector: js.Any, modifier: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

}

/**
  * Mongo Collection Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoCollection {

  /**
    * Mongo Collection Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoCollectionEnrich(val coll: MongoCollection) extends AnyVal {

    def dropAsync = callbackWithErrorToFuture[OperationResult](coll.drop)

    def findAsync[T <: js.Any] = callbackWithErrorToFuture[js.Array[T]](coll.find().toArray)

    def findAsync[T <: js.Any](selector: js.Any) = callbackWithErrorToFuture[js.Array[T]](coll.find(selector).toArray)

    def findOneAsync[T <: js.Any](selector: js.Any) = callbackWithErrorToFuture[js.UndefOr[T]](coll.findOne(selector, _))

    def insertAsync(doc: js.Any) = callbackWithErrorToFuture[WriteResult](coll.insert(doc, WriteOptions(w = 1), _))

    def insertAsync(docs: js.Array[js.Any]) = callbackWithErrorToFuture[WriteResult](coll.insert(docs, WriteOptions(w = 1), _))

    def removeAsync(doc: js.Any) = callbackWithErrorToFuture[WriteResult](coll.remove(doc, WriteOptions(w = 1), _))

    def updateAsync(selector: js.Any, modifier: js.Any) = callbackWithErrorToFuture[WriteResult](coll.update(selector, modifier, WriteOptions(w = 1), _))

  }

}
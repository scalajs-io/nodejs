package io.scalajs.npm.mongoose

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Everything in Mongoose starts with a Schema. Each schema maps to a MongoDB collection and defines
  * the shape of the documents within that collection.
  * @see http://mongoosejs.com/docs/api.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongoose", "Schema")
class Schema[T](structure: js.Any) extends js.Object {

  def get(field: String): js.Any = js.native

  def methods: Methods = js.native

  def path(label: String): SchemaProperty = js.native

  /**
    * Defines a middleware function.
    * @param method the defined method
    * @param value  the given method value callback
    * @example schema.pre('set', function (next, path, val, typel) { ... })
    */
  def pre[A](method: String, value: js.Function4[js.Function0[Any], String, js.Any, js.Any, Any]): Unit = js.native

}

/**
  * Schema Singleton
  * @author lawrence.daniels@gmail.com
  */
object Schema {

  /**
    * Creates a new schema
    * @param fields the schema fields
    * @return a new schema
    */
  @inline
  def apply[T](fields: (String, js.Any)*): Schema[T] = new Schema[T](js.Dictionary(fields: _*))

}
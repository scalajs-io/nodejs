package io.scalajs.npm

import io.scalajs.util.ScalaJsHelper._
import io.scalajs.util.JsUnderOrHelper._

import scala.concurrent.{Future, Promise}
import scala.language.{existentials, implicitConversions}
import scala.scalajs.{js, runtime}

/**
  * MongoDB package object
  * @author lawrence.daniels@gmail.com
  */
package object mongodb {

  /////////////////////////////////////////////////////////////////////////////////
  //      Promises and Futures
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Converts a JavaScript-style callback to a Scala-style future
    * @param f the given callback function
    * @return a Scala-style future
    */
  @inline
  def callbackMongoFuture[R](f: js.Function2[MongoError, R, Any] => Unit): Future[R] = {
    val promise = Promise[R]()
    f((err: MongoError, result: R) =>
      if (!isDefined(err)) promise.success(result) else promise.failure(runtime.wrapJavaScriptException(err)))
    promise.future
  }

  /////////////////////////////////////////////////////////////////////////////////
  //      Bulk Insert/Update
  /////////////////////////////////////////////////////////////////////////////////

  @inline
  def deleteMany(filter: js.Any) = doc("deleteMany" -> filter)

  @inline
  def deleteOne(filter: js.Any) = doc("deleteOne" -> filter)

  @inline
  def insertOne(document: js.Any) = doc("insertOne" -> document)

  @inline
  def replaceOne(filter: js.Any, replacement: js.Any, upsert: Boolean = false) = {
    doc("replaceOne" -> doc("filter" -> filter, "replacement" -> replacement, "upsert" -> upsert))
  }

  @inline
  def updateMany(filter: js.Any, update: js.Any, upsert: Boolean = false) = {
    doc("updateMany" -> doc("filter" -> filter, "update" -> update, "upsert" -> upsert))
  }

  @inline
  def updateOne(filter: js.Any, update: js.Any, upsert: Boolean = false) = {
    doc("updateOne" -> doc("filter" -> filter, "update" -> update, "upsert" -> upsert))
  }

  /////////////////////////////////////////////////////////////////////////////////
  //      MongoDB DSL
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Creates a new JSON document
    * @param kvps the given key-value pairs
    * @return a new document
    */
  @inline
  def doc(kvps: (String, js.Any)*) = js.Dictionary(kvps: _*)

  @inline
  def $addToSet(values: (String, js.Any)*) = "$addToSet" -> doc(values: _*)

  /**
    * Joins query clauses with a logical AND returns all documents that match the conditions of both clauses.
    * @example db.inventory.find( { $and: [ { price: { $ne: 1.99 } }, { price: { $exists: true } } ] } )
    */
  @inline
  def $and(values: (String, js.Any)*) = "$and" -> js.Array(values.map(doc(_)): _*)

  /**
    * Joins query clauses with a logical AND returns all documents that match the conditions of both clauses.
    * @example db.inventory.find( { $and: [ { price: { $ne: 1.99 } }, { price: { $exists: true } } ] } )
    */
  @inline
  def $and(array: => js.Array[js.Any]) = "$and" -> array

  /**
    * Modifies the $push and $addToSet operators to append multiple items for array updates.
    * @example $each: [ 90, 92, 85 ]
    */
  @inline
  def $each(values: js.Array[_ <: Any]) = "$each" -> values

  /**
    * Projects the first element in an array that matches the specified $elemMatch condition.
    * @example { students: { $elemMatch: { school: 102 } } }
    */
  @inline
  def $elemMatch(value: => js.Any) = "$elemMatch" -> value

  @inline
  def $group(document: => js.Any) = doc("$group" -> document)

  @inline
  def $group(values: (String, js.Any)*) = doc("$group" -> doc(values: _*))

  /**
    * @example { $inc: { <field1>: <amount1>, <field2>: <amount2>, ... } }
    */
  @inline
  def $inc(deltas: (String, Double)*) = "$inc" -> js.Dictionary(deltas: _*)

  @inline
  def $match(document: => js.Any) = doc("$match" -> document)

  @inline
  def $match(values: (String, js.Any)*) = doc("$match" -> doc(values: _*))

  /**
    * Joins query clauses with a logical NOR returns all documents that fail to match both clauses.
    * @example db.inventory.find( { $nor: [ { price: 1.99 }, { sale: true } ]  } )
    */
  @inline
  def $nor(values: (String, js.Any)*) = "$nor" -> js.Array(values.map(doc(_)): _*)

  /**
    * Joins query clauses with a logical NOR returns all documents that fail to match both clauses.
    * @example db.inventory.find( { $nor: [ { price: 1.99 }, { sale: true } ]  } )
    */
  @inline
  def $nor(array: => js.Array[js.Any]) = "$nor" -> array

  /**
    * Joins query clauses with a logical OR returns all documents that match the conditions of either clause.
    * @example db.inventory.find( { $or: [ { quantity: { $lt: 20 } }, { price: 10 } ] } )
    */
  @inline
  def $or(values: (String, js.Any)*) = "$or" -> js.Array(values.map(doc(_)): _*)

  /**
    * Joins query clauses with a logical OR returns all documents that match the conditions of either clause.
    * @example db.inventory.find( { $or: [ { quantity: { $lt: 20 } }, { price: 10 } ] } )
    */
  @inline
  def $or(array: => js.Array[js.Any]) = "$or" -> array

  /**
    * Modifies the $push operator to specify the position in the array to add elements.
    * @example $position: 1
    */
  @inline
  def $position(pos: => Int) = "$position" -> pos

  @inline
  def $pull(value: => js.Any) = "$pull" -> value

  @inline
  def $pull(value: (String, js.Any)*) = "$pull" -> doc(value: _*)

  /**
    * The $set operator replaces the value of a field with the specified value.
    * @example { $set: { field1: value1, ... } }
    */
  @inline
  def $set(value: => js.Any) = "$set" -> value

  /**
    * The $set operator replaces the value of a field with the specified value.
    * @example { $set: { field1: value1, ... } }
    */
  @inline
  def $set(value: (String, js.Any)*) = "$set" -> doc(value: _*)

  /**
    * Performs text search.
    * @example db.articles.find( { $text: { $search: "coffee" } } )
    * @see [[https://docs.mongodb.org/manual/reference/operator/query/text/#op._S_text]]
    */
  @inline
  def $text(options: => TextSearchOptions) = "$text" -> options

  /**
    * Matches documents that satisfy a JavaScript expression.
    * @example db.myCollection.find( { $where: "this.credits == this.debits" } )
    */
  @inline
  def $where(code: => String) = "$where" -> code

  /**
    * Implicit conversion tuple sequence to [[js.Dictionary]]
    */
  implicit def tupleToJS[A](values: (String, A)): js.Any = js.Dictionary(values)

  /**
    * Mongo DSL Extensions
    * @param attribute the given JSON attribute
    */
  implicit class DSLExtensions(val attribute: String) extends AnyVal {

    @inline
    def $oid = new ObjectID(attribute)

    /**
      * Adds elements to an array only if they do not already exist in the set.
      * @example { $addToSet: {letters: [ "c", "d" ] } }
      */
    @inline
    def $addToSet(value: => js.Any) = "$addToSet" -> doc(attribute -> value)

    /**
      * The $all is equivalent to an $and operation of the specified values; i.e. the following statement:
      * @example { tags: { $all: [ "ssl" , "security" ] } }
      */
    @inline
    def $all(values: js.Any*) = attribute -> doc("$all" -> js.Array(values: _*))

    /**
      * The $all is equivalent to an $and operation of the specified values; i.e. the following statement:
      * @example { tags: { $all: [ "ssl" , "security" ] } }
      */
    @inline
    def $all(array: => js.Array[_ <: Any]) = attribute -> doc("$all" -> array)

    @inline
    def between[A, B](minValue: js.UndefOr[A], maxValue: js.UndefOr[B]): (String, js.Dictionary[js.Any]) = {
      (minValue.flat.toOption, maxValue.flat.toOption) match {
        case (Some(min), Some(max)) =>
          attribute -> doc("$gte" -> min.asInstanceOf[js.Any], "$lte" -> max.asInstanceOf[js.Any])
        case (Some(min), None) => attribute $gte min.asInstanceOf[js.Any]
        case (None, Some(max)) => attribute $lte max.asInstanceOf[js.Any]
        case (None, None)      => die("Maximum and minimum values are null and/or undefined")
      }
    }

    @inline
    def between[A, B](values: => (js.UndefOr[A], js.UndefOr[B])): (String, js.Dictionary[js.Any]) =
      between(values._1, values._2)

    /**
      * Projects the first element in an array that matches the specified $elemMatch condition.
      * @example { students: { $elemMatch: { school: 102 } } }
      */
    @inline
    def $elemMatch(value: => js.Any) = attribute -> doc("$elemMatch" -> value)

    /**
      * Projects the first element in an array that matches the specified $elemMatch condition.
      * @example { students: { $elemMatch: { school: 102 } } }
      */
    @inline
    def $elemMatch(value: (String, js.Any)*) = attribute -> doc("$elemMatch" -> doc(value: _*))

    /**
      * Specifies equality condition. The $eq operator matches documents where the value of a field equals the specified value.
      * @example db.inventory.find( { qty: { $eq: 20 } } )
      * @example db.inventory.find( { qty: 20 } )
      */
    @inline
    def $eq(value: => js.Any) = attribute -> value

    /**
      * Matches documents that have the specified field.
      * @example db.inventory.find( { qty: { $exists: true, $nin: [ 5, 15 ] } } )
      */
    @inline
    def $exists(state: => Boolean) = attribute -> doc("$exists" -> state)

    /**
      * Matches values that are greater than a specified value.
      * @example db.inventory.find( { qty: { $gt: 20 } } )
      */
    @inline
    def $gt(value: => js.Any) = attribute -> doc("$gt" -> value)

    /**
      * Matches values that are greater than or equal to a specified value.
      * @example db.inventory.find( { qty: { $gte: 20 } } )
      */
    @inline
    def $gte(value: => js.Any) = attribute -> doc("$gte" -> value)

    /**
      * Matches any of the values specified in an array.
      * @example db.inventory.find( { qty: { $in: [ 5, 15 ] } } )
      */
    @inline
    def $in(array: => js.Array[_ <: Any]) = attribute -> doc("$in" -> array)

    /**
      * @example { $inc: { <field1>: <amount1>, <field2>: <amount2>, ... } }
      */
    @inline
    def $inc(delta: => Double) = "$inc" -> doc(attribute -> delta)

    /**
      * Matches values that are less than a specified value.
      * @example db.inventory.find( { qty: { $lt: 20 } } )
      */
    @inline
    def $lt(value: => js.Any) = attribute -> doc("$gt" -> value)

    /**
      * Matches values that are less than or equal to a specified value.
      * @example db.inventory.find( { qty: { $lte: 20 } } )
      */
    @inline
    def $lte(value: => js.Any) = attribute -> doc("$lte" -> value)

    /**
      * The $meta projection operator returns for each matching document the metadata (e.g. "textScore") associated with the query.
      * @example db.collection.find({}, { score: { $meta: "textScore" } })
      */
    @inline
    def $meta(text: => String) = attribute -> doc("$meta" -> text)

    /**
      * Performs a modulo operation on the value of a field and selects documents with a specified result.
      * @example db.inventory.find( { qty: { $mod: [ 4, 0 ] } } )
      */
    @inline
    def $mod(values: js.Any*) = attribute -> doc("$mod" -> js.Array(values: _*))

    /**
      * Performs a modulo operation on the value of a field and selects documents with a specified result.
      * @example db.inventory.find( { qty: { $mod: [ 4, 0 ] } } )
      */
    @inline
    def $mod(array: => js.Array[_ <: Any]) = attribute -> doc("$mod" -> array)

    /**
      * Matches all values that are not equal to a specified value.
      * @example db.inventory.find( { qty: { $ne: 20 } } )
      */
    @inline
    def $ne(value: => js.Any) = attribute -> doc("$ne" -> value)

    /**
      * Matches none of the values specified in an array.
      * @example db.inventory.find( { qty: { $nin: [ 5, 15 ] } } )
      */
    @inline
    def $nin(array: => js.Array[_ <: Any]) = attribute -> doc("$nin" -> array)

    /**
      * Inverts the effect of a query expression and returns documents that do not match the query expression.
      * @example db.inventory.find( { price: { $not: { $gt: 1.99 } } } )
      */
    @inline
    def $not(expression: => js.Any) = attribute -> doc("$not" -> expression)

    /**
      * The $orderby operator sorts the results of a query in ascending or descending order.
      * @example db.collection.find( { $query: {}, $orderby: { age : -1 } } )
      */
    @inline
    def $orderby(value: => js.Any) = attribute -> doc("$orderby" -> value)

    /**
      * Removes the first or last item of an array.
      * @example db.students.update( { _id: 1 }, { $pop: { scores: -1 } } )
      */
    def $pop(value: => js.Any) = "$pop" -> doc(attribute -> value)

    /**
      * The $pull operator removes from an existing array all instances of a value or values that match a specified condition.
      * @example { $pull: { results: { $elemMatch: { score: 8 , item: "B" } } } }
      */
    @inline
    def $pull(value: => js.Any) = "$pull" -> doc(attribute -> value)

    /**
      * The $pull operator removes from an existing array all instances of a value or values that match a specified condition.
      * @example { $pull: { results: { $elemMatch: { score: 8 , item: "B" } } } }
      */
    @inline
    def $pull(value: (String, js.Any)*) = "$pull" -> doc(attribute -> doc(value: _*))

    /**
      * The $pull operator removes from an existing array all instances of a value or values that match a specified condition.
      * @example db.survey.update( { _id: 1 }, { $pullAll: { scores: [ 0, 5 ] } } )
      */
    @inline
    def $pullAll(values: js.Any*) = "$pullAll" -> doc(attribute -> js.Array(values: _*))

    /**
      * The $pull operator removes from an existing array all instances of a value or values that match a specified condition.
      * @example db.survey.update( { _id: 1 }, { $pullAll: { scores: [ 0, 5 ] } } )
      */
    @inline
    def $pullAll(array: => js.Array[_ <: Any]) = "$pullAll" -> doc(attribute -> array)

    /**
      * Selects documents where values match a specified regular expression.
      * @example {{{ db.products.find( { sku: { $regex: /^ABC/i } } ) }}}
      */
    @inline
    def $regex(pattern: => String, ignoreCase: Boolean = false) = {
      attribute -> (if (ignoreCase) doc("$regex" -> pattern, "$options" -> "i") else doc("$regex" -> pattern))
    }

    /**
      * @example { $set: { <field1>: <value1>, <field2>: <value2>, ... } }
      */
    @inline
    def $set(value: => js.Any) = "$set" -> doc(attribute -> value)

    /**
      * Selects documents if the array field is a specified size.
      * @example db.collection.find( { field: { $size: 1 } } )
      */
    @inline
    def $size(count: => Double) = attribute -> doc("$size" -> count)

    /**
      * The $slice operator controls the number of items of an array that a query returns. For information on limiting
      * the size of an array during an update with $push, see the $slice modifier instead.
      * @example db.posts.find( {}, { comments: { $slice: 5 } } )
      */
    @inline
    def $slice(count: => Int) = attribute -> doc("$slice" -> count)

    /**
      * @example count: { $sum: 1 }
      */
    @inline
    def $sum(value: => Double) = attribute -> doc("$sum" -> value)

    /**
      * Selects documents if a field is of the specified type.
      * @example db.data.find( { x: { $type: "minKey" } } )
      */
    @inline
    def $type(name: => String) = attribute -> doc("$type" -> name)

  }

  /**
    * Mongo Client Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoClientExtensions(val client: MongoClient) extends AnyVal {

    @inline
    def closeFuture(): Future[Db] = callbackMongoFuture[Db](client.close)

    @inline
    def connectFuture(url: String): Future[Db] = callbackMongoFuture[Db](client.connect(url, _))

    @inline
    def connectFuture(url: String, options: ConnectionOptions): Future[Db] =
      callbackMongoFuture[Db](client.connect(url, options, _))

    @inline
    def openFuture(): Future[Db] = callbackMongoFuture[Db](client.open)

  }

  /**
    * Mongo Projection Enrichment
    * @param fields the given array of fields
    */
  implicit class ProjectionEnrichment(val fields: Seq[String]) extends AnyVal {

    def toProjection = js.Dictionary(fields.map(_ -> 1): _*)

  }

}

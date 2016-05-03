package com.github.ldaniels528.meansjs

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * MongoDB package object
  * @author lawrence.daniels@gmail.com
  */
package object mongodb {

  type ReadPreference = String

  /**
    * Creates a new JSON document
    * @param kvps the given key-value pairs
    * @return a new document
    */
  @inline
  def doc(kvps: (String, js.Any)*) = js.Dictionary(kvps: _*)

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
  def $each(values: js.Any*) = "$each" -> js.Array(values: _*)

  /**
    * Modifies the $push and $addToSet operators to append multiple items for array updates.
    * @example $each: [ 90, 92, 85 ]
    */
  def $each(values: js.Array[js.Any]) = "$each" -> js.Array(values: _*)

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
    def $oid(implicit mongo: MongoDB) = mongo.ObjectID(attribute)

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
    def $all(array: => js.Array[js.Any]) = attribute -> doc("$all" -> array)

    /**
      * Projects the first element in an array that matches the specified $elemMatch condition.
      * @example { students: { $elemMatch: { school: 102 } } }
      */
    @inline
    def $elemMatch(value: => js.Any) = attribute -> doc("$elemMatch" -> value)

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
    def $in(values: js.Any*) = attribute -> doc("$in" -> js.Array(values: _*))

    /**
      * Matches any of the values specified in an array.
      * @example db.inventory.find( { qty: { $in: [ 5, 15 ] } } )
      */
    @inline
    def $in(array: js.Array[js.Any]) = attribute -> doc("$in" -> array)

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
    def $lte(value: => js.Any) = attribute -> doc("$gte" -> value)

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
    def $mod(array: => js.Array[js.Any]) = attribute -> doc("$mod" -> array)

    /**
      * Matches all values that are not equal to a specified value.
      * @example db.inventory.find( { qty: { $ne: 20 } } )
      */
    @inline
    def $ne(value: => js.Any) = attribute -> doc("$ne" -> value)

    /**
      * Inverts the effect of a query expression and returns documents that do not match the query expression.
      * @example db.inventory.find( { price: { $not: { $gt: 1.99 } } } )
      */
    @inline
    def $not(expression: => js.Any) = attribute -> doc("$not" -> expression)

    /**
      * Matches none of the values specified in an array.
      * @example db.inventory.find( { qty: { $nin: [ 5, 15 ] } } )
      */
    @inline
    def $nin(values: js.Any*) = attribute -> doc("$nin" -> js.Array(values: _*))

    /**
      * Matches none of the values specified in an array.
      * @example db.inventory.find( { qty: { $nin: [ 5, 15 ] } } )
      */
    @inline
    def $nin(array: => js.Array[js.Any]) = attribute -> doc("$nin" -> array)

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
      * @example db.survey.update( { _id: 1 }, { $pullAll: { scores: [ 0, 5 ] } } )
      */
    @inline
    def $pullAll(values: js.Any*) = "$pullAll" -> doc(attribute -> js.Array(values: _*))

    /**
      * The $pull operator removes from an existing array all instances of a value or values that match a specified condition.
      * @example db.survey.update( { _id: 1 }, { $pullAll: { scores: [ 0, 5 ] } } )
      */
    @inline
    def $pullAll(array: => js.Array[js.Any]) = "$pullAll" -> doc(attribute -> array)

    /**
      * Selects documents where values match a specified regular expression.
      * @example {{{ db.products.find( { sku: { $regex: /^ABC/i } } ) }}}
      */
    @inline
    def $regex(pattern: => String, ignoreCase: Boolean = false) = {
      attribute -> (if (ignoreCase) doc("$regex" -> pattern, "$options" -> "i") else doc("$regex" -> pattern))
    }

    /**
      * Selects documents if the array field is a specified size.
      * @example db.collection.find( { field: { $size: 1 } } )
      */
    @inline
    def $size(count: => Int) = attribute -> doc("$size" -> count)

    /**
      * The $slice operator controls the number of items of an array that a query returns. For information on limiting
      * the size of an array during an update with $push, see the $slice modifier instead.
      * @example db.posts.find( {}, { comments: { $slice: 5 } } )
      */
    @inline
    def $slice(count: => Int) = attribute -> doc("$slice" -> count)

    /**
      * Selects documents if a field is of the specified type.
      * @example db.data.find( { x: { $type: "minKey" } } )
      */
    @inline
    def $type(name: => String) = attribute -> doc("$type" -> name)

  }

  /**
    * Text Search Options
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class TextSearchOptions extends js.Object {
    var $search: js.UndefOr[String] = _
    var $language: js.UndefOr[String] = _
    var $caseSensitive: js.UndefOr[Boolean] = _
    var $diacriticSensitive: js.UndefOr[Boolean] = _
  }

  /**
    * Text Search Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object TextSearchOptions {
    def apply($search: js.UndefOr[String] = js.undefined,
              $language: js.UndefOr[String] = js.undefined,
              $caseSensitive: js.UndefOr[Boolean] = js.undefined,
              $diacriticSensitive: js.UndefOr[Boolean] = js.undefined) = {
      val options = new TextSearchOptions()
      options.$search = $search
      options.$language = $language
      options.$caseSensitive = $caseSensitive
      options.$diacriticSensitive = $diacriticSensitive
      options
    }
  }

}

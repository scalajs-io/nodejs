package io.scalajs.npm

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.npm.mongodb.{ConnectionOptions, MongoError}
import io.scalajs.npm.mongoose.MongooseModel.CRUD
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * mongoose package object
  * @author lawrence.daniels@gmail.com
  */
package object mongoose {

  ///////////////////////////////////////////////////////////////////
  //    Type Definitions
  ///////////////////////////////////////////////////////////////////

  /**
    * Model with CRUD definition
    * @tparam A the underlying model type
    */
  type Model[A] = A with CRUD[A]

  /**
    * Mongoose Error
    */
  type MongooseError = MongoError

  /**
    * Generic Mongoose callback w/error
    * @tparam A the parameter type
    */
  type MongooseCallback[A] = js.Function2[MongooseError, A, Any]

  /**
    * Mongoose callback w/error for enriched models
    * @tparam A the underlying model type
    */
  type MongooseModelCallback[A] = js.Function2[MongooseError, Model[A], Any]

  /**
    * Mongoose callback w/error for enriched models
    * @tparam A the underlying model type
    */
  type MongooseModelArrayCallback[A] = js.Function2[MongooseError, js.Array[Model[A]], Any]

  /** Schema Field Types **/

  type ArrayFieldType = SchemaFieldType[js.Array[_]]
  type BooleanFieldType = SchemaFieldType[Boolean]
  type BufferFieldType = SchemaFieldType[Buffer]
  type DateFieldType = SchemaFieldType[js.Date | Double]
  type MixedFieldType = SchemaFieldType[js.Any]
  type NumberFieldType = SchemaFieldType[Double | Int]
  type ObjectIdFieldType = SchemaFieldType[ObjectId]
  type StringFieldType = SchemaFieldType[String]

  ///////////////////////////////////////////////////////////////////
  //    Objects
  ///////////////////////////////////////////////////////////////////

  @js.native
  @JSGlobal("exports")
  object exports extends Exports

  ///////////////////////////////////////////////////////////////////
  //    Implicit Definitions
  ///////////////////////////////////////////////////////////////////

  /**
    * Mongoose Enrichment
    * @param connectable the given [[Connectable]]
    */
  implicit class MongooseEnrichment(val connectable: Connectable) extends AnyVal {

    @inline
    def connectFuture(url: String, options: ConnectionOptions = null): Future[Connection] = {
      promiseWithError1[MongooseError, Connection](connectable.connect(url, options, _))
    }

  }

}

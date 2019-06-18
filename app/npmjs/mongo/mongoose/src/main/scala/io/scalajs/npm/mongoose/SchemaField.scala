package io.scalajs.npm.mongoose

import scala.scalajs.js


/**
  * Schema Field Definition
  * @param `type`    the [[SchemaFieldType field type]]
  * @param default   an optional default value
  * @param c         an optional ???
  * @param lowercase an optional lowercase string operation
  * @param trim      an optional trim string  operation
  * @param `match`   an optional regular expression constraint
  * @param min       an optional minimum value
  * @param max       an optional maximum value
  * @param index     an optional index indicator
  */

class SchemaField[A](val `type`: SchemaFieldType[A],
                     val default: js.UndefOr[A] = js.undefined,
                     val c: js.UndefOr[Boolean] = js.undefined,
                     val lowercase: js.UndefOr[Boolean] = js.undefined,
                     val trim: js.UndefOr[Boolean] = js.undefined,
                     val `match`: js.UndefOr[js.RegExp] = js.undefined,
                     val min: js.UndefOr[A] = js.undefined,
                     val max: js.UndefOr[A] = js.undefined,
                     val index: js.UndefOr[Boolean] = js.undefined,
                     val get: js.UndefOr[js.Function1[A, A]] = js.undefined,
                     val set: js.UndefOr[js.Function1[A, A]] = js.undefined) extends js.Object

/**
  * Schema Field Singleton
  * @author lawrence.daniels@gmail.com
  */
object SchemaField {

  /**
    * Creates a new schema field definition
    * @param `type`    the [[SchemaFieldType field type]]
    * @param default   an optional default value
    * @param c         an optional ???
    * @param lowercase an optional lowercase string operation
    * @param trim      an optional trim string  operation
    * @param `match`   an optional regular expression constraint
    * @param min       an optional minimum value
    * @param max       an optional maximum value
    * @param index     an optional index indicator
    */
  def apply[A](`type`: SchemaFieldType[A],
               default: js.UndefOr[A] = js.undefined,
               c: js.UndefOr[Boolean] = js.undefined,
               lowercase: js.UndefOr[Boolean] = js.undefined,
               trim: js.UndefOr[Boolean] = js.undefined,
               `match`: js.UndefOr[js.RegExp] = js.undefined,
               min: js.UndefOr[A] = js.undefined,
               max: js.UndefOr[A] = js.undefined,
               index: js.UndefOr[Boolean] = js.undefined,
               get: js.UndefOr[js.Function1[A, A]] = js.undefined,
               set: js.UndefOr[js.Function1[A, A]] = js.undefined): SchemaField[A] = {
    new SchemaField[A](
      `type` = `type`,
      default = default,
      c = c,
      `match` = `match`,
      lowercase = lowercase,
      trim = trim,
      min = min,
      max = max,
      index = index,
      get = get,
      set = set
    )
  }

}

/**
  * Represents a schema field type
  */
@js.native
trait SchemaFieldType[+T] extends js.Object
package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Cursor Count Options
  * @param skip           The number of documents to skip.
  * @param limit          The maximum amounts to count before aborting.
  * @param maxTimeMS      Number of miliseconds to wait before aborting the query.
  * @param hint           An index name hint for the query.
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
class CursorCountOptions(var skip: js.UndefOr[Int] = js.undefined,
                         var limit: js.UndefOr[Int] = js.undefined,
                         var maxTimeMS: js.UndefOr[Int] = js.undefined,
                         var hint: js.UndefOr[String] = js.undefined,
                         var readPreference: js.UndefOr[ReadPreference | String] = js.undefined) extends js.Object

/**
  * Cursor Count Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CursorCountOptions extends FlexibleOptions[CursorCountOptions]
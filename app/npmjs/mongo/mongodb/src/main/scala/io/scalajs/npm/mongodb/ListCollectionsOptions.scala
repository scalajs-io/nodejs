package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * List Collections Options
  * @param batchSize      The batchSize for the returned command cursor or if pre 2.8 the systems batch collection
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
class ListCollectionsOptions(var batchSize: js.UndefOr[Int] = js.undefined,
                             var readPreference: js.UndefOr[ReadPreference] = js.undefined) extends js.Object

/**
  * List Collections Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ListCollectionsOptions extends FlexibleOptions[ListCollectionsOptions]
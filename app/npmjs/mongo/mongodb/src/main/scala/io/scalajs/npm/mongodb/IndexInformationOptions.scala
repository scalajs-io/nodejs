package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Index Information Options
  * @param full           returns the full raw index information.
  * @param readPreference the preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
class IndexInformationOptions(var full: js.UndefOr[Boolean] = js.undefined,
                              var readPreference: js.UndefOr[ReadPreference] = js.undefined) extends js.Object

/**
  * Index Information Options Companion
  * @author lawrence.daniels@gmail.com
  */
object IndexInformationOptions extends FlexibleOptions[IndexInformationOptions]

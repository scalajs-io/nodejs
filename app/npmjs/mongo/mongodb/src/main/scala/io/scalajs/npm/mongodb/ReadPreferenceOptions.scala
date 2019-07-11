package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Read Preference Options
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
class ReadPreferenceOptions(var readPreference: js.UndefOr[ReadPreference | String] = js.undefined) extends js.Object

/**
  * Read Preference Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ReadPreferenceOptions extends FlexibleOptions[ReadPreferenceOptions]
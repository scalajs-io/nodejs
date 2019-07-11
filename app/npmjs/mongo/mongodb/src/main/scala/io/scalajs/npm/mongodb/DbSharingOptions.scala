package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Database Sharing Options
  * @param noListener              Do not make the db an event listener to the original connection.
  * @param returnNonCachedInstance Control if you want to return a cached instance or have a new one created
  */
class DbSharingOptions(var noListener: js.UndefOr[Boolean] = js.undefined,
                       var returnNonCachedInstance: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Database Sharing Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DbSharingOptions extends FlexibleOptions[DbSharingOptions]
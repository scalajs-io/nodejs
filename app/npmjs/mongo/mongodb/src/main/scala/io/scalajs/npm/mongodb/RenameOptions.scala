package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Rename Options
  * @param dropTarget drop the target name collection if it previously exists.
  */
class RenameOptions(var dropTarget: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Rename Options Companion
  * @author lawrence.daniels@gmail.com
  */
object RenameOptions extends FlexibleOptions[RenameOptions]
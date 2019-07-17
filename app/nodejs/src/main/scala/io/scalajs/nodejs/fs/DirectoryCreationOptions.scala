package io.scalajs.nodejs.fs

import io.scalajs.FlexibleOptions
import io.scalajs.nodejs.FileMode

import scala.scalajs.js

/**
  * Directory Creation Options
  * @param recursive indicates recursive creation
  * @param mode      the file mode
  */
class DirectoryCreationOptions(var recursive: js.UndefOr[Boolean] = js.undefined,
                               var mode: js.UndefOr[FileMode] = js.undefined) extends js.Object

/**
  * Directory Creation Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DirectoryCreationOptions extends FlexibleOptions[DirectoryCreationOptions]
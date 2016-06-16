package org.scalajs.nodejs.multer

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Multer accepts an options object, the most basic of which is the dest property, which tells Multer where to upload
  * the files. In case you omit the options object, the file will be renamed and uploaded to the temporary directory of
  * the system. If the inMemory option is true, no data is written to disk but data is kept in a buffer accessible in
  * the file object.
  *
  * By the default, Multer will rename the files so as to avoid name conflicts. The renaming function can be customized
  * according to your needs.
  *
  * The following are the options that can be passed to Multer.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class MulterOptions(var dest: js.UndefOr[String],
                    var limits: js.UndefOr[MulterLimits],
                    var includeEmptyFields: js.UndefOr[Boolean],
                    var inMemory: js.UndefOr[Boolean],
                    var rename: js.UndefOr[js.Function],
                    var onFileUploadStart: js.UndefOr[js.Function],
                    var onFileUploadData: js.UndefOr[js.Function],
                    var onFileUploadComplete: js.UndefOr[js.Function],
                    var onParseStart: js.UndefOr[js.Function],
                    var onParseEnd: js.UndefOr[js.Function],
                    var onError: js.UndefOr[js.Function],
                    var onFileSizeLimit: js.UndefOr[js.Function],
                    var onFilesLimit: js.UndefOr[js.Function],
                    var onFieldsLimit: js.UndefOr[js.Function],
                    var onPartsLimit: js.UndefOr[js.Function]) extends js.Object

/**
  * Multer Options Companion
  * @author lawrence.daniels@gmail.com
  */
object MulterOptions {

  def apply(dest: js.UndefOr[String] = js.undefined,
            limits: js.UndefOr[MulterLimits] = js.undefined,
            includeEmptyFields: js.UndefOr[Boolean] = js.undefined,
            inMemory: js.UndefOr[Boolean] = js.undefined,
            rename: js.UndefOr[js.Function] = js.undefined,
            onFileUploadStart: js.UndefOr[js.Function] = js.undefined,
            onFileUploadData: js.UndefOr[js.Function] = js.undefined,
            onFileUploadComplete: js.UndefOr[js.Function] = js.undefined,
            onParseStart: js.UndefOr[js.Function] = js.undefined,
            onParseEnd: js.UndefOr[js.Function] = js.undefined,
            onError: js.UndefOr[js.Function] = js.undefined,
            onFileSizeLimit: js.UndefOr[js.Function] = js.undefined,
            onFilesLimit: js.UndefOr[js.Function] = js.undefined,
            onFieldsLimit: js.UndefOr[js.Function] = js.undefined,
            onPartsLimit: js.UndefOr[js.Function] = js.undefined) = {
    new MulterOptions(
      dest, limits, includeEmptyFields, inMemory, rename,
      onFileUploadStart, onFileUploadData, onFileUploadComplete, onParseStart, onParseEnd, onError,
      onFileSizeLimit, onFilesLimit, onFieldsLimit, onPartsLimit
    )
  }

}

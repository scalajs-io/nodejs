package io.scalajs.npm.express.multer

import scala.scalajs.js


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

class MulterOptions(var dest: js.UndefOr[String] = js.undefined,
                    var limits: js.UndefOr[MulterLimits] = js.undefined,
                    var includeEmptyFields: js.UndefOr[Boolean] = js.undefined,
                    var inMemory: js.UndefOr[Boolean] = js.undefined,
                    var rename: js.UndefOr[js.Function] = js.undefined,
                    var onFileUploadStart: js.UndefOr[js.Function] = js.undefined,
                    var onFileUploadData: js.UndefOr[js.Function] = js.undefined,
                    var onFileUploadComplete: js.UndefOr[js.Function] = js.undefined,
                    var onParseStart: js.UndefOr[js.Function] = js.undefined,
                    var onParseEnd: js.UndefOr[js.Function] = js.undefined,
                    var onError: js.UndefOr[js.Function] = js.undefined,
                    var onFileSizeLimit: js.UndefOr[js.Function] = js.undefined,
                    var onFilesLimit: js.UndefOr[js.Function] = js.undefined,
                    var onFieldsLimit: js.UndefOr[js.Function] = js.undefined,
                    var onPartsLimit: js.UndefOr[js.Function] = js.undefined)
    extends js.Object

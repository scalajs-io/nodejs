package io.scalajs.npm.express

import scala.scalajs.js

/**
  * multer package object
  * @author lawrence.daniels@gmail.com
  */
package object multer {

  /**
    * Multer Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class MulterExtensions(val multer: Multer) extends AnyVal {

    /**
      * @example multer.withOptions(dest = "/tmp")
      */
    def withOptions(dest: js.UndefOr[String] = js.undefined,
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
                    onPartsLimit: js.UndefOr[js.Function] = js.undefined): MulterInstance = {
      multer.apply(
        new MulterOptions(
          dest,
          limits,
          includeEmptyFields,
          inMemory,
          rename,
          onFileUploadStart,
          onFileUploadData,
          onFileUploadComplete,
          onParseStart,
          onParseEnd,
          onError,
          onFileSizeLimit,
          onFilesLimit,
          onFieldsLimit,
          onPartsLimit
        ))
    }

  }

}

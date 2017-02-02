package io.scalajs.npm.express.multer

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * An object specifying the size limits of the following optional properties. This object is passed to busboy directly,
  * and the details of properties can be found on <a href="https://github.com/mscdex/busboy#busboy-methods">busboy's page</a>.
  * @param fieldNameSize Max field name size (Default: 100 bytes)
  * @param fieldSize     Max field value size (Default: 1MB)
  * @param fields        Max number of non-file fields (Default: Infinity)
  * @param fileSize      For multipart forms, the max file size (in bytes) (Default: Infinity)
  * @param files         For multipart forms, the max number of file fields (Default: Infinity)
  * @param parts         For multipart forms, the max number of parts (fields + files) (Default: Infinity)
  * @param headerPairs   For multipart forms, the max number of header key=>value pairs to parse Default: 2000 (same as node's http).
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class MulterLimits(var fieldNameSize: js.UndefOr[Int],
                   var fieldSize: js.UndefOr[Int],
                   var fields: js.UndefOr[Int],
                   var fileSize: js.UndefOr[Int],
                   var files: js.UndefOr[Int],
                   var parts: js.UndefOr[Int],
                   var headerPairs: js.UndefOr[Int])
    extends js.Object

/**
  * Multer Limits Companion
  * @author lawrence.daniels@gmail.com
  */
object MulterLimits {

  def apply(fieldNameSize: js.UndefOr[Int] = js.undefined,
            fieldSize: js.UndefOr[Int] = js.undefined,
            fields: js.UndefOr[Int] = js.undefined,
            fileSize: js.UndefOr[Int] = js.undefined,
            files: js.UndefOr[Int] = js.undefined,
            parts: js.UndefOr[Int] = js.undefined,
            headerPairs: js.UndefOr[Int] = js.undefined) = {
    new MulterLimits(fieldNameSize, fieldSize, fields, fileSize, files, parts, headerPairs)
  }

}

package io.scalajs.npm.express.fileupload

import scala.scalajs.js
import scala.scalajs.js.|

/**
 * Express.js File Upload Options
 * @param createParentPath
 * @param limits
 * @param preserveExtension
 * @param safeFileNames
 * @param tempFileDir
 * @param parseNested By default, req.body and req.files are flattened like this: {'name': 'John', 'hobbies[0]': 'Cinema', 'hobbies[1]': 'Bike'}
 *                    When this option is enabled they are parsed in order to be nested like this: {'name': 'John', 'hobbies': ['Cinema', 'Bike']}
 * @param uriDecodeFileNames
 * @param useTempFiles
 * @see [[https://www.npmjs.com/package/express-fileupload]]
 * @author lawrence.daniels@gmail.com
 */
class FileUploadOptions(val abortOnLimit: js.UndefOr[Int] = js.undefined,
                        val createParentPath: js.UndefOr[Boolean] = js.undefined,
                        val limitHandler: js.Any = js.undefined,
                        val limits: js.UndefOr[Double] = js.undefined,
                        val preserveExtension: js.UndefOr[Boolean] = js.undefined,
                        val responseOnLimit: js.UndefOr[String] = js.undefined,
                        val safeFileNames: js.UndefOr[Boolean | String] = js.undefined,
                        val tempFileDir: js.UndefOr[String] = js.undefined,
                        val parseNested: js.UndefOr[Boolean] = js.undefined,
                        val debug: js.UndefOr[Boolean] = js.undefined,
                        val uriDecodeFileNames: js.UndefOr[Double] = js.undefined,
                        val useTempFiles: js.UndefOr[Boolean] = js.undefined) extends js.Object
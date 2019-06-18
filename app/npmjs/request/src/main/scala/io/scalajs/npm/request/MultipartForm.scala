package io.scalajs.npm.request

import scala.scalajs.js


/**
  * Represents a multipart form
  * @author lawrence.daniels@gmail.com
  */

class MultipartForm(var method: js.UndefOr[String] = js.undefined,
                    var preambleCRLF: js.UndefOr[Boolean] = js.undefined,
                    var postambleCRLF: js.UndefOr[Boolean] = js.undefined,
                    var uri: js.UndefOr[String] = js.undefined,
                    var multipart: js.Any = js.undefined)
  extends js.Object

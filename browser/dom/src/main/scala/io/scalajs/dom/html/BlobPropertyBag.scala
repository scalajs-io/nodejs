package io.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Blob Property Bag
  * @param `type`  with a default value of "", that represents the MIME type of the content of the array that will be
  *                put in the blob.
  * @param endings with a default value of "transparent", that specifies how strings containing the line ending character \n
  *                are to be written out. It is one of the two values: "native", meaning that line ending characters are
  *                changed to match host OS filesystem convention, or "transparent", meaning that endings are stored in
  *                the blob without change.
  * lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class BlobPropertyBag(var `type`: js.UndefOr[String] = js.undefined,
                      var endings: js.UndefOr[String] = js.undefined) extends js.Object
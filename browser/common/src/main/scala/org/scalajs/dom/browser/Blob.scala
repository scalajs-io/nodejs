package org.scalajs.dom.browser

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The Blob() constructor returns a new Blob object. The content of the blob consists of the concatenation of the
  * values given in the parameter array.
  * @param array   is an Array of ArrayBuffer, ArrayBufferView, Blob, DOMString objects, or a mix of any of such objects,
  *                that will be put inside the Blob.
  * @param options is an optional BlobPropertyBag dictionary which may specify the following two attributes
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Blob(array: js.Array[_], options: BlobOptions | js.Dictionary[_] = null) extends BlobLike
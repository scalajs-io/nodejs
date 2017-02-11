package io.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The Blob() constructor returns a new Blob object. The content of the blob consists of the concatenation of the
  * values given in the parameter array.
  * @param blobParts is an Array of ArrayBuffer, ArrayBufferView, Blob, DOMString objects, or a mix of any of such objects,
  *                  that will be put inside the Blob.
  * @param options   is an optional BlobPropertyBag dictionary which may specify the following two attributes
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Blob(blobParts: js.Array[_], options: BlobPropertyBag | js.Dictionary[_] = js.native) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A boolean value, indicating whether the Blob.close() method has been called on the blob. Closed blobs can not be read.
    */
  def isClosed: Boolean = js.native

  /**
    * The size, in bytes, of the data contained in the Blob object.
    */
  def size: Int = js.native

  /**
    * The size, in bytes, of the data contained in the Blob object.
    */
  def `type`: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Closes the blob object, possibly freeing underlying resources.
    */
  def close(): Unit = js.native

  /**
    * Returns a new Blob object containing the data in the specified range of bytes of the source Blob.
    * @param start       An index into the Blob indicating the first byte to include in the new Blob. If you specify a
    *                    negative value, it's treated as an offset from the end of the string toward the beginning.
    *                    For example, -10 would be the 10th from last byte in the Blob. The default value is 0. If you
    *                    specify a value for start that is larger than the size of the source Blob, the returned Blob has
    *                    size 0 and contains no data.
    * @param end         An index into the Blob indicating the first byte that will *not* be included in the new Blob
    *                    (i.e. the byte exactly at this index is not included). If you specify a negative value, it's treated
    *                    as an offset from the end of the string toward the beginning. For example, -10 would be the 10th from
    *                    last byte in the Blob. The default value is size.
    * @param contentType The content type to assign to the new Blob; this will be the value of its type property.
    *                    The default value is an empty string.
    * @return A new Blob object containing the specified data from the source Blob.
    * @example {{{ var blob = instanceOfBlob.slice([start [, end [, contentType]]]); }}}
    */
  def slice(start: Int = js.native, end: Int = js.native, contentType: String = js.native): Blob = js.native

}
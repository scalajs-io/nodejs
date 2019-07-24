package io.scalajs.nodejs.util

import io.scalajs.FlexibleOptions
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.DataView
import scala.scalajs.js.|

/**
  * An implementation of the WHATWG Encoding Standard TextDecoder API.
  * @param encoding Identifies the encoding that this TextDecoder instance supports. Default: 'utf-8'.
  * @param options the [[TextDecoderOptions options]]
  * @since 8.3.0
  * @see https://encoding.spec.whatwg.org/
  */
@js.native
@JSImport("util", "TextDecoder")
class TextDecoder(encoding: String, options: TextDecoderOptions) extends js.Object {

  /**
    * Default Constructor
    */
  def this() = this(null, null)

  /**
    * Constructor
    * @param encoding Identifies the encoding that this TextDecoder instance supports. Default: 'utf-8'.
    */
  def this(encoding: String) = this(encoding, null)

  /**
    * Constructor
    * @param options the given [[TextDecoderOptions options]]
    */
  def this(options: TextDecoderOptions) = this(null, options)

  def decode(): String = js.native

  def decode(input: Buffer | DataView, options: TextDecoderOptions): String = js.native

}

/**
  * Text Decoder Options
  * @param fatal     true if decoding failures are fatal. This option is only supported when ICU is enabled
  *                  (see Internationalization). Default: false.
  * @param ignoreBOM When true, the TextDecoder will include the byte order mark in the decoded result.
  *                  When false, the byte order mark will be removed from the output. This option is only used
  *                  when encoding is 'utf-8', 'utf-16be' or 'utf-16le'. Default: false.
  * @param stream    true if additional chunks of data are expected. Default: false.
  */
class TextDecoderOptions(var fatal: js.UndefOr[Boolean] = js.undefined,
                         var ignoreBOM: js.UndefOr[Boolean] = js.undefined,
                         var stream: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Text Decoder Options Singleton
  * @author lawrence.daniels@gmail.com
  */
object TextDecoderOptions extends FlexibleOptions[InspectOptions]
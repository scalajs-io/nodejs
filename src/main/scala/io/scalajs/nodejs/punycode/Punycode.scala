package io.scalajs.nodejs.punycode

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The version of the punycode module bundled in Node.js is being deprecated. In a future major version of Node.js
  * this module will be removed. Users currently depending on the punycode module should switch to using the
  * userland-provided Punycode.js module instead.
  * @see https://nodejs.org/dist/latest-v7.x/docs/api/punycode.html
  */
@js.native
trait Punycode extends js.Object {

  /**
    * The punycode.decode() method converts a Punycode string of ASCII-only characters to the equivalent
    * string of Unicode codepoints.
    * @param string a Punycode string of ASCII-only characters
    * @return the equivalent string of Unicode codepoints.
    */
  def decode(string: String): String = js.native

  /**
    * The punycode.encode() method converts a string of Unicode codepoints to a Punycode string of ASCII-only characters.
    * @param codePoints a string of Unicode codepoints
    * @return a Punycode string of ASCII-only characters.
    */
  def encode(codePoints: String): String = js.native

  /**
    * The punycode.toASCII() method converts a Unicode string representing an Internationalized Domain Name to Punycode.
    * Only the non-ASCII parts of the domain name will be converted. Calling punycode.toASCII() on a string that already
    * only contains ASCII characters will have no effect.
    * @param domain the domain name
    * @return a Unicode string representing an Internationalized Domain Name as Punycode
    */
  def toASCII(domain: String): String = js.native

  /**
    * The punycode.toUnicode() method converts a string representing a domain name containing Punycode encoded
    * characters into Unicode. Only the Punycode encoded parts of the domain name are be converted.
    * @param domain a string representing a domain name containing Punycode encoded characters
    * @return the Unicode string
    */
  def toUnicode(domain: String): String = js.native

  /**
    * The UCS2 object
    * @return The [[UCS2 UCS2]] object
    */
  def ucs2: UCS2 = js.native

  /**
    * Returns a string identifying the current Punycode.js version number.
    * @return a string identifying the current Punycode.js version number.
    */
  def version: String = js.native

}

/**
  * Punycode.UCS2
  * @see https://nodejs.org/dist/latest-v7.x/docs/api/punycode.html
  */
@js.native
trait UCS2 extends js.Object {

  /**
    * The punycode.ucs2.decode() method returns an array containing the numeric codepoint values of each Unicode
    * symbol in the string.
    * @param string the string containing Unicode symbols
    * @return an array containing the numeric codepoint values of each Unicode symbol
    */
  def decode(string: String): js.Array[Int] = js.native

  /**
    * The punycode.ucs2.encode() method returns a string based on an array of numeric code point values.
    * @param codePoints an array of numeric code point values
    * @return a string based on an array of numeric code point values
    */
  def encode(codePoints: js.Array[Int]): String = js.native

}

@js.native
@JSImport("punycode", JSImport.Namespace)
object Punycode extends Punycode

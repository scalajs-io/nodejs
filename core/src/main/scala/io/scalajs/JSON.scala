package io.scalajs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * The JSON object contains methods for parsing JavaScript Object Notation (JSON) and converting values to JSON.
  * It can't be called or constructed, and aside from its two method properties it has no interesting functionality of its own.
  * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JSON extends js.Object {

  /**
    * The JSON.parse() method parses a JSON string, constructing the JavaScript value or object described by the string.
    * An optional reviver function can be provided to perform a transformation on the resulting object before it is returned.
    * @param text    The string to parse as JSON. See the JSON object for a description of JSON syntax.
    * @param reviver Optional: If a function, prescribes how the value originally produced by parsing is transformed,
    *                before being returned.
    * @return The Object corresponding to the given JSON text.
    */
  def parse(text: String, reviver: js.Function = js.native): js.Any = js.native

  /**
    * The JSON.stringify() method converts a JavaScript value to a JSON string, optionally replacing values
    * if a replacer function is specified, or optionally including only the specified properties if a replacer
    * array is specified.
    * @param value    The value to convert to a JSON string.
    * @param replacer Optional: A function that alters the behavior of the stringification process, or an array
    *                 of String and Number objects that serve as a whitelist for selecting/filtering the properties
    *                 of the value object to be included in the JSON string. If this value is null or not provided,
    *                 all properties of the object are included in the resulting JSON string.
    * @param space    Optional: A String or Number object that's used to insert white space into the output JSON string
    *                 for readability purposes. If this is a Number, it indicates the number of space characters to use
    *                 as white space; this number is capped at 10 if it's larger than that. Values less than 1 indicate
    *                 that no space should be used. If this is a String, the string (or the first 10 characters of the
    *                 string, if it's longer than that) is used as white space. If this parameter is not provided
    *                 (or is null), no white space is used.
    * @return A JSON string representing the given value.
    */
  def stringify(value: js.Any, replacer: js.Function = js.native, space: String | Int = js.native): String = js.native

}

/**
  * JSON Singleton Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("JSON")
object JSON extends JSON
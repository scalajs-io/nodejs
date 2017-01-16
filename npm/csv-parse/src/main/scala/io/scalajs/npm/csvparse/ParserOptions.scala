package io.scalajs.npm.csvparse

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Parser Options
  * @param delimiter              Set the field delimiter. One character only. Defaults to "," (comma).
  * @param  rowDelimiter          String used to delimit record rows or a special constant; special constants are
  *                               'auto', 'unix', 'mac', 'windows', 'unicode'; defaults to 'auto' (discovered in
  *                               source or 'unix' if no source is specified).
  * @param quote                  Optional: character surrounding a field. One character only. Defaults to double quote.
  * @param escape                 Set the escape character. One character only. Defaults to double quote.
  * @param  columns               (array|boolean|function) List of fields as an array, a user defined callback accepting
  *                               the first line and returning the column names, or true if autodiscovered in the first
  *                               CSV line. Defaults to null. Affects the result data set in the sense that records will
  *                               be objects instead of arrays.
  * @param  comment               Treat all the characters after this one as a comment. Defaults to '' (disabled).
  * @param  objname               Name of header-record title to name objects by.
  * @param relax                  Preserve quotes inside unquoted field.
  * @param relax_column_count     Discard inconsistent columns count. Default to false.
  * @param skip_empty_lines       Don't generate empty values for empty lines.
  * @param max_limit_on_data_read Maximum numer of characters to be contained in the field and line buffers before an
  *                               exception is raised. Used to guard against a wrong delimiter or rowDelimiter. Default
  *                               to 128,000 characters.
  * @param trim                   If true, ignore whitespace immediately around the delimiter. Defaults to false. Does
  *                               not remove whitespace in a quoted field.
  * @param ltrim                  If true, ignore whitespace immediately following the delimiter (i.e. left-trim all
  *                               fields). Defaults to false. Does not remove whitespace in a quoted field.
  * @param rtrim                  If true, ignore whitespace immediately preceding the delimiter (i.e. right-trim all
  *                               fields). Defaults to false. Does not remove whitespace in a quoted field.
  * @param auto_parse             If true, the parser will attempt to convert input string to native types.
  * @param  auto_parse_date       If true, the parser will attempt to convert input string to dates. It requires the
  *                               "auto_parse" option. Be careful, it relies on Date.parse.
  * @author lawrence.daniels@gmail.com
  **/
@ScalaJSDefined
class ParserOptions(var delimiter: js.UndefOr[String] = js.undefined,
                    var rowDelimiter: js.UndefOr[String] = js.undefined,
                    var quote: js.UndefOr[String] = js.undefined,
                    var escape: js.UndefOr[String] = js.undefined,
                    var columns: js.UndefOr[js.Array[String] | js.Function] = js.undefined,
                    var comment: js.UndefOr[String] = js.undefined,
                    var objname: js.UndefOr[String] = js.undefined,
                    var relax: js.UndefOr[Boolean] = js.undefined,
                    var relax_column_count: js.UndefOr[Boolean] = js.undefined,
                    var skip_empty_lines: js.UndefOr[Boolean] = js.undefined,
                    var max_limit_on_data_read: js.UndefOr[Int] = js.undefined,
                    var trim: js.UndefOr[Boolean] = js.undefined,
                    var ltrim: js.UndefOr[Boolean] = js.undefined,
                    var rtrim: js.UndefOr[Boolean] = js.undefined,
                    var auto_parse: js.UndefOr[Boolean] = js.undefined,
                    var auto_parse_date: js.UndefOr[Boolean] = js.undefined) extends js.Object
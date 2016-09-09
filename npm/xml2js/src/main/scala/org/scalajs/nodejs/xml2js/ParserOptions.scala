package org.scalajs.nodejs.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js Parser Options
  * @param attrkey               (default: $): Prefix that is used to access the attributes. Version 0.1 default was @.
  * @param charkey               (default: _): Prefix that is used to access the character content. Version 0.1 default was #.
  * @param explicitCharkey       (default: false)
  * @param trim                  (default: false): Trim the whitespace at the beginning and end of text nodes.
  * @param normalizeTags         (default: false): Normalize all tag names to lowercase.
  * @param normalize             (default: false): Trim whitespaces inside text nodes.
  * @param explicitRoot          (default: true): Set this if you want to get the root node in the resulting object.
  * @param emptyTag              (default: ""): what will the value of empty nodes be.
  * @param explicitArray         (default: true): Always put child nodes in an array if true; otherwise an array is
  *                              created only if there is more than one.
  * @param ignoreAttrs           (default: false): Ignore all XML attributes and only create text nodes.
  * @param mergeAttrs            (default: false): Merge attributes and child elements as properties of the parent,
  *                              instead of keying attributes off a child attribute object. This option is ignored if
  *                              ignoreAttrs is false.
  * @param validator             (default null): You can specify a callable that validates the resulting structure somehow,
  *                              however you want. See unit tests for an example.
  * @param xmlns                 (default false): Give each element a field usually called '$ns' (the first character is
  *                              the same as attrkey) that contains its local name and namespace URI.
  * @param explicitChildren      (default false): Put child elements to separate property. Doesn't work with
  *                              mergeAttrs = true. If element has no children then "children" won't be created. Added in 0.2.5.
  * @param childkey              (default $$): Prefix that is used to access child elements if explicitChildren is set to true.
  *                              Added in 0.2.5.
  * @param preserveChildrenOrder (default false): Modifies the behavior of explicitChildren so that the value of
  *                              the "children" property becomes an ordered array. When this is true, every node
  *                              will also get a #name field whose value will correspond to the XML nodeName, so
  *                              that you may iterate the "children" array and still be able to determine node names.
  *                              The named (and potentially unordered) properties are also retained in this configuration
  *                              at the same level as the ordered "children" array. Added in 0.4.9.
  * @param charsAsChildren       (default false): Determines whether chars should be considered children if explicitChildren
  *                              is on. Added in 0.2.5.
  * @param async                 (default false): Should the callbacks be async? This might be an incompatible change if
  *                              your code depends on sync execution of callbacks. Future versions of xml2js might change
  *                              this default, so the recommendation is to not depend on sync execution anyway. Added in 0.2.6.
  * @param strict                (default true): Set sax-js to strict or non-strict parsing mode. Defaults to true which
  *                              is highly recommended, since parsing HTML which is not well-formed XML might yield just
  *                              about anything. Added in 0.2.7.
  * @param attrNameProcessors    (default: null): Allows the addition of attribute name processing functions. Accepts an
  *                              Array of functions with following signature
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ParserOptions(var attrkey: js.UndefOr[String] = js.undefined,
                    var charkey: js.UndefOr[String] = js.undefined,
                    var explicitCharkey: js.UndefOr[Boolean] = js.undefined,
                    var trim: js.UndefOr[Boolean] = js.undefined,
                    var normalizeTags: js.UndefOr[Boolean] = js.undefined,
                    var normalize: js.UndefOr[Boolean] = js.undefined,
                    var explicitRoot: js.UndefOr[Boolean] = js.undefined,
                    var emptyTag: js.UndefOr[String] = js.undefined,
                    var explicitArray: js.UndefOr[Boolean] = js.undefined,
                    var ignoreAttrs: js.UndefOr[Boolean] = js.undefined,
                    var mergeAttrs: js.UndefOr[Boolean] = js.undefined,
                    var validator: js.UndefOr[js.Any] = js.undefined,
                    var xmlns: js.UndefOr[Boolean] = js.undefined,
                    var explicitChildren: js.UndefOr[Boolean] = js.undefined,
                    var childkey: js.UndefOr[String] = js.undefined,
                    var preserveChildrenOrder: js.UndefOr[Boolean] = js.undefined,
                    var charsAsChildren: js.UndefOr[Boolean] = js.undefined,
                    var async: js.UndefOr[Boolean] = js.undefined,
                    var strict: js.UndefOr[Boolean] = js.undefined,
                    var attrNameProcessors: js.UndefOr[Boolean] = js.undefined) extends js.Object

package com.github.ldaniels528.meansjs.nodejs.xml2js

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * NodeJS/xml2js Parser Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ParserOptions extends js.Object {
  // (default: $): Prefix that is used to access the attributes. Version 0.1 default was @.
  var attrkey: js.UndefOr[String] = _

  // (default: _): Prefix that is used to access the character content. Version 0.1 default was #.
  var charkey: js.UndefOr[String] = _

  // (default: false)
  var explicitCharkey: js.UndefOr[Boolean] = _

  // (default: false): Trim the whitespace at the beginning and end of text nodes.
  var trim: js.UndefOr[Boolean] = _

  // (default: false): Normalize all tag names to lowercase.
  var normalizeTags: js.UndefOr[Boolean] = _

  // (default: false): Trim whitespaces inside text nodes.
  var normalize: js.UndefOr[Boolean] = _

  // (default: true): Set this if you want to get the root node in the resulting object.
  var explicitRoot: js.UndefOr[Boolean] = _

  // (default: ''): what will the value of empty nodes be.
  var emptyTag: js.UndefOr[String] = _

  // (default: true): Always put child nodes in an array if true; otherwise an array is created only if there is more than one.
  var explicitArray: js.UndefOr[Boolean] = _

  // (default: false): Ignore all XML attributes and only create text nodes.
  var ignoreAttrs: js.UndefOr[Boolean] = _

  // (default: false): Merge attributes and child elements as properties of the parent, instead of keying attributes off a child attribute object. This option is ignored if ignoreAttrs is false.
  var mergeAttrs: js.UndefOr[Boolean] = _

  // (default null): You can specify a callable that validates the resulting structure somehow, however you want. See unit tests for an example.
  var validator: js.UndefOr[js.Any] = _

  // (default false): Give each element a field usually called '$ns' (the first character is the same as attrkey) that contains its local name and namespace URI.
  var xmlns: js.UndefOr[Boolean] = _

  // (default false): Put child elements to separate property. Doesn't work with mergeAttrs = true. If element has no children then "children" won't be created. Added in 0.2.5.
  var explicitChildren: js.UndefOr[Boolean] = _

  // (default $$): Prefix that is used to access child elements if explicitChildren is set to true. Added in 0.2.5.
  var childkey: js.UndefOr[String] = _

  // (default false): Modifies the behavior of explicitChildren so that the value of the "children" property becomes an ordered array. When this is true, every node will also get a #name field whose value will correspond to the XML nodeName, so that you may iterate the "children" array and still be able to determine node names. The named (and potentially unordered) properties are also retained in this configuration at the same level as the ordered "children" array. Added in 0.4.9.
  var preserveChildrenOrder: js.UndefOr[Boolean] = _

  // (default false): Determines whether chars should be considered children if explicitChildren is on. Added in 0.2.5.
  var charsAsChildren: js.UndefOr[Boolean] = _

  // (default false): Should the callbacks be async? This might be an incompatible change if your code depends on sync execution of callbacks. Future versions of xml2js might change this default, so the recommendation is to not depend on sync execution anyway. Added in 0.2.6.
  var async: js.UndefOr[Boolean] = _

  // (default true): Set sax-js to strict or non-strict parsing mode. Defaults to true which is highly recommended, since parsing HTML which is not well-formed XML might yield just about anything. Added in 0.2.7.
  var strict: js.UndefOr[Boolean] = _

  // (default: null): Allows the addition of attribute name processing functions. Accepts an Array of functions with following signature
  var attrNameProcessors: js.UndefOr[Boolean] = _

}

/**
  * Parser Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ParserOptions {

  def apply(attrkey: js.UndefOr[String] = js.undefined,
            charkey: js.UndefOr[String] = js.undefined,
            explicitCharkey: js.UndefOr[Boolean] = js.undefined,
            trim: js.UndefOr[Boolean] = js.undefined,
            normalizeTags: js.UndefOr[Boolean] = js.undefined,
            normalize: js.UndefOr[Boolean] = js.undefined,
            explicitRoot: js.UndefOr[Boolean] = js.undefined,
            emptyTag: js.UndefOr[String] = js.undefined,
            explicitArray: js.UndefOr[Boolean] = js.undefined,
            ignoreAttrs: js.UndefOr[Boolean] = js.undefined,
            mergeAttrs: js.UndefOr[Boolean] = js.undefined,
            validator: js.UndefOr[js.Any] = js.undefined,
            xmlns: js.UndefOr[Boolean] = js.undefined,
            explicitChildren: js.UndefOr[Boolean] = js.undefined,
            childkey: js.UndefOr[String] = js.undefined,
            preserveChildrenOrder: js.UndefOr[Boolean] = js.undefined,
            charsAsChildren: js.UndefOr[Boolean] = js.undefined,
            async: js.UndefOr[Boolean] = js.undefined,
            strict: js.UndefOr[Boolean] = js.undefined,
            attrNameProcessors: js.UndefOr[Boolean] = js.undefined) = {
    val options = new ParserOptions()
    options.attrkey = attrkey
    options.charkey = charkey
    options.explicitCharkey = explicitCharkey
    options.trim = trim
    options.normalizeTags = normalizeTags
    options.normalize = normalize
    options.explicitRoot = explicitRoot
    options.emptyTag = emptyTag
    options.explicitArray = explicitArray
    options.ignoreAttrs = ignoreAttrs
    options.mergeAttrs = mergeAttrs
    options.validator = validator
    options.xmlns = xmlns
    options.explicitChildren = explicitChildren
    options.childkey = childkey
    options.preserveChildrenOrder = preserveChildrenOrder
    options.charsAsChildren = charsAsChildren
    options.async = async
    options.strict = strict
    options.attrNameProcessors = attrNameProcessors
    options
  }
}

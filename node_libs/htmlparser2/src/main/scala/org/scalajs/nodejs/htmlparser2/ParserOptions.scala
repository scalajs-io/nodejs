package org.scalajs.nodejs.htmlparser2

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Parser Options
  * @param decodeEntities          If set to true, entities within the document will be decoded. Defaults to false.
  * @param lowerCaseTags           If set to true, all tags will be lowercased. If xmlMode is disabled, this defaults to true.
  * @param lowerCaseAttributeNames If set to true, all attribute names will be lowercased. This has noticeable impact on
  *                                speed, so it defaults to false.
  * @param recognizeCDATA          If set to true, CDATA sections will be recognized as text even if the xmlMode option is not enabled.
  *                                NOTE: If xmlMode is set to true then CDATA sections will always be recognized as text.
  * @param recognizeSelfClosing    If set to true, self-closing tags will trigger the onclosetag event even if xmlMode is not set to true.
  *                                NOTE: If xmlMode is set to true then self-closing tags will always be recognized.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ParserOptions(var decodeEntities: js.UndefOr[Boolean] = js.undefined,
                    var lowerCaseTags: js.UndefOr[Boolean] = js.undefined,
                    var lowerCaseAttributeNames: js.UndefOr[Boolean] = js.undefined,
                    var recognizeCDATA: js.UndefOr[Boolean] = js.undefined,
                    var recognizeSelfClosing: js.UndefOr[Boolean] = js.undefined) extends js.Object

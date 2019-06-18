package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Text Style Options
  * @param font            The style and size of the font.
  * @param fontStyle       The style of the font (eg. 'italic'): overrides the value in style.font.
  * @param fontVariant     The variant of the font (eg. 'small-caps'): overrides the value in style.font.
  * @param fontWeight      The weight of the font (eg. 'bold'): overrides the value in style.font
  * @param fontSize        The size of the font (eg. 32 or '32px'): overrides the value in style.font.
  * @param backgroundColor A canvas fillstyle that will be used as the background for the whole Text object.
  *                        Set to null to disable.
  * @param fill            A canvas fillstyle that will be used on the text eg 'red', '#00FF00'.
  * @param align           Horizontal alignment of each line in multiline text. Can be: 'left', 'center' or 'right'.
  *                        Does not affect single lines of text (see textBounds and boundsAlignH for that).
  * @param boundsAlignH    Horizontal alignment of the text within the textBounds. Can be: 'left', 'center' or 'right'.
  * @param boundsAlignV    Vertical alignment of the text within the textBounds. Can be: 'top', 'middle' or 'bottom'.
  * @param stroke          A canvas stroke style that will be used on the text stroke eg 'blue', '#FCFF00'.
  * @param strokeThickness A number that represents the thickness of the stroke. Default is 0 (no stroke).
  * @param wordWrap        Indicates if word wrap should be used.
  * @param wordWrapWidth   The width in pixels at which text will wrap.
  * @param maxLines        The maximum number of lines to be shown for wrapped text.
  * @param tabs            The size (in pixels) of the tabs, for when text includes tab characters.
  *                        0 disables. Can be an array of varying tab sizes, one per tab stop.
  */
class StyleOptions(var font: js.UndefOr[String] = js.undefined,
                   var fontStyle: js.UndefOr[String] = js.undefined,
                   var fontVariant: js.UndefOr[String] = js.undefined,
                   var fontWeight: js.UndefOr[String] = js.undefined,
                   var fontSize: js.UndefOr[String | JsNumber] = js.undefined,
                   var backgroundColor: js.UndefOr[String] = js.undefined,
                   var fill: js.UndefOr[String] = js.undefined,
                   var align: js.UndefOr[String] = js.undefined,
                   var boundsAlignH: js.UndefOr[String] = js.undefined,
                   var boundsAlignV: js.UndefOr[String] = js.undefined,
                   var stroke: js.UndefOr[String] = js.undefined,
                   var strokeThickness: js.UndefOr[String] = js.undefined,
                   var wordWrap: js.UndefOr[Boolean] = js.undefined,
                   var wordWrapWidth: js.UndefOr[JsNumber] = js.undefined,
                   var maxLines: js.UndefOr[JsNumber] = js.undefined,
                   var tabs: js.UndefOr[JsNumber] = js.undefined) extends js.Object
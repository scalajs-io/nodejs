package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * A Text Object will create a line or multiple lines of text. To split a line you can use '\n' in your text string,
  * or add a wordWrap property set to true and and wordWrapWidth property with a value in the style object.
  * @param font               default 'bold 20px Arial' The style and size of the font
  * @param fill               A canvas fillstyle that will be used on the text e.g 'red', '#00FF00'
  * @param align              Alignment for multiline text ('left', 'center' or 'right'), does not affect single line text
  * @param stroke             A canvas fillstyle that will be used on the text stroke e.g 'blue', '#FCFF00'
  * @param strokeThickness    A number that represents the thickness of the stroke. Default is 0 (no stroke)
  * @param wordWrap           Indicates if word wrap should be used
  * @param wordWrapWidth      The width at which text will wrap, it needs wordWrap to be set to true
  * @param lineHeight         The line height, a number that represents the vertical space that a letter uses
  * @param dropShadow         Set a drop shadow for the text
  * @param dropShadowColor    A fill style to be used on the dropshadow e.g 'red', '#00FF00'
  * @param dropShadowAngle    Set a angle of the drop shadow
  * @param dropShadowDistance Set a distance of the drop shadow
  * @param padding            Occasionally some fonts are cropped on top or bottom. Adding some padding will prevent
  *                           this from happening by adding padding to the top and bottom of text height.
  * @param textBaseline       The baseline of the text that is rendered.
  * @param lineJoin           The lineJoin property sets the type of corner created, it can resolve spiked text issues.
  *                           Default is 'miter' (creates a sharp corner).
  * @param miterLimit         The miter limit to use when using the 'miter' lineJoin mode. This can reduce or increase
  *                           the spikiness of rendered text.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class TextStyleOptions(var font: js.UndefOr[String] = js.undefined,
                       var fill: js.UndefOr[String | Double] = js.undefined,
                       var align: js.UndefOr[String] = js.undefined,
                       var stroke: js.UndefOr[String | Double] = js.undefined,
                       var strokeThickness: js.UndefOr[LineWidth] = js.undefined,
                       var wordWrap: js.UndefOr[Boolean] = js.undefined,
                       var wordWrapWidth: js.UndefOr[Int] = js.undefined,
                       var lineHeight: js.UndefOr[Int] = js.undefined,
                       var dropShadow: js.UndefOr[Boolean] = js.undefined,
                       var dropShadowColor: js.UndefOr[String] = js.undefined,
                       var dropShadowAngle: js.UndefOr[Double] = js.undefined,
                       var dropShadowDistance: js.UndefOr[Int] = js.undefined,
                       var padding: js.UndefOr[Padding] = js.undefined,
                       var textBaseline: js.UndefOr[String] = js.undefined,
                       var lineJoin: js.UndefOr[String] = js.undefined,
                       var miterLimit: js.UndefOr[Int] = js.undefined) extends js.Object
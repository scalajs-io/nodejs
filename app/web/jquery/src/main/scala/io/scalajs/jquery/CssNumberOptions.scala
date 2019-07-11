package io.scalajs.jquery

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * CSS Number Options
  * @param zIndex
  * @param fontWeight
  * @param opacity
  * @param zoom
  * @param lineHeight
  * @param widows      (added in jQuery 1.6)
  * @param orphans     (added in jQuery 1.6)
  * @param fillOpacity (added in jQuery 1.6.2)
  * @param columnCount (added in jQuery 1.9)
  * @param order       (added in jQuery 1.10.2)
  * @param flexGrow    (added in jQuery 1.11.1)
  * @param flexShrink  (added in jQuery 1.11.1)
  */
class CssNumberOptions(var zIndex: js.UndefOr[String] = js.undefined,
                       var fontWeight: js.UndefOr[String] = js.undefined,
                       var opacity: js.UndefOr[String] = js.undefined,
                       var zoom: js.UndefOr[String] = js.undefined,
                       var lineHeight: js.UndefOr[String] = js.undefined,
                       var widows: js.UndefOr[String] = js.undefined,
                       var orphans: js.UndefOr[String] = js.undefined,
                       var fillOpacity: js.UndefOr[String] = js.undefined,
                       var columnCount: js.UndefOr[String] = js.undefined,
                       var order: js.UndefOr[String] = js.undefined,
                       var flexGrow: js.UndefOr[String] = js.undefined,
                       var flexShrink: js.UndefOr[String] = js.undefined)
  extends js.Object

/**
  * CSS Number Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CssNumberOptions extends FlexibleOptions[CssNumberOptions]
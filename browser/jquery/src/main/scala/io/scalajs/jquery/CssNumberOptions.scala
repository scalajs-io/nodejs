package io.scalajs.jquery

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * CSS Number Options
  * By default the object contains the following properties:
  * zIndex
  * fontWeight
  * opacity
  * zoom
  * lineHeight
  * widows (added in jQuery 1.6)
  * orphans (added in jQuery 1.6)
  * fillOpacity (added in jQuery 1.6.2)
  * columnCount (added in jQuery 1.9)
  * order (added in jQuery 1.10.2)
  * flexGrow (added in jQuery 1.11.1)
  * flexShrink (added in jQuery 1.11.1)
  */
@ScalaJSDefined
class CssNumberOptions(var zIndex: String = null,
                       var fontWeight: String = null,
                       var opacity: String = null,
                       var zoom: String = null,
                       var lineHeight: String = null,
                       var widows: String = null,
                       var orphans: String = null,
                       var fillOpacity: String = null,
                       var columnCount: String = null,
                       var order: String = null,
                       var flexGrow: String = null,
                       var flexShrink: String = null)
    extends js.Object

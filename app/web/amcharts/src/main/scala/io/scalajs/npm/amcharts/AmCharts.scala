package io.scalajs.npm.amcharts

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * Namespace of the framework which holds the general settings, gets automatically injected to document since the source has been included.
  * @example
  * {{{
  * AmCharts.useUTC = true;
  * AmCharts.processDelay = 100;
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmCharts
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
object AmCharts extends AmChart {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Set it to true if you have base href set in your web page header. This will fix rendering issues caused by this
    * feature, like masks filters not working, causing graphs to protrude from plot area.
    */
  var baseHref: Boolean = js.native

  /**
    * This array will hold references to all instances of the charts or maps created on the same page.
    */
  var charts: js.Array[AmChart] = js.native

  /**
    * Array of day names, used when formatting dates (if categoryAxis.parseDates is set to true)
    * @example ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    */
  var dayNames: js.Array[String] = js.native

  /**
    * Array of month names, used when formatting dates (if categoryAxis.parseDates is set to true)
    * @example ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
    */
  var monthNames: js.Array[String] = js.native

  /**
    * Delay in ms at which each chart on the page should be rendered. This is very handy if you have a lot of charts
    * on the page and do not want to overload the device CPU.
    */
  var processDelay: Double = js.native

  /**
    * Array of short versions of day names, used when formatting dates (if categoryAxis.parseDates is set to true)
    * @example ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
    */
  var shortDayNames: js.Array[String] = js.native

  /**
    * Array of short versions of month names, used when formatting dates (if categoryAxis.parseDates is set to true)
    * @example ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    */
  var shortMonthNames: js.Array[String] = js.native

  /**
    * You can set theme for all the charts on your page by setting: AmCharts.theme = AmCharts.themes.light; // or some other theme. If you are creating charts using JavaScript API, not JSON, then this is quite a comfortable way, as you won't need to pass theme to each object you create. Note, you should set theme before write method is called. There is no way to change theme of already created chart, you have to create chart's instance once more if you want to change theme.
    */
  var theme: String = js.native

  /**
    * Set it to true if you want UTC time to be used instead of local time.
    */
  var useUTC: Boolean = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Format the number according to rules set in prefixesBig, prefixesSmall and numberFormatter.
    *
    * You can use chart instance's "prefixesOfSmallNumbers", "prefixesOfBigNumbers" as well as "precision",
    * "decimalSeparator" and "thousandsSeparator" properties to form your request.
    * @example
    * {{{
    *   var formatted = AmCharts.addPrefix(
    *      value,
    *      chart.prefixesOfBigNumbers,
    *      chart.prefixesOfSmallNumbers, {
    *         precision: chart.precision,
    *         decimalSeparator: chart.decimalSeparator,
    *         thousandsSeparator: chart.thousandsSeparator
    *      });
    * }}}
    * @param value
    * @param prefixesBig
    * @param prefixesSmall
    * @param numberFormatter
    * @return
    */
  def addPrefix(value: js.Any, prefixesBig: js.Any, prefixesSmall: js.Any, numberFormatter: Formatter): String = js.native

  /**
    * You can use this method to format date object into date string.
    * @param date
    * @param format
    * @return
    */
  def formatDate(date: js.Date, format: String): String = js.native

  /**
    * Returns string formatter with the provided settings. Formatter is an object with precision, decimalSeparator
    * and thousandsSeparator defined, like: {precision: 2, decimalSeparator: '.', thousandsSeparator: ','}; If you
    * don't need to adjust precision set it to -1. zeroCount defines how many zeros should be added after
    * comma (useful when formatting currencies).
    * @param number
    * @param formatter
    * @param zeroCount
    * @return
    */
  def formatNumber(number: Double = js.native, formatter: Formatter | js.Any, zeroCount: Double = js.native): String = js.native

  /**
    * You can use this method to convert date string to date object. Please note, that literal name codes
    * such as MMM or MMMM are not supported.
    * @param string
    * @param format
    * @return
    */
  def stringToDate(string: String, format: String): js.Date = js.native

}

package org.scalajs.nodejs.dns

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * DNS Options
  * @param family The record family. If present, must be the integer 4 or 6. If not provided, both IP v4
  *               and v6 addresses are accepted.
  * @param hints  If present, it should be one or more of the supported getaddrinfo flags. If hints is not
  *               provided, then no flags are passed to getaddrinfo. Multiple flags can be passed through hints by logically
  *               ORing their values. See supported getaddrinfo flags for more information on supported flags.</li>
  * @param all    When true, the callback returns all resolved addresses in an array, otherwise returns a
  *               single address. Defaults to false.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DnsOptions(var family: js.UndefOr[Int] = js.undefined,
                 var hints: js.UndefOr[Int] = js.undefined,
                 var all: js.UndefOr[Boolean] = js.undefined) extends js.Object
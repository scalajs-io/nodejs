package io.scalajs.nodejs.dns

import scala.scalajs.js

class DnsOptions(var family: js.UndefOr[Int] = js.undefined,
                 var hints: js.UndefOr[Int] = js.undefined,
                 var all: js.UndefOr[Boolean] = js.undefined,
                 var verbatim: js.UndefOr[Boolean] = js.undefined)
    extends js.Object

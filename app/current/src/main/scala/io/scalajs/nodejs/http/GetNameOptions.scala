package io.scalajs.nodejs.http

import scala.scalajs.js

class GetNameOptions(
    var host: String,
    var port: js.UndefOr[Int] = js.undefined,
    var localAddress: js.UndefOr[String] = js.undefined,
    var family: js.UndefOr[Int] = js.undefined
) extends js.Object

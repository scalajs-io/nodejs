package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Hosted Services Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class HostedServicesOptions(var serviceName: js.UndefOr[String],
                            var label: js.UndefOr[String],
                            var location: js.UndefOr[String])
  extends js.Object

/**
  * Hosted Services Options Companion
  * @author lawrence.daniels@gmail.com
  */
object HostedServicesOptions {

  def apply(serviceName: js.UndefOr[String] = js.undefined,
            label: js.UndefOr[String] = js.undefined,
            location: js.UndefOr[String] = js.undefined) = {
    new HostedServicesOptions(serviceName, label, location)
  }


}
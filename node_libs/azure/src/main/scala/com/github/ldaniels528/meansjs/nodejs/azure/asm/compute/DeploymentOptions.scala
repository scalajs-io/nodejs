package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Deployment Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DeploymentOptions(var name: js.UndefOr[String],
                        var deploymentSlot: js.UndefOr[String],
                        var label: js.UndefOr[String],
                        var roles: js.UndefOr[js.Array[Role]]) extends js.Object

/**
  * Deployment Options
  * @author lawrence.daniels@gmail.com
  */
object DeploymentOptions {

  def apply(name: js.UndefOr[String] = js.undefined,
            deploymentSlot: js.UndefOr[String] = js.undefined,
            label: js.UndefOr[String] = js.undefined,
            roles: js.UndefOr[js.Array[Role]] = js.undefined) = {
    new DeploymentOptions(name, deploymentSlot, label, roles)
  }

}
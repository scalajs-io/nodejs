package org.scalajs.nodejs.azure.asm.compute

import org.scalajs.nodejs.azure.asm.compute.ConfigurationSet.ConfigurationSetType

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Configuration Set
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ConfigurationSet(var configurationSetType: ConfigurationSetType,
                       var adminUserName: js.UndefOr[String],
                       var adminPassword: js.UndefOr[String],
                       var computerName: js.UndefOr[String],
                       var enableAutomaticUpdates: js.UndefOr[Boolean],
                       var resetPasswordOnFirstLogon: js.UndefOr[Boolean],
                       var subnetNames: js.UndefOr[js.Array[String]],
                       var storedCertificateSettings: js.UndefOr[js.Array[js.Any]],
                       var inputEndpoints: js.UndefOr[js.Array[Endpoint]],
                       var windowsRemoteManagement: js.UndefOr[WindowsRemoteManagement]) extends js.Object

/**
  * Configuration Set
  * @author lawrence.daniels@gmail.com
  */
object ConfigurationSet {

  type ConfigurationSetType = String
  val NetworkConfiguration: ConfigurationSetType = "NetworkConfiguration"
  val WindowsProvisioningConfiguration: ConfigurationSetType = "WindowsProvisioningConfiguration"

  def apply(configurationSetType: ConfigurationSetType,
            adminUserName: js.UndefOr[String] = js.undefined,
            adminPassword: js.UndefOr[String] = js.undefined,
            computerName: js.UndefOr[String] = js.undefined,
            enableAutomaticUpdates: js.UndefOr[Boolean] = js.undefined,
            resetPasswordOnFirstLogon: js.UndefOr[Boolean] = js.undefined,
            subnetNames: js.UndefOr[js.Array[String]] = js.undefined,
            storedCertificateSettings: js.UndefOr[js.Array[js.Any]] = js.undefined,
            inputEndpoints: js.UndefOr[js.Array[Endpoint]] = js.undefined,
            windowsRemoteManagement: js.UndefOr[WindowsRemoteManagement] = js.undefined) = {
    new ConfigurationSet(
      configurationSetType, adminUserName, adminPassword, computerName, enableAutomaticUpdates,
      resetPasswordOnFirstLogon, subnetNames, storedCertificateSettings, inputEndpoints, windowsRemoteManagement
    )
  }

}
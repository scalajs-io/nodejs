package org.scalajs.nodejs.azure.arm.keyvault

import org.scalajs.nodejs.NodeRequire
import org.scalajs.nodejs.azure.common.{KeyVaultManagementClient, TokenCloudCredentials}
import org.scalajs.nodejs.azure.common.TokenCloudCredentials

import scala.scalajs.js

/**
  * Azure ARM Key Vault
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AzureArmKeyVault extends js.Object {

  def KeyVaultManagementClient: js.Function1[TokenCloudCredentials, KeyVaultManagementClient] = js.native

}

/**
  * AzureArmKeyVault Companion
  * @author lawrence.daniels@gmail.com
  */
object AzureArmKeyVault {

  /**
    * Convenience method for retrieving the 'azure-arm-keyvault' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the AzureArmKeyVault instance
    */
  def apply()(implicit require: NodeRequire) = require[AzureArmKeyVault]("azure-arm-keyvault")

}
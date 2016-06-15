package com.github.ldaniels528.meansjs.nodejs.azure.arm.keyvault

import com.github.ldaniels528.meansjs.nodejs.NodeRequire
import com.github.ldaniels528.meansjs.nodejs.azure.common.{KeyVaultManagementClient, TokenCloudCredentials}

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
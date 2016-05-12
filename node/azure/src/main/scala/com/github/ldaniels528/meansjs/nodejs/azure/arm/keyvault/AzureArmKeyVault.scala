package com.github.ldaniels528.meansjs.nodejs.azure.arm.keyvault

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


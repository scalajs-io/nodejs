package com.github.ldaniels528.meansjs.nodejs.azure.common

import scala.scalajs.js

/**
  * Key Vault Management Client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KeyVaultManagementClient extends js.Object {

  def vaults: KeyVaultOperations = js.native

}

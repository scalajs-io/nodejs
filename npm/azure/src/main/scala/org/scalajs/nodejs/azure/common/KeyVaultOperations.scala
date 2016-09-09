package org.scalajs.nodejs.azure.common

import scala.scalajs.js

/**
  * Key Vault Operations
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KeyVaultOperations extends js.Object {

  def createOrUpdate(resourceGroup: String, vaultName: String, parameters: js.Any, callback: js.Function): Unit = js.native

}

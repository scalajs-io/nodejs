package org.scalajs.nodejs.azure.common

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Key Vault Parameters
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class KeyVaultParameters(var location: String,
                         var properties: KeyVaultParameters.Properties,
                         var tags: js.Dictionary[String]) extends js.Object


/**
  * Key Vault Parameters
  * @author lawrence.daniels@gmail.com
  */
object KeyVaultParameters {

  /**
    * Key Vault Parameters: Properties
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class Properties(var sku: SKU,
                   var accessPolicies: js.Array[js.Any],
                   var enabledForDeployment: Boolean,
                   var tenantId: String) extends js.Object

  /**
    * Key Vault Parameters: SKU
    * @author lawrence.daniels@gmail.com
    */
  @ScalaJSDefined
  class SKU(var family: String, var name: String) extends js.Object

}
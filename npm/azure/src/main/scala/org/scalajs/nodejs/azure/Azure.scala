package org.scalajs.nodejs
package azure

import org.scalajs.nodejs.azure.common.AzureCommon

import scala.scalajs.js

/**
  * Azure module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Azure extends NodeModule with AzureCommon /*with AzureAsmCompute with AzureAsmSQL with AzureStorage*/ {

  def createServiceBusService(): ServiceBusService = js.native

  def RoleEnvironment: RoleEnvironment = js.native

}

/**
  * Azure Companion
  * @author lawrence.daniels@gmail.com
  */
object Azure {

  /**
    * Convenience method for retrieving the azure module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Azure instance
    */
  def apply()(implicit require: NodeRequire) = require[Azure]("azure")

}
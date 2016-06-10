package com.github.ldaniels528.meansjs.nodejs.azure

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.azure.asm.compute.AzureAsmCompute
import com.github.ldaniels528.meansjs.nodejs.azure.asm.sql.AzureAsmSQL
import com.github.ldaniels528.meansjs.nodejs.azure.common.AzureCommon
import com.github.ldaniels528.meansjs.nodejs.azure.storage.AzureStorage

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

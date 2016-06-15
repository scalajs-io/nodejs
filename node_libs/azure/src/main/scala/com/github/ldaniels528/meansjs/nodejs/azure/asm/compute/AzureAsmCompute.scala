package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}
import com.github.ldaniels528.meansjs.nodejs.azure.asm.{CertificateCloudCredentials, CertificateCloudCredentialsOptions}

import scala.scalajs.js

/**
  * Azure Storage module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AzureAsmCompute extends NodeModule {

  def createCertificateCloudCredentials(options: CertificateCloudCredentialsOptions): CertificateCloudCredentials = js.native

  def createComputeManagementClient(credentials: CertificateCloudCredentials): ComputeManagementClient = js.native

}

/**
  * AzureAsmCompute Companion
  * @author lawrence.daniels@gmail.com
  */
object AzureAsmCompute {

  /**
    * Convenience method for retrieving the 'azure-asm-compute' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the AzureAsmCompute instance
    */
  def apply()(implicit require: NodeRequire) = require[AzureAsmCompute]("azure-asm-compute")

}
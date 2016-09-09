package org.scalajs.nodejs.azure.asm.compute

import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.azure.asm.{CertificateCloudCredentials, CertificateCloudCredentialsOptions}
import org.scalajs.nodejs.azure.asm.CertificateCloudCredentialsOptions

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
package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import com.github.ldaniels528.meansjs.nodejs.NodeModule
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

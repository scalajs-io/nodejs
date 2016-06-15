package com.github.ldaniels528.meansjs.nodejs.azure.asm.sql

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}
import com.github.ldaniels528.meansjs.nodejs.azure.asm.{CertificateCloudCredentials, CertificateCloudCredentialsOptions}

import scala.scalajs.js

/**
  * Azure ASM SQL node module
  * @author lawrence.daniels@gmail.com
  * @example {{ val sqlManagement = require[AzureAsmSQL("azure-asm-sql") }}
  * @see https://github.com/Azure/azure-sdk-for-node/blob/master/lib/services/sqlManagement/README.md
  */
@js.native
trait AzureAsmSQL extends NodeModule {

  def createCertificateCloudCredentials(options: CertificateCloudCredentialsOptions): CertificateCloudCredentials = js.native

  def createSqlManagementClient(credentials: CertificateCloudCredentials): SqlManagementClient = js.native

}

/**
  * AzureAsmSQL Companion
  * @author lawrence.daniels@gmail.com
  */
object AzureAsmSQL {

  /**
    * Convenience method for retrieving the 'azure-asm-sql' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the AzureAsmSQL instance
    */
  def apply()(implicit require: NodeRequire) = require[AzureAsmSQL]("azure-asm-sql")

}
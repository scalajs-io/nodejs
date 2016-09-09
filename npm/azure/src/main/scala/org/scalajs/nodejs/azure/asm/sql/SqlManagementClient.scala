package org.scalajs.nodejs.azure.asm.sql

import scala.scalajs.js

/**
  * This is the main client class for interacting with the Azure SQL Database REST APIs.
  * Initializes a new instance of the SqlManagementClient class.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SqlManagementClient extends js.Object {

  def dac: DacOperations = js.native

  def databases: DatabaseOperations = js.native

  def databaseOperations: DatabaseOperationOperations = js.native

  def databaseCopies: DatabaseCopyOperations = js.native

  def firewallRules: FirewallRuleOperations = js.native

  def quotas: QuotaOperations = js.native

  def recoverableDatabases: RecoverableDatabaseOperations = js.native

  def restoreDatabaseOperations: RestoreDatabaseOperations = js.native

  def servers: ServerOperations = js.native

  def serviceObjectives: ServiceObjectiveOperations = js.native

}

/**
  * SQL Management Client Companion
  * @author lawrence.daniels@gmail.com
  */
object SqlManagementClient {

}
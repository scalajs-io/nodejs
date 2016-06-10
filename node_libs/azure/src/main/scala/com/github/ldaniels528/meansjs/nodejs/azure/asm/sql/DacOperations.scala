package com.github.ldaniels528.meansjs.nodejs.azure.asm.sql

import com.github.ldaniels528.meansjs.nodejs.errors
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Database Operations
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DacOperations extends js.Object {

  /**
    * Exports an Azure SQL Database into a DACPAC file in Azure Blob Storage.
    * @param serverName           The name of the Azure SQL Database Server in which the database to export resides.
    * @param parametersOrCallback The parameters needed to initiate the export request.
    * @param callback             the callback
    */
  def exportMethod(serverName: String, parametersOrCallback: js.Any, callback: js.Function): Unit = js.native

  /**
    * Gets the status of the import or export operation in the specified server
    * with the corresponding request ID.  The request ID is provided in the
    * responses of the import or export operation.
    * @param serverName               The name of the server in which the import or export operation is taking place.
    * @param fullyQualifiedServerName The fully qualified domain name of the Azure SQL Database Server where the
    *                                 operation is taking place (Example: a9s7f7s9d3.database.windows.net)
    * @param username                 The administrator username for the Azure SQL Database Server.
    * @param password                 The administrator password for the Azure SQL Database Server.
    * @param requestId                The request ID of the operation being queried. The request ID is obtained from
    *                                 the responses of the import and export operations.
    * @param callback                 the callback
    */
  def getStatus(serverName: String, fullyQualifiedServerName: String, username: String, password: String, requestId: String, callback: js.Function): Unit = js.native

}

/**
  * Database Operations Companion
  * @author lawrence.daniels@gmail.com
  */
object DacOperations {

  /**
    * Database Operations Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class DacOperationsExtensions(val dac: DacOperations) extends AnyVal {

    /**
      * Exports an Azure SQL Database into a DACPAC file in Azure Blob Storage.
      * @param serverName           The name of the Azure SQL Database Server in which the database to export resides.
      * @param parametersOrCallback The parameters needed to initiate the export request.
      */
    @inline
    def exportMethodFuture(serverName: String, parametersOrCallback: js.Any) = {
      futureCallbackE1[errors.Error, js.Any](dac.exportMethod(serverName, parametersOrCallback, _))
    }

    /**
      * Gets the status of the import or export operation in the specified server
      * with the corresponding request ID.  The request ID is provided in the
      * responses of the import or export operation.
      * @param serverName               The name of the server in which the import or export operation is taking place.
      * @param fullyQualifiedServerName The fully qualified domain name of the Azure SQL Database Server where the
      *                                 operation is taking place (Example: a9s7f7s9d3.database.windows.net)
      * @param username                 The administrator username for the Azure SQL Database Server.
      * @param password                 The administrator password for the Azure SQL Database Server.
      * @param requestId                The request ID of the operation being queried. The request ID is obtained from
      *                                 the responses of the import and export operations.
      */
    @inline
    def getStatusFuture(serverName: String, fullyQualifiedServerName: String, username: String, password: String, requestId: String) = {
      futureCallbackE1[errors.Error, js.Any](dac.getStatus(serverName, fullyQualifiedServerName, username, password, requestId, _))
    }

  }

}
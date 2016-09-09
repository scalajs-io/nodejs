package org.scalajs.nodejs.azure.storage

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * Azure Storage module
  * @author lawrence.daniels@gmail.com
  * @see https://www.npmjs.com/package/azure
  */
@js.native
trait AzureStorage extends NodeModule {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def TableUtilities: js.Dynamic = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Classes
  /////////////////////////////////////////////////////////////////////////////////

  def createBlobService: js.Function0[BlobService] = js.native

  def createQueueService: js.Function0[QueueService] = js.native

  def createTableService: js.Function0[TableService] = js.native

}

/**
  * AzureStorage Companion
  * @author lawrence.daniels@gmail.com
  */
object AzureStorage {

  /**
    * Convenience method for retrieving the 'azure-storage' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the AzureStorage instance
    */
  def apply()(implicit require: NodeRequire) = require[AzureStorage]("azure-storage")

}
package com.github.ldaniels528.meansjs.nodejs.azure.storage

import com.github.ldaniels528.meansjs.nodejs.NodeModule

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

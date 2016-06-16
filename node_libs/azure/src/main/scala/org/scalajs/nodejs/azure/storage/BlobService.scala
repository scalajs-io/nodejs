package org.scalajs.nodejs.azure.storage

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.stream.Readable
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Blob Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BlobService extends js.Object {

  def createContainerIfNotExists(containerName: String, options: SharedAccessPolicy, callback: js.Function): Unit = js.native

  def getBlob(containerName: String, blobName: String): Readable = js.native

  def getBlobUrl(containerName: String, blobName: String, accessPolicy: SharedAccessPolicy): String = js.native

}

/**
  * Blob Service Companion
  * @author lawrence.daniels@gmail.com
  */
object BlobService {

  /**
    * Blob Service Extensions
    * @param blobService the given [[BlobService blob service]]
    */
  implicit class BlobServiceExtensions(val blobService: BlobService) extends AnyVal {

    @inline
    def createContainerIfNotExistsFuture(containerName: String, options: SharedAccessPolicy) = {
      futureCallbackE1[errors.Error, js.Any](blobService.createContainerIfNotExists(containerName, options, _))
    }

  }

}
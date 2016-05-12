package com.github.ldaniels528.meansjs.nodejs.azure.storage

import com.github.ldaniels528.meansjs.nodejs.errors.ErrorClass
import com.github.ldaniels528.meansjs.nodejs.stream.Readable
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

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
      futureCallbackE1[ErrorClass, js.Any](blobService.createContainerIfNotExists(containerName, options, _))
    }

  }

}
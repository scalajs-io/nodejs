package io.scalajs.npm

import io.scalajs.nodejs.Error
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future

/**
  * gzip-uncompressed-size package object
  * @author lawrence.daniels@gmail.com
  */
package object gzipuncompressedsize {

  /**
    * GzipUncompressedSize Enrichment
    * @param instance the given [[GzipUncompressedSize instance]]
    */
  implicit class GzipUncompressedSizeEnrichment(val instance: GzipUncompressedSize) extends AnyVal {

    @inline
    def fromFileFuture(path: String): Future[Double] = {
      promiseWithError1[Error, Double](instance.fromFile(path, _))
    }

  }

}

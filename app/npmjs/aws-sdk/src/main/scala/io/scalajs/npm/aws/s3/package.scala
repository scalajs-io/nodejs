package io.scalajs.npm.aws

import io.scalajs.RawOptions
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * aws.s3 package object
  * @author lawrence.daniels@gmail.com
  */
package object s3 {
  type EncodingType = js.Object
  type IsTruncated = js.Object
  type KeyCount = js.Object
  type CommonPrefixList = js.Array[String]
  type NextToken = js.Object
  type ObjectList = js.Object
  type StartAfter = js.Object
  type Token = js.Object

  /**
    * AWS S3 Enrichment
    * @param s3 the [[S3]] instance
    */
  implicit class S3Enrichment(val s3: S3) extends AnyVal {

    @inline
    def getBucketLocationFuture(params: BucketParams | RawOptions): Future[GetBucketLocationOutput] = {
      promiseWithError1[AWSError, GetBucketLocationOutput](s3.getBucketLocation(params, _))
    }

  }

}

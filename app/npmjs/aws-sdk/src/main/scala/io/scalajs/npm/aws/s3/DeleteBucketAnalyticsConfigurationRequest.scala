package io.scalajs.npm.aws.s3

import scala.scalajs.js


/**
  * Delete Bucket Analytics Configuration Request
  * @param Bucket The name of the bucket from which an analytics configuration is deleted.
  * @param Id     The identifier used to represent an analytics configuration.
  */

class DeleteBucketAnalyticsConfigurationRequest(val Bucket: js.UndefOr[String] = js.undefined,
                                                val Id: js.UndefOr[String] = js.undefined)
  extends js.Object

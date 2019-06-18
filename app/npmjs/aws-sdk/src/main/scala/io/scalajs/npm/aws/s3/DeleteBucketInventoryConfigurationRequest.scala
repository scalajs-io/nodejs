package io.scalajs.npm.aws.s3

import scala.scalajs.js


/**
  * Delete Bucket Inventory Configuration Request
  * @param Bucket The name of the bucket containing the inventory configuration to delete.
  * @param Id     The ID used to identify the inventory configuration.
  */

class DeleteBucketInventoryConfigurationRequest(val Bucket: js.UndefOr[String] = js.undefined,
                                                val Id: js.UndefOr[String] = js.undefined) extends js.Object
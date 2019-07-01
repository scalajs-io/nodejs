package io.scalajs.npm.aws.s3

import scala.scalajs.js


/**
  * Create Bucket Request
  * @param ACL                       The canned ACL to apply to the bucket.
  * @param Bucket                    The Bucket name
  * @param CreateBucketConfiguration The Create Bucket Configuration
  * @param GrantFullControl          Allows grantee the read, write, read ACP, and write ACP permissions on the bucket.
  * @param GrantRead                 Allows grantee to list the objects in the bucket.
  * @param GrantReadACP              Allows grantee to read the bucket ACL.
  * @param GrantWrite                Allows grantee to create, overwrite, and delete any object in the bucket.
  * @param  GrantWriteACP            Allows grantee to write the ACL for the applicable bucket.
  *
  */

class CreateBucketRequest(val ACL: js.UndefOr[String] = js.undefined,
                          val Bucket: js.UndefOr[String] = js.undefined,
                          val CreateBucketConfiguration: js.UndefOr[CreateBucketConfiguration] = js.undefined,
                          val GrantFullControl: js.UndefOr[Boolean] = js.undefined,
                          val GrantRead: js.UndefOr[Boolean] = js.undefined,
                          val GrantReadACP: js.UndefOr[Boolean] = js.undefined,
                          val GrantWrite: js.UndefOr[Boolean] = js.undefined,
                          val GrantWriteACP: js.UndefOr[Boolean] = js.undefined)
  extends js.Object


/**
  * Create Bucket Configuration
  * @param LocationConstraint Specifies the region where the bucket will be created. If you don't specify a region,
  *                           the bucket will be created in US Standard.
  */

class CreateBucketConfiguration(val LocationConstraint: js.UndefOr[String] = js.undefined)
  extends js.Object
package io.scalajs.npm.aws.s3

import scala.scalajs.js


/**
  * ListObjectsV2 Request
  * @param Bucket            Name of the bucket to list.
  * @param Delimiter         A delimiter is a character you use to group keys.
  * @param EncodingType      Encoding type used by Amazon S3 to encode object keys in the response.
  * @param MaxKeys           Sets the maximum number of keys returned in the response.
  *                          The response might contain fewer keys but will never contain more.
  * @param Prefix            Limits the response to keys that begin with the specified prefix.
  * @param ContinuationToken indicates Amazon S3 that the list is being continued on this bucket with a token.
  *                          ContinuationToken is obfuscated and is not a real key
  * @param FetchOwner        The owner field is not present in listV2 by default, if you want to return
  *                          owner field with each key in the result then set the fetch owner field to true
  * @param StartAfter        is where you want Amazon S3 to start listing from. Amazon S3 starts listing after this
  *                          specified key. StartAfter can be any key in the bucket
  * @param RequestPayer      Confirms that the requester knows that she or he will be charged for the list objects
  *                          request in V2 style. Bucket owners need not specify this parameter in their requests.
  */

class ListObjectsV2Request(val Bucket: String,
                           val Delimiter: js.UndefOr[String] = js.undefined,
                           val EncodingType: js.UndefOr[String] = js.undefined,
                           val MaxKeys: js.UndefOr[Int] = js.undefined,
                           val Prefix: js.UndefOr[String] = js.undefined,
                           val ContinuationToken: js.UndefOr[String] = js.undefined,
                           val FetchOwner: js.UndefOr[Boolean] = js.undefined,
                           val StartAfter: js.UndefOr[String] = js.undefined,
                           val RequestPayer: js.UndefOr[String] = js.undefined)
  extends js.Object


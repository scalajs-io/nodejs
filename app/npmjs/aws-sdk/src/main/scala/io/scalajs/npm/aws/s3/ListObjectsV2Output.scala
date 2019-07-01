package io.scalajs.npm.aws.s3

import scala.scalajs.js

/**
  * ListObjectsV2 Output
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ListObjectsV2Output extends js.Object {

  /**
    * A flag that indicates whether or not Amazon S3 returned all of the results that satisfied the search criteria.
    */
  val IsTruncated: Boolean = js.native

  /**
    * Metadata about each object returned.
    */
  val Contents: js.Array[ListObjectV2] = js.native

  /**
    * Name of the bucket to list.
    */
  val Name: String = js.native

  /**
    * Limits the response to keys that begin with the specified prefix.
    */
  val Prefix: String = js.native

  /**
    * A delimiter is a character you use to group keys.
    */
  val Delimiter: String = js.native

  /**
    * Sets the maximum number of keys returned in the response. The response might contain fewer
    * keys but will never contain more.
    */
  val MaxKeys: Int = js.native

  /**
    * CommonPrefixes contains all (if there are any) keys between Prefix and the next occurrence
    * of the string specified by delimiter
    */
  val CommonPrefixes: CommonPrefixList = js.native

  /**
    * Encoding type used by Amazon S3 to encode object keys in the response.
    */
  val EncodingType: String = js.native

  /**
    * KeyCount is the number of keys returned with this request.
    * KeyCount will always be less than equals to MaxKeys field. Say you ask for 50 keys,
    * your result will include less than equals 50 keys
    */
  val KeyCount: Integer = js.native

  /**
    * ContinuationToken indicates Amazon S3 that the list is being continued on this bucket with a token. ContinuationToken is obfuscated and is not a real key
    */
  val ContinuationToken: Token = js.native

  /**
    * NextContinuationToken is sent when isTruncated is true which means there are more keys in the bucket that can be listed. The next list requests to Amazon S3 can be continued with this NextContinuationToken. NextContinuationToken is obfuscated and is not a real key
    */
  val NextContinuationToken: NextToken = js.native

  /**
    * StartAfter is where you want Amazon S3 to start listing from.
    * Amazon S3 starts listing after this specified key. StartAfter can be any key in the bucket
    */
  val StartAfter: StartAfter = js.native
}

@js.native
trait ListObjectV2 extends js.Object {

  val Key: String = js.native

}
package io.scalajs.npm.aws.s3

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js

/**
  * Created by ldaniels3 on 3/16/2017.
  */
@js.native
trait GetObjectOutput extends js.Object {

  /**
    * Object data.
    */
  val Body: Buffer = js.native

  /**
    * Specifies whether the object retrieved was (true) or was not (false) a Delete Marker. If false, this response header does not appear in the response.
    */
  val DeleteMarker: Boolean = js.native

  val AcceptRanges: Boolean = js.native

  /**
    * If the object expiration is configured (see PUT Bucket lifecycle), the response includes this header. It includes the expiry-date and rule-id key value pairs providing object expiration information. The value of the rule-id is URL encoded.
    */
  val Expiration: js.Date = js.native

  /**
    * Provides information about object restoration operation and expiration time of the restored object copy.
    */
  val Restore: js.Any = js.native
  /**
    * Last modified date of the object
    */
  val LastModified: js.Date = js.native
  /**
    * Size of the body in bytes.
    */
  val ContentLength: String = js.native
  /**
    * An ETag is an opaque identifier assigned by a web server to a specific version of a resource found at a URL
    */
  val ETag: String = js.native
  /**
    * This is set to the number of metadata entries not returned in x-amz-meta headers. This can happen if you create metadata using an API like SOAP that supports more flexible metadata than the REST API. For example, using SOAP, you can create metadata whose values are not legal HTTP headers.
    */
  val MissingMeta: Integer = js.native
  /**
    * Version of the object.
    */
  val VersionId: String = js.native
  /**
    * Specifies caching behavior along the request/reply chain.
    */
  val CacheControl: String = js.native
  /**
    * Specifies presentational information for the object.
    */
  val ContentDisposition: String = js.native
  /**
    * Specifies what content encodings have been applied to the object and thus what decoding mechanisms must be applied to obtain the media-type referenced by the Content-Type header field.
    */
  val ContentEncoding: String = js.native
  /**
    * The language the content is in.
    */
  val ContentLanguage: String = js.native
  /**
    * The portion of the object returned in the response.
    */
  val ContentRange: String = js.native
  /**
    * A standard MIME type describing the format of the object data.
    */
  val ContentType: String = js.native
  /**
    * The date and time at which the object is no longer cacheable.
    */
  val Expires: js.Date = js.native
  /**
    * If the bucket is configured as a website, redirects requests for this object to another object in the same bucket or to an external URL. Amazon S3 stores the value of this header in the object metadata.
    */
  val WebsiteRedirectLocation: String = js.native
  /**
    * The Server-side encryption algorithm used when storing this object in S3 (e.g., AES256, aws:kms).
    */
  val ServerSideEncryption: String = js.native
  /**
    * A map of metadata to store with the object in S3.
    */
  val Metadata: js.Object = js.native
  /**
    * If server-side encryption with a customer-provided encryption key was requested, the response will include this header confirming the encryption algorithm used.
    */
  val SSECustomerAlgorithm: String = js.native
  /**
    * If server-side encryption with a customer-provided encryption key was requested, the response will include this header to provide round trip message integrity verification of the customer-provided encryption key.
    */
  val SSECustomerKeyMD5: String = js.native
  /**
    * If present, specifies the ID of the AWS Key Management Service (KMS) master encryption key that was used for the object.
    */
  val SSEKMSKeyId: String = js.native
  val StorageClass: String = js.native
  val RequestCharged: String = js.native
  val ReplicationStatus: String = js.native
  /**
    * The count of parts this object has.
    */
  val PartsCount: Integer = js.native
  /**
    * The number of tags, if any, on the object.
    */
  val TagCount: Integer = js.native
}

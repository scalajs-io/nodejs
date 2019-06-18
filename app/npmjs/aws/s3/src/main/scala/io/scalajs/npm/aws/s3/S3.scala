package io.scalajs.npm.aws
package s3

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * AWS.S3
  * @see http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/S3.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "S3")
class S3(options: ClientConfiguration | RawOptions = js.native) extends Service {

  /**
    * Aborts a multipart upload.To verify that all parts have been removed, so you don't get charged
    * for the part storage, you should call the List Parts operation and ensure the parts list is empty.
    */
  def abortMultipartUpload(params: AbortMultipartUploadRequest = js.native,
                           callback: AWSCallback[AbortMultipartUploadOutput] = js.native): AWSRequest[AbortMultipartUploadOutput] = js.native

  /**
    * Completes a multipart upload by assembling previously uploaded parts.
    */
  def completeMultipartUpload(params: CompleteMultipartUploadRequest = js.native,
                              callback: AWSCallback[CompleteMultipartUploadOutput] = js.native): AWSRequest[CompleteMultipartUploadOutput] = js.native

  /**
    * Creates a copy of an object that is already stored in Amazon S3.
    */
  def copyObject(params: CopyObjectRequest = js.native,
                 callback: AWSCallback[CopyObjectOutput] = js.native): AWSRequest[CopyObjectOutput] = js.native

  /**
    * Creates a new bucket.
    */
  def createBucket(params: CreateBucketRequest,
                   callback: AWSCallback[CreateBucketOutput]): AWSRequest[CreateBucketOutput] = js.native

  /**
    * Initiates a multipart upload and returns an upload ID.Note: After you initiate multipart upload and upload one or more parts, you must either complete or abort multipart upload in order to stop getting charged for storage of the uploaded parts. Only after you either complete or abort multipart upload, Amazon S3 frees up the parts storage and stops charging you for the parts storage.
    */
  def createMultipartUpload(params: CreateMultipartUploadRequest,
                            callback: AWSCallback[CreateMultipartUploadOutput]): AWSRequest[CreateMultipartUploadOutput] = js.native

  /**
    * Deletes the bucket. All objects (including all object versions and Delete Markers) in the bucket must be deleted before the bucket itself can be deleted.
    */
  def deleteBucket(params: DeleteBucketRequest = js.native,
                   callback: AWSCallback[Unit] = js.native): AWSRequest[Unit] = js.native

  /**
    * Deletes an analytics configuration for the bucket (specified by the analytics configuration ID).
    */
  def deleteBucketAnalyticsConfiguration(params: DeleteBucketAnalyticsConfigurationRequest = js.native,
                                         callback: AWSCallback[Unit] = js.native): AWSRequest[Unit] = js.native

  /**
    * Deletes the cors configuration information set for the bucket.
    */
  def deleteBucketCors(params: DeleteBucketCorsRequest = js.native,
                       callback: AWSCallback[Unit] = js.native): AWSRequest[Unit] = js.native

  /**
    * Deletes an inventory configuration (identified by the inventory ID) from the bucket.
    */
  def deleteBucketInventoryConfiguration(params: DeleteBucketInventoryConfigurationRequest,
                                         callback: AWSCallback[Unit] = js.native): AWSRequest[Unit] = js.native

  def getBucketLocation(params: BucketParams | RawOptions,
                        callback: AWSCallback[GetBucketLocationOutput] = js.native): AWSRequest[GetBucketLocationOutput] = js.native

  def getObject(params: GetObjectRequest,
                callback: AWSCallback[GetObjectOutput] = js.native): AWSRequest[GetObjectOutput] = js.native

  def headBucket(params: RawOptions,
                 callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  def headObject(params: RawOptions,
                 callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  def listObjects(params: ListObjectsRequest | RawOptions,
                  callback: AWSCallback[ListObjectsOutput] = js.native): AWSRequest[ListObjectsOutput] = js.native

  def listObjectsV2(params: ListObjectsV2Request | RawOptions,
                    callback: AWSCallback[ListObjectsV2Output] = js.native): AWSRequest[ListObjectsV2Output] = js.native

}

/**
  * AWS.S3 Singleton
  * @author lawrence.daniels@gmail.com
  */
object S3 {

  object Types {

    type AbortMultipartUploadRequest = s3.AbortMultipartUploadRequest

    type ClientConfiguration = s3.ClientConfiguration

    type CompleteMultipartUploadRequest = s3.CompleteMultipartUploadRequest

    type GetObjectOutput = s3.GetObjectOutput

    type GetObjectRequest = s3.GetObjectRequest

    type ListObjectsOutput = s3.ListObjectsOutput

    type ListObjectsV2Output = s3.ListObjectsV2Output

  }

}


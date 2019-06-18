package io.scalajs.npm
package aws

/**
  * AWS SDK
  * @see [[https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/]]
  * @author lawrence.daniels@gmail.com
  */
object AWS {

  type AWSError = aws.AWSError

  type Endpoint = aws.Endpoint

  type Kinesis = kinesis.Kinesis

  type Request[T, E] = aws.Request[T, E]

  type S3 = s3.S3

  object Kinesis {

  }

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

}

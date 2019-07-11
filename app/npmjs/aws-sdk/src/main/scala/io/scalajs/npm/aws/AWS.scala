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

  type Kinesis = aws.kinesis.Kinesis

  type Request[T, E] = aws.Request[T, E]

  type S3 = aws.s3.S3

  object S3 {

    object Types {
      type AbortMultipartUploadRequest = aws.s3.AbortMultipartUploadRequest
      type ClientConfiguration = aws.s3.ClientConfiguration
      type CompleteMultipartUploadRequest = aws.s3.CompleteMultipartUploadRequest
      type GetObjectOutput = aws.s3.GetObjectOutput
      type GetObjectRequest = aws.s3.GetObjectRequest
      type ListObjectsOutput = aws.s3.ListObjectsOutput
      type ListObjectsV2Output = aws.s3.ListObjectsV2Output
    }

  }

  type SES = aws.ses.SES

  type SNS = aws.sns.SNS

}

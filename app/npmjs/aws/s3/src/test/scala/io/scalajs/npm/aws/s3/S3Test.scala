package io.scalajs.npm.aws
package s3

import io.scalajs.nodejs.{console, process}
import org.scalatest.FunSpec

/**
  * S3 Functional Specification
  * @author lawrence.daniels@gmail.com
  */
class S3Test extends FunSpec {

  describe("S3") {

    it("should access buckets") {
      for {
        accessKeyId <- process.env.get("aws.accessKeyId")
        secretAccessKey <- process.env.get("aws.secretAccessKey")
        region <- process.env.get("aws.region")
        bucketName <- process.env.get("aws.bucket")
      } {
        val ses = new SES()
        val s3 = new S3(ClientConfiguration(
          apiVersion = "2006-03-01",
          accessKeyId = accessKeyId,
          secretAccessKey = secretAccessKey,
          region = region
        ))
        val params = new BucketParams(Bucket = bucketName)
        s3.getBucketLocation(params, (err, data) => {
          if (err != null) console.log(err, err.stack)
          else console.log(data)
        })
      }
    }

  }

}

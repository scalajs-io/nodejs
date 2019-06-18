package io.scalajs.npm.aws

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Configuration Options
  * @author lawrence.daniels@gmail.com
  */

class ConfigurationOptions() extends js.Object {

  /**
    * Whether to compute checksums for payload bodies when the service accepts it.
    * Currently supported in S3 only.
    */
  var computeChecksums: js.UndefOr[Boolean] = js.undefined

  /**
    * Whether types are converted when parsing response data.
    */
  var convertResponseTypes: js.UndefOr[Boolean] = js.undefined

  /**
    * Whether to apply a clock skew correction and retry requests that fail because 
    * of an skewed client clock.
    */
  var correctClockSkew: js.UndefOr[Boolean] = js.undefined

  /**
    * The AWS credentials to sign requests with.
    */
  var credentials: js.UndefOr[Credentials | CredentialsOptions] = js.undefined

  /**
    * The provider chain used to resolve credentials if no static credentials property is set.
    */
  var credentialProvider: js.UndefOr[CredentialProviderChain] = js.undefined

  /**
    * AWS access key ID.
    * @deprecated 
    */
  var accessKeyId: js.UndefOr[String] = js.undefined

  /**
    * AWS secret access key.
    * @deprecated 
    */
  var secretAccessKey: js.UndefOr[String] = js.undefined

  /**
    * AWS session token.
    * @deprecated 
    */
  var sessionToken: js.UndefOr[String] = js.undefined

  /**
    * A set of options to pass to the low-level HTTP request.
    */
  var httpOptions: js.UndefOr[HTTPOptions] = js.undefined

  /**
    * An object that responds to .write() (like a stream) or .log() (like the console object) in order to log information about requests.
    */
  var logger: js.UndefOr[Logger] = js.undefined

  /**
    * The maximum amount of redirects to follow for a service request.
    */
  var maxRedirects: js.UndefOr[Int] = js.undefined

  /**
    * The maximum amount of retries to perform for a service request.
    */
  var maxRetries: js.UndefOr[Int] = js.undefined

  /**
    * Returns whether input parameters should be validated against the operation description before sending the request. 
    * Defaults to true. 
    * Pass a map to enable any of the following specific validation features: min|max|pattern|enum
    */
  var paramValidation: js.UndefOr[ParamValidation | Boolean] = js.undefined

  /**
    * The region to send service requests to.
    */
  var region: js.UndefOr[String] = js.undefined

  /**
    * Returns A set of options to configure the retry delay on retryable errors.
    */
  var retryDelayOptions: js.UndefOr[RetryDelayOptions] = js.undefined

  /**
    * Whether the provided endpoint addresses an individual bucket.
    * false if it addresses the root API endpoint.
    */
  var s3BucketEndpoint: js.UndefOr[Boolean] = js.undefined

  /**
    * Whether to disable S3 body signing when using signature version v4.
    */
  var s3DisableBodySigning: js.UndefOr[Boolean] = js.undefined

  /**
    * Whether to force path style URLs for S3 objects.
    */
  var s3ForcePathStyle: js.UndefOr[Boolean] = js.undefined

  /**
    * Whether the signature to sign requests with (overriding the API configuration) is cached.
    */
  var signatureCache: js.UndefOr[Boolean] = js.undefined

  /**
    * The signature version to sign requests with (overriding the API configuration).
    * Possible values: 'v2'|'v3'|'v4'
    */
  var signatureVersion: js.UndefOr[String] = js.undefined

  /**
    * Whether SSL is enabled for requests.
    */
  var sslEnabled: js.UndefOr[Boolean] = js.undefined

  /**
    * An offset value in milliseconds to apply to all signing times.
    */
  var systemClockOffset: js.UndefOr[Int] = js.undefined

  /**
    * Whether to use the Accelerate endpoint with the S3 service.
    */
  var useAccelerateEndpoint: js.UndefOr[Boolean] = js.undefined
}

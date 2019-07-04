package io.scalajs.npm.aws.kinesis

import io.scalajs.npm.aws.{AWSCallback, AWSRequest, Service}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * AWS.Kinesis - Constructs a service interface object. Each API operation is exposed as a function on service.
  * @example {{{
  *
  *   var kinesis = new AWS.Kinesis();
  *   kinesis.addTagsToStream(params, function (err, data) {
  *     if (err) console.log(err, err.stack); // an error occurred
  *     else     console.log(data);           // successful response
  *   });
  *
  * }}}
  * @see [[https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Kinesis.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "Kinesis")
class Kinesis(options: KinesisOptions = js.native) extends Service {

  /**
    * Adds or updates tags for the specified Kinesis data stream. Each time you invoke this operation, you can specify
    * up to 10 tags. If you want to add more than 10 tags to your stream, you can invoke this operation multiple times.
    * In total, each stream can have up to 50 tags.
    *
    * If tags have already been assigned to the stream, AddTagsToStream overwrites any existing tags that correspond to
    * the specified tag keys.
    *
    * [[AddTagsToStream]] has a limit of five transactions per second per account.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def addTagsToStream(params: AddTagsToStream,
                      callback: AWSCallback[AddTagsToStreamResult] = js.native): AWSRequest[AddTagsToStreamResult] = js.native

  /**
    * Creates a Kinesis data stream. A stream captures and transports data records that are continuously emitted from
    * different data sources or producers. Scale-out within a stream is explicitly supported by means of shards, which
    * are uniquely identified groups of data records in a stream.
    *
    * You specify and control the number of shards that a stream is composed of. Each shard can support reads up to five
    * transactions per second, up to a maximum data read total of 2 MB per second. Each shard can support writes up to
    * 1,000 records per second, up to a maximum data write total of 1 MB per second. If the amount of data input increases
    * or decreases, you can add or remove shards.
    *
    * The stream name identifies the stream. The name is scoped to the AWS account used by the application. It is also
    * scoped by AWS Region. That is, two streams in two different accounts can have the same name, and two streams in
    * the same account, but in two different Regions, can have the same name.
    *
    * [[CreateStream]] is an asynchronous operation. Upon receiving a [[CreateStream]] request, Kinesis Data Streams immediately
    * returns and sets the stream status to CREATING. After the stream is created, Kinesis Data Streams sets the stream
    * status to ACTIVE. You should perform read and write operations only on an ACTIVE stream.
    *
    * You receive a LimitExceededException when making a CreateStream request when you try to do one of the following:
    *
    * Have more than five streams in the CREATING state at any point in time.
    *
    * Create more shards than are authorized for your account.
    *
    * For the default shard limit for an AWS account, see Amazon Kinesis Data Streams Limits in the
    * Amazon Kinesis Data Streams Developer Guide. To increase this limit, contact AWS Support.
    *
    * You can use [[DescribeStream]] to check the stream status, which is returned in [[StreamStatus]].
    *
    * [[CreateStream]] has a limit of five transactions per second per account.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def createStream(params: CreateStream,
                   callback: AWSCallback[CreateStreamResult] = js.native): AWSRequest[CreateStreamResult] = js.native

  /**
    * Decreases the Kinesis data stream's retention period, which is the length of time data records are accessible
    * after they are added to the stream. The minimum value of a stream's retention period is 24 hours.
    *
    * This operation may result in lost data. For example, if the stream's retention period is 48 hours and is decreased
    * to 24 hours, any data already in the stream that is older than 24 hours is inaccessible.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def decreaseStreamRetentionPeriod(params: DecreaseStreamRetentionPeriod,
                                    callback: AWSCallback[DecreaseStreamRetentionPeriodResult] = js.native): AWSRequest[DecreaseStreamRetentionPeriodResult] = js.native

  /**
    * Deletes a Kinesis data stream and all its shards and data. You must shut down any applications that are operating
    * on the stream before you delete the stream. If an application attempts to operate on a deleted stream, it receives
    * the exception ResourceNotFoundException.
    *
    * If the stream is in the ACTIVE state, you can delete it. After a DeleteStream request, the specified stream is in
    * the DELETING state until Kinesis Data Streams completes the deletion.
    *
    * Note: Kinesis Data Streams might continue to accept data read and write operations, such as PutRecord, PutRecords,
    * and GetRecords, on a stream in the DELETING state until the stream deletion is complete.
    *
    * When you delete a stream, any shards in that stream are also deleted, and any tags are dissociated from the stream.
    *
    * You can use the DescribeStream operation to check the state of the stream, which is returned in StreamStatus.
    *
    * [[DeleteStream]] has a limit of five transactions per second per account.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def deleteStream(params: DeleteStream,
                   callback: AWSCallback[DeleteStreamResult] = js.native): AWSRequest[DeleteStreamResult] = js.native

  /**
    * To deregister a consumer, provide its ARN. Alternatively, you can provide the ARN of the data stream and the name
    * you gave the consumer when you registered it. You may also provide all three parameters, as long as they don't
    * conflict with each other. If you don't know the name or ARN of the consumer that you want to deregister, you can
    * use the ListStreamConsumers operation to get a list of the descriptions of all the consumers that are currently
    * registered with a given data stream. The description of a consumer contains its name and ARN.
    *
    * This operation has a limit of five transactions per second per account.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def deregisterStreamConsumer(params: DeregisterStreamConsumer,
                               callback: AWSCallback[DeregisterStreamConsumerResult] = js.native): AWSRequest[DeregisterStreamConsumerResult] = js.native

  /**
    * Describes the shard limits and usage for the account.
    *
    * If you update your account limits, the old limits might be returned for a few minutes.
    *
    * This operation has a limit of one transaction per second per account.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def describeLimits(params: DescribeLimits,
                     callback: AWSCallback[DescribeLimitsResult] = js.native): AWSRequest[DescribeLimitsResult] = js.native

  /** Describes the specified Kinesis data stream.
    *
    * The information returned includes the stream name, Amazon Resource Name (ARN), creation time, enhanced metric
    * configuration, and shard map. The shard map is an array of shard objects. For each shard object, there is the
    * hash key and sequence number ranges that the shard spans, and the IDs of any earlier shards that played in a
    * role in creating the shard. Every record ingested in the stream is identified by a sequence number, which is
    * assigned when the record is put into the stream.
    *
    * You can limit the number of shards returned by each call. For more information, see Retrieving Shards from a
    * Stream in the Amazon Kinesis Data Streams Developer Guide.
    *
    * There are no guarantees about the chronological order shards returned. To process shards in chronological order,
    * use the ID of the parent shard to track the lineage to the oldest shard.
    *
    * This operation has a limit of 10 transactions per second per account.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def describeStream(params: DescribeStream,
                     callback: AWSCallback[DescribeStreamResult] = js.native): AWSRequest[DescribeStreamResult] = js.native

  /**
    * Waits for a given Kinesis resource. The final callback or 'complete' event will be fired only when the resource
    * is either in its final state or the waiter has timed out and stopped polling for the final state.
    * @param state  the resource state to wait for. Available states for this service are listed in "Waiter Resource States" below.
    * @param params a list of parameters for the given state. See each waiter resource state for required parameters.
    * @return a [[AWSRequest handle]] to the operation request for subsequent event callback registration.
    */
  def waitFor(state: String, params: StreamStatus,
              callback: AWSCallback[WaitForResult] = js.native): AWSRequest[WaitForResult] = js.native

}


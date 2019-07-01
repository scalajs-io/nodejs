package io.scalajs.npm.aws.kinesis

import scala.scalajs.js

/**
  * Describes the specified Kinesis data stream.
  *
  * The information returned includes the stream name, Amazon Resource Name (ARN), creation time, enhanced metric
  * configuration, and shard map. The shard map is an array of shard objects. For each shard object, there is the hash
  * key and sequence number ranges that the shard spans, and the IDs of any earlier shards that played in a role in
  * creating the shard. Every record ingested in the stream is identified by a sequence number, which is assigned
  * when the record is put into the stream.
  *
  * You can limit the number of shards returned by each call. For more information, see Retrieving Shards from a Stream
  * in the Amazon Kinesis Data Streams Developer Guide.
  *
  * There are no guarantees about the chronological order shards returned. To process shards in chronological order,
  * use the ID of the parent shard to track the lineage to the oldest shard.
  *
  * This operation has a limit of 10 transactions per second per account.
  * @example {{{
  * {
  *    "ExclusiveStartShardId": "string",
  *    "Limit": number,
  *    "StreamName": "string"
  * }
  * }}}
  * @param ExclusiveStartShardId The shard ID of the shard to start with.
  * @param Limit                 The maximum number of shards to return in a single call. The default value is 100.
  *                              If you specify a value greater than 100, at most 100 shards are returned.
  * @param StreamName            The name of the stream to describe.
  */
class DescribeStream(var ExclusiveStartShardId: js.UndefOr[String] = js.undefined,
                     var Limit: js.UndefOr[Int] = js.undefined,
                     var StreamName: js.UndefOr[String] = js.undefined) extends js.Object
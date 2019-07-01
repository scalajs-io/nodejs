package io.scalajs.npm.aws.kinesis

import scala.scalajs.js

/**
  * Stream Status
  * @param StreamName            The name of the stream to describe.
  * @param Limit                 The maximum number of shards to return in a single call. The default value is 100.
  *                              If you specify a value greater than 100, at most 100 shards are returned.
  * @param ExclusiveStartShardId The shard ID of the shard to start with.
  */
class StreamStatus(var StreamName: js.UndefOr[String] = js.undefined,
                   var Limit: js.UndefOr[Int] = js.undefined,
                   var ExclusiveStartShardId: js.UndefOr[String] = js.undefined) extends js.Object
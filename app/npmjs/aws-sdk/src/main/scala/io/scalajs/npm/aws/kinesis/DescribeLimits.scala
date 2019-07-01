package io.scalajs.npm.aws.kinesis

import scala.scalajs.js

/**
  * Describes the shard limits and usage for the account.
  *
  * If you update your account limits, the old limits might be returned for a few minutes.
  *
  * This operation has a limit of one transaction per second per account.
  * @example {{{
  * {
  *     "OpenShardCount": 20,
  *     "ShardLimit": 70
  * }
  * }}}
  * @param OpenShardCount The number of open shards.
  * @param ShardLimit     The maximum number of shards.
  * @see [[https://docs.aws.amazon.com/kinesis/latest/APIReference/API_DescribeLimits.html]]
  */
class DescribeLimits(var OpenShardCount: js.UndefOr[Int] = js.undefined,
                     var ShardLimit: js.UndefOr[Int] = js.undefined) extends js.Object
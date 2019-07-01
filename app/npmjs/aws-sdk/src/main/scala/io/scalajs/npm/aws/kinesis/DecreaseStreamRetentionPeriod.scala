package io.scalajs.npm.aws.kinesis

import scala.scalajs.js

/**
  * Decrease Stream Retention Period
  * @param RetentionPeriodHours The new retention period of the stream, in hours. Must be less than the current retention period.
  * @param StreamName           The name of the stream to modify.
  * @see [[https://docs.aws.amazon.com/kinesis/latest/APIReference/API_DecreaseStreamRetentionPeriod.html]]
  */
class DecreaseStreamRetentionPeriod(var RetentionPeriodHours: js.UndefOr[Int] = js.undefined,
                                    var StreamName: js.UndefOr[String] = js.undefined) extends js.Object
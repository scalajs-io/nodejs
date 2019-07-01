package io.scalajs.npm.aws.sns

import scala.scalajs.js

/**
  * Deletes a topic and all its subscriptions. Deleting a topic might prevent some messages previously sent to the
  * topic from being delivered to subscribers. This action is idempotent, so deleting a topic that does not exist
  * does not result in an error.
  */
class DeleteTopic(var TopicArn: js.UndefOr[String] = js.undefined) extends js.Object
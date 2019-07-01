package io.scalajs.npm.aws.sns

import scala.scalajs.js

/**
  * A wrapper type for the topic's Amazon Resource Name (ARN). To retrieve a topic's attributes, use GetTopicAttributes.
  * @param TopicArn The topic's ARN.
  */
class Topic(var TopicArn: js.UndefOr[String] = js.undefined) extends js.Object
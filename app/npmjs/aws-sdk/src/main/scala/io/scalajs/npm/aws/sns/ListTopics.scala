package io.scalajs.npm.aws.sns

import scala.scalajs.js

/**
  * Returns a list of the requester's topics. Each call returns a limited list of topics, up to 100.
  * If there are more topics, a NextToken is also returned. Use the NextToken parameter in a new ListTopics
  * call to get further results.
  *
  * This action is throttled at 30 transactions per second (TPS).
  * @param NextToken Token returned by the previous ListTopics request.
  */
class ListTopics(var NextToken: js.UndefOr[String] = js.undefined) extends js.Object
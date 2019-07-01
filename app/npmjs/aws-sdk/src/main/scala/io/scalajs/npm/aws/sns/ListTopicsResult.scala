package io.scalajs.npm.aws.sns

import scala.scalajs.js

/**
  * The following elements are returned by the service.
  * @param NextToken Token to pass along to the next ListTopics request. This element is returned if there are
  *                  additional topics to retrieve.
  * @param Topics    A list of topic ARNs.
  */
class ListTopicsResult(var NextToken: js.UndefOr[String] = js.undefined,
                       var Topics: js.UndefOr[Topic] = js.undefined) extends js.Object
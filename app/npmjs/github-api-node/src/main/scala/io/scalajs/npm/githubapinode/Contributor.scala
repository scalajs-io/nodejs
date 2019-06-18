package io.scalajs.npm.githubapinode

import io.scalajs.npm.githubapinode.Contributor._

import scala.scalajs.js

/**
  * Represents a Contributor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Contributor extends js.Object {
  val total: Int = js.native
  val weeks: js.Array[Week] = js.native
  val author: Author = js.native
}

/**
  * Contributor Companion
  * @author lawrence.daniels@gmail.com
  */
object Contributor {

  @js.native
  trait Author extends js.Object {
    val login: String = js.native
    val id: Int = js.native
    val avatar_url: String = js.native
    val gravatar_id: String = js.native
    val url: String = js.native
    val html_url: String = js.native
    val followers_url: String = js.native
    val following_url: String = js.native
    val gists_url: String = js.native
    val starred_url: String = js.native
    val subscriptions_url: String = js.native
    val organizations_url: String = js.native
    val repos_url: String = js.native
    val events_url: String = js.native
    val received_events_url: String = js.native
    val `type`: String = js.native
    val site_admin: Boolean = js.native
  }

  @js.native
  trait Week extends js.Object {
    val w: Int = js.native
    val a: Int = js.native
    val d: Int = js.native
    val c: Int = js.native
  }

}

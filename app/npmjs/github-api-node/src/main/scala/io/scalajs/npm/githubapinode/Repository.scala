package io.scalajs.npm.githubapinode

import scala.scalajs.js


/**
  * Represents an individual GitHub Repository Object
  * @author lawrence.daniels@gmail.com
  */

class Repository(var id: js.UndefOr[Int] = js.undefined,
                 var name: js.UndefOr[String] = js.undefined,
                 var full_name: js.UndefOr[String] = js.undefined,
                 var owner: js.UndefOr[Repository.Owner] = js.undefined) extends js.Object

/**
  * Repository Singleton
  * @author lawrence.daniels@gmail.com
  */
object Repository {

  @js.native
  trait Owner extends js.Object {
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
    val `private`: Boolean = js.native
  }

}

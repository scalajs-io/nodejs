package io.scalajs.npm.angularjs.facebook

import io.scalajs.dom.html.browser.console
import io.scalajs.nodejs.social.facebook._
import io.scalajs.util.ScalaJsHelper._
import io.scalajs.npm.angularjs.Service

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal
import scala.util.{Failure, Success, Try}

/**
  * Angular Facebook Service (v2.5)
  * @author lawrence.daniels@gmail.com
  * @see [[https://developers.facebook.com/docs/graph-api/using-graph-api/v2.5]]
  */
class FacebookService() extends Service {
  type CallbackObject = js.Function1[js.Dynamic, Unit]
  type PaginationCallback[T] = js.Function1[FacebookPagination[T], Unit]

  // define the API properties
  var auth: js.UndefOr[FacebookAuthResponse] = js.undefined

  ///////////////////////////////////////////////////////////////////////////
  //      Authentication and User Profile-related Functions
  ///////////////////////////////////////////////////////////////////////////

  def accessToken: js.UndefOr[String] = auth.map(_.accessToken)

  def facebookID: js.UndefOr[String] = auth.map(_.userID)

  def getLoginStatus = {
    val promise = Promise[FacebookLoginStatusResponse]()
    FB.getLoginStatus((response: js.UndefOr[FacebookLoginStatusResponse]) =>
      specialHandling(promise, response) {
        case resp if resp.status == "connected" =>
          auth = resp.authResponse
          //console.log(s"facebookID = $facebookID, auth = ${angular.toJson(auth)}")
          Success(resp)
        case resp =>
          Failure(new RuntimeException(s"Facebook is not connected (status: ${resp.status})"))
      })
    promise
  }

  def getUserProfile = {
    val promise = Promise[FacebookProfileResponse]()
    FB.api(fbURL(), (response: js.UndefOr[FacebookProfileResponse]) => handleResponse(promise, response))
    promise
  }

  def login() = {
    val promise = Promise[FacebookLoginStatusResponse]()
    FB.login((response: js.UndefOr[FacebookLoginStatusResponse]) =>
      specialHandling(promise, response) { resp =>
        auth = resp.authResponse
        //console.log(s"facebookID = $facebookID, auth = ${angular.toJson(auth)}")
        Success(resp)
      })
    promise
  }

  def logout() = {
    val promise = Promise[FacebookLoginStatusResponse]()
    FB.logout((response: js.UndefOr[FacebookLoginStatusResponse]) => handleResponse(promise, response))
    promise
  }

  ///////////////////////////////////////////////////////////////////////////
  //      Achievement Functions
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Retrieves an achievement by ID
    * @param achievementID the given achievement ID
    * @return a promise of a [[FacebookAchievementResponse achievement response]]
    * @see [[https://developers.facebook.com/docs/games/achievements]]
    */
  def getAchievement(achievementID: String) = {
    val promise = Promise[FacebookAchievementResponse]()
    FB.api(fbURL(s"/achievements"), (response: js.UndefOr[FacebookAchievementResponse]) => handleResponse(promise, response))
    promise
  }

  ///////////////////////////////////////////////////////////////////////////
  //      Friend-related Functions
  ///////////////////////////////////////////////////////////////////////////

  def createFriendList(friendListId: String) = {
    val promise = Promise[FacebookResponse]()
    FB.api(fbURL(s"/$friendListId/member"), (response: js.UndefOr[FacebookResponse]) => handleResponse(promise, response))
    promise
  }

  def getFriends = {
    val promise = Promise[js.Array[TaggableFriend]]()
    val friends = emptyArray[TaggableFriend]
    FB.api(fbURL("/friends"), (response: FacebookPagination[TaggableFriend]) => {
      //console.log(s"response = ${angular.toJson(response)}")
      val results = response.data
      if (results.nonEmpty) {
        friends.push(results: _*)
        console.log(s"${friends.length} friend(s) loaded")
      }
      ()
    })
    promise
  }

  def getFriendList(listType: js.UndefOr[String] = "close_friends") = {
    val promise = Promise[FacebookResponse]()
    FB.api(fbURL("/friendlists", s"list_type=$listType"), (response: js.UndefOr[FacebookResponse]) => handleResponse(promise, response))
    promise
  }

  def getFriendListMembers(friendListId: String) = {
    val promise = Promise[FacebookResponse]()
    FB.api(fbURL(s"/$friendListId/members"), (response: js.UndefOr[FacebookResponse]) => handleResponse(promise, response))
    promise
  }

  /**
    * Retrieves all "taggable" friends for the authenticated user
    * @return the array of [[TaggableFriend taggable friends]]
    */
  def getTaggableFriends = {
    val promise = Promise[js.Array[TaggableFriend]]()
    val friends = emptyArray[TaggableFriend]
    val callback: PaginationCallback[TaggableFriend] = (response: FacebookPagination[TaggableFriend]) => {
      //console.log(s"response = ${angular.toJson(response)}")
      val results = response.data
      if (results.nonEmpty) {
        friends.push(results: _*)
        console.log(s"${friends.length} friend(s) loaded")
      }
      ()
    }
    FB.api(fbURL("/taggable_friends"), { (response: TaggableFriendsResponse) =>
      handlePaginatedResults(response, callback)
      promise.success(friends)
    })
    promise
  }

  ///////////////////////////////////////////////////////////////////////////
  //      Photo-related Functions
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Retrieves photos for the current user
    * @param `type` the given photo type (e.g. "uploaded" or "tagged")
    * @return a promise of an array of [[FacebookPhoto photos]]
    * @see [[https://developers.facebook.com/docs/graph-api/reference/user/photos/]]
    */
  def getPhotos(`type`: js.UndefOr[String] = js.undefined) = {
    val promise = Promise[FacebookPhotosResponse]()
    FB.api(fbURL("/photos", `type` map (myType => s"type=$myType")), (response: FacebookPhotosResponse) => handleResponse(promise, response))
    promise
  }

  ///////////////////////////////////////////////////////////////////////////
  //      Page-related Functions
  ///////////////////////////////////////////////////////////////////////////

  def getConversations(pageAccessToken: String) = {
    FB.api("/me/conversations", literal(access_token = pageAccessToken))
  }

  ///////////////////////////////////////////////////////////////////////////
  //      Other Functions
  ///////////////////////////////////////////////////////////////////////////

  def feed(appID: String, caption: String, link: String) = {
    val promise = Promise[FacebookResponse]()
    FB.ui(FacebookCommand(app_id = appID, method = "feed", link = link, caption = caption), (response: js.UndefOr[FacebookResponse]) => handleResponse(promise, response))
    promise
  }

  def send(appID: String, message: String, link: String) = {
    val promise = Promise[FacebookResponse]()
    FB.ui(FacebookCommand(app_id = appID, method = "send", link = link), (response: js.UndefOr[FacebookResponse]) => handleResponse(promise, response))
    promise
  }

  def share(appID: String, link: String) = {
    val promise = Promise[FacebookResponse]()
    FB.ui(FacebookCommand(app_id = appID, method = "share", href = link), (response: js.UndefOr[FacebookResponse]) => handleResponse(promise, response))
    promise
  }

  ///////////////////////////////////////////////////////////////////////////
  //      Private Functions
  ///////////////////////////////////////////////////////////////////////////

  /**
    * Returns the URL for a Facebook API call
    * @param path     the optional Facebook node (e.g. "/photos")
    * @param args     the optional parameters
    * @param fbUserID the optional Facebook User ID (e.g. "10203751019174743")
    * @return the URL (e.g. "/me/photos?access_token=....")
    */
  private def fbURL(path: String = "", args: js.UndefOr[String] = js.undefined, fbUserID: String = "me") = {
    s"/$fbUserID$path?access_token=$accessToken" + (args map (myArgs => s"&$myArgs") getOrElse "")
  }

  private def handleResponse[A <: FacebookResponse](promise: Promise[A], response: js.UndefOr[A]) = {
    response.toOption match {
      case Some(resp) if resp.error.isEmpty => promise.success(resp)
      case Some(resp) => promise.failure(new Exception(resp.error getOrElse "Cause unknown"))
      case None => promise.failure(new Exception("No response from Facebook"))
    }
  }

  /**
    * Recursive retrieves a set of paginated results
    * @param response the given [[FacebookPagination pagination set]]
    * @param callback the function callback
    * @tparam A the paginated data type
    * @see [[https://developers.facebook.com/docs/graph-api/using-graph-api/v2.5#paging]]
    */
  private def handlePaginatedResults[A](response: FacebookPagination[A], callback: PaginationCallback[A]) {
    // TODO implement both cursor and time-based pagination
    // perform the callback for this response
    callback(response)

    // if there are more results, recursively extract them
    response.paging.foreach(_.next foreach { url =>
      FB.api(url, (response: FacebookPagination[A]) => handlePaginatedResults(response, callback))
    })
  }

  private def specialHandling[A <: FacebookResponse](promise: Promise[A], response: js.UndefOr[A])(handler: A => Try[A]) = {
    response.toOption match {
      case Some(resp) if resp.error.isEmpty =>
        handler(resp) match {
          case Success(value) => promise.success(value)
          case Failure(e) => promise.failure(e)
        }
      case Some(resp) => promise.failure(new Exception(resp.error getOrElse "Cause unknown"))
      case None => promise.failure(new Exception("No response from Facebook"))
    }
  }

}

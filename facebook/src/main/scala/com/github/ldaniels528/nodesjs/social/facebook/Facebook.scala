package com.github.ldaniels528.nodesjs.social.facebook

import scala.scalajs.js

/**
  * Facebook SDK binding for Scala.js
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Facebook extends js.Object {

  def api(url: String, callback: js.Function): Unit = js.native

  def api(url: String, params: js.Object): Unit = js.native

  def getLoginStatus(callback: js.Function1[js.UndefOr[FacebookLoginStatusResponse], Any]): Unit = js.native

  def init(config: FacebookAppConfig): Unit = js.native

  def login(callback: js.Function1[js.UndefOr[FacebookLoginStatusResponse], Any]): Unit = js.native

  def logout(callback: js.Function1[js.UndefOr[FacebookLoginStatusResponse], Any]): Unit = js.native

  def ui(command: FacebookCommand, callback: js.Function): Unit = js.native

}

/**
  * Facebook SDK Companion Object
  * @author lawrence.daniels@gmail.com
  */
object Facebook {
  lazy val FB = js.Dynamic.global.FB.asInstanceOf[js.UndefOr[Facebook]]
    .getOrElse(throw new IllegalStateException("Facebook SDK is not loaded"))

}

/*
 * Facebook Application Object
 * @author lawrence.daniels@gmail.com
 * @see [[https://developers.facebook.com/docs/graph-api/reference/application]]
 */
@js.native
trait FacebookApp extends FacebookResponse {
  var id: String
  var android_key_hash: js.Array[String]
  var android_sdk_error_categories: js.Array[FacebookMobileSdkErrorCategory]
  var app_ad_debug_info: FacebookApplicationAppAdDebugInfo
  var app_domains: js.Array[String]
  var app_events_feature_bitmask: Long
  var app_install_tracked: Boolean
  var app_name: String
  var app_type: Long
  var auth_dialog_data_help_url: String
  var auth_dialog_headline: String
  var auth_dialog_perms_explanation: String
  var auth_referral_default_activity_privacy: String
  var auth_referral_enabled: Long
  var auth_referral_extended_perms: js.Array[String]
  var auth_referral_friend_perms: js.Array[String]
  var auth_referral_response_type: String
  var auth_referral_user_perms: js.Array[String]
  var canvas_fluid_height: Boolean
  var canvas_fluid_width: Long
  var canvas_url: String
  var category: String
  var client_config: js.Dictionary[js.Any]
  var company: String
  var configured_ios_sso: Boolean
  var contact_email: String
  var context: js.Object
  // ApplicationContext
  var created_time: js.Date
  var creator_uid: js.Object // id
  // ...
}

/*
 * Facebook Application App Ad Debug Info
 * @author lawrence.daniels@gmail.com
 * @see [[https://developers.facebook.com/docs/graph-api/reference/application]]
 */
@js.native
trait FacebookApplicationAppAdDebugInfo extends FacebookResponse

/*
 * Facebook Achievement Response
 * @author lawrence.daniels@gmail.com
 * @see [[https://developers.facebook.com/docs/graph-api/reference/v2.5/achievement]]
 */
@js.native
trait FacebookAchievementResponse extends FacebookResponse {
  var id: js.UndefOr[String]
  var from: js.UndefOr[js.Object]
  // User
  var publish_time: js.UndefOr[js.Date]
  var application: js.UndefOr[FacebookApp]
  var data: js.Object
  var `type`: String
  var no_feed_story: Boolean
}

/*
 * Facebook Authorization Response
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait FacebookAuthResponse extends FacebookResponse {
  var accessToken: String
  var signedRequest: String
  var userID: String
  var expiresIn: Int
}

/*
 * Facebook Login Response
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait FacebookLoginStatusResponse extends FacebookResponse {
  var authResponse: FacebookAuthResponse
  var status: String
}

/*
 * Facebook Mobile SDK Error Category
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait FacebookMobileSdkErrorCategory extends js.Object

/**
  * Facebook Photo
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPhoto extends js.Object {
  var data: js.Array[FacebookPictureData]
}

/**
  * Facebook Photos Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPhotosResponse extends FacebookResponse {
  var data: js.Array[FacebookPhoto]
  var paging: js.UndefOr[FacebookPaging]
}

/**
  * Represents a Facebook Profile
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookProfileResponse extends FacebookResponse {
  var id: String
  var first_name: String
  var last_name: String
  var name: String
  var gender: String
  var link: String
  var locale: String
  var updated_time: js.Date
  var timezone: Int
  var verified: Boolean
}

/**
  * Facebook Friend Picture
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPicture extends js.Object {
  var data: FacebookPictureData
}

/**
  * Facebook Friend Picture Data
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPictureData extends js.Object {
  var is_silhouette: Boolean
  var url: String
}

/**
  * Facebook Cursor Trait
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookCursor extends js.Object {
  var before: js.UndefOr[String]
  var after: js.UndefOr[String]
}

/**
  * Facebook Pagination Trait
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPagination[T] extends js.Object {
  var data: js.Array[T]
  var paging: js.UndefOr[FacebookPaging]
}

/**
  * Facebook Paging Trait
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPaging extends js.Object {
  var cursors: FacebookCursor
  var previous: js.UndefOr[String]
  var next: js.UndefOr[String]
}

/**
  * Generic Facebook Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookResponse extends js.Object {
  var error: js.UndefOr[String]
}

/**
  * Facebook Taggable Friend
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TaggableFriend extends js.Object {
  var id: String
  var name: String
  var picture: FacebookPicture
}

/**
  * Facebook Taggable Friends Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TaggableFriendsResponse extends FacebookPagination[TaggableFriend]

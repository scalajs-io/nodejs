package io.scalajs.social.facebook

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

/*
 * Facebook Application Object
 * @author lawrence.daniels@gmail.com
 * @see [[https://developers.facebook.com/docs/graph-api/reference/application]]
 */
@js.native
trait FacebookApp extends FacebookResponse {
  var id: String = js.native
  var android_key_hash: js.Array[String] = js.native
  var android_sdk_error_categories: js.Array[FacebookMobileSdkErrorCategory] = js.native
  var app_ad_debug_info: FacebookApplicationAppAdDebugInfo = js.native
  var app_domains: js.Array[String] = js.native
  var app_events_feature_bitmask: Long = js.native
  var app_install_tracked: Boolean = js.native
  var app_name: String = js.native
  var app_type: Long = js.native
  var auth_dialog_data_help_url: String = js.native
  var auth_dialog_headline: String = js.native
  var auth_dialog_perms_explanation: String = js.native
  var auth_referral_default_activity_privacy: String = js.native
  var auth_referral_enabled: Long = js.native
  var auth_referral_extended_perms: js.Array[String] = js.native
  var auth_referral_friend_perms: js.Array[String] = js.native
  var auth_referral_response_type: String = js.native
  var auth_referral_user_perms: js.Array[String] = js.native
  var canvas_fluid_height: Boolean = js.native
  var canvas_fluid_width: Long = js.native
  var canvas_url: String = js.native
  var category: String = js.native
  var client_config: js.Dictionary[js.Any] = js.native
  var company: String = js.native
  var configured_ios_sso: Boolean = js.native
  var contact_email: String = js.native
  var context: js.Object = js.native
  // ApplicationContext
  var created_time: js.Date = js.native
  var creator_uid: js.Object = js.native // id
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
  var id: js.UndefOr[String] = js.native
  var from: js.UndefOr[js.Object] = js.native
  // User
  var publish_time: js.UndefOr[js.Date] = js.native
  var application: js.UndefOr[FacebookApp] = js.native
  var data: js.Object = js.native
  var `type`: String = js.native
  var no_feed_story: Boolean = js.native
}

/*
 * Facebook Authorization Response
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait FacebookAuthResponse extends FacebookResponse {
  var accessToken: String = js.native
  var signedRequest: String = js.native
  var userID: String = js.native
  var expiresIn: Int = js.native
}

/*
 * Facebook Login Response
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait FacebookLoginStatusResponse extends FacebookResponse {
  var authResponse: FacebookAuthResponse = js.native
  var status: String = js.native
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
  var data: js.Array[FacebookPictureData] = js.native
}

/**
  * Facebook Photos Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPhotosResponse extends FacebookResponse {
  var data: js.Array[FacebookPhoto] = js.native
  var paging: js.UndefOr[FacebookPaging] = js.native
}

/**
  * Represents a Facebook Profile
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookProfileResponse extends FacebookResponse {
  var id: String = js.native
  var first_name: String = js.native
  var last_name: String = js.native
  var name: String = js.native
  var gender: String = js.native
  var link: String = js.native
  var locale: String = js.native
  var updated_time: js.Date = js.native
  var timezone: Int = js.native
  var verified: Boolean = js.native
}

/**
  * Facebook Friend Picture
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPicture extends js.Object {
  var data: FacebookPictureData = js.native
}

/**
  * Facebook Friend Picture Data
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPictureData extends js.Object {
  var is_silhouette: Boolean = js.native
  var url: String = js.native
}

/**
  * Facebook Cursor Trait
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookCursor extends js.Object {
  var before: js.UndefOr[String] = js.native
  var after: js.UndefOr[String] = js.native
}

/**
  * Facebook Pagination Trait
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPagination[T] extends js.Object {
  var data: js.Array[T] = js.native
  var paging: js.UndefOr[FacebookPaging] = js.native
}

/**
  * Facebook Paging Trait
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookPaging extends js.Object {
  var cursors: FacebookCursor = js.native
  var previous: js.UndefOr[String] = js.native
  var next: js.UndefOr[String] = js.native
}

/**
  * Generic Facebook Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookResponse extends js.Object {
  var error: js.UndefOr[String] = js.native
}

/**
  * Facebook Taggable Friend
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TaggableFriend extends js.Object {
  var id: String = js.native
  var name: String = js.native
  var picture: FacebookPicture = js.native
}

/**
  * Facebook Taggable Friends Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TaggableFriendsResponse extends FacebookPagination[TaggableFriend]

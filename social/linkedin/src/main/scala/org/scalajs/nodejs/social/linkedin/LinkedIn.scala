package org.scalajs.nodejs.social.linkedin

import scala.scalajs.js

/**
  * LinkedIn JavaScript API Scala.js Binding
  * @author lawrence.daniels@gmail.com
  * @see [[https://developer-programs.linkedin.com/documents/making-api-requests-using-inapi]]
  * @see [[https://developer-programs.linkedin.com/documents/inauth-inevent-and-inui]]
  * @see [[https://developer.linkedin.com/docs/signin-with-linkedin]]
  */
@js.native
trait LinkedIn extends js.Object {
  val API: LinkedInAPIService = js.native
  val AUTH: js.Dynamic = js.native // TODO is AUTH a valid service?
  val Event: LinkedInEventService = js.native
  val ENV: LinkedInEnvironmentService = js.native
  val UI: LinkedInUIService = js.native
  val User: LinkedInUserService = js.native

  /**
    * Initializes the LinkedIn JavaScript API
    * @param config the given [[LinkedInConfig configuration]]
    */
  def init(config: LinkedInConfig): Unit = js.native

  /**
    * Parses a tag
    * @param domNode the given DOM node
    * @return
    */
  def parse(domNode: String): Any = js.native // TODO find out the return type

}

/**
  * LinkedIn API Service
  * @author lawrence.daniels@gmail.com
  * @see [[http://java2practice.com/2013/03/14/how-to-use-linkedin-javascript-api/]]
  */
@js.native
trait LinkedInAPIService extends js.Object {

  /**
    * Connections service
    * @see [[https://developer-programs.linkedin.com/documents/inapiconnections]]
    * @see [[http://stackoverflow.com/questions/29109880/linkedin-js-api-get-my-connections-issue]]
    */
  def Connections(): LinkedInConnectionsService = js.native

  /**
    * Connections service
    */
  def Connections(ids: js.Array[String]): LinkedInConnectionsService = js.native

  /**
    * Member Updates service
    * @see [[https://developer-programs.linkedin.com/documents/inapimemberupdates-and-inapinetworkupdates]]
    */
  def MemberUpdates(): LinkedInMemberUpdatesService = js.native

  /**
    * Member Updates service
    */
  def MemberUpdates(id: String): LinkedInMemberUpdatesService = js.native

  /**
    * Network Updates service
    * @see [[https://developer-programs.linkedin.com/documents/inapimemberupdates-and-inapinetworkupdates]]
    */
  def NetworkUpdates(): LinkedInNetworkUpdatesService = js.native

  /**
    * Network Updates service
    */
  def NetworkUpdates(id: String): LinkedInNetworkUpdatesService = js.native

  /**
    * People Search service
    * @see [[https://developer-programs.linkedin.com/documents/inapipeoplesearch]]
    */
  def PeopleSearch(): LinkedInPeopleSearchService = js.native

  /**
    * Profile Information service
    * @see [[https://developer-programs.linkedin.com/documents/inapiprofile]]
    */
  def Profile(): LinkedInAPIProfileService = js.native

  /**
    * Profile Information service
    */
  def Profile(ids: js.Array[String]): LinkedInAPIProfileService = js.native

  /**
    * Raw REST service
    * @see [[https://developer-programs.linkedin.com/documents/inapiraw]]
    * @see [[https://developer.linkedin.com/docs/company-pages]]
    */
  def Raw[T <: js.Any](): LinkedInAPIService_URL[T] = js.native

  /**
    * Raw REST service
    */
  def Raw[T <: js.Any](path: String): LinkedInAPIService_OptionsOrPromise[T] = js.native

}

/**
  * LinkedIn API Service: Connections
  * @author lawrence.daniels@gmail.com
  * @see [[https://developer-programs.linkedin.com/documents/inapiconnections]]
  */
@js.native
trait LinkedInConnectionsService extends LinkedInPromise[LinkedInProfileResponse] {

  /**
    * Specifies the IDs to retrieve.
    * @param identifiers the given identifiers
    * @return a reference to [[LinkedInConnectionsService self]]
    */
  def ids(identifiers: js.Array[String]): this.type = js.native

  def fields(names: String*): this.type = js.native

  def params(values: js.Dictionary[Any]): this.type = js.native

}

/**
  * LinkedIn API Options, URL or Promise
  * @author lawrence.daniels@gmail.com
  * @see [[http://java2practice.com/2013/03/14/how-to-use-linkedin-javascript-api/]]
  */
@js.native
trait LinkedInAPIService_URL[T <: js.Any] extends js.Object {

  /**
    * The API URL to invoke: should not include https://api.linkedin.com/v1.
    * @param path the given URI (e.g. "/people/~/shares?format=json")
    * @return a reference to [[LinkedInAPIService_OptionsOrPromise self]]
    */
  def url(path: String): LinkedInAPIService_OptionsOrPromise[T] = js.native

}

/**
  * LinkedIn API Options or Promise
  * @author lawrence.daniels@gmail.com
  * @see [[http://java2practice.com/2013/03/14/how-to-use-linkedin-javascript-api/]]
  */
@js.native
trait LinkedInAPIService_OptionsOrPromise[T <: js.Any] extends LinkedInPromise[T] {

  /**
    * For APIs with a POST body, POSTs and PUTs, this is the URL encoded post body. For GET requests, this does nothing.
    * @param content the given body content
    * @return a reference to [[LinkedInAPIService_OptionsOrPromise self]]
    */
  def body(content: String): this.type = js.native

  /**
    * Sets the HTTP method to use. If omitted, uses a default value of GET.
    * @param `type` the given HTTP method to use (GET, POST, PUT, or DELETE).
    * @return a reference to [[LinkedInAPIService_OptionsOrPromise self]]
    */
  def method(`type`: String): this.type = js.native

}

/**
  * LinkedIn Environment Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInEnvironmentService extends js.Object {
  var auth: LinkedInEnvironmentService_Auth
}

/**
  * LinkedIn Environment Auth
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInEnvironmentService_Auth extends js.Object {
  var oauth_token: js.UndefOr[String]
}

/**
  * LinkedIn Event Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInEventService extends js.Object {

  def on(handle: LinkedIn, eventName: String, callback: js.Function, callbackScope: js.Object = js.native, extraData: js.Object = js.native): Unit = js.native

  def onOnce(handle: LinkedIn, eventName: String, callback: js.Function, callbackScope: js.Object = js.native, extraData: js.Object = js.native): Unit = js.native

}

/**
  * LinkedIn API: Member Updates
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInMemberUpdatesService extends LinkedInPromise[LinkedInMemberUpdateResponse] {

  /**
    * Specifies the IDs to retrieve.
    * @param identifiers the given identifiers
    * @return a reference to [[LinkedInConnectionsService self]]
    */
  def ids(identifiers: js.Array[String]): this.type = js.native

  /**
    * Specifies the fields to retrieve. If not specified, the default fields will be
    * used: "id", "firstName", "lastName", "headline", "pictureUrl".  A full list of
    * available fields can be found in Profile Fields.
    * @param names the given field names
    * @return a reference to [[LinkedInAPIProfileService self]]
    */
  def fields(names: js.Array[String]): this.type = js.native

}

/**
  * LinkedIn API: Network Updates
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInNetworkUpdatesService extends LinkedInPromise[LinkedInMemberUpdateResponse] {

  /**
    * Specifies the IDs to retrieve.
    * @param identifiers the given identifiers
    * @return a reference to [[LinkedInConnectionsService self]]
    */
  def ids(identifiers: js.Array[String]): this.type = js.native

  /**
    * Specifies the fields to retrieve. If not specified, the default fields will be
    * used: "id", "firstName", "lastName", "headline", "pictureUrl".  A full list of
    * available fields can be found in Profile Fields.
    * @param names the given field names
    * @return a reference to [[LinkedInAPIProfileService self]]
    */
  def fields(names: js.Array[String]): this.type = js.native

}

/**
  * LinkedIn API: People Search
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInPeopleSearchService extends LinkedInPromise[LinkedInProfileResponse] {

  def fields(names: String*): this.type = js.native

  def params(values: js.Dictionary[Any]): this.type = js.native

}

/**
  * LinkedIn API: Profile
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInAPIProfileService extends LinkedInPromise[LinkedInProfileResponse] {

  /**
    * Specifies the IDs to retrieve.
    * @param identifiers the given identifiers
    * @return a reference to [[LinkedInAPIProfileService self]]
    */
  def ids(identifiers: js.Array[String]): this.type = js.native

  /**
    * Specifies the fields to retrieve. If not specified, the default fields will be
    * used: "id", "firstName", "lastName", "headline", "pictureUrl".  A full list of
    * available fields can be found in Profile Fields.
    * @param names the given field names
    * @return a reference to [[LinkedInAPIProfileService self]]
    */
  def fields(names: js.Array[String]): this.type = js.native

}

/**
  * LinkedIn UI Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInUIService extends js.Object {

  /**
    * Opens an authorization window.
    */
  def Authorize(): LinkedInUIService_Authorize = js.native

  /**
    * Opens a LinkedIn Share window so that the current member can share a URL with his professional network.
    * @see [[http://stackoverflow.com/questions/5962088/linkedin-button-dynamic-rendering]]
    */
  def Share(): LinkedInUIService_Share = js.native

}

/**
  * LinkedIn UI Service: Authorize
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInUIService_Authorize extends LinkedInUIService_Place

/**
  * LinkedIn UI Service: Share
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInUIService_Share extends LinkedInUIService_Place {

  def params(container: LinkedInURLContainer): this.type = js.native

}

/**
  * LinkedIn UI Service: Place
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInUIService_Place extends js.Object {

  def place(): Unit = js.native

}

/**
  * LinkedIn User Service
  * @author lawrence.daniels@gmail.com
  * @see [[https://developer-programs.linkedin.com/documents/inauth-inevent-and-inui]]
  */
@js.native
trait LinkedInUserService extends js.Object {

  /**
    * Requests Authorization
    * @param callbackFunction a function to call when the user is authorized. If the user is already logged in, callbackFunction will fire immediately.
    * @param callbackScope an optional scope to run callbackFunction in. Defaults to the window scope.
    */
  def authorize(callbackFunction: js.Function, callbackScope: js.Object): Unit = js.native

  /**
    * Checks if the User Is Authorized
    * @return true if the user is authorized, otherwise it returns false
    */
  def isAuthorized(): Boolean = js.native

  /**
    * Logs the User Out
    * @param callbackFunction a function to call when the user is logged out.
    * @param callbackScope an optional scope to run callbackFunction in. Defaults to the window scope.
    */
  def logout(callbackFunction: js.Function, callbackScope: js.Object): Unit = js.native

  /**
    * Refreshes the User Session
    */
  def refresh(): Unit = js.native

}

///////////////////////////////////////////////////////////////////////////
//      Data Objects
///////////////////////////////////////////////////////////////////////////

/**
  * LinkedIn Configuration
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInConfig extends js.Object {
  var api_key: js.UndefOr[String]
  var onLoad: js.Function
}

/**
  * LinkedIn Member Update Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInMemberUpdateResponse extends js.Object {
  var isCommentable: js.UndefOr[Boolean]
  var isLikable: js.UndefOr[Boolean]
  var isLiked: js.UndefOr[Boolean]
  var numLikes: js.UndefOr[Int]
  var timestamp: js.UndefOr[js.Date]
  var updateContent: js.UndefOr[LinkedInMemberUpdate_UpdateContent]
  var updatedFields: js.UndefOr[LinkedInMemberUpdate_UpdatedFields]
  var updateKey: js.UndefOr[String]
  var updateType: js.UndefOr[String]
}

/**
  * LinkedIn Member Update - Update Content
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInMemberUpdate_UpdateContent extends js.Object {
  var person: js.UndefOr[LinkedInProfile]
}

/**
  * LinkedIn Member Update - Updated Fields
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInMemberUpdate_UpdatedFields extends js.Object {
  var _count: js.UndefOr[Int]
  var values: js.Array[js.Dictionary[Any]]
}

/**
  * LinkedIn Profile Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInProfileResponse extends LinkedInResponse[LinkedInProfile]

/**
  * LinkedIn Profile
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInProfile extends js.Object {
  var id: js.UndefOr[String]
  var firstName: js.UndefOr[String]
  var lastName: js.UndefOr[String]
  var pictureUrl: js.UndefOr[String]
  var headline: js.UndefOr[String]
  var industry: js.UndefOr[String]
  var location: js.UndefOr[LinkedInProfile_Location]
  var siteStandardProfileRequest: js.UndefOr[LinkedInProfile_SiteStandardProfileRequest]
  var apiStandardProfileRequest: js.UndefOr[LinkedInProfile_ApiStandardProfileRequest]
}

/**
  * LinkedIn Profile Location
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInProfile_Location extends js.Object {
  var name: js.UndefOr[String]
  var country: js.UndefOr[LinkedInProfile_LocationCode]
}

/**
  * LinkedIn Profile Location Code
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInProfile_LocationCode extends js.Object {
  var code: js.UndefOr[String]
}

/**
  * LinkedIn Profile Site Standard Profile Request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInProfile_SiteStandardProfileRequest extends js.Object {
  var url: js.UndefOr[String]
}

/**
  * LinkedIn Profile API Standard Profile Request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInProfile_ApiStandardProfileRequest extends js.Object {
  var headers: js.UndefOr[LinkedInProfile_ApiStandardProfileRequest_Headers]
  var url: js.UndefOr[String]
}

/**
  * LinkedIn Profile API Standard Profile Request Headers
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInProfile_ApiStandardProfileRequest_Headers extends LinkedInResponse[LinkedInNameValuePair]

///////////////////////////////////////////////////////////////////////////
//      Reference Types
///////////////////////////////////////////////////////////////////////////

/**
  * LinkedIn Name-Value Pair
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInNameValuePair extends js.Object {
  var name: js.UndefOr[String]
  var value: js.UndefOr[String]
}

/**
  * LinkedIn Paginated Response Wrapper
  * @author lawrence.daniels@gmail.com
  * @see [[https://developer.linkedin.com/docs/company-pages]]
  */
@js.native
trait LinkedInPaginatedResponse[T <: js.Any] extends LinkedInResponse[T] {
  var _count: js.UndefOr[Int]
  var _start: js.UndefOr[Int]
}

/**
  * LinkedIn Response Wrapper
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInResponse[T <: js.Any] extends js.Object {
  var _total: js.UndefOr[Int]
  var values: js.Array[T]

  // in the case of an error ....?
  var errorCode: js.UndefOr[Int]
  var message: js.UndefOr[String]
  var requestId: js.UndefOr[String]
  var status: js.UndefOr[Int]
  var timestamp: js.UndefOr[js.Date]
}

/**
  * LinkedIn URL Container
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LinkedInURLContainer extends js.Object {
  var url: js.UndefOr[String]
}
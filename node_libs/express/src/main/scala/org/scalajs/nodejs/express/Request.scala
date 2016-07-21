package org.scalajs.nodejs.express

import org.scalajs.nodejs.http.ClientRequest

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Express Http Request
  * @author lawrence.daniels@gmail.com
  * @see [[http://expressjs.com/en/api.html]]
  */
@js.native
trait Request extends ClientRequest {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This property holds a reference to the instance of the Express application
    * that is using the middleware. If you follow the pattern in which you create
    * a module that just exports a middleware function and require() it in your main
    * file, then the middleware can access the Express instance via req.app
    */
  def app: Application = js.native

  /**
    * The URL path on which a router instance was mounted. The req.baseUrl property is
    * similar to the mountpath property of the app object, except app.mountpath returns
    * the matched path pattern(s).
    */
  def baseUrl: String = js.native

  /**
    * Contains key-value pairs of data submitted in the request body. By default,
    * it is undefined, and is populated when you use body-parsing middleware such
    * as body-parser and multer. The following example shows how to use body-parsing
    * middleware to populate req.body
    */
  def body: js.Any = js.native

  /**
    * When using cookie-parser middleware, this property is an object that contains
    * cookies sent by the request. If the request contains no cookies, it defaults to {}.
    */
  def cookies: js.Any = js.native

  /**
    * Indicates whether the request is “fresh.” It is the opposite of req.stale.
    * It is true if the cache-control request header doesn’t have a no-cache directive
    * and any of the following are true:
    * <ul>
    * <li>The if-modified-since request header is specified and last-modified request header
    * is equal to or earlier than the modified response header.</li>
    * <li>The if-none-match request header is *.</li>
    * <li>The if-none-match request header, after being parsed into its directives,
    * does not match the etag response header.</li>
    * </ul>
    */
  def fresh: Boolean = js.native

  /**
    * Contains the hostname derived from the Host HTTP header. When the trust proxy setting
    * does not evaluate to false, this property will instead have the value of
    * the X-Forwarded-Host header field. This header can be set by the client or by the proxy.
    */
  def hostname: String = js.native

  /**
    * Contains the remote IP address of the request. When the trust proxy setting does
    * not evaluate to false, the value of this property is derived from the left-most
    * entry in the X-Forwarded-For header. This header can be set by the client or by the proxy.
    */
  def ip: String = js.native

  /**
    * When the trust proxy setting does not evaluate to false, this property contains
    * an array of IP addresses specified in the X-Forwarded-For request header.
    * Otherwise, it contains an empty array. This header can be set by the client or by the proxy.
    *
    * For example, if X-Forwarded-For is client, proxy1, proxy2, req.ips would be ["client", "proxy1", "proxy2"],
    * where proxy2 is the furthest downstream.
    */
  def ips: js.Array[String] = js.native

  /**
    * Contains a string corresponding to the HTTP method of the request: GET, POST, PUT, and so on.
    */
  def method: String = js.native

  /**
    * This property is much like req.url; however, it retains the original request URL,
    * allowing you to rewrite req.url freely for internal routing purposes. For example,
    * the “mounting” feature of [[org.scalajs.nodejs.express.Application.use app.use()]]
    * will rewrite req.url to strip the mount point.
    */
  def originalUrl: String = js.native

  /**
    * This property is an object containing properties mapped to the named route “parameters”.
    * For example, if you have the route /user/:name, then the “name” property is available as
    * req.params.name. This object defaults to {}.
    */
  def params: js.Dictionary[String] = js.native

  /**
    * Contains the path part of the request URL.
    */
  def path: String = js.native

  /**
    * Contains the request protocol string: either http or (for TLS requests) https.
    * When the trust proxy setting does not evaluate to false, this property will use
    * the value of the X-Forwarded-Proto header field if present. This header can be
    * set by the client or by the proxy.
    */
  def protocol: String = js.native

  /**
    * Returns an object containing a property for each query string parameter in the route.
    * If there is no query string, it is the empty object, {}.
    */
  def query: js.Dictionary[String] = js.native

  /**
    * Contains the currently-matched route, a string.
    */
  def route: String = js.native

  /**
    * A Boolean property that is true if a TLS connection is established. Equivalent to:
    * <code>'https' == req.protocol</code>.
    */
  def secure: Boolean = js.native

  /**
    * When using cookie-parser middleware, this property contains signed cookies sent by the request,
    * unsigned and ready for use. Signed cookies reside in a different object to show developer intent;
    * otherwise, a malicious attack could be placed on req.cookie values (which are easy to spoof).
    * Note that signing a cookie does not make it “hidden” or encrypted; but simply prevents tampering
    * (because the secret used to sign is private).
    *
    * If no signed cookies are sent, the property defaults to {}.
    */
  def signedCookies: js.Any = js.native

  /**
    * Indicates whether the request is “stale,” and is the opposite of req.fresh.
    * @see [[Request.fresh]]
    */
  def stale: Boolean = js.native

  /**
    * An array of sub-domains in the domain name of the request.
    */
  def subdomains: js.Array[String] = js.native

  /**
    * A Boolean property that is true if the request’s X-Requested-With header field is “XMLHttpRequest”,
    * indicating that the request was issued by a client library such as jQuery.
    */
  def xhr: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Checks if the specified content types are acceptable, based on the request’s Accept HTTP header field.
    * The method returns the best match, or if none of the specified content types is acceptable,
    * returns false (in which case, the application should respond with 406 "Not Acceptable").
    *
    * The type value may be a single MIME type string (such as “application/json”), an extension name such as “json”,
    * a comma-delimited list, or an array. For a list or array, the method returns the best match (if any).
    */
  def accepts(`type`: String): String = js.native

  /**
    * @see [[Request.accepts(String)]]
    */
  def accepts(types: js.Array[String]): String = js.native

  /**
    * Returns the specified HTTP request header field (case-insensitive match).
    * The Referrer and Referer fields are interchangeable.
    */
  def get(field: String): js.UndefOr[String] = js.native

  /**
    * Returns true if the incoming request’s “Content-Type” HTTP header field matches
    * the MIME type specified by the type parameter. Returns false otherwise.
    */
  def is(`type`: String): Boolean = js.native

  /**
    * Returns the value of param name when present.
    */
  def param(name: String, defaultValue: String): String = js.native

  /**
    * Returns the value of param name when present.
    */
  @deprecated("Use params() instead", since = "2.0")
  def param(name: String): js.UndefOr[String] = js.native

}

/**
  * Http Request Companion
  * @author lawrence.daniels@gmail.com
  */
object Request {

  /**
    * Http Request Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class HttpRequestExtensions(val request: Request) extends AnyVal {

    def bodyAs[T <: js.Any] = request.body.asInstanceOf[T]

    def cookiesAs[T <: js.Any] = request.cookies.asInstanceOf[T]

    def queryAs[T <: js.Object]: T = request.query.asInstanceOf[T]

  }

}
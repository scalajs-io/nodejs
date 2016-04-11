package com.github.ldaniels528.meansjs.nodejs.express

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * The Response object represents the HTTP response that an Express app sends when it gets an HTTP request.
  * In this documentation and by convention, the object is always referred to as res (and the HTTP request is req)
  * but its actual name is determined by the parameters to the callback function in which you’re working.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Response extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This property holds a reference to the instance of the Express application that is using the middleware.
    * res.app is identical to the [[Request.app]] property in the request object.
    */
  def app: Application

  /**
    * Boolean property that indicates if the app sent HTTP headers for the response.
    */
  def headersSent: Boolean

  /**
    * An object that contains response local variables scoped to the request, and therefore available only
    * to the view(s) rendered during that request / response cycle (if any). Otherwise, this property is
    * identical to app.locals.
    *
    * This property is useful for exposing request-level information such as the request path name,
    * authenticated user, user settings, and so on.
    */
  def locals: String

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Appends the specified value to the HTTP response header field. If the header is not already set,
    * it creates the header with the specified value. The value parameter can be a string or an array.
    * <b>Note</b>: calling [[Response.set()]] after [[Response.append()]] will reset the previously-set header value.
    */
  def append(field: String, value: String): Unit

  def append(field: String): Unit

  /**
    * Sets the HTTP response Content-Disposition header field to “attachment”. If a filename is given,
    * then it sets the Content-Type based on the extension name via res.type(), and sets the
    * Content-Disposition “filename=” parameter.
    */
  def attachment(filename: String): Unit

  def attachment(): Unit

  /**
    * Sets cookie name to value. The value parameter may be a string or object converted to JSON.
    */
  def cookie(name: String, value: js.Any, options: Response.CookieOptions): Unit

  def cookie(name: String, value: js.Any): Unit

  /**
    * Clears the cookie specified by name. For details about the options object.
    * @see [[Response.cookie()]]
    */
  def clearCookie(name: String, options: Response.CookieOptions): Unit

  def clearCookie(name: String): Unit

  /**
    * Transfers the file at path as an “attachment”. Typically, browsers will prompt the user for download.
    * By default, the Content-Disposition header “filename=” parameter is path (this typically appears in the
    * browser dialog). Override this default with the filename parameter.
    *
    * When an error occurs or transfer is complete, the method calls the optional callback function fn.
    * This method uses res.sendFile() to transfer the file.
    */
  def download(path: String, filename: String, callback: js.Function): Unit

  def download(path: String, filename: String): Unit

  def download(path: String): Unit

  /**
    * Ends the response process. This method actually comes from Node core, specifically the response.end()
    * method of http.ServerResponse. Use to quickly end the response without any data. If you need to respond
    * with data, instead use methods such as res.send() and res.json()
    */
  def end(data: js.Any, encoding: String): Unit

  def end(data: js.Any): Unit

  def end(): Unit

  /**
    * Performs content-negotiation on the Accept HTTP header on the request object, when present.
    * It uses req.accepts() to select a handler for the request, based on the acceptable types ordered
    * by their quality values. If the header is not specified, the first callback is invoked. When no
    * match is found, the server responds with 406 “Not Acceptable”, or invokes the default callback.
    * The Content-Type response header is set when a callback is selected. However, you may alter this
    * within the callback using methods such as res.set() or res.type().
    */
  def format(`object`: js.Any): Unit

  /**
    * Returns the HTTP response header specified by field. The match is case-insensitive.
    */
  def get(field: String): js.UndefOr[String]

  /**
    * Sends a JSON response. This method is identical to res.send() with an object or array as the parameter.
    * However, you can use it to convert other values to JSON, such as null, and undefined (although these
    * are technically not valid JSON).
    */
  def json(body: js.Any): Unit

  def json(): Unit

  /**
    * Sends a JSON response with JSONP support. This method is identical to res.json(),
    * except that it opts-in to JSONP callback support.
    */
  def jsonp(body: js.Any): Unit

  def jsonp(): Unit

  /**
    * Joins the links provided as properties of the parameter to populate the response’s Link HTTP header field.
    */
  def links(links: js.Any): js.Array[String]

  /**
    * Sets the response Location HTTP header to the specified path parameter.
    */
  def location(path: String): Unit

  /**
    * Redirects to the URL derived from the specified path, with specified status, a positive integer
    * that corresponds to an HTTP status code . If not specified, status defaults to “302 “Found”.
    */
  def redirect(status: Int, path: String): Unit

  def redirect(path: String): Unit

  /**
    * Renders a view and sends the rendered HTML string to the client. Optional parameters:
    * <ul>
    * <li>locals, an object whose properties define local variables for the view.</li>
    * <li>callback, a callback function. If provided, the method returns both the
    * possible error and rendered string, but does not perform an automated response.
    * When an error occurs, the method invokes next(err) internally.</li>
    * </ul>
    */
  def render(view: String, locals: String, callback: js.Function): Unit

  def render(view: String, locals: String): Unit

  def render(view: String): Unit

  /**
    * Sends the HTTP response.
    * The body parameter can be a Buffer object, a String, an object, or an Array.
    */
  def send(body: js.Any): Unit

  def send(): Unit

  /**
    * Transfers the file at the given path. Sets the Content-Type response HTTP header
    * field based on the filename’s extension. Unless the root option is set in the
    * options object, path must be an absolute path to the file.
    */
  def sendFile(path: String, options: Response.FileTransferOptions, callback: js.Function): Unit

  def sendFile(path: String, options: Response.FileTransferOptions): Unit

  def sendFile(path: String): Unit

  /**
    * Sets the response HTTP status code to statusCode and send its string representation as the response body.
    */
  def sendStatus(statusCode: Int): Unit

  /**
    * Sets the response’s HTTP header field to value. To set multiple fields at once, pass an object as the parameter.
    */
  def set(name: String, value: String): Unit

  def set(`object`: js.Any): Unit

  /**
    * Sets the HTTP status for the response. It is a chainable alias of Node’s response.statusCode.
    */
  def status(code: Int): this.type

  /**
    * Sets the Content-Type HTTP header to the MIME type as determined by mime.lookup() for the specified type.
    * If type contains the “/” character, then it sets the Content-Type to type.
    */
  def `type`(mime: String): js.UndefOr[String]

  /**
    * Adds the field to the Vary response header, if it is not there already.
    */
  def vary(field: String): this.type

}

/**
  * Http Response Companion
  * @author lawrence.daniels@gmail.com
  */
object Response {

  /**
    * Cookie Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait CookieOptions extends js.Object {
    /** Domain name for the cookie. Defaults to the domain name of the app. */
    var domain: js.UndefOr[String]

    /** A synchronous function used for cookie value encoding. Defaults to encodeURIComponent. */
    var encode: js.UndefOr[js.Function]

    /** Expiry date of the cookie in GMT. If not specified or set to 0, creates a session cookie. */
    var expires: js.UndefOr[js.Date]

    /** Flags the cookie to be accessible only by the web server. */
    var httpOnly: js.UndefOr[Boolean]

    /** Convenient option for setting the expiry time relative to the current time in milliseconds. */
    var maxAge: js.UndefOr[String]

    /** Path for the cookie. Defaults to “/”. */
    var path: js.UndefOr[String]

    /** Marks the cookie to be used with HTTPS only. */
    var secure: js.UndefOr[Boolean]

    /** Indicates if the cookie should be signed. */
    var signed: js.UndefOr[Boolean]
  }

  /**
    * Cookie Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object CookieOptions {

    def apply(domain: js.UndefOr[String] = js.undefined,
              encode: js.UndefOr[js.Function] = js.undefined,
              expires: js.UndefOr[js.Date] = js.undefined,
              httpOnly: js.UndefOr[Boolean] = js.undefined,
              maxAge: js.UndefOr[String] = js.undefined,
              path: js.UndefOr[String] = js.undefined,
              secure: js.UndefOr[Boolean] = js.undefined,
              signed: js.UndefOr[Boolean] = js.undefined) = {
      val options = makeNew[CookieOptions]
      options.domain = domain
      options.encode = encode
      options.expires = expires
      options.httpOnly = httpOnly
      options.maxAge = maxAge
      options.path = path
      options.secure = secure
      options.signed = signed
      options
    }

  }

  /**
    * File Transfer Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait FileTransferOptions extends js.Object {
    /**  Sets the max-age property of the Cache-Control header in milliseconds or a string in ms format	(default: 0) */
    var maxAge: js.UndefOr[Int]

    /** Root directory for relative filenames. */
    var root: js.UndefOr[String]

    /** Sets the Last-Modified header to the last modified date of the file on the OS. Set false to disable it.	Enabled	4.9.0+ */
    var lastModified: js.UndefOr[js.Date]

    /** Object containing HTTP headers to serve with the file. */
    var headers: js.UndefOr[js.Any]

    /** Option for serving dotfiles. Possible values are “allow”, “deny”, “ignore”.	“ignore” */
    var dotfiles: js.UndefOr[js.Array[String]]
  }

  /**
    * File Transfer Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object FileTransferOptions {

    def apply(maxAge: js.UndefOr[Int] = js.undefined,
              root: js.UndefOr[String] = js.undefined,
              lastModified: js.UndefOr[js.Date] = js.undefined,
              headers: js.UndefOr[js.Any] = js.undefined,
              dotfiles: js.UndefOr[js.Array[String]] = js.undefined) = {
      val options = makeNew[FileTransferOptions]
      options.maxAge = maxAge
      options.root = root
      options.lastModified = lastModified
      options.headers = headers
      options.dotfiles = dotfiles
      options
    }

  }

  /**
    * Http Response Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class HttpResponseEnrich(val response: Response) extends AnyVal {

    def badRequest() = response.sendStatus(400)

    def badRequest(message: String) = response.sendStatus(400)

    def badRequest(cause: Throwable) = response.sendStatus(400)

    def internalServerError() = response.sendStatus(500)

    def internalServerError(message: String) = response.sendStatus(500)

    def internalServerError(cause: Throwable) = response.sendStatus(500)

    def notFound() = response.sendStatus(404)

    def notFound(message: String) = response.sendStatus(404)

    def notFound(cause: Throwable) = response.sendStatus(404)

  }

}
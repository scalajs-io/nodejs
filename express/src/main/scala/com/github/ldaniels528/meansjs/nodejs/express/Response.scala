package com.github.ldaniels528.meansjs.nodejs.express

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
  def app: Application = js.native

  /**
    * Boolean property that indicates if the app sent HTTP headers for the response.
    */
  def headersSent: Boolean = js.native

  /**
    * An object that contains response local variables scoped to the request, and therefore available only
    * to the view(s) rendered during that request / response cycle (if any). Otherwise, this property is
    * identical to app.locals.
    *
    * This property is useful for exposing request-level information such as the request path name,
    * authenticated user, user settings, and so on.
    */
  def locals: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Appends the specified value to the HTTP response header field. If the header is not already set,
    * it creates the header with the specified value. The value parameter can be a string or an array.
    * <b>Note</b>: calling [[Response.set()]] after [[Response.append()]] will reset the previously-set header value.
    */
  def append(field: String, value: String): Unit = js.native

  def append(field: String): Unit = js.native

  /**
    * Sets the HTTP response Content-Disposition header field to “attachment”. If a filename is given,
    * then it sets the Content-Type based on the extension name via res.type(), and sets the
    * Content-Disposition “filename=” parameter.
    */
  def attachment(filename: String): Unit = js.native

  def attachment(): Unit = js.native

  /**
    * Sets cookie name to value. The value parameter may be a string or object converted to JSON.
    */
  def cookie(name: String, value: js.Any, options: CookieOptions): Unit = js.native

  def cookie(name: String, value: js.Any): Unit = js.native

  /**
    * Clears the cookie specified by name. For details about the options object.
    * @see [[Response.cookie()]]
    */
  def clearCookie(name: String, options: CookieOptions): Unit = js.native

  def clearCookie(name: String): Unit = js.native

  /**
    * Transfers the file at path as an “attachment”. Typically, browsers will prompt the user for download.
    * By default, the Content-Disposition header “filename=” parameter is path (this typically appears in the
    * browser dialog). Override this default with the filename parameter.
    *
    * When an error occurs or transfer is complete, the method calls the optional callback function fn.
    * This method uses res.sendFile() to transfer the file.
    */
  def download(path: String, filename: String, callback: js.Function): Unit = js.native

  def download(path: String, filename: String): Unit = js.native

  def download(path: String): Unit = js.native

  /**
    * Ends the response process. This method actually comes from Node core, specifically the response.end()
    * method of http.ServerResponse. Use to quickly end the response without any data. If you need to respond
    * with data, instead use methods such as res.send() and res.json()
    */
  def end(data: js.Any, encoding: String): Unit = js.native

  def end(data: js.Any): Unit = js.native

  def end(): Unit = js.native

  /**
    * Performs content-negotiation on the Accept HTTP header on the request object, when present.
    * It uses req.accepts() to select a handler for the request, based on the acceptable types ordered
    * by their quality values. If the header is not specified, the first callback is invoked. When no
    * match is found, the server responds with 406 “Not Acceptable”, or invokes the default callback.
    * The Content-Type response header is set when a callback is selected. However, you may alter this
    * within the callback using methods such as res.set() or res.type().
    */
  def format(`object`: js.Any): Unit = js.native

  /**
    * Returns the HTTP response header specified by field. The match is case-insensitive.
    */
  def get(field: String): js.UndefOr[String] = js.native

  /**
    * Sends a JSON response. This method is identical to res.send() with an object or array as the parameter.
    * However, you can use it to convert other values to JSON, such as null, and undefined (although these
    * are technically not valid JSON).
    */
  def json(body: js.Any): Unit = js.native

  def json(): Unit = js.native

  /**
    * Sends a JSON response with JSONP support. This method is identical to res.json(),
    * except that it opts-in to JSONP callback support.
    */
  def jsonp(body: js.Any): Unit = js.native

  def jsonp(): Unit = js.native

  /**
    * Joins the links provided as properties of the parameter to populate the response’s Link HTTP header field.
    */
  def links(links: js.Any): js.Array[String] = js.native

  /**
    * Sets the response Location HTTP header to the specified path parameter.
    */
  def location(path: String): Unit = js.native

  /**
    * Redirects to the URL derived from the specified path, with specified status, a positive integer
    * that corresponds to an HTTP status code . If not specified, status defaults to “302 “Found”.
    */
  def redirect(status: Int, path: String): Unit = js.native

  def redirect(path: String): Unit = js.native

  /**
    * Renders a view and sends the rendered HTML string to the client. Optional parameters:
    * <ul>
    * <li>locals, an object whose properties define local variables for the view.</li>
    * <li>callback, a callback function. If provided, the method returns both the
    * possible error and rendered string, but does not perform an automated response.
    * When an error occurs, the method invokes next(err) internally.</li>
    * </ul>
    */
  def render(view: String, locals: String, callback: js.Function): Unit = js.native

  def render(view: String, locals: String): Unit = js.native

  def render(view: String): Unit = js.native

  /**
    * Sends the HTTP response.
    * The body parameter can be a Buffer object, a String, an object, or an Array.
    */
  def send(body: js.Any): Unit = js.native

  def send(): Unit = js.native

  /**
    * Transfers the file at the given path. Sets the Content-Type response HTTP header
    * field based on the filename’s extension. Unless the root option is set in the
    * options object, path must be an absolute path to the file.
    */
  def sendFile(path: String, options: FileTransferOptions, callback: js.Function): Unit = js.native

  def sendFile(path: String, options: FileTransferOptions): Unit = js.native

  def sendFile(path: String): Unit = js.native

  /**
    * Sets the response HTTP status code to statusCode and send its string representation as the response body.
    */
  def sendStatus(statusCode: Int): Unit = js.native

  /**
    * Sets the response’s HTTP header field to value. To set multiple fields at once, pass an object as the parameter.
    */
  def set(name: String, value: String): Unit = js.native

  def set(`object`: js.Any): Unit = js.native

  /**
    * Sets the HTTP status for the response. It is a chainable alias of Node’s response.statusCode.
    */
  def status(statusCode: Int): this.type = js.native

  /**
    * Sets the Content-Type HTTP header to the MIME type as determined by mime.lookup() for the specified type.
    * If type contains the “/” character, then it sets the Content-Type to type.
    */
  def `type`(mime: String): js.UndefOr[String]

  /**
    * Adds the field to the Vary response header, if it is not there already.
    */
  def vary(field: String): this.type = js.native

}

/**
  * Http Response Companion
  * @author lawrence.daniels@gmail.com
  */
object Response {

  /**
    * Http Response Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class HttpResponseExtensions(val response: Response) extends AnyVal {

    def badRequest() = response.sendStatus(400)

    def badRequest(json: js.Any) = response.status(400).json(json)

    def badRequest(message: String) = response.status(400).send(message)

    def badRequest(cause: Throwable) = response.status(400).send(cause.getMessage)

    def forbidden() = response.sendStatus(403)

    def forbidden(json: js.Any) = response.status(403).json(json)

    def forbidden(message: String) = response.status(403).send(message)

    def forbidden(cause: Throwable) = response.status(403).send(cause.getMessage)

    def internalServerError() = response.status(500)

    def internalServerError(json: js.Any) = response.status(500).json(json)

    def internalServerError(message: String) = response.status(500).send(message)

    def internalServerError(cause: Throwable) = response.status(500).send(cause.getMessage)

    def notFound() = response.sendStatus(404)

    def notFound(json: js.Any) = response.status(404).json(json)

    def notFound(message: String) = response.status(404).send(message)

    def notFound(cause: Throwable) = response.status(404).send(cause.getMessage)

  }

}
package org.scalajs.nodejs.express

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.http.Server
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.http.Server
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * The app object conventionally denotes the Express application. Create it by calling the
  * top-level express() function exported by the Express module.
  * @author lawrence.daniels@gmail.com
  * @see [[http://expressjs.com/en/api.html]]
  */
@js.native
trait Application extends Router with EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The app.locals object has properties that are local variables within the application.
    * @see [[http://expressjs.com/en/api.html#app.locals]]
    */
  var locals: js.Any = js.native

  /**
    * The app.mountpath property contains one or more path patterns on which a sub-app was mounted.
    * @see [[http://expressjs.com/en/api.html#app.mountpath]]
    */
  var mountpath: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * app.configure has been removed in Express 4.x.
    * @example app.configure(init)
    */
  @deprecated("app.configure has been removed", "4.x")
  def configure(init: js.Function): Unit = js.native

  /**
    * Sets the Boolean setting name to false, where name is one of the properties from the app settings table.
    * Calling app.set('foo', false) for a Boolean property is the same as calling app.disable('foo').
    * @example app.disable(name)
    */
  def disable(name: String): Unit = js.native

  /**
    * Returns true if the Boolean setting name is disabled (false), where name is one of the properties
    * from the app settings table.
    * @example app.disabled(name)
    */
  def disabled(name: String): Boolean = js.native

  /**
    * Sets the Boolean setting name to true, where name is one of the properties from the app settings table.
    * Calling app.set('foo', true) for a Boolean property is the same as calling app.enable('foo').
    * @example app.enable(name)
    */
  def enable(name: String): Unit = js.native

  /**
    * Returns true if the setting name is enabled (true), where name is one of the properties from the app settings table.
    * @example app.enabled(name)
    */
  def enabled(name: String): Boolean = js.native

  /**
    * Registers the given template engine callback as ext. By default, Express will require() the engine based on
    * the file extension. For example, if you try to render a “foo.jade” file, Express invokes the following
    * internally, and caches the require() on subsequent calls to increase performance.
    * @example app.engine(ext, callback)
    */
  def engine(name: String, callback: js.Function): Unit = js.native

  /**
    * Returns the value of name app setting, where name is one of strings in the app settings table.
    * @example app.get(name)
    */
  def get(name: String): js.UndefOr[String] = js.native

  /**
    * Binds and listens for connections on the specified host and port.
    * This method is identical to Node’s http.Server.listen().
    * @example app.listen(port, [hostname], [backlog], [callback])
    */
  def listen(port: Int, hostname: String, backlog: Int, callback: js.Function): Unit = js.native

  /**
    * Binds and listens for connections on the specified host and port.
    * This method is identical to Node’s http.Server.listen().
    */
  def listen(port: Int, hostname: String, backlog: Int): Unit = js.native

  /**
    * Binds and listens for connections on the specified host and port.
    * This method is identical to Node’s http.Server.listen().
    */
  def listen(port: Int, hostname: String, callback: js.Function): Unit = js.native

  /**
    * Binds and listens for connections on the specified host and port.
    * This method is identical to Node’s http.Server.listen().
    */
  def listen(port: Int, hostname: String): Unit = js.native

  /**
    * Binds and listens for connections on the specified host and port.
    * This method is identical to Node’s http.Server.listen().
    */
  def listen(port: Int, callback: js.Function): Server = js.native

  /**
    * Binds and listens for connections on the specified host and port.
    * This method is identical to Node’s http.Server.listen().
    */
  def listen(port: Int): Unit = js.native

  /**
    * Returns the canonical path of the app, a string.
    * @example app.path()
    */
  def path(): String = js.native

  /**
    * Returns the rendered HTML of a view via the callback function. It accepts an optional parameter
    * that is an object containing local variables for the view. It is like res.render(), except it
    * cannot send the rendered view to the client on its own.
    * @example app.render(view, [locals], callback)
    */
  def render(view: String, locals: js.Any, callback: js.Function): Unit = js.native

  /**
    * Returns an instance of a single route, which you can then use to handle HTTP verbs with
    * optional middleware. Use app.route() to avoid duplicate route names (and thus typo errors).
    * @example app.route(path)
    */
  def route(path: String): js.Any = js.native

  /**
    * Assigns setting name to value, where name is one of the properties from the app settings table.
    * Calling app.set('foo', true) for a Boolean property is the same as calling app.enable('foo').
    * Similarly, calling app.set('foo', false) for a Boolean property is the same as calling app.disable('foo').
    * Retrieve the value of a setting with app.get().
    * @example app.set(name, value)
    */
  def set(name: String, value: js.Any): Unit = js.native

  def set(headers: js.Any): Unit = js.native // TODO ????

  /**
    * Mounts the specified middleware function or functions at the specified path.
    * If path is not specified, it defaults to “/”.
    * @example app.use([path,] function [, function...])
    */
  def use(path: String, router: Router): Unit = js.native

  /**
    * Mounts the specified middleware function or functions at the specified path.
    * If path is not specified, it defaults to “/”.
    * @example app.use([path,] function [, function...])
    */
  def use(path: String, callback: js.Function, next: js.Function*): Unit = js.native

  /**
    * Mounts the specified middleware function or functions at the specified path.
    * If path is not specified, it defaults to “/”.
    * @example app.use([path,] function [, function...])
    */
  def use(callback: js.Function, next: js.Function*): Unit = js.native

  /**
    * Mounts the specified middleware function or functions at the specified path.
    * If path is not specified, it defaults to “/”.
    * @example app.use([path,] function [, function...])
    */
  def use(router: Router): Unit = js.native

}

/**
  * Application Companion
  * @author lawrence.daniels@gmail.com
  */
object Application {

  /**
    * Application Extensions
    * @param app the given [[Application application]]
    */
  implicit class ApplicationExtensions(val app: Application) extends AnyVal {

    /**
      * Binds and listens for connections on the specified host and port.
      */
    def listenFuture(port: Int) = futureCallbackE1[errors.Error, Server](app.listen(port, _))

    /**
      * Binds and listens for connections on the specified host and port.
      */
    def listenFuture(port: Int, hostname: String) = futureCallbackE1[errors.Error, Server](app.listen(port, hostname, _))

    /**
      * Binds and listens for connections on the specified host and port.
      */
    def listenFuture(port: Int, hostname: String, backlog: Int) = futureCallbackE1[errors.Error, Server](app.listen(port, hostname, backlog, _))

  }

}

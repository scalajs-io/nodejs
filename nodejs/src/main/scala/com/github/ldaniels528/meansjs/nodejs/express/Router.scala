package com.github.ldaniels528.meansjs.nodejs.express

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A router object is an isolated instance of middleware and routes. You can think of it as a “mini-application,”
  * capable only of performing middleware and routing functions. Every Express application has a built-in app router.
  *
  * A router behaves like middleware itself, so you can use it as an argument to app.use() or as the argument to
  * another router’s use() method.
  *
  * The top-level express object has a Router() method that creates a new router object.
  * @author lawrence.daniels@gmail.com
  * @see [[http://expressjs.com/en/4x/api.html#router]]
  */
@js.native
trait Router extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Add callback triggers to route parameters, where name is the name of the parameter or an array of them,
    * and callback is the callback function. The parameters of the callback function are the request object,
    * the response object, the next middleware, the value of the parameter and the name of the parameter,
    * in that order.
    * <p/>If name is an array, the callback trigger is registered for each parameter declared in it, in the order
    * in which they are declared. Furthermore, for each declared parameter except the last one, a call to next
    * inside the callback will call the callback for the next declared parameter. For the last parameter, a call
    * to next will call the next middleware in place for the route currently being processed, just like it would
    * if name were just a string.
    * @example app.param([name], callback)
    */
  def param(name: String, callback: js.Function): Unit

  def param(names: js.Array[String], callback: js.Function): Unit

  def param(callback: js.Function): Unit

  /////////////////////////////////////////////////////////////////////////////////
  //      HTTP Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This method is like the standard app.METHOD() methods, except it matches all HTTP verbs.
    * It’s useful for mapping “global” logic for specific path prefixes or arbitrary matches.
    * For example, if you put the following at the top of all other route definitions, it
    * requires that all routes from that point on require authentication, and automatically
    * load a user. Keep in mind that these callbacks do not have to act as end-points: loadUser
    * can perform a task, then call next() to continue matching subsequent routes
    * @example app.all(path, callback [, callback ...])
    */
  def all(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP CONNECT requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * @example app.connect(path, callback [, callback ...])
    */
  def connect(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP DELETE requests to the specified path with the specified callback functions.
    * For more information, see the routing guide. You can provide multiple callback functions that
    * behave just like middleware, except these callbacks can invoke next('route') to bypass the
    * remaining route callback(s). You can use this mechanism to impose pre-conditions on a route,
    * then pass control to subsequent routes if there’s no reason to proceed with the current route.
    * @example app.delete(path, callback [, callback ...])
    */
  def delete(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP GET requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * <p/>You can provide multiple callback functions that behave just like middleware, except these callbacks
    * can invoke next('route') to bypass the remaining route callback(s). You can use this mechanism to impose
    * pre-conditions on a route, then pass control to subsequent routes if there’s no reason to proceed with
    * the current route.
    * @example app.get(path, callback [, callback ...])
    */
  def get(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP HEAD requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * @example app.head(path, callback [, callback ...])
    */
  def head(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP OPTIONS requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * @example app.options(path, callback [, callback ...])
    */
  def options(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP PATCH requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * @example app.patch(path, callback [, callback ...])
    */
  def patch(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP POST requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * <p/>You can provide multiple callback functions that behave just like middleware, except that these callbacks
    * can invoke next('route') to bypass the remaining route callback(s). You can use this mechanism to impose
    * pre-conditions on a route, then pass control to subsequent routes if there’s no reason to proceed with the current route.
    * @example app.post(path, callback [, callback ...])
    */
  def post(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP PUT requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * <p/>You can provide multiple callback functions that behave just like middleware, except that these callbacks
    * can invoke next('route') to bypass the remaining route callback(s). You can use this mechanism to impose
    * pre-conditions on a route, then pass control to subsequent routes if there’s no reason to proceed with the current route.
    * @example app.put(path, callback [, callback ...])
    */
  def put(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /**
    * Routes HTTP TRACE requests to the specified path with the specified callback functions. For more information,
    * see the routing guide.
    * @example app.trace(path, callback [, callback ...])
    */
  def trace(path: String, callback: js.Function, callbacks: js.Function*): Unit

  /////////////////////////////////////////////////////////////////////////////////
  //      Routing Methods
  //
  //      @example app.METHOD(path, callback [, callback ...])
  //      http://expressjs.com/en/api.html#app.METHOD
  /////////////////////////////////////////////////////////////////////////////////

  def checkout(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def copy(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def lock(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def merge(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def mkactivity(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def mkcol(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def move(path: String, callback: js.Function, callbacks: js.Function*): Unit

  @JSName("m-search")
  def m_search(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def notify(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def propfind(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def proppatch(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def purge(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def report(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def search(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def subscribe(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def unlock(path: String, callback: js.Function, callbacks: js.Function*): Unit

  def unsubscribe(path: String, callback: js.Function, callbacks: js.Function*): Unit

}

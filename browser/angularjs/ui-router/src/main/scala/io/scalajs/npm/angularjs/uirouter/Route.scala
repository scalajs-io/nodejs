package io.scalajs.npm.angularjs.uirouter

import scala.scalajs.js

/**
  * \$route is used for deep-linking URLs to controllers and views (HTML partials).
  * It watches \$location.url() and tries to map the path to an existing route definition.
  * @see [[https://docs.angularjs.org/api/ngRoute/service/\$route]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Route extends js.Object {

  /**
    * Reference to the current route definition.
    */
  var current: RouteCurrent = js.native

  /**
    * Object with all route configuration Objects as its properties.
    */
  var routes: js.Dictionary[String] = js.native

  /**
    * Causes $route service to reload the current route even if $location hasn't changed.
    * As a result of that, ngView creates new scope and reinstantiates the controller.
    */
  def reload(): Unit = js.native

  /**
    * Causes $route service to update the current URL, replacing current route parameters with those specified in
    * newParams. Provided property names that match the route's path segment definitions will be interpolated into the
    * location's path, while remaining properties will be treated as query params.
    * @param newParams mapping of URL parameter names to values
    */
  def updateParams(newParams: js.Dictionary[String]): Unit = js.native

}

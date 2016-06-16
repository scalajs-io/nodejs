package org.scalajs.angularjs.uirouter

import org.scalajs.angularjs.Provider

import scala.scalajs.js

/**
  * Route Provider - Used for configuring routes.
  * @see [[https://docs.angularjs.org/api/ngRoute/provider/\$routeProvider]]
  */
@js.native
trait RouteProvider extends Provider[Route] {

  /**
    * A boolean property indicating if routes defined using this provider should be matched using a
    * case insensitive algorithm. Defaults to false.
    */
  var caseInsensitiveMatch: Boolean = js.native

  /**
    * Adds a new route definition to the \$route service.
    * @param path  Route path (matched against $location.path). If $location.path contains redundant trailing slash
    *              or is missing one, the route will still match and the $location.path will be updated to add or drop
    *              the trailing slash to exactly match the route definition.
    * @param route Mapping information to be assigned to $route.current on route match.
    * @return self
    */
  def when(path: String, route: RouteTo): this.type = js.native

  /**
    * Sets route definition that will be used on route change when no other route definition is matched.
    * @param params Mapping information to be assigned to $route.current. If called with a string,
    *               the value maps to redirectTo.
    * @return self
    */
  def otherwise(params: RouteTo): this.type = js.native

}

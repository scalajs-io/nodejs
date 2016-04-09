package com.github.ldaniels528.nodesjs.angularjs.extensions

import com.github.ldaniels528.nodesjs.angularjs.Scope
import com.github.ldaniels528.nodesjs.angularjs.core.Provider

import scala.scalajs.js

/**
 * \$route is used for deep-linking URLs to controllers and views (HTML partials).
 * It watches \$location.url() and tries to map the path to an existing route definition.
 * @see [[https://docs.angularjs.org/api/ngRoute/service/\$route]]
 */
@js.native
trait Route extends js.Object {

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

/**
 * Reference to the current route definition. The route definition contains:
 * <ul>
 *  <li>controller: The controller constructor as define in route definition</li>
 *  <li> locals: A map of locals which is used by $controller service for controller instantiation.
 * The locals contain the resolved values of the resolve map. Additionally the locals also contain:
 *    <ul>
 *      <li>$scope - The current route scope.</li>
 *      <li>$template - The current route template HTML.</li>
 *    </ul>
 *  </li>
 * </ul>
 */
@js.native
trait RouteCurrent extends js.Object {
  var controller: String = js.native
  var locals: js.Dictionary[Any] = js.native
  var $scope: Scope = js.native
  var $template: String = js.native
}

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
   * @param path Route path (matched against $location.path). If $location.path contains redundant trailing slash
   *             or is missing one, the route will still match and the $location.path will be updated to add or drop
   *             the trailing slash to exactly match the route definition.
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
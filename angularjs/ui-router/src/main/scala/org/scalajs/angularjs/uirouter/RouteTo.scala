package org.scalajs.angularjs.uirouter

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.UndefOr

/**
 * Type-Safe AngularJS Route
 */
@js.native
trait RouteTo extends js.Object {

  /**
   * Controller function that should be associated with newly created scope or the name of a registered controller
   * if passed as a string (string or function).
   */
  var controller: js.Any = js.native

  /**
   * An identifier name for a reference to the controller. If present, the controller will be published to scope under
   * the controllerAs name.
   */
  var controllerAs: String = js.native

  /**
   * HTML template as a string or a function that returns an HTML template as a string which should be used by ngView
   * or ngInclude directives. This property takes precedence over templateUrl (string or function).
   */
  var template: js.Any = js.native

  /**
   * Path or function that returns a path to an HTML template that should be used by ngView.
   */
  var templateUrl: js.Any = js.native

  /**
   * An optional map of dependencies which should be injected into the controller. If any of these dependencies are
   * promises, the router will wait for them all to be resolved or one to be rejected before the controller is
   * instantiated. If all the promises are resolved successfully, the values of the resolved promises are injected
   * and \$routeChangeSuccess event is fired.
   */
  var resolve: js.Dictionary[_ <: js.Any] = js.native

  /**
   * Value to update $location path with and trigger route redirection (string or function).
   */
  var redirectTo: js.Any = js.native

  /**
   * Reload route when only \$location.search() or \$location.hash() changes.
   */
  var reloadOnSearch: Boolean = js.native

  /**
   * Match routes without being case sensitive. If the option is set to true, then the particular route can be
   * matched without being case sensitive.
   */
  var caseInsensitiveMatch: Boolean = js.native

}

/**
 * RouteTo Singleton
 */
object RouteTo {

  def apply(controller: UndefOr[String] = js.undefined,
            controllerFn: UndefOr[js.Function] = js.undefined,
            controllerAs: UndefOr[String] = js.undefined,
            template: UndefOr[String] = js.undefined,
            templateFn: UndefOr[js.Function] = js.undefined,
            templateUrl: UndefOr[String] = js.undefined,
            templateUrlFn: UndefOr[js.Function] = js.undefined,
            resolve: js.Dictionary[_ <: js.Any] = null,
            redirectTo: UndefOr[String] = js.undefined,
            redirectToFn: UndefOr[js.Function] = js.undefined,
            reloadOnSearch: UndefOr[Boolean] = js.undefined,
            caseInsensitiveMatch: UndefOr[Boolean] = js.undefined) = {
    val route = new js.Object().asInstanceOf[RouteTo]
    controller.foreach(route.controller = _)
    controllerFn.foreach(route.controller = _)
    controllerAs.foreach(route.controllerAs = _)
    template.foreach(route.template = _)
    templateFn.foreach(route.template = _)
    templateUrl.foreach(route.templateUrl = _)
    templateUrlFn.foreach(route.templateUrl = _)
    route.resolve = resolve
    redirectTo.foreach(route.redirectTo = _)
    redirectToFn.foreach(route.redirectTo = _)
    reloadOnSearch.foreach(route.reloadOnSearch = _)
    caseInsensitiveMatch.foreach(route.reloadOnSearch = _)
    route
  }

}

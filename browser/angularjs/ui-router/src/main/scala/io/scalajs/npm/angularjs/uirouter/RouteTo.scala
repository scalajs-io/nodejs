package io.scalajs.npm.angularjs.uirouter

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Type-Safe AngularJS Route
  * @param controller           Controller function that should be associated with newly created scope or the name of a
  *                             registered controller if passed as a string (string or function).
  * @param controllerFn
  * @param controllerAs         An identifier name for a reference to the controller. If present, the controller will be
  *                             published to scope under the controllerAs name.
  * @param template             HTML template as a string or a function that returns an HTML template as a string which
  *                             should be used by ngView or ngInclude directives. This property takes precedence over
  *                             templateUrl (string or function).
  * @param templateFn
  * @param templateUrl          Path or function that returns a path to an HTML template that should be used by ngView.
  * @param templateUrlFn
  * @param resolve              An optional map of dependencies which should be injected into the controller. If any of
  *                             these dependencies are promises, the router will wait for them all to be resolved or one
  *                             to be rejected before the controller is instantiated. If all the promises are resolved
  *                             successfully, the values of the resolved promises are injected and \$routeChangeSuccess
  *                             event is fired.
  * @param redirectTo           Value to update $location path with and trigger route redirection (string or function).
  * @param redirectToFn
  * @param reloadOnSearch       Reload route when only \$location.search() or \$location.hash() changes.
  * @param caseInsensitiveMatch Match routes without being case sensitive. If the option is set to true,
  *                             then the particular route can be matched without being case sensitive.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class RouteTo(val controller: UndefOr[String] = js.undefined,
              val controllerFn: UndefOr[js.Function] = js.undefined,
              val controllerAs: UndefOr[String] = js.undefined,
              val template: UndefOr[String] = js.undefined,
              val templateFn: UndefOr[js.Function] = js.undefined,
              val templateUrl: UndefOr[String] = js.undefined,
              val templateUrlFn: UndefOr[js.Function] = js.undefined,
              val resolve: UndefOr[js.Dictionary[_ <: js.Any]] = js.undefined,
              val redirectTo: UndefOr[String] = js.undefined,
              val redirectToFn: UndefOr[js.Function] = js.undefined,
              val reloadOnSearch: UndefOr[Boolean] = js.undefined,
              val caseInsensitiveMatch: UndefOr[Boolean] = js.undefined)
    extends js.Object

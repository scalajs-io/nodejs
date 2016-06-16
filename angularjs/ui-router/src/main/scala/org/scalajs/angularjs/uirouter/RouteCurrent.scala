package org.scalajs.angularjs.uirouter

import org.scalajs.angularjs.Scope

import scala.scalajs.js

/**
  * Reference to the current route definition. The route definition contains:
  * <ul>
  * <li>controller: The controller constructor as define in route definition</li>
  * <li> locals: A map of locals which is used by $controller service for controller instantiation.
  * The locals contain the resolved values of the resolve map. Additionally the locals also contain:
  * <ul>
  * <li>$scope - The current route scope.</li>
  * <li>$template - The current route template HTML.</li>
  * </ul>
  * </li>
  * </ul>
  */
@js.native
trait RouteCurrent extends js.Object {
  var controller: String = js.native
  var locals: js.Dictionary[Any] = js.native
  var $scope: Scope = js.native
  var $template: String = js.native
}

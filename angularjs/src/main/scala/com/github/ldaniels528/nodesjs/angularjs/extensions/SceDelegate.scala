package com.github.ldaniels528.nodesjs.angularjs.extensions

import com.github.ldaniels528.nodesjs.angularjs.core.Provider

import scala.scalajs.js

/**
 * SCE Delegate - is a service that is used by the $sce service to provide
 * Strict Contextual Escaping (SCE) services to AngularJS
 * @see [[https://docs.angularjs.org/api/ng/service/\$sceDelegate]]
 */
@js.native
trait SceDelegate extends js.Object {

  /**
   * TODO verify this one...
   * @return
   */
  def apply(): SceDelegate = js.native

  /**
   * Returns an object that is trusted by angular for use in specified strict contextual escaping contexts
   * (such as ng-bind-html, ng-include, any src attribute interpolation, any dom event binding attribute interpolation
   * such as for onclick, etc.) that uses the provided value. See $sce for enabling strict contextual escaping.
   * @param `type` The kind of context in which this value is safe for use. e.g. url, resourceUrl, html, js and css.
   * @param value The value that that should be considered trusted/safe.
   * @return A value that can be used to stand in for the provided value in places where Angular expects
   *         a $sce.trustAs() return value.
   */
  def trustAs(`type`: String, value: js.Any): js.Any = js.native

  /**
   * If the passed parameter had been returned by a prior call to \$sceDelegate.trustAs, returns the value that had
   * been passed to $sceDelegate.trustAs.
   *
   * If the passed parameter is not a value that had been returned by \$sceDelegate.trustAs, returns it as-is.
   * @param value The result of a prior $sceDelegate.trustAs call or anything else.
   * @return The value that was originally provided to $sceDelegate.trustAs if value is the result of such a call.
   *         Otherwise, returns value unchanged.
   */
  def valueOf(value: js.Any): js.Any = js.native

  /**
   * Takes the result of a $sceDelegate.trustAs call and returns the originally supplied value if the
   * queried context type is a supertype of the created type. If this condition isn't satisfied,
   * throws an exception.
   * @param `type` The kind of context in which this value is to be used.
   * @param maybeTrusted The result of a prior \$sceDelegate.trustAs call.
   * @return The value the was originally provided to $sceDelegate.trustAs if valid in this context.
   *         Otherwise, throws an exception.
   */
  def getTrusted(`type`: String, maybeTrusted: js.Any): js.Any = js.native

}

/**
 * SCE Delegate Provider
 * @see [[https://docs.angularjs.org/api/ng/provider/\$sceDelegateProvider]]
 */
@js.native
trait SceDelegateProvider extends Provider[SceDelegate] {

  /**
   * Sets/Gets the whitelist of trusted resource URLs.
   * @param whitelist When provided, replaces the resourceUrlWhitelist with the value provided.
   *                  This must be an array or null. A snapshot of this array is used so further
   *                  changes to the array are ignored.
   * @return the currently set whitelist array.
   */
  def resourceUrlWhitelist(whitelist: js.Array[String] = js.native): js.Array[String] = js.native

  /**
   * Sets/Gets the blacklist of trusted resource URLs.
   * @param blacklist When provided, replaces the resourceUrlBlacklist with the value provided.
   *                  This must be an array or null. A snapshot of this array is used so further
   *                  changes to the array are ignored.
   * @return the currently set blacklist array.
   */
  def resourceUrlBlacklist(blacklist: js.Array[String]): js.Array[String] = js.native

}
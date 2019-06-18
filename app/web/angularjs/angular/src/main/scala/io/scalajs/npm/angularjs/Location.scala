package io.scalajs.npm.angularjs

import scala.scalajs.js

/**
  * Location - The \$location service parses the URL in the browser address bar (based on the window.location)
  * and makes the URL available to your application.
  * @see [[https://docs.angularjs.org/api/ng/service/\$location]]
  */
@js.native
trait Location extends js.Object {

  /**
    * This method is getter only.
    * @return full url representation with all segments encoded according to rules specified in RFC 3986.
    */
  def absUrl(): String = js.native

  /**
    * This method is setter.
    * @param url New url without base prefix (e.g. /path?a=b#hash)
    * @return url (e.g. /path?a=b#hash) when called without any parameter.
    */
  def url(url: String): Unit = js.native

  /**
    * This method is getter.
    * @return url (e.g. /path?a=b#hash) when called without any parameter.
    */
  def url(): String = js.native

  /**
    * This method is getter only.
    * @return protocol of current url.
    */
  def protocol(): String = js.native

  /**
    * This method is getter only.
    * <b>Note</b>: compared to the non-angular version location.host which returns hostname:port,
    * this returns the hostname portion only.
    * @return host of current url.
    */
  def host(): String = js.native

  /**
    * This method is getter only.
    * @return port of current url.
    */
  def port(): Int = js.native

  /**
    * This method is getter.
    * @return path of current url when called without any parameter.
    */
  def path(): String = js.native

  /**
    * This method is setter.
    * @param path New path
    * @return a reference to self
    */
  def path(path: String): this.type = js.native

  /**
    * This method is getter / setter. Return search part (as object) of current url when called without any parameter.
    * Change search part when called with parameter and return \$location.
    * @param search New search params - string or hash object. When called with a single argument the method
    *               acts as a setter, setting the search component of $location to the specified value.
    *               If the argument is a hash object containing an array of values, these values will be
    *               encoded as duplicate search parameters in the url.
    * @param paramValue If search is a string or number, then paramValue will override only a single search property.
    *                   If paramValue is an array, it will override the property of the search component of \$location
    *                   specified via the first argument.
    *                   If paramValue is null, the property specified via the first argument will be deleted.
    *                   If paramValue is true, the property specified via the first argument will be added with
    *                   no value nor trailing equal sign.
    * @return If called with no arguments returns the parsed search object. If called with one or more
    *         arguments returns $location object itself.
    */
  def search(search: js.Any = js.native, paramValue: js.Any = js.native): js.Object = js.native

  /**
    * This method is getter / setter.
    * Changes hash fragment when called with parameter and return \$location.
    * @return hash fragment when called without any parameter.
    */
  def hash(): String = js.native

  /**
    * This method is getter / setter.
    * Changes hash fragment when called with parameter and return \$location.
    * @param hash New hash fragment
    * @return hash fragment when called without any parameter.
    */
  def hash(hash: String): Unit = js.native

  /**
    * If called, all changes to $location during current $digest will be replacing current history record,
    * instead of adding new one.
    */
  def replace(): Unit = js.native

  /**
    * This method is getter / setter. Change the history state object when called with one parameter
    * and return \$location. The state object is later passed to pushState or replaceState.
    * @param newState State object for pushState or replaceState
    * @return the history state object when called without any parameter.
    */
  def state(newState: js.Any = js.native): js.Object = js.native

}

/**
  * Location Provider - Use the \$locationProvider to configure how the application deep linking paths are stored.
  * @see [[https://docs.angularjs.org/api/ng/provider/\$locationProvider]]
  */
@js.native
trait LocationProvider extends Provider[Location] {

  /**
    * Retrieves or sets the hash prefix
    * @param prefix Prefix for hash part (containing path and search)
    * @return current value if used as getter or itself (chaining) if used as setter
    */
  def hashPrefix(prefix: String = js.native): this.type = js.native

  /**
    * Retrieves or sets the HTML5 mode
    * @param mode If boolean, sets html5Mode.enabled to value. If object, sets enabled, requireBase
    *             and rewriteLinks to respective values. Supported properties:
    *             <ul>
    *             <li>enabled – {boolean} – (default: false) If true, will rely on history.pushState to
    *             change urls where supported. Will fall back to hash-prefixed paths in browsers that
    *             do not support pushState.</li>
    *             <li>requireBase - {boolean} - (default: true) When html5Mode is enabled, specifies whether
    *             or not a tag is required to be present. If enabled and requireBase are true, and a base
    *             tag is not present, an error will be thrown when $location is injected. See the \$location
    *             guide for more information</li>
    *             <li>rewriteLinks - {boolean} - (default: true) When html5Mode is enabled,
    *             enables/disables url rewriting for relative links.</li>
    *             </ul>
    * @return html5Mode object if used as getter or itself (chaining) if used as setter
    */
  def html5Mode(mode: js.Any = js.native): this.type = js.native

}

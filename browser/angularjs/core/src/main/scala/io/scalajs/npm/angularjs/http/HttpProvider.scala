package io.scalajs.npm.angularjs.http

import io.scalajs.npm.angularjs.Provider

import scala.scalajs.js

/**
  * HTTP Provider Service - Use \$httpProvider to change the default behavior of the [[Http \$http]] service.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpProvider extends Provider[Http] {

  /**
    * Configure $http service to combine processing of multiple http responses received at around the
    * same time via \$rootScope.\$applyAsync. This can result in significant performance improvement for
    * bigger applications that make many HTTP requests concurrently (common during application bootstrap).
    *
    * Defaults to false. If no value is specified, returns the current configured value.
    * @param value If true, when requests are loaded, they will schedule a deferred "apply" on the next tick,
    *              giving time for subsequent requests in a roughly ~10ms window to load and share the same digest cycle.
    * @return If a value is specified, returns the $httpProvider for chaining. otherwise, returns the current configured value.
    */
  def useApplyAsync(value: Boolean): this.type = js.native

  def useApplyAsync(): js.Any = js.native

  /**
    * Object containing default values for all $http requests.
    * @return
    */
  def defaults: js.Dictionary[Any] = js.native

  /**
    * Array containing service factories for all synchronous or asynchronous $http pre-processing of request or
    * postprocessing of responses.
    *
    * These service factories are ordered by request, i.e. they are applied in the same order as the array,
    * on request, but reverse order, on response.
    * @return
    * @see [[https://docs.angularjs.org/api/ng/service/\$http#interceptors]]
    */
  def interceptors: js.Array[js.Any] = js.native

}

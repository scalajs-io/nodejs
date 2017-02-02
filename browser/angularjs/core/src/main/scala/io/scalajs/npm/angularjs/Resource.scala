package io.scalajs.npm.angularjs

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Resource - A factory which creates a resource object that lets you interact with RESTful server-side data sources.
  * @see [[https://code.angularjs.org/1.4.2/docs/api/ngResource/service/\$resource]]
  */
@js.native
trait Resource extends js.Object {

  /**
    * $resource(url, [paramDefaults], [actions], options)
    * @param url A parameterized URL template with parameters prefixed by : as in /user/:username.
    *            If you are using a URL with a port number (e.g. http://example.com:8080/api), it will be respected.
    * @param paramDefaults Default values for url parameters. These can be overridden in actions methods.
    *                      If any of the parameter value is a function, it will be executed every time when a
    *                      param value needs to be obtained for a request (unless the param was overridden).
    * @param actions Hash with declaration of custom actions that should extend the default set of resource actions.
    * @param options Hash with custom settings that should extend the default $resourceProvider behavior.
    *                The only supported option is
    *                Where:
    *                <ul>
    *                <li>stripTrailingSlashes – {boolean} – If true then the trailing slashes from any calculated
    *                URL will be stripped. (Defaults to true.)</li>
    *                </ul>
    * @return A resource "class" object with methods for the default set of resource actions optionally extended
    *         with custom actions
    */
  def apply[T <: ResourceClass[T]](url: String,
                                   paramDefaults: js.Any = js.native,
                                   actions: js.Any = js.native,
                                   options: ResourceOptions | AngularOptions): T = js.native

}

/**
  * A resource "class" object with methods for the default set of resource actions optionally extended
  * with custom actions. The default set contains these actions:
  * <pre>
  * {
  * 'get':    {method:'GET'},
  * 'save':   {method:'POST'},
  * 'query':  {method:'GET', isArray:true},
  * 'remove': {method:'DELETE'},
  * 'delete': {method:'DELETE'}
  * }
  * </pre>
  */
@js.native
trait ResourceClass[T] extends js.Object {

  def get(params: js.Dictionary[Any], callback: js.Function0[Unit]): T = js.native

  def save(params: js.Dictionary[Any], callback: js.Function0[Unit]): T = js.native

  def query(params: js.Dictionary[Any], callback: js.Function0[Unit]): T = js.native

  def remove(params: js.Dictionary[Any], callback: js.Function0[Unit]): T = js.native

  def delete(params: js.Dictionary[Any], callback: js.Function0[Unit]): T = js.native

}

/**
  * Resource Provider
  */
@js.native
trait ResourceProvider extends Provider[Resource] {
  var defaults: js.Dynamic = js.native

}

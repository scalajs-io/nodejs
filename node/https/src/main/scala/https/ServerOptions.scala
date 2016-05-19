package https

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Server Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ServerOptions extends js.Object {
  /** A domain name or IP address of the server to issue the request to. Defaults to 'localhost'. */
  var host: js.UndefOr[String] = _

  /** Alias for host. To support url.parse() hostname is preferred over host. */
  var hostname: js.UndefOr[String] = _

  /** IP address family to use when resolving host and hostname. Valid values are 4 or 6. When unspecified, both IP v4 and v6 will be used. */
  var family: js.UndefOr[String] = _

  /** Port of remote server. Defaults to 443. */
  var port: js.UndefOr[Int] = _

  /** Local interface to bind for network connections. */
  var localAddress: js.UndefOr[String] = _

  /** Unix Domain Socket (use one of host:port or socketPath). */
  var socketPath: js.UndefOr[String] = _

  /** A string specifying the HTTP request method. Defaults to 'GET'. */
  var method: js.UndefOr[String] = _

  /**
    * Request path. Defaults to '/'. Should include query string if any. E.G. '/index.html?page=12'.
    * An exception is thrown when the request path contains illegal characters. Currently, only spaces
    * are rejected but that may change in the future.
    */
  var path: js.UndefOr[String] = _

  /** An object containing request headers. */
  var headers: js.UndefOr[js.Dictionary[String]] = _

  /** Basic authentication i.e. 'user:password' to compute an Authorization header. */
  var auth: js.UndefOr[js.Dictionary[String]] = _

  /**
    * Controls Agent behavior. When an Agent is used request will default to Connection: keep-alive.
    * Possible values:
    * <ul>
    * <li>undefined (default): use globalAgent for this host and port.</li>
    * <li>Agent object: explicitly use the passed in Agent.</li>
    * <li>false: opts out of connection pooling with an Agent, defaults request to Connection: close.</li>
    * </ul>
    */
  var agent: js.UndefOr[String] = _

}

/**
  * Server Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerOptions {

  def apply(host: js.UndefOr[String] = js.undefined,
            hostname: js.UndefOr[String] = js.undefined,
            family: js.UndefOr[String] = js.undefined,
            port: js.UndefOr[Int] = js.undefined,
            localAddress: js.UndefOr[String] = js.undefined,
            socketPath: js.UndefOr[String] = js.undefined,
            method: js.UndefOr[String] = js.undefined,
            path: js.UndefOr[String] = js.undefined,
            headers: js.UndefOr[js.Dictionary[String]] = js.undefined,
            auth: js.UndefOr[js.Dictionary[String]] = js.undefined,
            agent: js.UndefOr[String] = js.undefined) = {
    val options = new ServerOptions()
    options.host = host
    options.hostname = hostname
    options.family = family
    options.port = port
    options.localAddress = localAddress
    options.socketPath = socketPath
    options.method = method
    options.path = path
    options.headers = headers
    options.auth = auth
    options.agent = agent
    options
  }

}
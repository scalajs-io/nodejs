package https

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Server Options
  * @param host         A domain name or IP address of the server to issue the request to. Defaults to 'localhost'.
  * @param hostname     Alias for host. To support url.parse() hostname is preferred over host.
  * @param family       IP address family to use when resolving host and hostname. Valid values are 4 or 6. When
  *                     unspecified, both IP v4 and v6 will be used.
  * @param port         Port of remote server. Defaults to 443.
  * @param localAddress Local interface to bind for network connections.
  * @param socketPath   Unix Domain Socket (use one of host:port or socketPath).
  * @param method       A string specifying the HTTP request method. Defaults to 'GET'.
  * @param path         Request path. Defaults to '/'. Should include query string if any. E.G. '/index.html?page=12'.
  *                     An exception is thrown when the request path contains illegal characters. Currently, only spaces
  *                     are rejected but that may change in the future.
  * @param headers      An object containing request headers.
  * @param auth         Basic authentication i.e. 'user:password' to compute an Authorization header.
  * @param agent        Controls Agent behavior. When an Agent is used request will default to Connection: keep-alive.
  *                     Possible values:
  *                     <ul>
  *                     <li>undefined (default): use globalAgent for this host and port.</li>
  *                     <li>Agent object: explicitly use the passed in Agent.</li>
  *                     <li>false: opts out of connection pooling with an Agent, defaults request to Connection: close.</li>
  *                     </ul>
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ServerOptions(var host: js.UndefOr[String] = js.undefined,
                    var hostname: js.UndefOr[String] = js.undefined,
                    var family: js.UndefOr[String] = js.undefined,
                    var port: js.UndefOr[Int] = js.undefined,
                    var localAddress: js.UndefOr[String] = js.undefined,
                    var socketPath: js.UndefOr[String] = js.undefined,
                    var method: js.UndefOr[String] = js.undefined,
                    var path: js.UndefOr[String] = js.undefined,
                    var headers: js.UndefOr[js.Dictionary[String]] = js.undefined,
                    var auth: js.UndefOr[js.Dictionary[String]] = js.undefined,
                    var agent: js.UndefOr[String] = js.undefined) extends js.Object
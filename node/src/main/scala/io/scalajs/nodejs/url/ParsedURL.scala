package io.scalajs.nodejs.url

import scala.scalajs.js

/**
  * Parsed URL Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ParsedURL extends js.Object {
  // will be ignored.
  var href: js.UndefOr[String] = js.native

  // will be ignored.
  var path: js.UndefOr[String] = js.native

  /**
    * is treated the same with or without the trailing : (colon). The protocols http, https, ftp, gopher,
    * file will be postfixed with :// (colon-slash-slash) as long as host/hostname are present.
    * All other protocols mailto, xmpp, aim, sftp, foo, etc will be postfixed with : (colon).
    */
  var protocol: js.UndefOr[String] = js.native

  /**
    * set to true if the protocol requires :// (colon-slash-slash)
    * Only needs to be set for protocols not previously listed as requiring
    * slashes, such as mongodb://localhost:8000/, or if host/hostname are absent.
    */
  var slashes: js.UndefOr[Boolean] = js.native

  // will be used if present.
  var auth: js.UndefOr[String] = js.native

  // will only be used if host is absent.
  var hostname: js.UndefOr[String] = js.native

  // will only be used if host is absent.
  var port: js.UndefOr[String] = js.native

  // will be used in place of hostname and port.
  var host: js.UndefOr[String] = js.native

  // is treated the same with or without the leading / (slash).
  var pathname: js.UndefOr[String] = js.native

  // (object; see querystring) will only be used if search is absent.
  var query: js.UndefOr[String] = js.native

  // will be used in place of query.
  // It is treated the same with or without the leading ? (question mark).
  var search: js.UndefOr[String] = js.native

  // is treated the same with or without the leading # (pound sign, anchor).
  var hash: js.UndefOr[String] = js.native

}

package io.scalajs.npm.syncrequest

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Sync-Request - Make synchronous web requests with cross-platform support.
  * @see [[https://www.npmjs.com/package/sync-request]]
  */
@js.native
@JSImport("sync-request", name = JSImport.Namespace)
object SyncRequest extends js.Object {

  /**
    * Make synchronous web requests with cross-platform support.
    * @param method the HTTP method
    * @param url    the HTTP URL
    * @return
    * @example {{{
    *   var request = require('sync-request');
    *   var res = request('GET', 'http://example.com');
    *   console.log(res.getBody());
    * }}}
    */
  def apply(method: String, url: String, data: js.Any = js.native): SyncResponse = js.native

}

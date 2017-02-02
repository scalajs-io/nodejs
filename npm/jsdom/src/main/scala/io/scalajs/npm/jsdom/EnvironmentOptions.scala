package io.scalajs.npm.jsdom

import io.scalajs.nodejs.Error

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * JsDom Configuration Options
  * @param html                    a HTML fragment
  * @param file                    a file which jsdom will load HTML from; the resulting document's URL will be a file:// URL.
  * @param url                     sets the resulting document's URL, which is reflected in various properties like document.URL
  *                                and location.href, and is also used for cross-origin request restrictions. If config.html and
  *                                config.file are not provided, jsdom will load HTML from this URL.
  * @param src                     an array of JavaScript strings that will be evaluated against the resulting document.
  *                                Similar to scripts, but it accepts JavaScript instead of paths/URLs.
  * @param cookieJar               cookie jar which will be used by document and related resource requests.
  *                                Can be created by jsdom.createCookieJar() method. Useful to share cookie state
  *                                among different documents as
  *                                browsers does.
  * @param parsingMode             either "auto", "html", or "xml". The default is "auto", which uses HTML behavior unless
  *                                config.url responds with an XML Content-Type, or config.file contains a filename ending
  *                                in .xml or .xhtml. Setting to "xml" will attempt to parse the document as an XHTML document.
  *                                (jsdom is currently only OK at doing that.)
  * @param referrer                the new document will have this referrer.
  * @param cookie                  manually set a cookie value, e.g. 'key=value; expires=Wed, Sep 21 2011 12:00:00 GMT; path=/'.
  *                                Accepts cookie string or array of cookie strings.
  * @param headers                 an object giving any headers that will be used while loading the HTML from config.url, if applicable.
  * @param userAgent               the user agent string used in requests; defaults to Node.js (#process.platform#; U; rv:#process.version#)
  * @param features                see Flexibility section below. Note: the default feature set for jsdom.env does not include fetching
  *                                remote JavaScript and executing it. This is something that you will need to carefully enable yourself.
  * @param resourceLoader          a function that intercepts subresource requests and allows you to re-route them, modify,
  *                                or outright replace them with your own content. More below.
  * @param done                    config.onload, config.created: see below.
  * @param concurrentNodeIterators the maximum amount of NodeIterators that you can use at the same time.
  *                                The default is 10; setting this to a high value will hurt performance.
  * @param virtualConsole          a virtual console instance that can capture the window’s console output;
  *                                see the "Capturing Console Output" examples.
  * @param pool                    an object describing which agents to use for the requests; defaults to { maxSockets: 6 },
  *                                see request module for more details.
  * @param agent                   http(s).Agent instance to use
  * @param agentClass              alternatively specify your agent's class name
  * @param agentOptions            the agent options; defaults to { keepAlive: true, keepAliveMsecs: 115000 }, see http api for more details.
  * @param strictSSL               if true, requires SSL certificates be valid; defaults to true, see request module for more details.
  * @param proxy                   a URL for a HTTP proxy to use for the requests.
  */
@ScalaJSDefined
class EnvironmentOptions(var html: js.UndefOr[String] = js.undefined,
                         var file: js.UndefOr[String] = js.undefined,
                         var url: js.UndefOr[String] = js.undefined,
                         var scripts: js.UndefOr[js.Array[String]] = js.undefined,
                         var src: js.UndefOr[js.Array[String]] = js.undefined,
                         var cookieJar: js.UndefOr[CookieJar] = js.undefined,
                         var parsingMode: js.UndefOr[String] = js.undefined,
                         var referrer: js.UndefOr[String] = js.undefined,
                         var cookie: js.UndefOr[String] = js.undefined,
                         var headers: js.UndefOr[String] = js.undefined,
                         var userAgent: js.UndefOr[String] = js.undefined,
                         var features: js.UndefOr[String] = js.undefined,
                         var resourceLoader: js.UndefOr[String] = js.undefined,
                         var done: js.Function2[Error, JsDomWindowWithJQuery, Any] = null,
                         var concurrentNodeIterators: js.UndefOr[String] = js.undefined,
                         var virtualConsole: js.UndefOr[VirtualConsole] = js.undefined,
                         var pool: js.Any = js.undefined,
                         var agent: js.UndefOr[String] = js.undefined,
                         var agentClass: js.UndefOr[String] = js.undefined,
                         var agentOptions: js.Any = js.undefined,
                         var strictSSL: js.UndefOr[Boolean] = js.undefined,
                         var proxy: js.UndefOr[String] = js.undefined)
    extends js.Object

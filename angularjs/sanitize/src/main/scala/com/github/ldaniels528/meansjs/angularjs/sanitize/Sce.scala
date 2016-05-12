package com.github.ldaniels528.meansjs.angularjs.sanitize

import com.github.ldaniels528.meansjs.angularjs.Provider

import scala.scalajs.js

/**
  * SCE Service - is a service that provides Strict Contextual Escaping services to AngularJS.
  * @see [[https://docs.angularjs.org/api/ng/provider/\$sceDelegateProvider]]
  */
@js.native
trait Sce extends js.Object {

  /**
    * Returns a boolean indicating if SCE is enabled.
    * @return a boolean indicating if SCE is enabled.
    */
  def isEnabled(): Boolean = js.native

  /**
    * Converts Angular expression into a function. This is like $parse and is identical
    * when the expression is a literal constant. Otherwise, it wraps the expression
    * in a call to \$sce.getTrusted(type, result)
    * @param `type`     The kind of SCE context in which this result will be used.
    * @param expression String expression to compile.
    * @return a function which represents the compiled expression:
    *         <ul>
    *         <li>context – {object} – an object against which any expressions embedded in the strings are evaluated
    *         against (typically a scope object).</li>
    *         <li>locals – {object=} – local variables context object, useful for overriding values in context.</li>
    *         </ul>
    */
  def parseAs(`type`: String, expression: String): js.Function2[js.Any, js.Any, js.Any] = js.native

  /**
    * Delegates to $sceDelegate.trustAs. As such, returns an object that is trusted by angular for use in specified
    * strict contextual escaping contexts (such as ng-bind-html, ng-include, any src attribute interpolation,
    * any dom event binding attribute interpolation such as for onclick, etc.) that uses the provided value.
    * See * \$sce for enabling strict contextual escaping.
    * @param `type` The kind of context in which this value is safe for use. e.g. url, resourceUrl, html, js and css.
    * @param value  The value that that should be considered trusted/safe.
    * @return A value that can be used to stand in for the provided value in places where Angular expects a \$sce.trustAs() return value.
    */
  def trustAs(`type`: String, value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.trustAsHtml(value) -> \$sceDelegate.trustAs($sce.HTML, value)
    * @param value
    * @return
    */
  def trustAsHtml(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.trustAsUrl(value) -> \$sceDelegate.trustAs(\$sce.URL, value)
    * @param value The value to trustAs.
    * @return An object that can be passed to \$sce.getTrustedUrl(value) to obtain the original value.
    *         (privileged directives only accept expressions that are either literal constants or are the
    *         return value of $sce.trustAs.)
    */
  def trustAsUrl(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.trustAsResourceUrl(value) -> \$sceDelegate.trustAs(\$sce.RESOURCE_URL, value)
    * @param value The value to trustAs.
    * @return An object that can be passed to $sce.getTrustedResourceUrl(value) to obtain the original value.
    *         (privileged directives only accept expressions that are either literal constants or are the return
    *         value of $sce.trustAs.)
    */
  def trustAsResourceUrl(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.trustAsJs(value) -> \$sceDelegate.trustAs(\$sce.JS, value)
    * @param value The value to trustAs.
    * @return An object that can be passed to \$sce.getTrustedJs(value) to obtain the original value.
    *         (privileged directives only accept expressions that are either literal constants or are
    *         the return value of \$sce.trustAs.)
    */
  def trustAsJs(value: js.Any): js.Any = js.native

  /**
    * Delegates to $sceDelegate.getTrusted. As such, takes the result of a $sce.trustAs() call and
    * returns the originally supplied value if the queried context type is a supertype of the created type.
    * If this condition isn't satisfied, throws an exception.
    * @param `type`       The kind of context in which this value is to be used.
    * @param maybeTrusted The result of a prior $sce.trustAs call.
    * @return The value the was originally provided to $sce.trustAs if valid in this context.
    *         Otherwise, throws an exception.
    */
  def getTrusted(`type`: String, maybeTrusted: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.getTrustedHtml(value) -> \$sceDelegate.getTrusted(\$sce.HTML, value)
    * @param value The value to pass to $sce.getTrusted.
    * @return The return value of \$sce.getTrusted(\$sce.HTML, value)
    */
  def getTrustedHtml(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.getTrustedCss(value) -> \$sceDelegate.getTrusted(\$sce.CSS, value)
    * @param value The value to pass to $sce.getTrusted.
    * @return The return value of \$sce.getTrusted(\$sce.CSS, value)
    */
  def getTrustedCss(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.getTrustedUrl(value) -> \$sceDelegate.getTrusted(\$sce.URL, value)
    * @param value The value to pass to $sce.getTrusted.
    * @return The return value of $sce.getTrusted($sce.URL, value)
    */
  def getTrustedUrl(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.getTrustedResourceUrl(value) -> \$sceDelegate.getTrusted(\$sce.RESOURCE_URL, value)
    * @param value The value to pass to $sceDelegate.getTrusted.
    * @return The return value of \$sce.getTrusted(\$sce.RESOURCE_URL, value)
    */
  def getTrustedResourceUrl(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.getTrustedJs(value) -> \$sceDelegate.getTrusted(\$sce.JS, value)
    * @param value The value to pass to $sce.getTrusted.
    * @return The return value of \$sce.getTrusted(\$sce.JS, value)
    */
  def getTrustedJs(value: js.Any): js.Any = js.native

  /**
    * Shorthand method. \$sce.parseAsHtml(expression string) -> \$sce.parseAs(\$sce.HTML, value)
    * @param expression String expression to compile.
    * @return a function which represents the compiled expression:
    *         <ul>
    *         <li>context – {object} – an object against which any expressions embedded in the strings are
    *         evaluated against (typically a scope object).</li>
    *         <li>locals – {object=} – local variables context object, useful for overriding values in context.</li>
    *         <ul>
    */
  def parseAsHtml(expression: String): js.Function2[js.Any, js.Any, js.Any] = js.native

  /**
    * Shorthand method. $sce.parseAsCss(value) → $sce.parseAs($sce.CSS, value)
    * @param expression String expression to compile.
    * @return a function which represents the compiled expression:
    *         <ul>
    *         <li>context – {object} – an object against which any expressions embedded in the strings are
    *         evaluated against (typically a scope object).</li>
    *         <li>locals – {object=} – local variables context object, useful for overriding values in context.</li>
    *         <ul>
    */
  def parseAsCss(expression: String): js.Function2[js.Any, js.Any, js.Any] = js.native

  /**
    * Shorthand method. \$sce.parseAsUrl(value) -> \$sce.parseAs($sce.URL, value)
    * @param expression String expression to compile.
    * @return a function which represents the compiled expression:
    *         <ul>
    *         <li>context – {object} – an object against which any expressions embedded in the strings are
    *         evaluated against (typically a scope object).</li>
    *         <li>locals – {object=} – local variables context object, useful for overriding values in context.</li>
    *         <ul>
    */
  def parseAsUrl(expression: String): js.Function2[js.Any, js.Any, js.Any] = js.native

  /**
    * Shorthand method. \$sce.parseAsResourceUrl(value) -> \$sce.parseAs(\$sce.RESOURCE_URL, value)
    * @param expression String expression to compile.
    * @return a function which represents the compiled expression:
    *         <ul>
    *         <li>context – {object} – an object against which any expressions embedded in the strings are
    *         evaluated against (typically a scope object).</li>
    *         <li>locals – {object=} – local variables context object, useful for overriding values in context.</li>
    *         <ul>
    */
  def parseAsResourceUrl(expression: String): js.Function2[js.Any, js.Any, js.Any] = js.native

  /**
    * Shorthand method. $sce.parseAsJs(value) → $sce.parseAs($sce.JS, value)
    * @param expression String expression to compile.
    * @return a function which represents the compiled expression:
    *         <ul>
    *         <li>context – {object} – an object against which any expressions embedded in the strings are
    *         evaluated against (typically a scope object).</li>
    *         <li>locals – {object=} – local variables context object, useful for overriding values in context.</li>
    *         <ul>
    */
  def parseAsJs(expression: String): js.Function2[js.Any, js.Any, js.Any] = js.native

}

/**
  * SCE Service Singleton
  */
object Sce {

  /**
    * For HTML that's safe to source into the application. The ngBindHtml directive uses this
    * context for bindings. If an unsafe value is encountered and the $sanitize module is present
    * this will sanitize the value instead of throwing an error.
    */
  val HTML = "HTML"

  /**
    * For CSS that's safe to source into the application. Currently unused.
    * Feel free to use it in your own directives.
    */
  val CSS = "CSS"

  /**
    * For URLs that are safe to follow as links. Currently unused (<a href= and <img src= sanitize their urls
    * and don't constitute an SCE context.
    */
  val URL = "URL"

  /**
    * For URLs that are not only safe to follow as links, but whose contents are also safe to include in
    * your application. Examples include ng-include, src / ngSrc bindings for tags other than
    * IMG (e.g. IFRAME, OBJECT, etc.)
    *
    * Note that $sce.RESOURCE_URL makes a stronger statement about the URL than $sce.URL does and therefore
    * contexts requiring values trusted for \$sce.RESOURCE_URL can be used anywhere that values trusted for
    * \$sce.URL are required.
    */
  val RESOURCE_URL = "RESOURCE_URL"

  /**
    * For JavaScript that is safe to execute in your application's context. Currently unused.
    * Feel free to use it in your own directives.
    */
  val JS = "JS"

}

/**
  * SCE Provider - The \$sceProvider provider allows developers to configure the $sce service.
  * @see [[https://docs.angularjs.org/api/ng/provider/\$sceProvider]]
  */
@js.native
trait SceProvider extends Provider[Sce] {

  /**
    * Enables/disables SCE and returns the current value.
    * @param value If provided, then enables/disables SCE.
    * @return true if SCE is enabled, false otherwise.
    */
  def enabled(value: Boolean = js.native): Boolean = js.native

}

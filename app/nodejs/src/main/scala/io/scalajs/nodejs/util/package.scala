package io.scalajs.nodejs

import scala.scalajs.js

/**
  * nodejs.util package object
  * @author lawrence.daniels@gmail.com
  */
package object util {

  type CBF[Y, Z] = js.Function2[Y, Z, Any]

  /**
    * Util Enrichment
    * @param util the supplied [[Util]]
    */
  final implicit class UtilEnriched(val util: Util) extends AnyVal {

    /**
      * Takes an async function (or a function that returns a Promise) and returns a function following the
      * error-first callback style, i.e. taking an (err, value) => ... callback as the last argument. In the
      * callback, the first argument will be the rejection reason (or null if the Promise resolved), and the
      * second argument will be the resolved value.
      * @example util.callbackify(original)
      * @param original An async function
      * @return a callback style function
      */
    def callbackify[E <: js.Error, Z](original: => js.Promise[Z]): js.Function2[E, Z, Any] = util.callbackifyJS(original)

  }

}

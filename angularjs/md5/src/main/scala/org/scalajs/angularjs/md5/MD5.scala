package org.scalajs.angularjs
package md5

import scala.scalajs.js

/**
  * angular-md5 - A md5 crypto component for Angular.js
  * @version 0.1.10
  * @see [[https://www.npmjs.com/package/angular-md5]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MD5 extends js.Object {

  def createHash(value: js.UndefOr[String]): String = js.native

}

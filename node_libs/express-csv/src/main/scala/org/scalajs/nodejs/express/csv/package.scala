package org.scalajs.nodejs.express

import scala.scalajs.js

/**
  * express-csv package object
  * @author lawrence.daniels@gmail.com
  */
package object csv {

  @js.native
  trait CSVResponse extends js.Object {

    def csv(values: js.Array[_]): js.Any = js.native

  }

}

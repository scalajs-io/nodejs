package io.scalajs.nodejs

import io.scalajs.collection.Iterator

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * url package object
  * @author lawrence.daniels@gmail.com
  */
package object url {

  type Iterable[A] = js.Array[A] | Iterator[A]

}

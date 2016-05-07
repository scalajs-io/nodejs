package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.JsIterator.IteratorResult
import com.github.ldaniels528.meansjs.nodejs.buffer._
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * Buffers Example
  * @author lawrence.daniels@gmail.com
  */
class Buffers(bootstrap: Bootstrap) {

  val buf1 = Buffer.from("ABC")
  val buf2 = Buffer.from("BCD")
  val buf3 = Buffer.from("ABCD")

  // Prints: 0
  console.log(buf1.compare(buf1))
  // Prints: -1
  console.log(buf1.compare(buf2))
  // Prints: 1
  console.log(buf1.compare(buf3))
  // Prints: 1
  console.log(buf2.compare(buf1))
  // Prints: 1
  console.log(buf2.compare(buf3))

  // produces sort order [buf1, buf3, buf2]
  console.log(js.Array(buf1, buf2, buf3).sort((buf1: Buffer, buf2: Buffer) => Buffer.compare(buf1, buf2)))

  // iterate the 3rd buffer
  val it = buf3.entries()
  var result: IteratorResult = _
  do {
    result = it.next()
    console.log(result)
  } while (!result.done)
}

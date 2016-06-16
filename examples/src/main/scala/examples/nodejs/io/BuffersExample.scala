package examples.nodejs.io

import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.buffer.{Buffer, _}
import org.scalajs.sjs.Iterator.Entry

import scala.scalajs.js

/**
  * Buffers Example
  * @author lawrence.daniels@gmail.com
  */
class BuffersExample(bootstrap: Bootstrap) {

  example1()
  example2()
  example3()

  def example1() {
    // "Hello " + "World" => "Hello World"
    val bufA = Buffer.from("Hello ")
    console.log("bufA =>", bufA.toString())
    val bufB = Buffer.from("World")
    console.log("bufB =>", bufB.toString())
    val bufC = bufA + bufB
    console.log("bufC =>", bufC.toString(), ", length = ", bufC.byteLength())
  }

  def example2() {
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
  }

  def example3() = {
    val buf = Buffer.from("Hello!")

    // iterate the buffer
    console.log("iterate the buffer")
    val it = buf.entries()
    var result: Entry[js.Any] = null
    do {
      result = it.next()
      if (!result.done) console.log("value:", result.value)
    } while (!result.done)

    // iterate the buffer -- the Scala way
    console.log("iterate the buffer -- the Scala way")
    for (value <- buf.entries()) console.log("value:", value)
  }

}

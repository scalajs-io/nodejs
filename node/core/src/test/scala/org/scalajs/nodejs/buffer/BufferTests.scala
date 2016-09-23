package org.scalajs.nodejs.buffer

import org.scalajs.nodejs.console
import org.scalajs.sjs.Iterator.Entry
import utest._

import scala.scalajs.js

/**
  * Buffer Tests
  * @author lawrence.daniels@gmail.com
  */
object BufferTests extends TestSuite {

  override val tests = this {

    "Buffer.from" - {
      val bufA = Buffer.from("Hello ")
      console.log("bufA =>", bufA.toString())
      val bufB = Buffer.from("World")
      console.log("bufB =>", bufB.toString())
      val bufC = bufA + bufB
      console.log("bufC =>", bufC.toString(), ", length = ", bufC.byteLength())

      bufA.toString() ==> "Hello "
      bufB.toString() ==> "World"
      bufC.byteLength() ==> 11
    }

    "buffer.sort" - {
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

    "buffer.entries [classic]" - {
      val buf = Buffer.from("Hello!")
      val it = buf.entries()
      var result: Entry[js.Any] = null
      do {
        result = it.next()
        if (!result.done) console.log("value:", result.value)
      } while (!result.done)
    }

    "buffer.entries [Scala]" - {
      val buf = Buffer.from("Hello!")
      for (value <- buf.entries()) console.log("value:", value)
    }

  }

}

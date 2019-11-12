package io.scalajs.nodejs

import org.scalatest.FunSuite

import scala.scalajs.js

class TopLevelTest extends FunSuite {
  test("queueMicrotask") {
    assert(queueMicrotask.isInstanceOf[js.Function])
    queueMicrotask(() => println("printed from queueMicrotask"))
  }
}

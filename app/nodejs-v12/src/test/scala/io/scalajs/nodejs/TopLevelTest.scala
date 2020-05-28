package io.scalajs.nodejs

import scala.scalajs.js
import org.scalatest.funsuite.AnyFunSuite

class TopLevelTest extends AnyFunSuite {
  test("queueMicrotask") {
    assert(queueMicrotask.isInstanceOf[js.Function])
    queueMicrotask(() => println("printed from queueMicrotask"))
  }
}

package org.scalajs.rx

import org.scalajs.nodejs.{NodeRequire, console}
import utest._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Observable Test Suite
  * @author lawrence.daniels@gmail.com
  */
object ObservableTest extends TestSuite {

  override val tests = this {

    "Rx.Observable.just" {
      console.log(require)

      val RxJs = Rx()

      val source = RxJs.Observable.just(42)

      val subscription = source.forEachWith(
        onNext = { x =>
          console.log("Next: %s", x)
        },
        onError = { err =>
          console.log("Error: %s", err)
        },
        onCompleted = () => {
          console.log("Completed ")
        })

      // => Next: 42
      // => Completed

      subscription.dispose()
      1
    }

  }

  @js.native
  @JSName("require")
  implicit object require extends NodeRequire

}
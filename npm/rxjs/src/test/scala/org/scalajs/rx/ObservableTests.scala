package org.scalajs.rx

import com.cognitect.transducers.TransducersJs
import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.console
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.sjs.JSONHelper._
import utest._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Observable Tests
  * @author lawrence.daniels@gmail.com
  */
object ObservableTests extends TestSuite {

  override val tests = this {
    val rx = Rx()
    val tx = TransducersJs()

    "Rx.Observable.just" - {
      rx.Observable.just(42).drainFuture map { values =>
        console.log("output", values)
        values.toSeq ==> Seq(42)
      }
    }

    "Rx.Observable.of + flatMapWith" - {
      rx.Observable.of(2, 3, 5)
        .flatMapWith(
          selector = { (x, index, _) => js.Array(
            x * x,
            x * x * x,
            x * x * x * x)
          },
          resultSelector = { (outer, inner, outerIndex, innerIndex) =>
            new Data(outer = outer, inner = inner, outerIdx = outerIndex, innerIdx = innerIndex)
          })
        .drainFuture map { values =>
        val data = values.map(_.toJson).mkString(",")
        console.log(values.map(_.toJson).mkString("\n"))
        assert(data == """{"outer":2,"inner":4,"outerIdx":0,"innerIdx":0},{"outer":2,"inner":8,"outerIdx":0,"innerIdx":1},{"outer":3,"inner":9,"outerIdx":1,"innerIdx":0},{"outer":2,"inner":16,"outerIdx":0,"innerIdx":2},{"outer":3,"inner":27,"outerIdx":1,"innerIdx":1},{"outer":5,"inner":25,"outerIdx":2,"innerIdx":0},{"outer":3,"inner":81,"outerIdx":1,"innerIdx":2},{"outer":5,"inner":125,"outerIdx":2,"innerIdx":1},{"outer":5,"inner":625,"outerIdx":2,"innerIdx":2}""")
      }
    }

    "Rx.Observable.filterWith" - {
      rx.Observable.range(0, 5).filterWith(_ % 2 == 0).drainFuture map { values =>
        console.log("output", values)
        assert(values.toSeq == Seq(0, 2, 4))
      }
    }

    "Rx.Observable.mapWith + mergeAll" - {
      rx.Observable.range(0, 3).mapWith(rx.Observable.range(_, 3)).mergeAll().drainFuture map { values =>
        console.log("output", values)
        assert(values.toSeq == Seq(0, 1, 1, 2, 2, 2, 3, 3, 4))
      }
    }

    "Rx.Observable.take + toArray" - {
      rx.Observable.range(0, 1000).take(5).toArray().drainFuture map { values =>
        console.log("output", values)
        assert(values.map(_.toSeq).toSeq == Seq(Seq(0, 1, 2, 3, 4)))
      }
    }

    "Rx.Observable.transduce" - {
      val isEven: js.Function = (x: Int) => x % 2 == 0
      val mul10: js.Function = (x: Int) => x * 10
      rx.Observable.range(1, 5).transduce(tx.comp(tx.filter(isEven), tx.map(mul10))).drainFuture map { values =>
        console.log("output", values)
        assert(values.toSeq == Seq(20, 40))
      }
    }

  }

  @ScalaJSDefined
  class Data(val outer: Int, val inner: Int, val outerIdx: Int, val innerIdx: Int) extends js.Object

}
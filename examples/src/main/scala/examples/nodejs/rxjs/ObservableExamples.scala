package examples.nodejs.rxjs

import com.cognitect.transducers.TransducersJs
import examples.nodejs.rxjs.ObservableExamples.Data
import org.scalajs.nodejs.{Bootstrap, console}
import org.scalajs.rx.{Observable, Rx}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Observable Examples
  * @author lawrence.daniels@gmail.com
  */
class ObservableExamples(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val rx = Rx()
  val t = TransducersJs()

  example7()

  def example1() = log {
    val document = new js.Object()

    // Using a value
    val md = rx.Observable.fromEvent(document, "mousedown").mapWith(_ => true)
    val mu = rx.Observable.fromEvent(document, "mouseup").mapWith(_ => false)

    // Using a function
    rx.Observable.range(1, 3).mapWith(x => x * x)
  }

  def example2() = log {
    rx.Observable.range(0, 3).mapWith(rx.Observable.range(_, 3)).mergeAll()

    // => Next: 0
    // => Next: 1
    // => Next: 1
    // => Next: 2
    // => Next: 2
    // => Next: 2
    // => Next: 3
    // => Next: 3
    // => Next: 4
    // => Completed
  }

  def example3() = log {
    rx.Observable.of(2, 3, 5).flatMapWith(
      selector = { (x, index, _) => js.Array(
        x * x,
        x * x * x,
        x * x * x * x)
      },
      resultSelector = { (outer, inner, outerIndex, innerIndex) =>
        new Data(outer = outer, inner = inner, outerIdx = outerIndex, innerIdx = innerIndex)
      })

    //=> Outer: 2, Inner: 4, InnerIndex : 0, OuterIndex : 0
    //=> Outer: 2, Inner: 8, InnerIndex : 1, OuterIndex : 0
    //=> Outer: 2, Inner: 16, InnerIndex : 2, OuterIndex : 0
    //=> Outer: 3, Inner: 9, InnerIndex : 0, OuterIndex : 1
    //=> Outer: 3, Inner: 27, InnerIndex : 1, OuterIndex : 1
    //=> Outer: 3, Inner: 81, InnerIndex : 2, OuterIndex : 1
    //...etc
    //=> Completed
  }

  def example4() = log {
    rx.Observable.range(0, 5).take(3)

    // => Next: 0
    // => Next: 1
    // => Next: 2
    // => Completed
  }

  def example5() = log {
    rx.Observable.range(0, 5).filterWith(_ % 2 == 0)

    // => Next: 0
    // => Next: 2
    // => Next: 4
    // => Completed
  }

  def example6() = log {
    rx.Observable.range(0, 1000).take(5).toArray()
  }

  def example7() = {
    val even: js.Function = (x: Int) => x % 2 == 0
    val mul10: js.Function = (x: Int) => x * 10
    log(rx.Observable.range(1, 5).transduce(t.comp(t.filter(even), t.map(mul10))))

    // => Next: 20
    // => Next: 40
    // => Completed
  }

  private def log(source: => Observable[_]): Unit = {
    val subscription = source.forEachWith(
      onNext = { value => console.log("Next: %j", value) },
      onError = { err => console.log("Error: %s", err) },
      onCompleted = { () => console.log("Completed") }
    )
    subscription.dispose()
  }

}

/**
  * Observable Examples Companion
  * @author lawrence.daniels@gmail.com
  */
object ObservableExamples {

  @ScalaJSDefined
  class Data(val outer: Int, val inner: Int, val outerIdx: Int, val innerIdx: Int) extends js.Object

}
package examples.nodejs.io

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.fs.Stats
import com.github.ldaniels528.meansjs.nodejs.watch._

import scala.concurrent.duration._
import scala.scalajs.js

/**
  * Watch Example
  * @author lawrence.daniels@gmail.com
  */
class WatchExample(bootstrap: Bootstrap) {
  import bootstrap._

  val watch = require[Watch]("watch")
  val root = "/Users/ldaniels/Downloads"

  example1()

  def example1(): Unit = {
    watch.watchTree(root, new WatchOptions(), (files: js.Dictionary[Stats], current: Stats, prev: Stats) => {
      files foreach { case (file, stat) =>
        console.log("file '%s' (%d bytes)", file, stat.size)
      }
    })

    // Stop watching after 30 seconds
    setTimeout(() => watch.unwatchTree(root), 15.seconds)
  }

  def example2(): Unit = {
    watch.createMonitor(root, (monitor: Monitor) => {
      // get the stat for FilledStar.gif
      monitor.files.get(s"$root/images/FilledStar.gif") foreach { stat =>
        console.log("FilledStar.gif is %d bytes", stat.size)
      }

      monitor.onCreated((file, stat) => {
        console.log("onCreated: ", file)
        console.log("stat => ", stat)
      })

      monitor.onChanged((file, curr, prev) => {
        console.log("onChanged: ", file)
        console.log("curr => ", curr)
        console.log("prev => ", prev)
      })

      monitor.onRemoved((file, stat) => {
        console.log("onRemoved: ", file)
        console.log("stat => ", stat)
      })

      // Stop watching after 30 seconds
      setTimeout(() => monitor.stop(), 30.seconds)
    })
  }

  def example3(): Unit = {
    watch.walk(root, (response: js.Any) => {
      console.log("walk =>", response)
    })
  }

}

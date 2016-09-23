package org.scalajs.nodejs.watch

import org.scalajs.nodejs._
import org.scalajs.nodejs.fs.Stats
import utest._

import scala.concurrent.duration._
import scala.scalajs.js

/**
  * Watch Tests
  * @author lawrence.daniels@gmail.com
  */
object WatchTests extends TestSuite {

  override val tests = this {
    val watch = Watch()
    val root = "/Users/ldaniels/Downloads"

    "watch.watchTree" - {
      watch.watchTree(root, new WatchOptions(), (files: js.Dictionary[Stats], current: Stats, prev: Stats) => {
        files foreach { case (file, stat) =>
          console.log("file '%s' (%d bytes)", file, stat.size)
        }
      })

      // Stop watching after 30 seconds
      setTimeout(() => watch.unwatchTree(root), 15.seconds)
    }

    "watch.createMonitor" - {
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

    "watch.walk" - {
      watch.walk(root, (response: js.Any) => {
        console.log("walk =>", response)
      })
    }

  }

}

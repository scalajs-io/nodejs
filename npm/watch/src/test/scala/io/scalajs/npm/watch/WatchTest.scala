package io.scalajs.npm.watch

import io.scalajs.nodejs._
import io.scalajs.nodejs.fs.Stats
import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.scalajs.js

/**
  * Watch Tests
  * @author lawrence.daniels@gmail.com
  */
class WatchTest extends FunSpec {

  describe("Watch") {

    val root = "./node_modules"

    it("supports watchTree") {
      Watch.watchTree(root, new WatchOptions(), (files: js.Dictionary[Stats], current: Stats, prev: Stats) => {
        files foreach { case (file, stat) =>
          info("file '%s' (%f bytes)".format(file, stat.size))
        }
      })

      // Stop watching after 30 seconds
      setTimeout(() => Watch.unwatchTree(root), 15.seconds)
    }

    it("supports createMonitor") {
      Watch.createMonitor(root, (monitor: Monitor) => {
        // get the stat for FilledStar.gif
        monitor.files.get(s"$root/images/FilledStar.gif") foreach { stat =>
          info("FilledStar.gif is %f bytes".format(stat.size))
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

    it("supports walk") {
      Watch.walk(root, (response: js.Any) => {
        console.log("walk =>", response)
      })
    }

  }

}

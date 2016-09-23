package org.scalajs.nodejs.cluster

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs._
import org.scalajs.nodejs.util.ScalaJsHelper._
import utest._

import scala.concurrent.duration._

/**
  * Cluster Tests
  * @author lawrence.daniels@gmail.com
  */
object ClusterTests extends TestSuite {

  override val tests = this {
    val cluster = Cluster()

    "cluster.isMaster" - {
      console.log("cluster.isMaster =>", cluster.isMaster)
      assert(isDefined(cluster.isMaster))
    }

    "cluster.isWorker" - {
      console.log("cluster.isWorker =>", cluster.isWorker)
      assert(isDefined(cluster.isWorker))
    }

    "cluster.schedulingPolicy" - {
      //console.log("cluster.schedulingPolicy =>", cluster.schedulingPolicy)
      //assert(isDefined(cluster.schedulingPolicy))
    }

    "cluster.settings" - {
      //console.log("cluster.settings =>", cluster.settings.toJson)
      //assert(isDefined(cluster.settings))
    }

    "cluster.fork()" - {
      if (cluster.isMaster) {
        // Fork the workers
        (1 to 2) map { n =>
          val worker = cluster.fork()
          worker.onOnline(() => console.log(s"Worker #$n is online..."))

          // shutdown worker after 5 seconds
          setTimeout(() => {
            console.log(s"Shutting down worker ${worker.id}...")
            worker.disconnect()
          }, 5.seconds)
        }

        cluster.onExit((worker, code, signal) => console.log(s"worker ${worker.process.pid} died"))
      }
    }

  }

}

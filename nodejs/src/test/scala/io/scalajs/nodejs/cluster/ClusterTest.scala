package io.scalajs.nodejs.cluster

import io.scalajs.JSON
import io.scalajs.nodejs._
import org.scalatest.FunSpec

import scala.concurrent.duration._

/**
  * Cluster Tests
  * @author lawrence.daniels@gmail.com
  */
class ClusterTest extends FunSpec {

  describe("Cluster") {

    it("cluster should be master") {
      info(s"cluster.isMaster => ${Cluster.isMaster}")
      assert(Cluster.isMaster)
    }

    it("cluster should not be a worker") {
      info(s"cluster.isWorker => ${Cluster.isWorker}")
      assert(!Cluster.isWorker)
    }

    it("cluster.schedulingPolicy") {
      info(s"cluster.schedulingPolicy => ${Cluster.schedulingPolicy}")
      assert(Cluster.schedulingPolicy == 2)
    }

    it("cluster.settings") {
      info(s"cluster.settings => ${JSON.stringify(Cluster.settings)}")
      //assert(isDefined(cluster.settings))
    }

    it("cluster support fork() new workers") {
      if (Cluster.isMaster) {
        // Fork the workers
        (1 to 2) map { n =>
          val worker = Cluster.fork()
          worker.onOnline(() => info(s"Worker #$n is online..."))

          // shutdown worker after 5 seconds
          setTimeout(() => {
            info(s"Shutting down worker ${worker.id}...")
            worker.disconnect()
          }, 1.seconds)
        }

        Cluster.onExit((worker, code, signal) => info(s"worker ${worker.process.pid} died"))
      }
    }

  }

}

package io.scalajs.nodejs.cluster

import io.scalajs.nodejs.setTimeout

import scala.concurrent.duration._
import scala.scalajs.js
import org.scalatest.funspec.AnyFunSpec

class ClusterTest extends AnyFunSpec {
  describe("ClusterSettings") {
    it("can be instantiated") {
      val settings: ClusterSettings = ClusterSettings(
        cwd = "/home/user",
        exec = "ls",
        execArgv = js.Array(),
        args = js.Array(),
        gid = 1,
        uid = 2,
        inspectPort = 3,
        stdio = js.Array(),
        windowsHide = false,
        silent = true
      )
      assert(settings.silent === true)
      assert(settings.gid === 1)
    }
  }

  describe("Cluster") {
    it("cluster should be master") {
      assert(Cluster.isMaster)
    }

    it("cluster should not be a worker") {
      assert(!Cluster.isWorker)
    }

    it("cluster.schedulingPolicy must be defined") {
      assert(!js.isUndefined(Cluster.schedulingPolicy))
    }

    it("cluster.settings  must be defined") {
      assert(!js.isUndefined(Cluster.settings))
    }

    // TODO: Update test
    // Cluster.fork() behavior changed somewhere between Node v10 and v12.
    // TypeError [ERR_INVALID_ARG_TYPE]: The "modulePath" argument must be of type string. Received type undefined
    //    at validateString (internal/validators.js:107:11)
    //    at fork (child_process.js:55:3)
    //    at createWorkerProcess (internal/cluster/master.js:130:10)
    //    at EventEmitter.cluster.fork (internal/cluster/master.js:164:25)
    //    at repl:1:9
    //    at Script.runInThisContext (vm.js:123:20)
    //    at REPLServer.defaultEval (repl.js:384:29)
    //    at bound (domain.js:415:14)
    //    at REPLServer.runBound [as eval] (domain.js:428:12)
    //    at REPLServer.onLine (repl.js:700:10)
    ignore("cluster support fork() new workers") {
      if (Cluster.isMaster) {
        // Fork the workers
        (1 to 2) map { n =>
          val worker = Cluster.fork()
          worker.onOnline(() => info(s"Worker #$n is online..."))

          // shutdown worker after 5 seconds
          setTimeout(
            () => {
              info(s"Shutting down worker ${worker.id}...")
              worker.disconnect()
            },
            0.5.seconds.toMillis.toInt
          )
        }

        Cluster.onExit((worker, code, signal) => info(s"worker ${worker.process.pid} died"))
      }
    }
  }
}

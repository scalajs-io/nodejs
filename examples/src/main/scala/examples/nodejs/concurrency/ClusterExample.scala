package examples.nodejs.concurrency

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.cluster._
import com.github.ldaniels528.meansjs.nodejs.http._
import com.github.ldaniels528.meansjs.nodejs.os._

import scala.concurrent.duration._

/**
  * Cluster Example
  * @author lawrence.daniels@gmail.com
  */
class ClusterExample(bootstrap: Bootstrap) {
  import bootstrap._

  val cluster = require[Cluster]("cluster")
  val http = require[Http]("http")
  val numCPUs = require[OS]("os").cpus().length

  if (cluster.isMaster) {
    // Fork workers.
    for (n <- 1 to numCPUs) {
      val worker = cluster.fork()
      worker.onOnline(() => console.log(s"Worker #$n is online..."))

      // shutdown worker after 30 seconds
      setTimeout(() => {
        console.log(s"Shutting down worker ${worker.id}...")
        worker.disconnect()
      }, 30.seconds)
    }

    cluster.onExit((worker, code, signal) => console.log(s"worker ${worker.process.pid} died"))

  } else {
    // Workers can share any TCP connection
    // In this case it is an HTTP server
    http.createServer((req: ClientRequest, res: ServerResponse) => {
      res.writeHead(200)
      res.end("hello world\n")
    }).listen(8000)
  }

}

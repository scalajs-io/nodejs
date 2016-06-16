package examples.nodejs.concurrency

import org.scalajs.nodejs._
import org.scalajs.nodejs.cluster._
import org.scalajs.nodejs.http._
import org.scalajs.nodejs.os._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.cluster.Cluster
import org.scalajs.nodejs.http.{ClientRequest, Http, ServerResponse}
import org.scalajs.nodejs.os.OS

import scala.concurrent.duration._

/**
  * Cluster Example
  * @author lawrence.daniels@gmail.com
  */
class ClusterExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val cluster = Cluster()
  val http = Http()
  val numCPUs = OS().cpus().length

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

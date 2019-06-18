package io.scalajs.npm.mongoose

import io.scalajs.nodejs.process
import io.scalajs.npm.mongodb.{Db, MongoClient}
import org.scalatest.FunSpec

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

/**
  * MongoDB Test Support
  * @author lawrence.daniels@gmail.com
  */
trait MongoDBTestSupport {
  self: FunSpec =>

  def withMongoURL[S](block: String => S): Any = {
    process.env.get("MONGO_CONNECT") match {
      case Some(url) => block(url)
      case None =>
        info("No MongoDB configuration. Set 'MONGO_CONNECT' (ex. MONGO_CONNECT=mongodb://localhost:27017/test)")
    }
  }

  def withMongo[S](label: String)(block: Db => Future[S])(implicit ec: ExecutionContext): Any = {
    process.env.get("MONGO_CONNECT") match {
      case None =>
        info("No MongoDB configuration. Set 'MONGO_CONNECT' (ex. MONGO_CONNECT=mongodb://localhost:27017/test)")

      case Some(url) =>
        val outcome = for {
          db <- MongoClient.connectFuture(url)
          result <- block(db)
        } yield (db, result)

        outcome onComplete {
          case Success((db, _)) =>
            info(s"$label: Closing connection....")
            db.close()
          case Failure(e) =>
            throw new IllegalStateException(s"MongoDB connection failure: ${e.getMessage}")
        }
    }
  }

}

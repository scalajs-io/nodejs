package examples.nodejs.azure

import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.azure.storage.AzureStorage
import org.scalajs.nodejs.fs.Fs

/**
  * Blob Service Example
  * @author lawrence.daniels@gmail.com
  */
class BlobServiceExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val azure = AzureStorage()
  val fs = Fs()

  def blob() = {
    val blobService = azure.createBlobService()
    blobService.getBlob("taskcontainer", "task1").pipe(fs.createWriteStream("task1-download.txt"))
  }

}

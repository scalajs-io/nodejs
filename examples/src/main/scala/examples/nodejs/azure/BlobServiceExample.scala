package examples.nodejs.azure

import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.azure.storage.AzureStorage
import com.github.ldaniels528.meansjs.nodejs.fs.Fs

/**
  * Blob Service Example
  * @author lawrence.daniels@gmail.com
  */
class BlobServiceExample(bootstrap: Bootstrap) {
  import bootstrap._
  
  val azure = require[AzureStorage]("azure-storage")
  val fs = require[Fs]("fs")
  
  def blob() = {
    val blobService = azure.createBlobService()
    blobService.getBlob("taskcontainer", "task1").pipe(fs.createWriteStream("task1-download.txt"))
  }

}

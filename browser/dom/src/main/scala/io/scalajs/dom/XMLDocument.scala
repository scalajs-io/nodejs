package io.scalajs.dom

import scala.scalajs.js

/**
  * The XMLDocument interface represent an XML document. It inherits from the generic Document
  * and does not add any specific methods or properties to it: nevertheless, several algorithms
  * behave differently with the two types of documents.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/XMLDocument
  *
  */
@js.native
class XMLDocument extends Document {

  /**
    * Loads an XML document.
    *
    * document.load() is a part of an old version of the W3C DOM Level 3 Load & Save module.
    * Can be used with document.async to indicate whether the request is synchronous or asynchronous
    * (the default). As of at least Gecko 1.9, this no longer supports cross-site loading of documents
    * (Use XMLHttpRequest instead).
    */
  def load(): Unit = js.native

}

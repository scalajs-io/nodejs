package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL

import scala.scalajs.js.|

package object http2 {
  type Origin = String | URL | HasOrigin
  type Path   = String | Buffer | URL
}

package io.scalajs.nodejs.zlib

import com.thoughtworks.enableMembersIf

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("zlib", "constants")
object Constants extends UncategorizedConstants with BlotriConstants with ZlibConstants {}

@js.native
trait UncategorizedConstants extends js.Object {
  val DEFLATE: Int     = js.native
  val DEFLATERAW: Int  = js.native
  val GUNZIP: Int      = js.native
  val GZIP: Int        = js.native
  val INFLATE: Int     = js.native
  val INFLATERAW: Int  = js.native
  val UNZIP: Int       = js.native
  val ZLIB_VERNUM: Int = js.native
}

@js.native
trait ZlibConstants extends js.Object {
  val Z_DEFAULT_CHUNK: Int      = js.native
  val Z_DEFAULT_LEVEL: Int      = js.native
  val Z_DEFAULT_MEMLEVEL: Int   = js.native
  val Z_DEFAULT_WINDOWBITS: Int = js.native
  val Z_MAX_CHUNK: Double       = js.native
  val Z_MAX_LEVEL: Int          = js.native
  val Z_MAX_MEMLEVEL: Int       = js.native
  val Z_MAX_WINDOWBITS: Int     = js.native
  val Z_MIN_CHUNK: Int          = js.native
  val Z_MIN_LEVEL: Int          = js.native
  val Z_MIN_MEMLEVEL: Int       = js.native
  val Z_MIN_WINDOWBITS: Int     = js.native

  // Allowed flush values
  val Z_NO_FLUSH: CompressionFlush      = js.native
  val Z_PARTIAL_FLUSH: CompressionFlush = js.native
  val Z_SYNC_FLUSH: CompressionFlush    = js.native
  val Z_FULL_FLUSH: CompressionFlush    = js.native
  val Z_FINISH: CompressionFlush        = js.native
  val Z_BLOCK: CompressionFlush         = js.native
  val Z_TREES: CompressionFlush         = js.native

  // Return codes for the compression/decompression functions.
  val Z_OK: CompressionFunction            = js.native
  val Z_STREAM_END: CompressionFunction    = js.native
  val Z_NEED_DICT: CompressionFunction     = js.native
  val Z_ERRNO: CompressionFunction         = js.native
  val Z_STREAM_ERROR: CompressionFunction  = js.native
  val Z_DATA_ERROR: CompressionFunction    = js.native
  val Z_MEM_ERROR: CompressionFunction     = js.native
  val Z_BUF_ERROR: CompressionFunction     = js.native
  val Z_VERSION_ERROR: CompressionFunction = js.native

  // Compression levels
  val Z_NO_COMPRESSION: CompressionLevel      = js.native
  val Z_BEST_SPEED: CompressionLevel          = js.native
  val Z_BEST_COMPRESSION: CompressionLevel    = js.native
  val Z_DEFAULT_COMPRESSION: CompressionLevel = js.native

  // Compression strategies
  val Z_FILTERED: CompressionStrategy         = js.native
  val Z_HUFFMAN_ONLY: CompressionStrategy     = js.native
  val Z_RLE: CompressionStrategy              = js.native
  val Z_FIXED: CompressionStrategy            = js.native
  val Z_DEFAULT_STRATEGY: CompressionStrategy = js.native

  // Possible values of the data_type field
  val Z_BINARY: DataType  = js.native
  val Z_TEXT: DataType    = js.native
  val Z_ASCII: DataType   = js.native
  val Z_UNKNOWN: DataType = js.native

  // The deflate compression method (the only one supported in this version).
  val Z_DEFLATED: DeflateCompressMethod = js.native

  // For initializing zalloc, zfree, opaque.
  val Z_NULL: AllocationType = js.native
}

@enableMembersIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
@js.native
trait BlotriConstants extends js.Object {
  val BROTLI_DECODE: Int                                         = js.native
  val BROTLI_DECODER_ERROR_ALLOC_BLOCK_TYPE_TREES: Int           = js.native
  val BROTLI_DECODER_ERROR_ALLOC_CONTEXT_MAP: Int                = js.native
  val BROTLI_DECODER_ERROR_ALLOC_CONTEXT_MODES: Int              = js.native
  val BROTLI_DECODER_ERROR_ALLOC_RING_BUFFER_1: Int              = js.native
  val BROTLI_DECODER_ERROR_ALLOC_RING_BUFFER_2: Int              = js.native
  val BROTLI_DECODER_ERROR_ALLOC_TREE_GROUPS: Int                = js.native
  val BROTLI_DECODER_ERROR_DICTIONARY_NOT_SET: Int               = js.native
  val BROTLI_DECODER_ERROR_FORMAT_BLOCK_LENGTH_1: Int            = js.native
  val BROTLI_DECODER_ERROR_FORMAT_BLOCK_LENGTH_2: Int            = js.native
  val BROTLI_DECODER_ERROR_FORMAT_CL_SPACE: Int                  = js.native
  val BROTLI_DECODER_ERROR_FORMAT_CONTEXT_MAP_REPEAT: Int        = js.native
  val BROTLI_DECODER_ERROR_FORMAT_DICTIONARY: Int                = js.native
  val BROTLI_DECODER_ERROR_FORMAT_DISTANCE: Int                  = js.native
  val BROTLI_DECODER_ERROR_FORMAT_EXUBERANT_META_NIBBLE: Int     = js.native
  val BROTLI_DECODER_ERROR_FORMAT_EXUBERANT_NIBBLE: Int          = js.native
  val BROTLI_DECODER_ERROR_FORMAT_HUFFMAN_SPACE: Int             = js.native
  val BROTLI_DECODER_ERROR_FORMAT_PADDING_1: Int                 = js.native
  val BROTLI_DECODER_ERROR_FORMAT_PADDING_2: Int                 = js.native
  val BROTLI_DECODER_ERROR_FORMAT_RESERVED: Int                  = js.native
  val BROTLI_DECODER_ERROR_FORMAT_SIMPLE_HUFFMAN_ALPHABET: Int   = js.native
  val BROTLI_DECODER_ERROR_FORMAT_SIMPLE_HUFFMAN_SAME: Int       = js.native
  val BROTLI_DECODER_ERROR_FORMAT_TRANSFORM: Int                 = js.native
  val BROTLI_DECODER_ERROR_FORMAT_WINDOW_BITS: Int               = js.native
  val BROTLI_DECODER_ERROR_INVALID_ARGUMENTS: Int                = js.native
  val BROTLI_DECODER_ERROR_UNREACHABLE: Int                      = js.native
  val BROTLI_DECODER_NEEDS_MORE_INPUT: Int                       = js.native
  val BROTLI_DECODER_NEEDS_MORE_OUTPUT: Int                      = js.native
  val BROTLI_DECODER_NO_ERROR: Int                               = js.native
  val BROTLI_DECODER_PARAM_DISABLE_RING_BUFFER_REALLOCATION: Int = js.native
  val BROTLI_DECODER_PARAM_LARGE_WINDOW: Int                     = js.native
  val BROTLI_DECODER_RESULT_ERROR: Int                           = js.native
  val BROTLI_DECODER_RESULT_NEEDS_MORE_INPUT: Int                = js.native
  val BROTLI_DECODER_RESULT_NEEDS_MORE_OUTPUT: Int               = js.native
  val BROTLI_DECODER_RESULT_SUCCESS: Int                         = js.native
  val BROTLI_DECODER_SUCCESS: Int                                = js.native
  val BROTLI_DEFAULT_MODE: Int                                   = js.native
  val BROTLI_DEFAULT_QUALITY: Int                                = js.native
  val BROTLI_DEFAULT_WINDOW: Int                                 = js.native
  val BROTLI_ENCODE: Int                                         = js.native
  val BROTLI_LARGE_MAX_WINDOW_BITS: Int                          = js.native
  val BROTLI_MAX_INPUT_BLOCK_BITS: Int                           = js.native
  val BROTLI_MAX_QUALITY: Int                                    = js.native
  val BROTLI_MAX_WINDOW_BITS: Int                                = js.native
  val BROTLI_MIN_INPUT_BLOCK_BITS: Int                           = js.native
  val BROTLI_MIN_QUALITY: Int                                    = js.native
  val BROTLI_MIN_WINDOW_BITS: Int                                = js.native
  val BROTLI_MODE_FONT: Int                                      = js.native
  val BROTLI_MODE_GENERIC: Int                                   = js.native
  val BROTLI_MODE_TEXT: Int                                      = js.native
  val BROTLI_OPERATION_EMIT_METADATA: Int                        = js.native
  val BROTLI_OPERATION_FINISH: Int                               = js.native
  val BROTLI_OPERATION_FLUSH: Int                                = js.native
  val BROTLI_OPERATION_PROCESS: Int                              = js.native
  val BROTLI_PARAM_DISABLE_LITERAL_CONTEXT_MODELING: Int         = js.native
  val BROTLI_PARAM_LARGE_WINDOW: Int                             = js.native
  val BROTLI_PARAM_LGBLOCK: Int                                  = js.native
  val BROTLI_PARAM_LGWIN: Int                                    = js.native
  val BROTLI_PARAM_MODE: Int                                     = js.native
  val BROTLI_PARAM_NDIRECT: Int                                  = js.native
  val BROTLI_PARAM_NPOSTFIX: Int                                 = js.native
  val BROTLI_PARAM_QUALITY: Int                                  = js.native
  val BROTLI_PARAM_SIZE_HINT: Int                                = js.native
}

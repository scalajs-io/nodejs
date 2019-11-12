package io.scalajs.nodejs.process

import scala.scalajs.js

@js.native
trait ProcessConfig extends js.Object {
  var target_defaults: ProcessConfigTargetDefaults = js.native
  var variables: ProcessConfigVariable             = js.native
}

@js.native
trait ProcessConfigTargetDefaults extends js.Object {
  var cflags: js.Array[js.Any]       = js.native
  var deafult_configuration: String  = js.native
  var defines: js.Array[js.Any]      = js.native
  var include_dirs: js.Array[js.Any] = js.native
  var libraries: js.Array[js.Any]    = js.native
}

@js.native
trait ProcessConfigVariable extends js.Object {
  var asan: Int                                = js.native
  var build_v8_with_gn: Boolean                = js.native
  var coverage: Boolean                        = js.native
  var debug_nghttp2: Boolean                   = js.native
  var enable_lto: Boolean                      = js.native
  var enable_pgo_generate: Boolean             = js.native
  var enable_pgo_use: Boolean                  = js.native
  var force_dynamic_crt: Int                   = js.native
  var gas_version: String                      = js.native
  var host_arch: String                        = js.native
  var icu_data_in: String                      = js.native
  var icu_endianness: String                   = js.native
  var icu_gyp_path: String                     = js.native
  var icu_locales: String                      = js.native
  var icu_path: String                         = js.native
  var icu_small: Boolean                       = js.native
  var icu_ver_major: String                    = js.native
  var is_debug: Int                            = js.native
  var llvm_version: Int                        = js.native
  var napi_build_version: String               = js.native
  var node_byteorder: String                   = js.native
  var node_code_cache: String                  = js.native
  var node_debug_lib: Boolean                  = js.native
  var node_enable_d8: Boolean                  = js.native
  var node_install_npm: Boolean                = js.native
  var node_module_version: Int                 = js.native
  var node_no_browser_globals: Boolean         = js.native
  var node_prefix: String                      = js.native
  var node_release_urlbase: String             = js.native
  var node_report: Boolean                     = js.native
  var node_shared: Boolean                     = js.native
  var node_shared_cares: Boolean               = js.native
  var node_shared_http_parser: Boolean         = js.native
  var node_shared_libuv: Boolean               = js.native
  var node_shared_nghttp2: Boolean             = js.native
  var node_shared_openssl: Boolean             = js.native
  var node_shared_zlib: String                 = js.native
  var node_tag: String                         = js.native
  var node_target_type: String                 = js.native
  var node_use_bundled_v8: Boolean             = js.native
  var node_use_dtrace: Boolean                 = js.native
  var node_use_etw: Boolean                    = js.native
  var node_use_large_pages: Boolean            = js.native
  var node_use_large_pages_script_lld: Boolean = js.native
  var node_use_node_snapshot: Boolean          = js.native
  var node_use_openssl: Boolean                = js.native
  var node_use_v8_platform: Boolean            = js.native
  var node_with_ltcg: Boolean                  = js.native
  var node_without_node_options: Boolean       = js.native
  var openssl_fips: String                     = js.native
  var openssl_is_fips: Boolean                 = js.native
  var shlib_suffix: String                     = js.native
  var target_arch: String                      = js.native
  var v8_enable_gdbjit: Int                    = js.native
  var v8_enable_i18n_support: Int              = js.native
  var v8_enable_inspector: Int                 = js.native
  var v8_no_strict_aliasing: Int               = js.native
  var v8_optimized_debug: Int                  = js.native
  var v8_promise_internal_field_count: Int     = js.native
  var v8_random_seed: Int                      = js.native
  var v8_trace_maps: Int                       = js.native
  var v8_use_siphash: Int                      = js.native
  var v8_use_snapshot: Int                     = js.native
  var want_separate_host_toolset: Int          = js.native
}

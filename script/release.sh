#! /bin/bash

cat ./version.sbt

export SCALAJS_VERSION=0.6.32
sbt clean +publishSigned sonatypeBundleUpload sonatypeReleaseAll
export SCALAJS_VERSION=1.0.0
sbt clean +publishSigned sonatypeBundleUpload sonatypeReleaseAll

#!/bin/bash

SOURCE_DIR=$(pwd)/app/nodejs-v14/src/main

V12_DIR=$(pwd)/app/nodejs-v12/src/main
if [ -e "$V12_DIR" ]; then
  echo "V12 dir already exists."
else
  ln -s "$SOURCE_DIR" "$V12_DIR";
  echo "V12 dir created.";
fi

V10_DIR=$(pwd)/app/nodejs-v10/src/main
if [ -e "$V10_DIR" ]; then
  echo "V10 dir already exists."
else
  ln -s "$SOURCE_DIR" "$V10_DIR";
  echo "V1 dir created.";
fi

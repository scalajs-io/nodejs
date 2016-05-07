#!/bin/bash
cp $(find . | grep [.]jar | grep sjs | grep -v sources[.]jar | grep -v javadoc[.]jar) ~/Downloads/staging

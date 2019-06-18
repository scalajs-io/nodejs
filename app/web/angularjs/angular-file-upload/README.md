Angular File Upload API for Scala.js
================================
[angular-file-upload](https://www.npmjs.com/package/angular-file-upload) - angular-file-upload binding for Scala.js.

### Description

Angular File Upload is a module for the AngularJS framework. Supports drag-n-drop upload, upload progress, 
validation filters and a file upload queue. It supports native HTML5 uploads, but degrades to a legacy iframe 
upload method for older browsers. Works with any server side platform which supports standard HTML form uploads.

When files are selected or dropped into the component, one or more filters are applied. Files which pass all filters 
are added to the queue. When file is added to the queue, for him is created instance of {FileItem} and uploader 
options are copied into this object. After, items in the queue (FileItems) are ready for uploading.

### Build Dependencies

* [SBT v1.2.x](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Artifacts and Resolvers

To add the `angular-file-upload` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "angular-file-upload" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
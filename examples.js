/**
 * Examples bootstrap
 * @author: lawrence.daniels@gmail.com
 */
(function () {
    // define the bootstrap object
    const bootstrap = {
        "__dirname": __dirname,
        "__filename": __filename,
        "exports": exports,
        "module": module,
        "require": require
    };

    require("./examples/target/scala-2.11/scalajs-nodejs-examples-fastopt.js");
    const facade = examples.Examples();
    facade.start(bootstrap);
})();


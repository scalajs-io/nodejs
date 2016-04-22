/**
 * Examples bootstrap
 * @author: lawrence.daniels@gmail.com
 */
(function () {
    require("./target/scala-2.11/means-examples-fastopt.js");
    const facade = examples.Examples();
    facade.start(require);
})();


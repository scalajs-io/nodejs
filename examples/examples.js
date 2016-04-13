/**
 * Node.sjs SkillDepth Server
 * @author: lawrence.daniels@gmail.com
 */
(function () {
    console.log("Loading the Scala.js facade...");
    require("./target/scala-2.11/meansjs-examples-fastopt.js");

    console.log("Initializing the facade...");
    var facade = examples.Examples();

    console.log("Starting the application server...");
    facade.timers(require);
})();


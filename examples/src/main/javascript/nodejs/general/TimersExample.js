/**
 * Timers Example
 * @author lawrence.daniels@gmail.com
 */
(function() {

    setImmediate(function () { console.log("Hello") });

    setTimeout(function () { console.log("\tWorld") }, 500);

    setTimeout(function () { console.log("\t\tfrom MEANS.js") }, 1000);
    
})();
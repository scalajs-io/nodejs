(function() {
    const EventEmitter = require("events");
    const ee = new EventEmitter();
    
    console.log(Error);

    setImmediate(function () {
        // This will crash the process because no "error" event
        // handler has been added.
        ee.emit("error", new Error("This will crash"));
    });
    
})();
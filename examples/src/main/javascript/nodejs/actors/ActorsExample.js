/**
 * Actors Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    var drama = require("drama");
    var actorSystem = drama("sys");

    exampleA();
    exampleB();
    
    function exampleA() {
        var actor = actorSystem.actor({
            sayHello: function (message) {
                console.log(message); // "Hello"
            }
        });

        actor.tell("sayHello", "Hello");
    }

    function exampleB() {
        var actor = actorSystem.actor(function (initial) {
            var value = initial;
            var body = {
                set: function (val) {
                    value = val
                }, 
                get: function () {
                    this.reply(value)
                }
            };
            console.log(body);
            return body;
        });

        actor.init("Goodbye");
        actor.ask(actor, "get", function (val) {
            console.log(val); // "Goodbye"
        })
    }

})();
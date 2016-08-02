/**
 * Observable Examples
 * @author lawrence.daniels@gmail.com
 */
(function () {
    const Rx = require("rx");
    const t = require("transducers-js");

    example7();

    function example1() {
        const document = {};

        // Using a value
        const md = Rx.Observable.fromEvent(document, 'mousedown').map(true);
        const mu = Rx.Observable.fromEvent(document, 'mouseup').map(false);

        // Using a function
        log(Rx.Observable.range(1, 3)
            .select(function (x, idx, obs) {
                return x * x;
            }));
    }

    function example2() {
        log(Rx.Observable.range(0, 3)
            .map(function (x) {
                return Rx.Observable.range(x, 3);
            })
            .mergeAll());

        // => Next: 0
        // => Next: 1
        // => Next: 1
        // => Next: 2
        // => Next: 2
        // => Next: 2
        // => Next: 3
        // => Next: 3
        // => Next: 4
        // => Completed
    }

    function example3() {
        log(Rx.Observable.of(2, 3, 5).flatMap(
            function (x) {
                // Return x^2, x^3 and x^4
                return [
                    x * x,
                    x * x * x,
                    x * x * x * x
                ];
            },

            function (outer, inner, outerIndex, innerIndex) {
                return {outer: outer, inner: inner, outerIdx: outerIndex, innerIdx: innerIndex};
            }
        ));

        //=> Outer: 2, Inner: 4, InnerIndex : 0, OuterIndex : 0
        //=> Outer: 2, Inner: 8, InnerIndex : 1, OuterIndex : 0
        //=> Outer: 2, Inner: 16, InnerIndex : 2, OuterIndex : 0
        //=> Outer: 3, Inner: 9, InnerIndex : 0, OuterIndex : 1
        //=> Outer: 3, Inner: 27, InnerIndex : 1, OuterIndex : 1
        //=> Outer: 3, Inner: 81, InnerIndex : 2, OuterIndex : 1
        //...etc
        //=> Completed
    }

    function example4() {
        log(Rx.Observable.range(0, 5).take(3));

        // => Next: 0
        // => Next: 1
        // => Next: 2
        // => Completed
    }

    function example5() {
        log(Rx.Observable.range(0, 5)
            .filter(function (x, idx, obs) {
                return x % 2 === 0;
            }));

        // => Next: 0
        // => Next: 2
        // => Next: 4
        // => Completed
    }

    function example6() {
        log(Rx.Observable.range(0, 1000).take(5).toArray());

        // => Next: [0,1,2,3,4]
        // => Completed
    }

    function example7() {
        function even (x) { return x % 2 === 0; }
        function mul10(x) { return x * 10; }
        log(Rx.Observable.range(1, 5).transduce(t.comp(t.filter(even), t.map(mul10))));

        // => Next: 20
        // => Next: 40
        // => Completed
    }

    function log(source) {
        const subscription = source.subscribe(
            function (value) {
                console.log('Next: %j', value);
            },
            function (err) {
                console.log('Error: ' + err);
            },
            function () {
                console.log('Completed');
            });
        subscription.dispose();
    }

})();
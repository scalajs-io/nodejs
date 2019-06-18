FeedParserPromised API for Scala.js
================================
[feedparser-promised](https://www.npmjs.com/package/feedparser-promised) - Wrapper around [feedparser](https://www.npmjs.com/package/feedparser) with promises.

### Description

Wrapper around [feedparser](https://www.npmjs.com/package/feedparser) with promises.

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

### Examples

```scala
import io.scalajs.npm.feedparser._
import io.scalajs.util.PromiseHelper.Implicits._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

val url = "http://feeds.feedwrench.com/JavaScriptJabber.rss"
for {
  items <- FeedParserPromised.parse(url)
} {
  items.foreach(item => println(s"title: ${item.title}"))
}
```

The resulting output is:
```text
title: MJS #003: Max Lynch
title: JSJ 247 Building a Development Environment with Cory House
title: MJS #002: Mark Nadal
title: JSJ 246 GraphQL and Apollo with Uri Goldshtein
title: MJS #001: Keith Horwood
title: JSJ 245 Styled Components and react-boilerplate with Max Stoiber
title: 244 JSJ Visual Studio with Sam Guckenheimer
title: 243 JSJ Immutable.js with Lee Byron
title: 242 JSJ Visual Studio and .NET with Maria Naggaga
title: 241 JSJ Microsoft Docs with Dan Fernandez
title: 240 JSJ Visual Studio Code with Chris Dias
title: 239 JSJ Vets Who Code with Jerome Hardaway
title: 238 JSJ Intellectual Property and Software Forensics with Bob Zeidman
title: 237 JSJ CLls - Ember Angular and React with Tracy Lee
title: 236 JSJ Interview with Mads Kristensen from Microsoft Ignite
title: 235 JSJ JavaScript Devops and Tools with Donovan Brown and Jordan Matthiesen
title: 234 JSJ JAMStack with Brian Douglas and Matt Christensen
title: 233 JSJ Google Chrome Extensions with John Sonmez
title: 232 JSJ GunDB and Databases with Mark Nadal
title: 231 JSJ Codewars with Nathan Doctor, Jake Hoffner, and Dan Nolan
title: 230 JSJ Node at Capital One with Azat Mardan
title: 229 JSJ Elm with Richard Feldman
title: 228 JSJ React Native with Nader Dabit and Mike Grabowski
title: 227 JSJ Fostering Community Through React with Benjamin Dunphy, Berkeley Martinez, and Ian Sinnott
title: 226 JSJ Test Doubles with Justin Searls
title: 225 JSJ Functional Programming with John A. De Goes
title: 224 JSJ Cypress.js with Brian Mann
title: 223 JSJ WebStorm with Dennis Ushakov
title: 222 JSJ Nodal with Keith Horwood
title: 221 JSJ Visual Studio Code with Wade Anderson Live From Microsoft Build 2016
title: 220 JSJ Teaching JavaScript with Kyle Simpson
title: 219 JSJ Learning JavaScript in 2016
title: 218 JSJ Ember.js with Yehuda Katz
title: 217 JSJ The Now Project with Guillermo Rauch
title: 216 JSJ Angular with Rob Wormald Live from Microsoft Build 2016
title: 215 JSJ ChakraCode with Guarav Seth Live from Microsoft Build 2016
title: 214 JSJ Pebble with Heiko Behrens and François Baldassari
title: 213 JSJ Developer Evangelism with Greg Baugues
title: 212 JSJ Horizon.js with Horizon.js with Michael Glukhovsky: Live from ng-conf!
title: 211 JSJ Ember and EmberConf with Michael North
title: 210 JSJ The 80/20 Guide to ES2015 Generators with Valeri Karpov
title: 209 JSJ TypeScript with Anders Hejlsberg
title: 208 JSJ MS Office with Jeremy Thake
title: 207 JSJ Growing Happy Developers with Marcus Blankenship
title: 206 JSJ PostCSS with Ben Briggs
title: 205 JSJ Shasta with Eric Schoffstall
title: 204 JSJ Free Code Camp with Quincy Larson
title: 203 JSJ Aurelia with Rob Eisenberg
title: 202 JSJ DoneJS + CanJS with Justin Meyer
title: 201 JSJ Security with Troy Hunt
title: 200 JSJ EPISODE 200!!!
title: 199 JSJ Visual Studio Code with Chris Dias and Erich Gamma
title: 198 JSJ 2015 Recap and 2016 Predictions
title: 197 JSJ Auth0 with Kassandra Perch
title: 196 JSJ Tabris.js with Jochen Krause and Ian Bull
title: 195 JSJ Rollup.js with Rich Harris and Oskar Segersvärd
title: 194 JSJ JavaScript Tools Fatigue
title: 193 JSJ Electron with Jessica Lord and Amy Palamountain
title: 192 JSJ IoT with Peter Hoddie
title: 191 JSJ Stripe with Craig McKeachie
title: 190 JSJ Web Performance Part 2 with Nik Molnar
title: 189 JSJ PureScript with John A. De Goes and Phil Freeman
title: 188 JSJ JavaScript Code Smells with Elijah Manor
title: 187 JSJ Vue.js with Evan You
title: 186 JSJ NativeScript with TJ VanToll and Burke Holland
title: 185 JSJ PouchDB with Nolan Lawson
title: 184 JSJ Web Performance with Nik Molnar
title: 183 JSJ Should I go to college?
title: 182 JSJ RxJS with Matthew Podwysocki
title: 181 JSJ The Evolution of Flux Libraries with Andrew Clark and Dan Abramov
title: 180 JSJ Finding a Job
title: 179 JSJ redux and React with Dan Abramov
title: 178 JSJ Tech Education and The Business of Running Front End Masters with Marc Grabanski
title: 177 JSJ UI Validation with Oren Rubin
title: 176 JSJ RethinkDB with Slava Akhmechet
title: 175 JSJ Elm with Evan Czaplicki and Richard Feldman
title: 174 JSJ npm 3 with Rebecca Turner and Forrest Norvell
title: 173 JSJ Online Learning with Gregg Pollack
title: 172 JSJ NodeSchool with Jason Rhodes
title: 171 JSJ Babel with Sebastian McKenzie
title: 170 JSJ RabbitMQ with Derick Bailey
title: 169 JSJ Property-based Testing (QuickCheck) with Zach Kessin
title: 168 JSJ The Future of JavaScript with Jafar Husain
title: 167 JSJ TypeScript and Angular with Jonathan Turner and Alex Eagle
title: 166 JSJ New Relic with Wraithan and Ben Weintraub
title: 165 JSJ ShopTalk with Chris Coyier and Dave Rupert
title: 164 JSJ Rendr with Spike Brehm
title: 163 JSJ Flow with Jeff Morrison and Avik Chaudhuri
title: 162 JSJ ESLint with Jamund Ferguson
title: 161 JSJ Rust with David Herman
title: 160 JSJ Stormpath with Robert Damphousse
title: 159 JSJ Why JavaScript Is Hard
title: 158 JSJ Roots with Jeff Escalante
title: 157 Moving Your Rendering Engine to React with Amit Kaufman and Avi Marcus
title: 156 JSJ Soft Skills and Marketing Yourself as a Software Developer with John Sonmez
title: 155 JSJ Webtorrent with Feross Aboukhadijeh
title: 154 JSJ Raygun.io Error Reporting and Workflow with John-Daniel Trask
title: 153 JSJ Careers for Junior Developers with Aimee Knight
title: 152 JSJ GraphQL and Relay with Nick Schrock and Joe Savona
title: 151 JSJ Getting Started with a Career in Web Development with Tyler McGinnis
title: 150 JSJ OIMs with Richard Kennard, Geraint Luff, and David Luecke
title: 149 JSJ Passenger Enterprise with Node.js with Hongli Lai and Tinco Andringa
title: 148 JSJ i.cx and EveryBit.js with Matt Asher and Dann Toliver
title: 147 JSJ io.js with Isaac Schleuter and Mikeal Rogers
title: 146 JSJ React with Christopher Chedeau and Jordan Walke
title: 145 JSJ Meteor.js with Matt DeBergalis
title: 144 JSJ Marionette.js 2.0 with Sam Saccone
title: 143 JSJ Teaching Programming and Computer Science with Pamela Fox
title: 142 JSJ Share.js with Joseph Gentle
title: 141 JSJ Firefox OS with Jason Weathersby
title: 140 JSJ Using Art to Get and Keep People Interested in Programming with Jenn Schiffer
title: 139 JSJ The Mozilla Developer Network with Les Orchard and David Walsh
title: 138 JSJ {Track:js} with Todd Gardner
title: 137 JSJ &yet with Henrik Joreteg and Phil Roberts
title: 136 JSJ TrackingJS with Eduardo Lundgren
title: 135 JSJ Smallest Federated Wiki with Ward Cunningham
title: 134 JSJ Quilljs with Jason Chen
title: 133 JSJ Remote Work with Mike Hostetler
title: 132 JSJ MV Frameworks with Craig McKeachie
title: 131 JSJ Conferences & Meetups with Dave Nugent
title: 130 JSJ Browser Tools and Extensions
title: 129 JSJ BaaS with Ryan Done
title: 128 JSJ Famo.us with Steve Newcomb
title: 127 JSJ Changes in npm-Land with Forrest Norvell, Rebecca Turner, Ben Coe, and Isaac Z. Schlueter
title: 126 JSJ The Ionic Framework with Max Lynch and Tyler Renelle
title: 125 JSJ WebGL with Sean Griffin
title: 124 JSJ The Origin of Javascript with Brendan Eich
title: 123 JSJ Traceur with Erik Arvidsson
title: 122 JSJ Socket.IO with Guillermo Rauch
title: 121 JSJ Broccoli.js with Jo Liss
title: 120 JSJ Google Polymer with Rob Dodson and Eric Bidelman
title: 119 JSJ Chrome Apps with Joe Marini
title: 118 JSJ Web Developer Skills
title: 117 JSJ The Koa Framework with Gerred Dillon and Will Conant
title: 116 JSJ jQuery UI vs KendoUI with Burke Holland and TJ VanToll
title: 115 JSJ The ES6 Module Loader Polyfill, SystemJS, and jspm with Guy Bedford
title: 114 JSJ Asynchronous UI and Non-Blocking Interactions with Elliott Kember
title: 113 JSJ Community Dynamics with Reginald Braithwaite
title: 112 JSJ Refactoring JavaScript Apps Into a Framework with Brandon Hays
title: 111 JSJ The Ember.js Project with Erik Bryn
title: 110 JSJ Zones with Brian Ford
title: 109 JSJ Dependency Injection in JavaScript with Vojta Jína & Misko Hevery
title: 108 JSJ AngularJS with Igor Minar
title: 107 JSJ ClojureScript & Om with David Nolen
title: 106 JSJ Protractor with Julie Ralph
title: 105 JSJ JSConf and Organizing Conferences with Chris Williams
title: 104 JSJ Hypermedia APIs with Steve Klabnik
title: 103 JSJ Robots with Raquel Vélez
title: 102 JSJ Angular and Open Source Projects with Brad Green
title: 101 JSJ js-git with Tim Caswell
title: 100 JSJ Centennial Episode Celebration
title: 099 JSJ npm, Inc. with Isaac Schlueter, Laurie Voss, and Rod Boothby
title: 098 JSJ Assemble.io with Brian Woodward and Jon Schlinkert
title: 097 JSJ Gulp.js with Eric Schoffstall
title: 096 JSJ The Challenges of Large Single Page JavaScript Applications with Bart Wood
title: 095 JSJ AngularUI with Dean Sofer
title: 094 JSJ BonsaiJS with Tobi Reiss
title: 093 JSJ The New York Times and JavaScript with Eitan Konigsburg, Alastair Coote and Reed Emmons
title: 092 JSJ The MEAN Stack with Ward Bell and Valeri Karpov
title: 091 JSJ JSON APIs
title: 090 JSJ Users Groups
title: 089 JSJ The Node Security Project with Adam Baldwin
title: 088 JSJ Lazy.js with Daniel Tao
title: 087 JSJ TC39 with Alex Russell
title: 086 JSJ Ember.js & Discourse with Robin Ward
title: 085 JSJ Huxley with Pete Hunt
title: 084 JSJ Node with Mikeal Rogers
title: 083 JSJ FRP and RxJS with Matthew Podwysocki
title: 082 JSJ JSHint with Anton Kovalyov
title: 081 JSJ Promises for Testing Async JavaScript with Pete Hodgson
title: 080 JSJ - Impact.js with Dominic Szablewski
title: 079 Lo-Dash with John-David Dalton
title: 078 Working From Home
title: 077 JSJ Monocle with Alex MacCaw
title: 076 JSJ Meteor.js with Marcus Phillips and Fred Zirdung
title: 075 JSJ Maintainable JavaScript with Nicholas Zakas
title: 074 JSJ Grunt with Ben Alman
title: 073 JSJ React with Pete Hunt and Jordan Walke
title: 072 JSJ Screencasts
title: 071 JSJ JavaScript Strategies at Microsoft with Scott Hanselman
title: 070 JSJ Book Club: JavaScript Allongé with Reginald Braithwaite
title: 069 JSJ The Application Cache with Jake Archibald
title: 068 JSJ ES6 with Aaron Frost
title: 067 JSJ Testem with Toby Ho
title: 066 JSJ Transitioning to JavaScript
title: 065 JSJ Build Tools with Adam Hawkins
title: 064 JSJ Ember Tools with Ryan Florence
title: 063 JSJ Burnout
title: 062 JSJ Dojo with Dylan Schiemann
title: 061 JSJ Functional Reactive Programming with Juha Paananen and Joe Fiorini
title: 060 JSJ Development Environments
title: 059 JSJ jQuery Mobile with Todd Parker
title: 058 JSJ Building Accessible Websites with Brian Hogan
title: 057 JSJ Functional Programming with Zach Kessin
title: 056 JSJ Marionette.js with Derick Bailey
title: 055 JSJ Web Developer Skills
title: 054 JSJ JavaScript Parsing, ASTs, and Language Grammar w/ David Herman and Ariya Hidayat
title: 053 JSJ Software Team Dynamics
title: 052 JSJ Node & NPM with Isaac Schlueter
title: 051 JSJ Finding a Job
title: 050 JSJ QUnit with Jörn Zaefferer
title: 049 JSJ MooTools with Valerio Proietti and Arian Stolwijk
title: 048 JSJ Why JavaScript Is Hard
title: 047 JSJ Specialized vs Monolithic with James Halliday and Tom Dale
title: 046 JSJ Staying Current
title: 045 JSJ jQuery
title: 044 JSJ Book Club: Effective JavaScript with David Herman
title: 043 JSJ Sinon.JS
title: 042 JSJ CSS and CSS Superset Languages
title: 041 JSJ Single Page Applications
title: 040 JSJ Conferences
title: 039 JSJ Sweet.js with Tim Disney
title: 038 JSJ Jasmine with Justin Searls
title: 037 JSJ Promises with Domenic Denicola and Kris Kowal
title: 036 JSJ DOM Rendering and Manipulating
title: 035 JSJ node-webkit
title: 034 JSJ Ember.js
title: 033 JSJ enyo.js
title: 032 JSJ Angular.js
title: 031 JSJ history.js
title: 030 JSJ Learning & Teaching JavaScript with Noel Rappin
title: 029 JSJ Bower.js with Alex MacCaw and Jacob Thornton
title: 028 JSJ Greenfield vs Brownfield Projects
title: 027 JSJ The JavaScript Community
title: 026 JSJ Code Organization and Reuse
title: 025 JSJ Require.js with James Burke
title: 024 JSJ Strata.js with Michael Jackson
title: 023 JSJ Phantom.js with Ariya Hidayat
title: 022 JSJ Node.js on Azure with Glenn Block
title: 021 JSJ Weapons of Choice
title: 020 JSJ Cloud9
title: 019 JSJ Browserify with James Halliday
title: 018 JSJ Agile Development
title: 017 JSJ CoffeeScript with Jeremy Ashkenas
title: 016 JSJ SQL and NoSQL
title: 015 JSJ Open Discussion
title: 014 JSJ SVG and Data Visualization with Chris Bannon
title: 013 JSJ Knockout.js with Steven Sanderson
title: 012 JSJ Design Patterns in JavaScript with Addy Osmani
title: 011 JSJ Can HTML5 and JavaScript Really Replace Flash?
title: 010 JSJ Node.js
title: 009 JSJ Testing JavaScript with Joe Eames
title: 008 JSJ V8 and Dart with Lars Bak and Kasper Lund
title: 007 JSJ Online Resources for Javascript Developers
title: 006 JSJ Chrome Dev Tools with Paul Irish
title: 005 JSJ Javascript Objects
title: 004 JSJ Backbone.js with Jeremy Ashkenas
title: 003 JSJ Build Tools
title: 002 JSJ The Right Way to Build Web Applications
title: 001 JSJ Asynchronous Programming
```

### Artifacts and Resolvers

To add the `FeedParserPromised` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "feedparser-promised" % "0.5.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
(ns clj.rules)

(def stop-list (set [
                     "php" "django" "cuda" "ionic2" "ionic-framework" "cordova" "wordpress" "laravel"
                     "winforms" "mysql" "forms" "unity3d" "google-app-engine" "kendo-grid" "angularfire2"
                     "firebase" "facebook" "pascal" "office365" "salesforce" "crm" "knockout.js" "lodash"
                     "extjs" "swing" "javafx" "groovy" "neo4j" "google-cloud-storage" "pygame" "scene2d"
                     "tkinter" "wildfly-9" "twilio" "tfs" "tfs2017" "jquery" "struts2" "kendo-ui"
                     "sharepoint" "vbscript" "dynamics-crm" "sap" "highcharts" "three.js" "ember.js" "vba"
                     "sharepoint-2010" "vb.net" "amazon-web-services" "excel" "devexpress" "datagridview"
                     "crystal-reports" "google-apps-script" "charts.js" "carousel" "firebase-cloud-messaging"
                     "word" "facebook-graph-api" "amazon-web-services" "gruntjs" "regex" "handlebars.js"
                     "google-apps-script" "laravel-5.1" "openwrt" "identityserver3" "wildfly" "nhibernate"
                     "apache-cayenne" "opencv" "alexa" "jq" "playframework" "codenvy" "botframework" "mobx"
                     "eclipse" "transpose" "phantomjs" "ruby-on-rails" "flask" "ibm-mq" "docplexcloud"
                     "underscore.js" "youtube-iframe-api" "actionscript-3" "gis" "openlayers" "devextreme"
                     "google-maps" "js-pdf" "google-maps-api-3" "parse.com" "woocommerce" "amazon-s3"
                     "chart.js" "openerp" "primeng" "nativescript" "ckeditor4.x" "pentaho" "postman"
                     "mondrian" "instagram" "jspdf" "socialshare" "markojs" "jrecorder" "slack"
                     "google-analytics" "automapper-5" "unity2d" "polly" "excel-interop" "unity5"
                     "sharppcap" "tibco-ems" "sonarqube" "protocol-buffers" "heroku" "sails.js" "waterline"
                     "certbot" "snapchat" "feathersjs" "orientdb" "ogg" "ibm-mq" "pdfkit" "ffmpeg"
                     "dreamfactory" "ms-access" "wso2esb" "ms-access-2013" "cakephp" "cygwin" "amazon-redshift"
                     "aurelia" "picturefill" "ruby-on-rails-4" "slider" "plotly" "owl-carousel" "vis.js"
                     "tizen" "geoserver" "mapbox" "froala" "navision" "dropbox-api" "mono" "hangfire" "vsix"
                     "exchange-server" "sharepoint-2013" "webforms" "imagemagick" "google-sheets-api"
                     "flash" "dailymotion-api" "openstreetmap" "rhino" "google-trends" "angular-dart"
                     "angular2-dart" "payara" "polymer" "cloudfoundry" "c3.js" "joomla" "c++" "selenium"
                     "onedrive-api" "visual-foxpro" "outlook" "selenium-webdriver" "mirth" "video.js"
                     "imagemagick-convert" "laravel-5" "aforge" "square-connect" "arduino" "alloy-ui"
                     "mojolicious" "mithril.js" "opentok" "google-spreadsheet" "iframe" "google-maps-markers"
                     "pouchdb" "leaflet" "soundcloud" "jtable" "netbeans" "kotlin" "affdex-sdk" "mono.cecil"
                     "powerpoint" "exchangewebservices" "amcharts" "meteor" "jasper-reports" "solaris"
                     "ghprb" "bitbucket" "google-search-console" "openshift" "activemq" "voicemail" "pug"
                     "grpc" "intel-xdk" "aws-lambda" "okta" "loopbackjs" "flowtype" "visualforce"
                     "jsfeat" "tampermonkey" "symfony" "tweenmax" "backbone.js" "nunjucks" "blueimp"
                     "google-recaptcha" "discord" "google-visualization" "sweetalert" "bacon.js" "thymeleaf"
                     "zebble" "gatt" "docusign" "signalr-hub" "aleagpu" "google-api" "paypal-ipn" "pdfsharp"
                     "yii2" "qweb" "dojo" "ms-word" "tampermonkey" "jira" "sapui5" "jszip" "google-form"
                     "jqgrid" "deployd" "sinatra" "mediaelement.js" "jwplayer" "ckeditor" "accordion"
                     "masonry" "shopify" "google-drive-sdk" "whatsapp" "slick.js" "tinymce" "skulpt"
                     "ormlite-servicestack" "postgis" "eclipselink" "oozie" "ibm-bluemix" "salesforce"]))

;; list of first level classification rules
(def first-list (list { :site "security"   :include "*" :result "information security" }
                      { :site "codereview" :include "*" :result "code review" }
                      { :site "softwareengineering" :include "unit-testing" :result "unit-testing" }
                      { :site "softwareengineering" :include "design" :result "software-desing" }
                      { :site "stackoverflow" :include "unit-testing" :result "unit-testing" }
                      { :site "stackoverflow" :include "machine-learning" :result "machine-learning" }
                      { :site "stackoverflow" :include "go" :result "go" }
                      { :site "stackoverflow" :include "azure" :result "azure" }
                      { :site "stackoverflow" :include "f#" :result "fsharp" }
                      { :site "stackoverflow" :include "postgresql" :result "postgresql" }
                      { :site "stackoverflow" :include "mongodb" :result "mongodb" }
                      { :site "stackoverflow" :include "clojure" :result "clojure" }
                      { :site "stackoverflow" :include "angular2" :result "angular2" }
                      { :site "stackoverflow" :include "angular4" :result "angular2" }
                      { :site "stackoverflow" :include "git" :result "git" }
                      { :site "stackoverflow" :include "docker" :result "docker" }
                      { :site "stackoverflow" :include "rust" :result "rust" }
                      { :site "stackoverflow" :include "scala" :result "scala" }
                      { :site "stackoverflow" :include "sql-server" :result "ms sql server" }
                      { :site "stackoverflow" :include "oracle" :result "oracle" }
                      { :site "stackoverflow" :include "powershell" :result "powershell" }
                      { :site "stackoverflow" :include "xamarin" :result "xamarin" }
                      { :site "stackoverflow" :include "xamarin.forms" :result "xamarin" }
                      { :site "stackoverflow" :include "xamarin.ios" :result "xamarin" }
                      { :site "stackoverflow" :include "c#" :result ".net" }
                      { :site "stackoverflow" :include ".net" :result ".net" }
                      { :site "stackoverflow" :include "svg" :result "web" }
                      { :site "stackoverflow" :include "twitter-bootstrap" :result "web" }
                      { :site "stackoverflow" :include "android" :result "android" }
                      { :site "stackoverflow" :include "gulp" :result "js" }
                      { :site "stackoverflow" :include "mocha" :result "js" }
                      { :site "stackoverflow" :include "chai" :result "js" }
                      { :site "stackoverflow" :include "webpack" :result "js" }
                      { :site "stackoverflow" :include "eslint" :result "js" }
                      { :site "stackoverflow" :include "google-chrome-extension" :result "js" }
                      { :site "stackoverflow" :include "typescript" :result "typescript" }
                      { :site "stackoverflow" :include "node.js" :result "node.js" }
                      { :site "stackoverflow" :include "javascript" :result "js" }
                      { :site "stackoverflow" :include "bash" :result "bash" }
                      { :site "stackoverflow" :include "r" :result "r lang" }
                      { :site "stackoverflow" :include "java" :result "java" }
                      { :site "stackoverflow" :include "python" :result "python" }
                      { :site "stackoverflow" :include "haskell" :result "haskell" }
                      { :site "stackoverflow" :include "ios" :result "ios" }
                      { :site "stackoverflow" :include "swift" :result "ios" }
                      ))

;; list of first level classification rules
(def second-list (list { :site "stackoverflow" :first "azure" :include "azure-functions" :result "azure-functions" }
                       { :site "stackoverflow" :first "azure" :include "machine-learning" :result "machine-learning" }
                       { :site "stackoverflow" :first "azure" :include "azure-web-sites" :result "web-sites" }
                       { :site "stackoverflow" :first "azure" :include "azure-logic-apps" :result "logic-apps" }
                       { :site "stackoverflow" :first "azure" :include "sql-server" :result "sql-server" }
                       { :site "stackoverflow" :first "azure" :include "azure-active-directory" :result "active directory" }
                       { :site "stackoverflow" :first "azure" :include "active-directory" :result "active directory" }
                       { :site "stackoverflow" :first "azure" :include "azure-documentdb" :result "azure-documentdb" }
                       { :site "stackoverflow" :first "azure" :include "windows-azure-storage" :result "storage" }
                       { :site "stackoverflow" :first "azure" :include "azure-media-services" :result "media-services" }
                       { :site "stackoverflow" :first "azure" :include "azure-service-fabric" :result "fabric" }
                       { :site "stackoverflow" :first "azure" :include "iot" :result "iot" }
                       { :site "stackoverflow" :first "azure" :include "hdinsight" :result "hdinsight" }
                       { :site "stackoverflow" :first "azure" :include "azure-cdn" :result "cdn" }
                       { :site "stackoverflow" :first "azure" :include "asp.net-mvc" :result "asp.net" }
                       { :site "stackoverflow" :first "azure" :include "servicebus" :result "servicebus" }
                       { :site "stackoverflow" :first "azure" :include "azure-servicebus-queues" :result "servicebus" }
                       { :site "stackoverflow" :first "azure" :include "azure-security" :result "security" }
                       { :site "stackoverflow" :first "azure" :include "azure-virtual-machine" :result "vms" }
                       { :site "stackoverflow" :first "ms sql server" :include "reporting-services" :result "ssrs" }
                       { :site "stackoverflow" :first "ms sql server" :include "ssis" :result "ssis" }
                       { :site "stackoverflow" :first "ms sql server" :include "database-design" :result "database-design" }
                       { :site "stackoverflow" :first "ms sql server" :include "merge-replication" :result "replication" }
                       { :site "stackoverflow" :first "ms sql server" :include "transactional-replication" :result "replication" }
                       { :site "stackoverflow" :first "ms sql server" :include "maintenance" :result "maintenance" }
                       { :site "stackoverflow" :first "ms sql server" :include "tsql" :result "tsql" }
                       { :site "stackoverflow" :first "ms sql server" :include "xml" :result "xml" }
                       { :site "stackoverflow" :first "ms sql server" :include "pivot" :result "powerbi" }
                       { :site "stackoverflow" :first "ms sql server" :include "powerbi" :result "powerbi" }
                       { :site "stackoverflow" :first "ms sql server" :include "stored-procedures" :result "stored-procedures" }
                       { :site "stackoverflow" :first "postgresql" :include "performance" :result "optimization" }
                       { :site "stackoverflow" :first "postgresql" :include "optimization" :result "optimization" }
                       { :site "stackoverflow" :first "postgresql" :include "backup" :result "backup" }
                       { :site "stackoverflow" :first "postgresql" :include "restore" :result "backup" }
                       { :site "stackoverflow" :first "postgresql" :include "psql" :result "psql" }
                       { :site "stackoverflow" :first "angular2" :include "angular-cli" :result "angular-cli" }
                       { :site "stackoverflow" :first "angular2" :include "angular2-cli" :result "angular-cli" }
                       { :site "stackoverflow" :first "angular2" :include "rxjs" :result "rxjs" }
                       { :site "stackoverflow" :first "angular2" :include "rxjs5" :result "rxjs" }
                       { :site "stackoverflow" :first "angular2" :include "ngrx" :result "ngrx" }
                       { :site "stackoverflow" :first "angular2" :include "ngrx-effects" :result "ngrx" }
                       { :site "stackoverflow" :first "angular2" :include "bootstrap-4" :result "bootstrap" }
                       { :site "stackoverflow" :first "angular2" :include "material" :result "material" }
                       { :site "stackoverflow" :first "angular2" :include "webpack" :result "webpack" }
                       { :site "stackoverflow" :first "angular2" :include "webpack-2" :result "webpack" }
                       { :site "stackoverflow" :first "angular2" :include "karma-jasmine" :result "testing" }
                       { :site "stackoverflow" :first "angular2" :include "angular-material2" :result "material" }
                       { :site "stackoverflow" :first "angular2" :include "angular-material" :result "material" }
                       { :site "stackoverflow" :first "angular2" :include "angular2-routing" :result "routing" }
                       { :site "stackoverflow" :first "angular2" :include "angular2-router" :result "routing" }
                       { :site "stackoverflow" :first "angular2" :include "angular-ui-router" :result "routing" }
                       { :site "stackoverflow" :first "angular2" :include "routing" :result "routing" }
                       { :site "stackoverflow" :first "angular2" :include "promise" :result "promise" }
                       { :site "stackoverflow" :first "angular2" :include "angular2-forms" :result "forms" }
                       { :site "stackoverflow" :first "angular2" :include "angular2-template" :result "templates" }
                       { :site "stackoverflow" :first "angular2" :include "animation" :result "animation" }
                       { :site "stackoverflow" :first "angular2" :include "zone.js" :result "zone.js" }
                       { :site "stackoverflow" :first "angular2" :include "zonejs" :result "zone.js" }
                       { :site "stackoverflow" :first "angular2" :include "cors" :result "cors" }
                       { :site "stackoverflow" :first "angular2" :include "angular4" :result "angular4" }
                       { :site "stackoverflow" :first "go" :include "goroutine" :result "concurrency" }
                       { :site "stackoverflow" :first "js" :include "ecmascript-6" :result "es6" }
                       { :site "stackoverflow" :first "js" :include "google-chrome-extension" :result "google-chrome-extension" }
                       { :site "stackoverflow" :first "js" :include "gulp" :result "gulp" }
                       { :site "stackoverflow" :first "js" :include "eslint" :result "eslint" }
                       { :site "stackoverflow" :first "js" :include "webpack" :result "webpack" }
                       { :site "stackoverflow" :first "js" :include "meteor" :result "meteor" }
                       { :site "stackoverflow" :first "js" :include "mocha" :result "mocha" }
                       { :site "stackoverflow" :first "js" :include "chai" :result "chai" }
                       { :site "stackoverflow" :first "js" :include "reactjs" :result "reactjs" }
                       { :site "stackoverflow" :first "js" :include "redux" :result "reactjs" }
                       { :site "stackoverflow" :first "js" :include "d3.js" :result "d3.js" }
                       { :site "stackoverflow" :first "js" :include "momentjs" :result "momentjs" }
                       { :site "stackoverflow" :first "js" :include "underscore.js" :result "underscore.js" }
                       { :site "stackoverflow" :first "js" :include "webpack" :result "webpack" }
                       { :site "stackoverflow" :first "js" :include "jquery" :result "jquery" }
                       { :site "stackoverflow" :first "js" :include "json" :result "json" }
                       { :site "stackoverflow" :first "web" :include "svg" :result "svg" }
                       { :site "stackoverflow" :first "web" :include "twitter-bootstrap" :result "bootstrap" }
                       { :site "stackoverflow" :first "node.js" :include "express" :result "express" }
                       { :site "stackoverflow" :first "node.js" :include "socket.io" :result "socket.io" }
                       { :site "stackoverflow" :first "node.js" :include "npm" :result "npm" }
                       { :site "stackoverflow" :first "node.js" :include "callback" :result "callback" }
                       { :site "stackoverflow" :first "node.js" :include "promise" :result "promise" }
                       { :site "stackoverflow" :first "node.js" :include "stream" :result "stream" }
                       { :site "stackoverflow" :first "node.js" :include "mongoose" :result "mongoose" }
                       { :site "stackoverflow" :first ".net" :include ".net-core" :result "net.core" }
                       { :site "stackoverflow" :first ".net" :include "asp.net-core" :result "net.core" }
                       { :site "stackoverflow" :first ".net" :include "entity-framework-core" :result "net.core" }
                       { :site "stackoverflow" :first ".net" :include "asp.net-web-api" :result "web.api" }
                       { :site "stackoverflow" :first ".net" :include "asp.net-web-api2" :result "web.api" }
                       { :site "stackoverflow" :first ".net" :include "wpf" :result "wpf" }
                       { :site "stackoverflow" :first ".net" :include "wcf" :result "wcf" }
                       { :site "stackoverflow" :first ".net" :include "linq" :result "linq" }
                       { :site "stackoverflow" :first ".net" :include "entity-framework" :result "entity-framework" }
                       { :site "stackoverflow" :first ".net" :include "entity-framework-6" :result "entity-framework" }
                       { :site "stackoverflow" :first ".net" :include "ado.net" :result "ado.net" }
                       { :site "stackoverflow" :first ".net" :include "uwp" :result "uwp" }
                       { :site "stackoverflow" :first ".net" :include "asp.net" :result "asp.net" }
                       { :site "stackoverflow" :first ".net" :include "asp.net-mvc" :result "asp.net" }
                       { :site "stackoverflow" :first ".net" :include "asp.net-mvc-4" :result "asp.net" }
                       { :site "stackoverflow" :first ".net" :include "signalr" :result "signalr" }
                       { :site "stackoverflow" :first ".net" :include "odata" :result "odata" }
                       { :site "stackoverflow" :first ".net" :include "async-await" :result "async" }
                       { :site "stackoverflow" :first ".net" :include "asynchronous" :result "async" }
                       { :site "stackoverflow" :first ".net" :include "multithreading" :result "async" }
                       { :site "stackoverflow" :first ".net" :include "generics" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "extension-methods" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "reflection" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "idisposable" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "dictionary" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "enums" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "garbage-collection" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "collections" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "lambda" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "serialization" :result "csharp-core" }
                       { :site "stackoverflow" :first ".net" :include "json" :result "json" }
                       { :site "stackoverflow" :first ".net" :include "xml" :result "xml" }
                       { :site "stackoverflow" :first ".net" :include "roslyn" :result "roslyn" }
                       { :site "stackoverflow" :first ".net" :include "dependency-injection" :result "design" }
                       { :site "stackoverflow" :first ".net" :include "design-patterns" :result "design" }
                       { :site "stackoverflow" :first ".net" :include "oop" :result "design" }
                       { :site "stackoverflow" :first ".net" :include "visual-studio" :result "vs" }
                       { :site "stackoverflow" :first ".net" :include "visual-studio-2015" :result "vs" }
                       { :site "stackoverflow" :first ".net" :include "visual-studio-2017" :result "vs" }
                       { :site "stackoverflow" :first "java" :include "maven" :result "maven" }
                       { :site "stackoverflow" :first "java" :include "gradle" :result "gradle" }
                       { :site "stackoverflow" :first "java" :include "tomcat" :result "tomcat" }
                       { :site "stackoverflow" :first "java" :include "spring" :result "spring" }
                       { :site "stackoverflow" :first "java" :include "hibernate" :result "spring" }
                       { :site "stackoverflow" :first "java" :include "reflection" :result "java-core" }
                       { :site "stackoverflow" :first "java" :include "try-catch" :result "java-core" }
                       { :site "stackoverflow" :first "java" :include "jsp" :result "jsp" }
                       { :site "stackoverflow" :first "ios" :include "uitableview" :result "uitableview" }
                       { :site "stackoverflow" :first "ios" :include "uicollectionview" :result "uicollectionview" }
                       { :site "stackoverflow" :first "ios" :include "swift" :result "swift" }
                       { :site "stackoverflow" :first "ios" :include "xcode" :result "xcode" }
                       { :site "stackoverflow" :first "python" :include "pandas" :result "sci-fi" }
                       { :site "stackoverflow" :first "python" :include "numpy" :result "sci-fi" }
                       { :site "stackoverflow" :first "python" :include "matplotlib" :result "sci-fi" }
                       { :site "stackoverflow" :first "bash" :include "awk" :result "awk" }
                       { :site "stackoverflow" :first "bash" :include "sed" :result "sed" }
                       { :site "stackoverflow" :first "bash" :include "cron" :result "cron" }
                       { :site "stackoverflow" :first "bash" :include "curl" :result "curl" }
                       { :site "stackoverflow" :first "bash" :include "scripting" :result "scripting" }
                       { :site "stackoverflow" :first "git" :include "merge" :result "merge" }
                       { :site "stackoverflow" :first "git" :include "git-merge" :result "merge" }
                       { :site "stackoverflow" :first "git" :include "gitignore" :result "gitignore" }
                       { :site "stackoverflow" :first "git" :include "ssh" :result "ssh" }
                       { :site "stackoverflow" :first "git" :include "git-submodules" :result "submodules" }
                       { :site "stackoverflow" :first "git" :include "rebase" :result "rebase" }
                       { :site "stackoverflow" :first "git" :include "gitlab" :result "gitlab" }
                       { :site "stackoverflow" :first "git" :include "github" :result "github" }
                       { :site "stackoverflow" :first "docker" :include "docker-swarm" :result "swarm" }
                       { :site "stackoverflow" :first "docker" :include "swarm" :result "swarm" }
                       { :site "stackoverflow" :first "typescript" :include "types" :result "types" }
                       { :site "security" :first "information security" :include "certificates" :result "certificates" }
                       { :site "security" :first "information security" :include "tls" :result "certificates" }
                       { :site "security" :first "information security" :include "openssl" :result "certificates" }
                       { :site "security" :first "information security" :include "public-key-infrastructure" :result "certificates" }
                       { :site "security" :first "information security" :include "privacy" :result "privacy" }
                       { :site "security" :first "information security" :include "torjj" :result "privacy" }
                       { :site "security" :first "information security" :include "passwords" :result "passwords" }
                       { :site "security" :first "information security" :include "android" :result "android" }
                       { :site "security" :first "information security" :include "firewalls" :result "networking" }
                       { :site "security" :first "information security" :include "network" :result "networking" }
                       { :site "security" :first "information security" :include "openvpn" :result "networking" }
                       { :site "security" :first "information security" :include "wireless" :result "networking" }
                       { :site "security" :first "information security" :include "dmz" :result "networking" }
                       { :site "security" :first "information security" :include "wpa2" :result "networking" }
                       { :site "security" :first "information security" :include "dns" :result "networking" }
                       { :site "security" :first "information security" :include "network-scanners" :result "networking" }
                       { :site "security" :first "information security" :include "linux" :result "linux" }
                       { :site "security" :first "information security" :include "windows" :result "windows" }
                       { :site "codereview" :first "code review" :include "java" :result "java" }
                       { :site "codereview" :first "code review" :include "python" :result "python" }
                       { :site "codereview" :first "code review" :include "ruby" :result "ruby" }
                       { :site "codereview" :first "code review" :include "go" :result "go" }
                       { :site "codereview" :first "code review" :include "clojure" :result "clojure" }
                       { :site "codereview" :first "code review" :include "c" :result "c" }
                       { :site "codereview" :first "code review" :include "c#" :result "csharp" }
                       { :site "codereview" :first "code review" :include "javascript" :result "js" }
                       ))

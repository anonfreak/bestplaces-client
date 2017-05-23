[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a740460201604a9d81d1db68daed21a9)](https://www.codacy.com/app/kolb.marco/bestplaces-client?utm_source=github.com&utm_medium=referral&utm_content=anonfreak/bestplaces-client&utm_campaign=badger)
[![Build Status](https://travis-ci.org/anonfreak/bestplaces-client.svg?branch=master)](https://travis-ci.org/anonfreak/bestplaces-client)
[![Coverage Status](https://coveralls.io/repos/github/anonfreak/bestplaces-client/badge.svg?branch=master)](https://coveralls.io/github/anonfreak/bestplaces-client?branch=master)

client
==============

Template for a simple Vaadin application that only requires a Servlet 3.0 container to run.


Workflow
========

To compile the entire project, run "mvn install".

To run the application, run "mvn jetty:run" and open http://localhost:8080/ .

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run "mvn clean package"
- test the war file with "mvn jetty:run-war"

Client-Side compilation
-------------------------

The generated maven project is using an automatically generated widgetset by default. 
When you add a dependency that needs client-side compilation, the maven plugin will 
automatically generate it for you. Your own client-side customisations can be added into
package "client".

Debugging client side code
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application

Developing a theme using the runtime compiler
-------------------------

When developing the theme, Vaadin can be configured to compile the SASS based
theme at runtime in the server. This way you can just modify the scss files in
your IDE and reload the browser to see changes.

To use the runtime compilation, open pom.xml and comment out the compile-theme 
goal from vaadin-maven-plugin configuration. To remove a possibly existing 
pre-compiled theme, run "mvn clean package" once.

When using the runtime compiler, running the application in the "run" mode 
(rather than in "debug" mode) can speed up consecutive theme compilations
significantly.

It is highly recommended to disable runtime compilation for production WAR files.

Using Vaadin pre-releases
-------------------------

If Vaadin pre-releases are not enabled by default, use the Maven parameter
"-P vaadin-prerelease" or change the activation default value of the profile in pom.xml .

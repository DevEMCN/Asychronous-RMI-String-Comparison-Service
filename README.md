# Asynchronous-RMI-String-Comparison-Service

# Table of Contents
* [Introduction](#introduction)
* [Installation](#installation)
* [Project Details](#details)

#<a name="introduction"></a>Introduction
Using the Java RMI framework to develop a remote, asynchronous string comparison service. A client should be able to remotely connect and pass two strings to the service for comparison. The service should use one of a number of optional string comparison algorithms to compute the edit distance or optimal alignment between the two strings. <br/>


#<a name="installation"></a>Installation
First you will require Apache tomcat to run the client web application part of the project. You can then place the comparator.war file into the webapps folder in the apache tomcat folder.<br/>
Next you should run the command: <br/>
    `java –cp ./string-service.jar ie.gmit.sw.Servant` <br/>
Then you can go to <br/>`localhost:8080/comparator`<br/> to run and use the application.

#<a name="details"></a>Project Details

The project is split into two parts.
1. The RMI server side and 
2. The Tomcat web application

<h3> 1. RMI ServerSide </h3>
This package contains 6 classes:
 * Resultator (interface) 
   - The remote method setResult() should be used by the service provider to update the state of the returned “pass-by-              reference” object with a relevant string response (edit distance or optimal alignment).
   - The method getResult() should return this text to a caller.
   - The service provider should flag the Resultator object as processed by calling the method setProcessed().
   - Finally, calling isProcessed() should return whether or not the process is complete.
 * ResulatatorImpl
 * StringService(interface)
  -  exposes a remote method called compare which takes in 2 strings and an algorithm and returns a resultator object
 * StringServiceImpl
 * Algorithms
 * Servant 
  - Runs the rmi server

<h3> 2. Tomcat Web Application </h3>
 This package has 3 classes
 * ServiceHandler 
    - Stanard JSP that contains the code for displaying the form for the client and the results page that updates every 10 seconds to see if your request has been processed. 
    - It get the result by checking the isComplete method of the Service Manager class.
 * ServiceManager 
   - This class controls the majority of the web application functionality. It contains a BlockingQueue that takes in job requests from the client.
   - The run method polls the BlockingQueue for tasks and if there is one, calls the method getResult() which makes makes a lookup call on the rmi service and then calls the compare method of StringService to return a Resultator object that contains the result of the comparison.
 * Task - This class is used for storing the object variable (the 2 strings, the algorithm and the job number)

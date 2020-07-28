
# Exchange Rates Comparison Application

#### Primary Goal and Agenda

The primary goal is:

* Design and develop a web application to provide comparative available exchange rates converting to a given currency. 

#### Installation and Getting Started

This application has been implemented in Java while based on Spring framework particularly leveraging on Spring-Boot to provide as a standalone application. 

* To Run

----
    $ mvn clean package spring-boot:run
----

* To Access the Application UI

----
    http://localhost:8080
----

* To Stop

----
    CTRL-C on command window/console
----

* To View Database content

    - enable H2-Database console setting \*h2.console.enabled\*
    - restart application, data is accessible via browser on http://localhost:8080/h2-console
    (user/password can be found in application.yml)  
    


#### Assumptions

The following assumptions have been made while providing the completed solution:

* it is assumed for this application that a seperate background process has retrieved and pushed the daily updated rates into the \*RATES\* table
    

#### Further and Future Enhancements

The following items are possible items for enhancements:

* provide execution from UI to retrieve the latest exchange rates
* include fee as part of the exchange rate calculation



#### Known Issues

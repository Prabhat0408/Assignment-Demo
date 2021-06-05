# Assignment-Demo
This is a BDD-Cucmber-TESTNG-MAVEN-POM design pattern based framework which provide the coplete solution to Automate UI application & Rest API services.
Prerequisites
What you need to install before importing the project.

1. Java (1.8)
2. Maven

Starting your automation project
-Maven
 1- mvn clean install
 2- mvn verify
 
 
Report
Please Navigate to test-output>SparkReport>index.html




Note :
This Framework contains 2 Feature file and 1 Test runner.
**While running this feature files, you will observe Browser getting opened in Rest Api automation also. This is happeneing due to Hooks file present this file.
This will be resolve by either of below 2 approaches
1- Have a flag in config file for API and UI application, based on that flag Webdriver wil be intialize
2- Move webdriver intiliziation code into step defintion file

** This framework developed just for a quick demo, but many libs added just to depicts the whole architecture of framwork.


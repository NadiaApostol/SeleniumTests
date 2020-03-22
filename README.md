# SeleniumTests

Basic project with Java + Maven + TestNG + Selenium stack for UI testing of the flight booking aplication http://newtours.demoaut.com/
Test suite covers main paths:
* login functionality (negative and positive paths)
* navigation through side menu
* filling flight booking forms and checking its concistency through all the booking pages
* payments verification(amounts and payment details)

To follow the best practices and separate pages representation from the test logic, the Page Object Model using Page Factory is implemented.
To implement the data driven testing approach, TestNG DataProvides are used. This allows to re-use the test logic for different data sets.
Tests can be run manually directly in Intellij as well as using testng.xml and Maven which can facilitate the project integration 
with different build systmes like Jenkins.
As a result of test run, the HTML report is generated. For this reason Allure library and surefire plugin is used.

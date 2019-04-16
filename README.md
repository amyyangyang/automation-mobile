# JavaMobileTest

### Introduction
Currant project includes smoking autotests for NEXT Mobile APP. JavaMobileTest project was written by Java + Selenium      Webdriver + Appium. Project can be used for APPs for different environment, such as Dev, Test, Demo and Prod. 
 
### Project structure
Project was build according PageObject pattern. pom.xml is the main execution file. It describes all project dependencies. Project includes three parts: 
   1. Page Classes (\src\main\java\...). Each Page Class describes one web page and includes methods to work with this page.
   2. Test Classes (\src\test\java\...). Test Classes include Test methods.
   3. Test Data (\src\test\java\resources\json\...). Folder includes three .json files with Test data for three environments.
    
### Installation
In the bottom you can see software list which should be install to run JavaAutoTest project:
- Java
- Maven
- Nodejs
- Google Chrome
- Appium
- UiAutomator2

Note: Do not forget set up environment variables if required.

### Run project
To run JavaAutoTest project we should execute "mvn" maven command from project folder, for example:

    mvn -DENV_VAR=Dev -DENV_VAR_L=Server clean verify

Depend on value of ENV_VAR variable we can choose Dev, Test or Demo environment where is we want to run our Java project (default: -DENV_VAR=Dev). 
Depend on value of ENV_VAR_L variable we can choose Server or Local machine to run our Java project (default: -DENV_VAR_L=Local).





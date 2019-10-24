# JavaMobileAutoTest

### Introduction
Currant project includes smoking autotests for NEXT Mobile APP. JavaMobileAutoTest project was written by Java + Selenium Webdriver + Appium. Project can be used for APPs for different environment, such as Dev, Test, Demo and Prod.
 
### Project structure
Project was build according PageObject pattern. pom.xml is the main execution file. It describes all project dependencies. Project includes three parts: 
   1. Page Classes (\src\main\java\...). Each Page Class describes one app page and includes methods to work with this page.
   2. Test Classes (\src\test\java\...). Test Classes include Test methods.
   3. Test Data (\src\main\resources\json\...). Folder includes three .json files with Test data for three environments.
    
### Installation
   1. In the bottom you can see software list which should be install to run JavaAutoTest project:
    - Java
    - android-sdk
    - android-sdk tools
    - Maven
    - Nodejs
    - IntelliJ IDEA
    - Appium
    - UiAutomator2

Note: Do not forget set up environment variables if required.

   2. Download apps and put .apk files to "D:\\app" folder.

### Run project
   1. Create package. To create package we can use:

    for iOS
      mvn clean -DPLATFORM_NAME=ios -DENV_NAME=dev -DskipTests -P prepare-for-upload package

    for Android
      mvn clean -DPLATFORM_NAME=android -DENV_NAME=dev -DskipTests -P prepare-for-upload package


   2. Run project on your local. To run JavaMobileAutoTest project we should execute "mvn" maven command from project folder, for example:

    for iOS
      mvn -DPLATFORM_NAME=ios -DENV_NAME=dev -DLOCATION_NAME=local clean verify

    for Android
      mvn -DPLATFORM_NAME=android -DENV_NAME=dev -DLOCATION_NAME=local clean verify


   3. Run project on MS AppCenter (you should change path to your APP file). To run project on MS AppCenter we should create package first (paragraph 1):

    for iOS run from Wimdows
      appcenter test run appium --app "NextTrucking-Dev/NEXTTrucking-iOS" --devices 827284fc --app-path "D:\app\NEXT DEV.ipa_2.0.10.ipa"  --test-series "master" --locale "en_US" --build-dir target/upload
    for iOS run from Mac
      appcenter test run appium --app "NextTrucking-Dev/NEXTTrucking-iOS" --devices 827284fc --app-path "/Users/nexttrucking/NEXT DEV.ipa_2.0.10.ipa"  --test-series "master" --locale "en_US" --build-dir target/upload

    for Android run from Wimdows
      appcenter test run appium --app "NextTrucking-Dev/NEXTTrucking-Android" --devices 7807b566 --app-path "D:\app\NEXT DEV.apk_2.0.10.apk"  --test-series "master" --locale "en_US" --build-dir target/upload
    for Android run from Mac
      appcenter test run appium --app "NextTrucking-Dev/NEXTTrucking-Android" --devices 7807b566 --app-path "/Users/nexttrucking/NEXT DEV.apk_2.0.10.apk"  --test-series "master" --locale "en_US" --build-dir target/upload


Depend on value of PLATFORM_NAME variable we can choose platform (android or ios) where is we want to run our Java project (default: -DPLATFORM_NAME=android).
Depend on value of ENV_NAME variable we can choose environment (dev, test, demo or prod) where is we want to run our Java project (default: -DENV_NAME=dev).
Depend on value of LOCATION_NAME variable we can choose environment (local or server) where is we want to run our Java project (default: -DLOCATION_NAME=server).

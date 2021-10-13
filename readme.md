## Usage
To run tests on EPAM Mobile Cloud you should:

1. Write down your token in the pom.xml file in the properties section
2. Run tests with Maven:
   
for iOS Native Cloud test 

      mvn clean test -P iosNative

for Android Native Cloud test 

      mvn clean test -P androidNative

for iOS Web Cloud test 

      mvn clean test -P iosWeb

for Android Cloud test 
   
      mvn clean test -P androidWeb

***Don't forget:***

To run iOS Native Cloud and Android Native Cloud tests install app on the device before running test
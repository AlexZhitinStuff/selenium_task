# selenium_task

selenium_task is a project which contains tests to check user log out operation.
The testbase is set up to run ui tests on Chrome and Firefox either on Windows or MacOS.

## Installation

Before running tests make sure JVM and Maven are installed and set up.

## Usage

The testng.xml file is configured the way to run all tests on both Firefox and Chrome in parallel (1 thread per browser).
To run tests navigate to the project directory and execute the following command:

- for Windows(Powershell)
```bash
mvn clean test -DsuiteXmlFile="./src/test/java/XMLs/testng.xml"
```
- for MacOS(terminal)
```bash
mvn clean test -DsuiteXmlFile=./src/test/java/XMLs/testng.xml
```
To see Allure reports run the following command in the same project directory:

```bash
allure serve allure-results
```

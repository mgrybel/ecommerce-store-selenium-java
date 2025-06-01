# E2E Testing using Selenium WebDriver with Java

Automated end-to-end tests of an e-commerce store built using **Selenium WebDriver** with **Java**.

## Table of Contents

- [Prerequisites](#prerequisites)
- [System Under Test (SUT)](#system-under-test-sut)
- [Downloading the project](#downloading-the-project)
- [Setting the Java version](#setting-the-java-version)
- [Installation](#installation)
- [Running tests](#running-tests)
- [Generating the Allure report](#generating-the-allure-report)

## Prerequisites

Install the following prerequisites:

1. [OpenJDK](https://openjdk.org/) or [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
2. [Apache Maven](https://maven.apache.org/install.html)
3. [Allure Command Line Tool (allurectl)](https://docs.qameta.io/allure-testops/ecosystem/allurectl/)
4. [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## System Under Test (SUT)

The system under test (SUT) is this [e-commerce store](https://github.com/mgrybel/ecommerce-store) built using the **.NET Framework**, **React**, **Redux**, and **Material UI**, which uses an **SQLite** database to store data.

To run tests in this project, you must first install and run the SUT. To do that, follow [these steps](https://github.com/mgrybel/ecommerce-store/blob/master/README.md).

## Downloading the project

1. Clone this repository or download the ZIP file and unzip the project.
2. Open the project in IntelliJ IDEA.

## Setting the Java version

In the [pom.xml](https://github.com/mgrybel/ecommerce-store-selenium-java/blob/master/pom.xml) file, you have to set up the correct version of Java installed on your computer.

To check your Java version, run the command:

```
java -version
```

To check the default JDK version of Maven, run the command:

```
mvn -v
```

The `mvn -v` command will show the Java version in which Maven runs.<br /><br />

Once you get the Java version, you have to modify the **maven.compiler.source** and **maven.compiler.target** properties in the [pom.xml](https://github.com/mgrybel/ecommerce-store-selenium-java/blob/master/pom.xml) file. The example below shows a setup for Java 17:

```
<properties>
  <maven.compiler.source>17</maven.compiler.source>
  <maven.compiler.target>17</maven.compiler.target>
</properties>
```

## Installation

From the **root** directory, run:

```
mvn compile
```

## Running tests

From the **root** directory, run:

```
mvn clean test
```

## Generating the Allure report

From the **root** directory, run:

```
allure serve target/allure-results
```

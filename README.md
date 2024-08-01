# Web Application Task Automation

This repository contains a Selenium-based automation framework for testing a web application. The project is built using Java, TestNG, and Maven, and it integrates with GitHub Actions for continuous integration and testing.

## Project Structure

```plaintext
src
└── test
    └── java
        ├── pages
        │   ├── InputsPage.java
        │   ├── LogInPage.java
        │   └── TablesPage.java
        ├── stepdefinitions
        │   └── StepDefinitions.java
    └── resources
        └── testng.xml
pom.xml

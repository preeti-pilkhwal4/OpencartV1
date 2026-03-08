# Hybrid Test Automation Framework – OpenCart

## Project Overview
This project demonstrates a **Hybrid Test Automation Framework** developed for the OpenCart e-commerce application.  
The framework is built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern.  

It supports **data-driven testing, reusable utilities, reporting, and logging**, making the framework scalable and maintainable for automation testing.

---

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI (Excel data handling)
- ExtentReports (HTML reporting)
- Log4j (logging)
- Git & GitHub (version control)

---

## Framework Design
The framework follows a **Hybrid Framework approach**, combining:

- **Page Object Model (POM)** for better maintainability
- **Data Driven Testing** using Excel
- **Reusable utility methods** for common operations

### Key Components

**1. Base Class**
- Browser initialization
- WebDriver setup
- Test teardown
- Logging and reporting configuration

**2. Page Classes**
- Contains web element locators
- Page-specific methods and actions

**3. Test Classes**
- Contains test scenarios
- Uses methods from page classes to perform actions

**4. Utilities**
- **ExcelUtility** – for reading test data from Excel  
- **ConfigReader** – for reading property/configuration files  
- **ExtentReportManager** – initializes and manages **ExtentReports** for HTML reporting  
- **ScreenshotUtility** – captures screenshots on test failure

---

## Features
- Hybrid automation framework
- Page Object Model implementation
- Data-driven testing using Excel
- Reusable methods through base class
- **HTML test execution reports via ExtentReportManager**
- Runtime logging for debugging
- Easy scalability for adding new test cases

---

## Reporting
Test execution reports are generated using **ExtentReports** managed through **ExtentReportManager**.  
The report provides:
- Test case status (Pass / Fail / Skip)
- Execution time
- Error details
- Screenshots for failed tests

---

## Logging
The framework uses **Log4j** for logging test execution steps and debugging information during runtime.

---

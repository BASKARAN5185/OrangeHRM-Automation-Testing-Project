# OrangeHRM Testing Project

This repository contains automated tests for the **OrangeHRM** application. The goal of this project is to validate the functionality, performance, and reliability of the **OrangeHRM** HR management system by running various test cases and generating test reports.

## Features

- **Automated Testing**: This project includes automated tests for different modules of OrangeHRM (Leave Management, Employee Management, and more).
- **Test Framework**: The tests are built using **TestNG** for test management and **Selenium WebDriver** for browser automation.
- **Continuous Integration**: Tests can be integrated into **CI/CD pipelines** using tools like **Jenkins** or **GitHub Actions**.

## Installation

### Prerequisites

To run the tests, you must have the following installed:

- **Java 8 or higher**
- **Maven** (for dependency management and test running)
- **Selenium WebDriver** (for browser automation)
- **TestNG** (for test management)

### Setup

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/BASKARAN5185/OrangeHRM-Testing.git
    ```

2. **Navigate to the Project Folder**:

    ```bash
    cd OrangeHRM-Testing
    ```

3. **Install Project Dependencies**:

    If you’re using **Maven**, run:

    ```bash
    mvn install
    ```

    If you’re using **Gradle**, run:

    ```bash
    gradle build
    ```

4. **Set Up Your WebDriver**: Ensure that you have the appropriate **WebDriver** (ChromeDriver, GeckoDriver, etc.) set up on your system and configured in your project.

    - Download the appropriate **WebDriver** based on the browser you're using (Chrome, Firefox, etc.).
    - Add the path to the WebDriver in your **system's environment variables** or configure it in your project.

### Running the Tests

Once everything is set up, you can run the tests using **Maven** or **Gradle**:

#### Using Maven:

```bash
mvn test

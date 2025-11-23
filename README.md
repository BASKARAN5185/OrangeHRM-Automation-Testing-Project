---

# OrangeHRM Testing Project

This repository contains **automated tests** for the [OrangeHRM](https://www.orangehrm.com/) application. The goal of this project is to ensure the **functionality**, **performance**, and **reliability** of key modules in the OrangeHRM system using Selenium and TestNG.

> 📌 Designed for QA engineers and automation testers to validate real-world HR workflows.

---

## 🚀 Features

| ✅ Feature               | 🔍 Description                                                                 |
|-------------------------|---------------------------------------------------------------------------------|
| Automated Functional Tests | Covers Leave, PIM, Admin, My Info, Dashboard, and more.                    |
| Selenium WebDriver      | Automates real browser interactions across different modules.                  |
| TestNG Framework        | Manages test cases with annotations, assertions, and custom groups.            |
| Data-Driven Testing     | Uses Excel and TestNG DataProviders to inject test data dynamically.           |
| ExtentReports Integration | Provides rich HTML reports with logs, screenshots, and step statuses.       |
| CI/CD Ready             | Easily integrable with Jenkins, GitHub Actions, or other CI pipelines.         |

---

## 🛠️ Tech Stack

| Tool / Library     | Purpose                          |
|--------------------|----------------------------------|
| **Java 8+**        | Programming language              |
| **Maven**          | Project build and dependency management |
| **TestNG**         | Testing framework for managing test suites |
| **Selenium WebDriver** | Browser automation               |
| **ExtentReports**  | Test reporting in HTML format     |
| **Apache POI**     | Reading test data from Excel files |

---

## 📁 Project Structure

```bash
OrangeHRM-Testing/
├── src/
│   ├── main/java/MyProject/OrangeHRM/
│   │   └── App.java
│   └── test/java/
│       ├── baseClass/
│       │   └── BaseClass.java
│       ├── pageObjectClass/
│       │   ├── AdminPage.java
│       │   ├── Contact_Page.java
│       │   ├── DashboardPage.java
│       │   ├── HomeMenuPage.java
│       │   ├── LeavePage.java
│       │   ├── My_info_page.java
│       │   ├── OrangeHRMLoginPage.java
│       │   └── PIMPage.java
│       ├── testBase/
│       │   ├── Admin_pageTest.java
│       │   ├── DashboardPageTest.java
│       │   ├── LeavePageTest.java
│       │   ├── Login_Page_test.java
│       │   ├── My_Info_PageTest.java
│       │   └── PIMPageTest.java
│       └── utility/
│           ├── DataProviderClass.java
│           ├── ExcelUtility.java
│           ├── ExtentReportManager.java
│           └── ExtentReportManager1.java
├── testng.xml
├── pom.xml
└── README.md
```

---

## ⚙️ Installation & Setup

### 📋 Prerequisites

- Java 8 or later
- Maven
- ChromeDriver / GeckoDriver (depending on browser used)

---

### 🧱 Steps to Set Up

#### 1️⃣ Clone the Repository

```bash
git clone https://github.com/BASKARAN5185/OrangeHRM-Testing.git
cd OrangeHRM-Testing
```

#### 2️⃣ Install Dependencies

```bash
mvn install
```

#### 3️⃣ Configure WebDriver

- Download the appropriate browser driver:
  - [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
  - [GeckoDriver](https://github.com/mozilla/geckodriver/releases)
- Add the path to your **system environment variables** or configure it directly in `BaseClass.java`.

---

## 🧪 Running Tests

Use Maven to run all TestNG test cases:

```bash
mvn test
```

- ✅ Executes test suites defined in `testng.xml`.
- 📄 Reports will be generated in:

```bash
target/test-output/
```

- 🌐 ExtentReports (HTML format) will be available in the specified directory (as configured in `ExtentReportManager.java`).

---

## 📊 Modules Covered

| Module            | Test Class                  |
|-------------------|-----------------------------|
| Login             | `Login_Page_test.java`      |
| Dashboard         | `DashboardPageTest.java`    |
| Leave Management  | `LeavePageTest.java`        |
| PIM (Employee Mgmt) | `PIMPageTest.java`        |
| Admin             | `Admin_pageTest.java`       |
| My Info           | `My_Info_PageTest.java`     |

---

## 📄 License

This project is for **educational and testing purposes only**.  
All rights related to OrangeHRM belong to their respective owners.

---

## 📬 Feedback & Contributions

Have ideas to improve this project? Found a bug?  
Feel free to open an issue or submit a pull request.

---

---

# OrangeHRM Testing Project

This repository contains **automated tests** for the [OrangeHRM](https://www.orangehrm.com/) application. The primary objective is to validate the functionality, performance, and reliability of various modules in the OrangeHRM system through automated testing.

---

## 📌 Features

- **Automated Functional Tests**: Covers modules like Leave Management, Employee Management (PIM), My Info, Admin, Dashboard, and more.
- **Selenium WebDriver**: Browser automation for simulating user interactions.
- **TestNG Framework**: For test management, grouping, and reporting.
- **Data-Driven Testing**: Using TestNG DataProviders and Excel input for dynamic testing.
- **Custom Reporting**: Integrated with ExtentReports for rich HTML-based test reports.
- **CI/CD Ready**: Can be integrated with Jenkins, GitHub Actions, or any CI pipeline.

---

## 🛠️ Tech Stack

- **Java 8+**
- **Maven**
- **TestNG**
- **Selenium WebDriver**
- **ExtentReports**
- **Apache POI (for Excel utility)**

---

## 🧰 Project Structure

```bash
OrangeHRM-Testing/
│
├── src/
│   ├── main/java/MyProject/OrangeHRM/
│   │   └── App.java
│   │
│   ├── test/java/
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
│
├── testng.xml
├── pom.xml
└── README.md
```

---

## 🚀 Installation & Setup

### 📋 Prerequisites

- Java 8 or later
- Maven
- ChromeDriver / GeckoDriver (based on the browser you are using)

### 🧱 Steps

1. **Clone the Repository**:

```bash
git clone https://github.com/BASKARAN5185/OrangeHRM-Testing.git
cd OrangeHRM-Testing
```

2. **Install Dependencies**:

```bash
mvn install
```

3. **Configure WebDriver**:

- Download the appropriate driver:
  - [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
  - [GeckoDriver](https://github.com/mozilla/geckodriver/releases)
- Set its path in your system’s environment variables **or** configure it in the `BaseClass.java`.

---

## 🧪 Running the Tests

### Using Maven

```bash
mvn test
```

Tests will execute as defined in `testng.xml`. Reports will be generated under:

```bash
target/test-output/
```

You can also view **ExtentReports** (HTML format) in the specified output directory.

---

## 📄 License

This project is for educational and testing purposes only. All rights to OrangeHRM belong to their respective owners.

---

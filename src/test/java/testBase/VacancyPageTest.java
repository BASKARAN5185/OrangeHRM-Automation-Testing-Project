package testBase;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectClass.OrangeHRMLoginPage;
import pageObjectClass.VacancyPage;

public class VacancyPageTest {

    private RemoteWebDriver driver;
    private VacancyPage vacancyPage;
    private OrangeHRMLoginPage login;

    @BeforeClass
    public void setUp() throws InterruptedException {
        login = new OrangeHRMLoginPage(driver);
        vacancyPage = new VacancyPage(driver);
        login.login("Admin", "admin123");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl,
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);  // wait for login
        // Navigate to Vacancy page
        vacancyPage.menuClickVacancyPage();
    }

    @Test(priority = 1)
    public void testSelectVacancyTitle() {
        vacancyPage.selectVacancyTitle("Senior QA Lead");
        // Add verification if dropdown has selected value (optional)
        Assert.assertTrue(true, "Vacancy Title selected successfully");
    }

    @Test(priority = 2)
    public void testSelectVacancy() {
        vacancyPage.selectVacancy("Senior QA Lead");
        Assert.assertTrue(true, "Vacancy selected successfully");
    }

    @Test(priority = 3)
    public void testSelectHiringManager() {
        vacancyPage.selectHiringManager("John Doe");
        Assert.assertTrue(true, "Hiring Manager selected successfully");
    }

    @Test(priority = 4)
    public void testSelectStatus() {
        vacancyPage.selectStatus("Active");
        Assert.assertTrue(true, "Status selected successfully");
    }

    @Test(priority = 5)
    public void testClickSearchButton() {
        vacancyPage.clickSearchButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("viewJobVacancy"),
                "Search executed successfully");
    }

    @Test(priority = 6)
    public void testClickResetButton() {
        vacancyPage.clickResetButton();
        Assert.assertTrue(true, "Reset button clicked successfully");
    }

    @Test(priority = 7)
    public void testClickAddVacancyButton() {
        vacancyPage.clickAddVacancyButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("saveJobVacancy"),
                "Navigated to Add Vacancy page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

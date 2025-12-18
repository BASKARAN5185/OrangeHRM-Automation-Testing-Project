package testBase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;
import pageObjectClass.recuritment.VacancyPage;


public class VacancyPageTest extends BaseClass {

    private VacancyPage vacancyPage;
    private OrangeHRMLoginPage login;

    @BeforeClass
    public void setUp() throws InterruptedException {
        login = new OrangeHRMLoginPage(driver);
        vacancyPage = new VacancyPage(driver);
        login.login();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl,
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    
    }
    @BeforeMethod
    public void navigateVacancyPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewJobVacancy");
    }

    @Test(priority = 1)
    public void testSelectVacancyTitle() {
       Assert.assertTrue(vacancyPage.selectVacancyTitle("Automation Tester"),"vaccancy title selection is failed");
    }

    @Test(priority = 2)
    public void testSelectVacancy() {
        vacancyPage.selectVacancy("Senior QA Lead");
        vacancyPage.clickSearchButton();
        Assert.assertTrue(vacancyPage.serachFunctionValidation("Senior QA Lead"), "Vacancy selected successfully");
    }

    @Test(priority = 3)
    public void testSelectHiringManager() {
        vacancyPage.selectHiringManager();
        vacancyPage.clickSearchButton();
        Assert.assertTrue(vacancyPage.serachFunctionValidation("Rahul Das"), "Hiring Manager selected successfully");
    }

    @Test(priority = 4)
    public void testSelectStatus() {
        vacancyPage.selectStatus();
        Assert.assertTrue(vacancyPage.serachFunctionValidation("Closed"), "Status selected successfully");
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
        Assert.assertTrue(driver.getCurrentUrl().contains("/recruitment/addJobVacancy"),
                "Navigated to Add Vacancy page");
    }



}

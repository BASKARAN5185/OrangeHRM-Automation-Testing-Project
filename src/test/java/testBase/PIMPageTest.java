package testBase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;
import pageObjectClass.PIMPage;

public class PIMPageTest extends BaseClass {

    PIMPage pimPage;
    OrangeHRMLoginPage login;

    @BeforeClass

    public void setup() {
        pimPage = new PIMPage(driver);
        login = new OrangeHRMLoginPage(driver);
        login.login();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
                "Login Failed or URL mismatch!");
    }

    @Test(priority = 2, groups = {"Sanity", "Regression", "PIMTest"})
    void verifyPIMMenuNavigation() {
        pimPage.menuClickPIMPage();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList",
                "PIM Page navigation failed!");
    }

    @Test(priority = 3, groups = {"Sanity", "Regression", "PIMTest"})
    void verifyAddButtonOpensAddEmployeePage() {
        pimPage.clickAddButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee",
                "Add Employee page did not open!");
    }

    @Test(priority = 4, groups = {"Sanity", "Regression", "PIMTest"})
    void searchEmployeeByName() {
        pimPage.enterEmployeeName("Linda");
        pimPage.clickSearchButton();
        // Add assertion later if verifying results
    }

    @Test(priority = 5, groups = {"Sanity", "Regression", "PIMTest"})
    void searchEmployeeById() {
        pimPage.enterEmployeeId("0012");
        pimPage.clickSearchButton();
    }

    @Test(priority = 6, groups = {"Sanity", "Regression", "PIMTest"})
    void selectJobTitleTest() {
        pimPage.selectJobTitle("Software Engineer");
    }

    @Test(priority = 7, groups = {"Sanity", "Regression", "PIMTest"})
    void selectEmploymentStatusTest() {
        pimPage.selectEmploymentStatus("Full-Time Permanent");
    }

    @Test(priority = 8, groups = {"Sanity", "Regression", "PIMTest"})
    void selectIncludeOptionTest() {
        pimPage.selectIncludeOption("Current Employees Only");
    }

    @Test(priority = 9, groups = {"Sanity", "Regression", "PIMTest"})
    void selectSubUnitTest() {
        pimPage.selectSubUnit("Engineering");
    }

    @Test(priority = 10, groups = {"Sanity", "Regression", "PIMTest"})
    void supervisorNameSearchTest() {
        pimPage.enterSupervisorName("Peter");
        pimPage.clickSearchButton();
    }

    @Test(priority = 11, groups = {"Sanity", "Regression", "PIMTest"})
    void resetSearchFiltersTest() {
        pimPage.enterEmployeeName("John");
        pimPage.enterEmployeeId("0050");
        pimPage.clickResetButton();
    }
}

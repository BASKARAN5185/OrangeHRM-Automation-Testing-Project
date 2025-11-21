package testBase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.DashboardPage;
import pageObjectClass.OrangeHRMLoginPage;

public class DashboardPageTest extends BaseClass {

    OrangeHRMLoginPage login;
    DashboardPage dashboard;

    @BeforeClass
    public void setup() {
        login = new OrangeHRMLoginPage(driver);
        dashboard = new DashboardPage(driver);
    }

    @Test(enabled = true, dependsOnMethods = "verifyPageName")
    public void checkBrokenLinks() {
        validateBrokenLinks();
    }

    @Test(priority = 1, groups = {"Regression", "Sanity", "DashboardTest"})
    void loginTest() {
        login.login("Admin", "admin123");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl,
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 2, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyPageName() {
        String name = dashboard.nameOfThePageGet();
        Assert.assertEquals(name, "Dashboard");
    }

    @Test(priority = 3, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyClockPage() {
        dashboard.clockIconClick();
        dashboard.back();
    }

    @Test(priority = 4, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyPerformancePage() {
        String url = dashboard.myNotification();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/performance/myPerformanceReview");
        dashboard.back();
    }

    @Test(priority = 5, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyAssignLeavePage() {
        String title = dashboard.assignLeaveClick();
        Assert.assertEquals(title, "OrangeHRM");
        dashboard.back();
    }

    @Test(priority = 6, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyLeaveListPage() {
        String url = dashboard.leaveListClick();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
        dashboard.back();
    }

    @Test(priority = 7, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyTimesheetPage() {
        String url = dashboard.timesheetClicking();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet");
        dashboard.back();
    }

    @Test(priority = 8, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyApplyLeavePage() {
        String url = dashboard.applyLeaveClicking();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        dashboard.back();
    }

    @Test(priority = 9, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyMyLeavePage() {
        String url = dashboard.myLeave();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewMyLeaveList");
        dashboard.back();
    }

    @Test(priority = 10, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyMyTimesheetPage() {
        String url = dashboard.myTimeSheet();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewMyTimesheet");
        dashboard.back();
    }

    @Test(priority = 11, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyEmployeeLeaveSettings() throws IOException {
        dashboard.employeeLeaveSettingIcon();
        dashboard.employeeLeaveClose();

        dashboard.employeeLeaveSettingIcon();
        dashboard.employeeLeaveCancel();

        dashboard.employeeLeaveSettingIcon();
        dashboard.employeeLeaveCheckbox();
        DashboardPage.pageScreenshot(driver, "employeesettingcheckbox.png");
        dashboard.employeeLeaveSave();
    }

    @Test(priority = 12, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyBuzzPage() {
        String url = dashboard.buzPage();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");
        dashboard.back();
    }

    @Test(priority = 13, groups = {"Regression", "Sanity", "DashboardTest"})
    void captureAllDashboardImages() throws IOException {

        dashboard.getEmployeeImage();
        dashboard.timeToWorkBoxImg();
        dashboard.myActionsBoximg();
        dashboard.quickLunchBoxImg();
        DashboardPage.pageScreenshot(driver, "dash1.png");

        dashboard.scrollPage();
        dashboard.buzlaTestPostBoxImg();
        DashboardPage.pageScreenshot(driver, "dash2.png");
    }

    @Test(priority = 14, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyEmployeeDistribution() throws IOException {
        dashboard.engineeringClicking();
        dashboard.humanresoureClicking();
        dashboard.unassignedClicking();
        DashboardPage.pageScreenshot(driver, "circle-change.png");
    }

    @Test(priority = 15, groups = {"Regression", "Sanity", "DashboardTest"})
    void verifyAdminMenuWorking() {
        String url = dashboard.adminMenuVerify();
        Assert.assertEquals(url,
                "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        dashboard.back();
    }
}

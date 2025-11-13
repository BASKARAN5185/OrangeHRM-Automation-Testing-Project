package testBase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;

import java.time.Duration;

public class LoginPageTest extends BaseClass {

    private OrangeHRMLoginPage login;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Initialize page object
        login = new OrangeHRMLoginPage(driver);

        // Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------------- LOGIN TESTS ----------------------

    @Test(priority = 1, groups = {"Smoke", "Regression", "LoginTest"})
    void loginWithEmptyUsername() {
        login.login("", "123");
        wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 2, groups = {"Smoke", "Regression", "LoginTest"})
    void loginWithInvalidEmail() {
        login.login("baskar@gmail.com", "123");
        wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 3, groups = {"Smoke", "Regression", "LoginTest"})
    void loginWithEmptyCredentials() {
        login.login("", "");
        wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 4, groups = {"Smoke", "Regression", "LoginTest"})
    void loginWithInvalidPassword() {
        login.login("Admin", "123");
        wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 20, groups = {"Smoke", "Regression", "LoginTest"})
    void loginWithValidCredentials() {
        login.login("Admin", "admin123");
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    // ---------------------- FORGOT PASSWORD TESTS ----------------------

    @Test(priority = 7, groups = {"Smoke", "Regression", "LoginTest"})
    void forgotPasswordNavigation() {
        login.clickForgotPasswordLink();
        wait.until(ExpectedConditions.urlContains("requestPasswordResetCode"));
        Assert.assertEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test(priority = 8, groups = {"Smoke", "Regression", "LoginTest"})
    void cancelForgotPassword() {
        login.cancelPasswordReset();
        wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertNotEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test(priority = 9, groups = {"Smoke", "Regression", "LoginTest"})
    void resetPasswordFlow() {
        login.clickForgotPasswordLink();
        login.resetPassword("Admin");
        wait.until(ExpectedConditions.urlContains("sendPasswordReset"));
        Assert.assertEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset");

        // Go back to login page
        login.goBack();
        login.goBack();
    }

    // ---------------------- UI & ICON TESTS ----------------------

    @Test(priority = 5, groups = {"Smoke", "Regression", "LoginTest"})
    void logoVisibilityTest() {
        Assert.assertTrue(login.logoVisible(), "Company logo is not visible");
        Assert.assertTrue(login.sideLogoVisible(), "Side logo is not visible");
    }

    @Test(priority = 14, groups = {"Smoke", "Regression", "LoginTest"})
    void pageTitleTest() {
        Assert.assertTrue(login.getPageTitle().equalsIgnoreCase("login"), "Page title mismatch");
    }

    @Test(priority = 15, groups = {"Smoke", "Regression", "LoginTest"})
    void pageTitleVisibilityTest() {
        Assert.assertTrue(login.pageTitleVisible(), "Page title is not visible");
    }

    @Test(priority = 16, groups = {"Smoke", "Regression", "LoginTest"})
    void socialIconLinkedInTest() {
        Assert.assertTrue(login.linkedinIconVisible(), "LinkedIn icon is not visible");
    }

    @Test(priority = 17, groups = {"Smoke", "Regression", "LoginTest"})
    void socialIconFacebookTest() {
        Assert.assertTrue(login.facebookIconVisible(), "Facebook icon is not visible");
    }

    @Test(priority = 18, groups = {"Smoke", "Regression", "LoginTest"})
    void socialIconTwitterTest() {
        Assert.assertTrue(login.twitterIconVisible(), "Twitter icon is not visible");
    }

    @Test(priority = 19, groups = {"Smoke", "Regression", "LoginTest"})
    void socialIconYouTubeTest() {
        Assert.assertTrue(login.youtubeIconVisible(), "YouTube icon is not visible");
    }

    // ---------------------- DATA PROVIDER EXAMPLE ----------------------

    @Test(priority = 12, groups = {"Smoke", "Regression", "LoginTest"},
            dataProvider = "New Employee",
            dataProviderClass = utility.DataProviderClass.class)
    void invalidUserLogin(String username, String password) {
        login.login(username, password);
        wait.until(ExpectedConditions.urlContains("auth/login"));
        Assert.assertNotEquals(login.getCurrentPageUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    // ---------------------- BROKEN LINK VALIDATION ----------------------

    @Test(dependsOnMethods = "loginWithEmptyUsername")
    void checkBrokenLinks() {
        validateBrokenLinks(); // Implemented in BaseClass
    }

}

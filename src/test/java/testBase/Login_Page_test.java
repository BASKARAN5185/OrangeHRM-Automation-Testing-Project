package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;

public class Login_Page_test extends BaseClass {

    OrangeHRMLoginPage login = new OrangeHRMLoginPage(driver);

    @Test(priority = 1, groups = { "Smoke", "Regression", "LoginTest" })
    void loginTest001() {
        login.login("", "123");
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 2, groups = { "Smoke", "Regression", "LoginTest" })
    void loginTest002() {
        login.login("baskar@gmail.com", "123");
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 3, groups = { "Smoke", "Regression", "LoginTest" })
    void loginTest003() {
        login.login("", "");
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 4, groups = { "Smoke", "Regression", "LoginTest" })
    void loginTest1004() {
        login.login("ADmin", "123");
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 5, groups = { "Smoke", "Regression", "LoginTest" })
    void logoTest005() {
        Assert.assertTrue(login.logoVisiblible(), "Logo is not visible");
        System.out.println("Logo visible: " + login.logoVisiblible());

        Assert.assertTrue(login.sidelogovisible(), "Side logo is not visible");
        System.out.println("Side logo visible: " + login.sidelogovisible());
    }

    @Test(priority = 7, groups = { "Smoke", "Regression", "LoginTest" })
    void forgetpasstest007() {
        login.forgetpass();
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl,
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test(priority = 8, groups = { "Smoke", "Regression", "LoginTest" })
    void forgetpasscancelTest008() {
        login.forgetpasscancel();
        String pageurl = login.LoginValidation();
        Assert.assertNotEquals(pageurl,
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test(priority = 9, groups = { "Smoke", "Regression", "LoginTest" })
    void forgetpasssentest009() {
        login.forgetpass();
        login.forgetpassreset("Admin");
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset");
        login.goback();
        login.goback();
    }

    @Test(priority = 10, groups = { "Smoke", "Regression", "LoginTest" }, dataProvider = "UserLogin", dataProviderClass = utility.DataProviderClass.class)
    void loginTest010(String user, String pas) {
        login.login(user, pas); // Fixed: was login(user, user)
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 12, groups = { "Smoke", "Regression", "LoginTest" })
    void CredentialUserNameAndPassword() {
        login.login("Admin", "admin123");
        String pageurl = login.LoginValidation();
        Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
}

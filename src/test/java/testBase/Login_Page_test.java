package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;


public class Login_Page_test extends BaseClass {

	OrangeHRMLoginPage login = new OrangeHRMLoginPage(driver);

	@Test(priority = 1)
	void loginTest001() {
		
		login.login("", "123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", pageurl);

	}

	@Test(priority = 2)
	void loginTest002() {
		login.login("baskar@gmail.com", "123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", pageurl);

	}

	@Test(priority = 3)
	void loginTest003() {
		login.login("", "");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", pageurl);

	}

	@Test(priority = 4)
	void loginTest1004() {
		login.login("ADmin", "123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", pageurl);

	}

	@Test(priority = 5)
	void logoTest005() {
		Assert.assertEquals(login.logoVisiblible(), true);
		System.out.println(login.logoVisiblible());
		Assert.assertEquals(login.sidelogovisible(), true);
		System.out.println(login.sidelogovisible());
	}
	/*
	 * 
	 * @Test(priority =6) void loginTest006() { login.login("Admin",""); String
	 * pageurl=login.LoginValidation(); Assert.assertEquals(
	 * "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
	 * pageurl);
	 * 
	 * }
	 */

	@Test(priority = 7)
	void forgetpasstest007() {
		login.forgetpass();
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode",
				pageurl);

	}

	@Test(priority = 8)
	void forgetpasscancelTest008() {

		login.forgetpasscancel();
		String pageurl = login.LoginValidation();
		Assert.assertNotEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode",
				pageurl);
	}

	@Test(priority = 9)
	void forgetpasssentest009() {
		login.forgetpass();
		login.forgetpassreset("Admin");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset", pageurl);
		login.goback();
		login.goback();
	}

	@Test(priority = 12)
	void CredentialUserNameAndPassword() {
		login.login("Admin", "admin123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", pageurl);

	}
	
	@Test(enabled = false, priority = 10,dataProvider = "UserLogin",dataProviderClass = utility.DataProviderClass.class)
	void loginTest010(String user,String pas) {
		login.login(user, user);
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", pageurl);

	}

}

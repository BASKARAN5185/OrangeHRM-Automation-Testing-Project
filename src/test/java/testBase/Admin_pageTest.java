package testBase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.AdminPage;
import pageObjectClass.OrangeHRMLoginPage;

public class Admin_pageTest extends BaseClass {
	OrangeHRMLoginPage login;
	AdminPage adminpage;
	
	@BeforeClass
	public void setup() {
	 login = new OrangeHRMLoginPage(driver);
	 adminpage = new AdminPage(driver);
	}


/* 	@Test(priority = 0, groups = { "Sanity", "Regression", "LoginTest" })
	void loginTest001() {
		login.login("Admin", "admin123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", pageurl);
		adminpage.clicktheadminmenu();
	} */

	@Test(priority = 1, groups = { "Regression", "AdminTest" })
	void SearchSystemUsers() {
		adminpage.enterUsernameForSystemUser("Admin");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();
	}

	@Test(priority = 2, groups = { "Regression", "AdminTest" })
	void SearchSystemrole() {
		adminpage.selectUserRoleForSystemUser("Admin");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();
	}

	@Test(priority = 7, groups = { "Regression", "AdminTest" })
	void SearchSystememployeename() {
		adminpage.enterEmployeeNameForSystemUser("John Doe");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();
	}

	@Test(priority = 4, groups = { "Regression", "AdminTest" })
	void SearchSystemstatus() {
		adminpage.selectStatusForSystemUser("Enabled");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();
	}

	@Test(priority = 5, groups = { "Sanity", "AdminTest" })
	void Cicktheadduserbutton() {
		adminpage.clickAddButtonForSystemUser();
	}

	@Test(priority = 6, groups = { "Regression", "Sanity", "AdminTest" })
	void AddNewUser() {
		adminpage.selectUserRole("Admin");
		adminpage.enterEmployeeName("John Doe");
		adminpage.selectStatus("Active");
		adminpage.enterUsername("john.doe");
		adminpage.enterPassword("Password123");
		adminpage.enterConfirmPassword("Password123");
		adminpage.clickSaveButton();
	}
}

package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.AdminPage;
import pageObjectClass.OrangeHRMLoginPage;

public class Admin_pageTest extends BaseClass {

	OrangeHRMLoginPage login = new OrangeHRMLoginPage(driver);
	AdminPage adminpage = new AdminPage(driver);

	@Test(priority = 0)
	void loginTest001() {
		login.login("Admin", "admin123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", pageurl);
		adminpage.clicktheadminmenu();

	}

	@Test(priority = 1)
	void SearchSystemUsers() {
		adminpage.enterUsernameForSystemUser("Admin");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();

	}

	@Test(priority = 2)
	void SearchSystemrole() {
		adminpage.selectUserRoleForSystemUser("Admin");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();

	}

	@Test(priority = 7)
	void SearchSystememployeename() {
		adminpage.enterEmployeeNameForSystemUser("John Doe");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();

	}

	@Test(priority = 4)
	void SearchSystemstatus() {
		adminpage.selectStatusForSystemUser("Enabled");
		adminpage.clickSearchButtonForSystemUser();
		adminpage.clickResetButtonForSystemUser();

	}
	
	

	@Test(priority = 5)
	void Cicktheadduserbutton() {
		adminpage.clickAddButtonForSystemUser();

	}
	
	@Test(priority =6)
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

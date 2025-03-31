package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.My_info_page;
import pageObjectClass.OrangeHRMLoginPage;
import pageObjectClass.PIMPage;

public class PIMPageTest extends BaseClass {

	PIMPage PIMPage = new PIMPage(driver);
	OrangeHRMLoginPage login = new OrangeHRMLoginPage(driver);
	My_info_page myInfoPage = new My_info_page(driver);

	@Test(priority = 1)
	void userlogin() {
		login.login("Admin", "admin123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", pageurl);

	}

	@Test(priority = 2)
	void clickThePIMManu() {
		PIMPage.MenuClickPIMPage();
		String PIMPageurl = getCurrentUrlpage();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList", PIMPageurl);
	}

	@Test(priority = 3)
	void clickEmployeeListTheAddButton() {
		PIMPage.clickAddButton();
		String Pageurl = getCurrentUrlpage();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee", Pageurl);

		PIMPage.enterEmployeeFirstName("d");
		PIMPage.enterEmployeeMiddleName("d");
		PIMPage.enterEmployeeLastName("d");
		PIMPage.clickSaveButton();
		Boolean Visiblehaedr = myInfoPage.PersonalDetailsHeader();
		Assert.assertEquals(true, Visiblehaedr);
		NavigateBack();
		String Pageurl1 = getCurrentUrlpage();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee", Pageurl1);

	}

	@Test(priority = 4)
	void Add_Employee() {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Sanjay");
		PIMPage.enterEmployeeMiddleName("");
		PIMPage.enterEmployeeLastName("S");
		PIMPage.enterEmployeeId("1");
		PIMPage.toggleEmployeeLoginDetailsSwitch();
		PIMPage.enterEmployeeName("Sanja S");
		PIMPage.enterEmployeePassword("Sanjay123");
		PIMPage.enterEmployeeConfirmPassword("Sanjay123");
		PIMPage.selectEmployeeStatus("Enabled");
		PIMPage.clickSaveButton();
		Boolean Visiblehaedr = myInfoPage.PersonalDetailsHeader();
		Assert.assertEquals(true, Visiblehaedr);
		NavigateBack();
		String Pageurl1 = getCurrentUrlpage();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee", Pageurl1);
	}

	@Test(priority = 5)
	void Add_Employee_Disable_Satus() {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Sanjay");
		PIMPage.enterEmployeeMiddleName("");
		PIMPage.enterEmployeeLastName("S");
		PIMPage.enterEmployeeId("5");
		PIMPage.toggleEmployeeLoginDetailsSwitch();
		PIMPage.enterEmployeeName("Sanja S");
		PIMPage.enterEmployeePassword("Sanjay123");
		PIMPage.enterEmployeeConfirmPassword("Sanjay123");
		PIMPage.selectEmployeeStatus("Disabled");
		PIMPage.clickSaveButton();
		Boolean Visiblehaedr = myInfoPage.PersonalDetailsHeader();
		Assert.assertEquals(true, Visiblehaedr);
		NavigateBack();
		String Pageurl1 = getCurrentUrlpage();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee", Pageurl1);
	}

	@Test(priority = 6)
	void Add_Employee_cancel() {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Sanjay");
		PIMPage.enterEmployeeMiddleName("");
		PIMPage.enterEmployeeLastName("S");
		PIMPage.enterEmployeeId("8");
		PIMPage.toggleEmployeeLoginDetailsSwitch();
		PIMPage.enterEmployeeName("Sanja S");
		PIMPage.enterEmployeePassword("Sanjay123");
		PIMPage.enterEmployeeConfirmPassword("Sanjay123");
		PIMPage.selectEmployeeStatus("enabled");
		PIMPage.clickCancelButton();
		String PIMPageurl = getCurrentUrlpage();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList", PIMPageurl);
	}

	@Test(priority = 7)
	void Empty_Employee_Save() throws InterruptedException {
		PIMPage.clickAddButton();
		PIMPage.clickSaveButton();
		Thread.sleep(3000);
		Boolean Visiblehaedr = PIMPage.clickSaveButton();
		Assert.assertTrue(Visiblehaedr, "Save button is not visible");

	}

	@Test(priority = 8)
	void EmployeeNameOnlyEnter_Save() throws InterruptedException {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Lara");
		PIMPage.clickSaveButton();
		Thread.sleep(3000);
		Boolean Visible = PIMPage.clickSaveButton();
		Assert.assertTrue(Visible, "Save button is not visible");

	}

	@Test(priority = 9)
	void EmployeeNamelastEnter_Save() {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Lara");
		PIMPage.enterEmployeeLastName("Craft");
		boolean ButtonVis = PIMPage.clickSaveButton();
		Assert.assertEquals(ButtonVis, false);
		NavigateBack();
	}

	@Test(priority = 10)
	void EmployeeusernameI_Save() throws InterruptedException {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Lara");
		PIMPage.enterEmployeeLastName("Craft");
		PIMPage.toggleEmployeeLoginDetailsSwitch();
		PIMPage.enterEmployeeUsername(null);
		PIMPage.clickSaveButton();
		Thread.sleep(3000);
		Boolean Visible = PIMPage.clickSaveButton();
		Assert.assertTrue(Visible, "Save button is not visible");
	}

	@Test(priority = 11)
	void EmployeeUserNameIsEmpty() throws InterruptedException {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Lara");
		PIMPage.enterEmployeeLastName("Craft");
		PIMPage.toggleEmployeeLoginDetailsSwitch();
		PIMPage.enterEmployeeName("");
		PIMPage.clickSaveButton();
		Thread.sleep(3000);
		Boolean Visible = PIMPage.clickSaveButton();
		Assert.assertTrue(Visible, "Save button is not visible");

	}

	@Test(priority = 12)
	void EmployeeEnterPassword() throws InterruptedException {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Lara");
		PIMPage.enterEmployeeLastName("Craft");
		PIMPage.toggleEmployeeLoginDetailsSwitch();
		PIMPage.enterEmployeeName("a");
		PIMPage.enterEmployeePassword("");
		PIMPage.clickSaveButton();
		Thread.sleep(3000);
		Boolean Visible = PIMPage.clickSaveButton();
		Assert.assertTrue(Visible, "Save button is not visible");

	}

	@Test(priority = 13)
	void EmployeeConformPassword() throws InterruptedException {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Lara");
		PIMPage.enterEmployeeLastName("Craft");
		PIMPage.toggleEmployeeLoginDetailsSwitch();
		PIMPage.enterEmployeeName("a");
		PIMPage.enterEmployeePassword("Abcdefg123");
		PIMPage.enterEmployeeConfirmPassword("");
		PIMPage.clickSaveButton();
		Thread.sleep(3000);
		Boolean Visible = PIMPage.clickSaveButton();
		Assert.assertTrue(Visible, "Save button is not visible");

	}

	@Test(priority = 14)
	void SameEmployeeID() throws InterruptedException {
		PageRefresh();
		PIMPage.enterEmployeeFirstName("Sanjay");
		PIMPage.enterEmployeeMiddleName("");
		PIMPage.enterEmployeeLastName("S");
		PIMPage.enterEmployeeId("0500");
		PIMPage.clickSaveButton();
		Thread.sleep(3000);
		Boolean Visible = PIMPage.clickSaveButton();
		Assert.assertTrue(Visible, "Save button is not visible");

	}

}
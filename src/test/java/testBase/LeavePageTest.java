package testBase;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.HomeMenuPage;
import pageObjectClass.LeavePage;
import pageObjectClass.OrangeHRMLoginPage;

public class LeavePageTest extends BaseClass {

	HomeMenuPage Menu;
	LeavePage Leave;
	OrangeHRMLoginPage login;

	@BeforeClass
	public void setUpPages() {
		Menu = new HomeMenuPage(driver);
		Leave = new LeavePage(driver);
		login = new OrangeHRMLoginPage(driver);
	}

	@Test(priority = 1, groups = { "Regression", "Sanity", "LeaveModuleTest" })
	void login() {
		login.login("Admin", "admin123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals(pageurl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
				"Login URL validation failed.");
	}

	@Test(priority = 2, groups = { "Regression", "Sanity", "LeaveModuleTest" })
	void ClickTheLeavemenu() {
		Menu.clickLeaveMenu();
		String pageUrl = getCurrentUrlpage();
		System.out.println("Leave page URL: " + pageUrl);
		Assert.assertTrue(pageUrl.contains("leave/viewLeaveList"), "URL does not contain 'leave/viewLeaveList'");
	}

	@Test(priority = 3, groups = { "Regression", "Sanity", "LeaveModuleTest" })
	void EnterTheLeaveList() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		Leave.enterToDate("2025-07-03");
		Leave.selectLeaveStatus("Cancelled");
		Leave.selectLeaveStatus("CAN - Personal");
		Leave.enterEmployeeName("John");
		Leave.selectSubUnit("Engineering");
		boolean isClickable = Leave.clickSearchButton();
		Assert.assertTrue(isClickable, "Search button is not clickable");
	}

	@Test(priority = 4, groups = { "Regression", "LeaveModuleTest" })
	void clickTheResetbutton() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		Leave.enterToDate("2025-07-03");
		Leave.selectLeaveStatus("Cancelled");
		Leave.selectLeaveStatus("CAN - Personal");
		Leave.enterEmployeeName("John");
		Leave.selectSubUnit("Engineering");
		boolean isClickable = Leave.clickResetButton();
		Assert.assertTrue(isClickable, "Reset button is not clickable");
	}

	@Test(priority = 5, groups = { "Sanity", "LeaveModuleTest" })
	void formDateFieldisEmpty() throws AWTException {
		String fromDateEmpty = Leave.enterFromDate("");
		Assert.assertEquals(fromDateEmpty, "", "From Date field is not empty");
		boolean isClickable = Leave.clickResetButton();
		Assert.assertTrue(isClickable, "Reset button is not clickable");
	}

	@Test(priority = 6, groups = { "Sanity", "LeaveModuleTest" })
	void ToDateFieldisEmpty() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		String toDateEmpty = Leave.enterToDate("");
		Assert.assertEquals(toDateEmpty, "", "To Date field is not empty");
		boolean isClickable = Leave.clickResetButton();
		Assert.assertTrue(isClickable, "Reset button is not clickable");
	}

	@Test(priority = 7, groups = { "LeaveModuleTest" })
	void statusFieldisEmpty() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		Leave.enterToDate("2025-07-03");
		String leaveStatusEmpty = Leave.selectLeaveStatus("");
		Assert.assertEquals(leaveStatusEmpty, "", "Leave Status field is not empty");
		boolean isClickable = Leave.clickResetButton();
		Assert.assertTrue(isClickable, "Reset button is not clickable");
	}

	@Test(priority = 8, groups = { "Regression", "LeaveModuleTest" })
	void fieldsAreEmpty() throws AWTException {
		String fromDateEmpty = Leave.enterFromDate("");
		Assert.assertEquals(fromDateEmpty, "", "From Date field is not empty");

		String toDateEmpty = Leave.enterToDate("");
		Assert.assertEquals(toDateEmpty, "", "To Date field is not empty");

		String leaveStatusEmpty = Leave.selectLeaveStatus("");
		Assert.assertEquals(leaveStatusEmpty, "", "Leave Status field is not empty");

		boolean isClickable = Leave.clickResetButton();
		Assert.assertTrue(isClickable, "Reset button is not clickable");
	}
}

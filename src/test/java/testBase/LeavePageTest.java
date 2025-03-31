package testBase;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.HomeMenuPage;
import pageObjectClass.LeavePage;
import pageObjectClass.OrangeHRMLoginPage;

public class LeavePageTest extends BaseClass {

	HomeMenuPage Menu = new HomeMenuPage(driver);
	LeavePage Leave = new LeavePage(driver);
	OrangeHRMLoginPage login = new OrangeHRMLoginPage(driver);

	@Test(priority = 1)
	void login() {

		login.login("Admin", "admin123");
		String pageurl = login.LoginValidation();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", pageurl);

	}

	@Test(priority = 2)
	void ClickTheLeavemenu() {
		Menu.clickLeaveMenu();
		String pageUrl = getCurrentUrlpage();

		System.out.println(pageUrl);

		// Verify that the URL contains 'model=hr.job'
		Assert.assertTrue(pageUrl.contains("leave/viewLeaveList"), "URL does not contain 'leave/viewLeaveList'");

	}

	@Test(priority = 3)
	void EnterTheLeaveList() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		Leave.enterToDate("2025-07-03");
		Leave.selectLeaveStatus("Cancelled");
		Leave.selectLeaveStatus("CAN - Personal");
		Leave.enterEmployeeName("John");
		Leave.selectSubUnit("Engineering");
		boolean isclickable = Leave.clickSearchButton();
		Assert.assertTrue(isclickable, "Searchbutton is not clicabe ");

	}

	@Test(priority = 4)
	void clickTheResetbutton() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		Leave.enterToDate("2025-07-03");
		Leave.selectLeaveStatus("Cancelled");
		Leave.selectLeaveStatus("CAN - Personal");
		Leave.enterEmployeeName("John");
		Leave.selectSubUnit("Engineering");
		boolean isclickable = Leave.clickResetButton();
		Assert.assertTrue(isclickable, "Searchbutton is not clicabe ");

	}

	@Test(priority = 5)
	void formDateFieldisEmpty() throws AWTException {

		// Test case for From Date being empty
        String fromDateEmpty = Leave.enterFromDate("");
        Assert.assertEquals(fromDateEmpty,"" ,"To Date field is not null");
		boolean isclickable1 = Leave.clickResetButton();
		Assert.assertTrue(isclickable1, "Searchbutton is not clicabe ");
	}

	@Test(priority = 6)
	void ToDateFieldisEmpty() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		 // Test case for To Date being empty
	      
        String toDateEmpty = Leave.enterToDate("");
        Assert.assertEquals(toDateEmpty,"" ,"To Date field is not null");
		boolean isclickable1 = Leave.clickResetButton();
		Assert.assertTrue(isclickable1, "Searchbutton is not clicabe ");
	}

	@Test(priority = 7)
	void statusFieldisEmpty() throws AWTException {
		Leave.enterFromDate("2025-07-01");
		Leave.enterToDate("2025-07-03");
		// Test case for Leave Status being empty
        String leaveStatusEmpty = Leave.selectLeaveStatus("");
        Assert.assertEquals(leaveStatusEmpty,"" ,"To Date field is not null");
		boolean isclickable1 = Leave.clickResetButton();
		Assert.assertTrue(isclickable1, "Searchbutton is not clicabe ");
	}
	
	  @Test(priority = 8)
	    void fieldsAreEmpty() throws AWTException {
	        // Test case for From Date being empty
	        String fromDateEmpty = Leave.enterFromDate("");
	        Assert.assertEquals(fromDateEmpty,"" ,"To Date field is not null");

	        // Test case for To Date being empty
	      
	        String toDateEmpty = Leave.enterToDate("");
	        Assert.assertEquals(toDateEmpty,"" ,"To Date field is not null");

	        // Test case for Leave Status being empty
	        String leaveStatusEmpty = Leave.selectLeaveStatus("");
	        Assert.assertEquals(leaveStatusEmpty,"" ,"To Date field is not null");

	        // Click the Reset button after all checks
	        boolean isClickable = Leave.clickResetButton();
	        Assert.assertTrue(isClickable, "Reset button is not clickable");
	    }

}

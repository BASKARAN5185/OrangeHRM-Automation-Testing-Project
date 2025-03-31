package testBase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectClass.DashboardPage;
import pageObjectClass.OrangeHRMLoginPage;

public class DashboardPageTest extends BaseClass {

	OrangeHRMLoginPage login = new OrangeHRMLoginPage(driver);
	DashboardPage Dashboard = new DashboardPage(driver);

	@Test(priority = 1)
	void loginTest001() {
		login.login("Admin", "admin123");
		String pageurl = login.LoginValidation();
		Assert.assertNotEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", pageurl);
	}

	@Test(priority = 2)
	void PagenameVerify002() {
		String pagename = Dashboard.NameofthePageGet();
		Assert.assertEquals("Dashboard", pagename);

	}

	@Test(priority = 3)
	void clockpageVerify003() {
		//String clockpage =
				Dashboard.clockiconclicking();
		// Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/attendance/punchOut", clockpage);
		Dashboard.Back();

	}

	@Test(priority = 4)
	void performancepageVerify004() {
		String performancepage = Dashboard.Mynotification();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/performance/myPerformanceReview",performancepage);
		Dashboard.Back();
	}

	@Test(priority = 5)
	void AssignleavepageVerify005() {
		String Assignleavepagetitle = Dashboard.Assignleaveclick();
		Assert.assertEquals("OrangeHRM", Assignleavepagetitle);
		Dashboard.Back();
	}

	@Test(priority = 6)
	void leaveListpageVerify006() {
		String leaveListpage = Dashboard.Leavelistclick();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList",
				leaveListpage);
		Dashboard.Back();
	}

	@Test(priority = 7)
	void timesheetpageVerify007() {
		String timesheeetpage = Dashboard.Timesheetclicing();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet",
				timesheeetpage);
		Dashboard.Back();
	}

	@Test(priority = 8)
	void ApplyleavepageVerify08() {
		String Applyleavepage = Dashboard.ApplyLeaveclicking();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave", Applyleavepage);
		Dashboard.Back();
	}

	@Test(priority = 9)
	void ApplyleavepageVerify009() {
		String Myleavepage = Dashboard.MyLeave();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewMyLeaveList",
				Myleavepage);
		Dashboard.Back();
	}

	@Test(priority = 10)
	void mytimesheetpageVerify0010() {
		String mytimeSheetpage = Dashboard.MyTimeSheet();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewMyTimesheet",mytimeSheetpage);
		Dashboard.Back();
	}

	@Test(priority = 11)
	void EmplloyeeLeavesettingVerify011() throws IOException {
		Dashboard.employeeleavesettingicon();
		Dashboard.employeeleaveclose();
		System.out.println("close");
		Dashboard.employeeleavesettingicon();
		Dashboard.employeeleavecancel();
		System.out.println("cancel");
		Dashboard.employeeleavesettingicon();
		Dashboard.employeeleavecheckbox();
		System.out.println("click");
		DashboardPage.pageScreenshot("employeesettingcheckbox.png");
		Dashboard.employeeleavesave();

	}

	@Test(priority = 12)
	void BUZpageVerify012() {
		String Buzpagepage = Dashboard.Buzpage1();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz",Buzpagepage);
		Dashboard.Back();
	}


	@Test(priority = 13)
	void elementscreenshot_employeeimg_TWBox_Qlbox_MAbox013() throws IOException {
		Dashboard.getemployeeimage();
		System.out.println("dashimg_1");
		Dashboard.timetoworkboximg();
		System.out.println("dashimg_2");
		Dashboard.MyActionsBoximg();
		System.out.println("dashimg_3");
		Dashboard.QuicklunchBoximg();
		System.out.println("dashimg_4");
		DashboardPage.pageScreenshot("dash1.png");
		System.out.println("dashimg_5");
		Dashboard.Scrollpage();
		System.out.println("dashimg_6");
		Dashboard.BUZlatestpostnoximg();
		System.out.println("dashimg_7");
		DashboardPage.pageScreenshot("dash2.png");
		System.out.println("dashimg_8");

	}

	@Test(priority = 14)
	void EmployeeDistributionbySubUnit14() throws IOException {
		Dashboard.Engineeringclicking();
		Dashboard.Humanresoureclicking();
		Dashboard.unassignedclicking();
		DashboardPage.pageScreenshot("circulechange.png");
	}
	
	
	@Test(priority = 15)
	void Verifyadminmenubuttonworkin() throws IOException {
		String Admin=Dashboard.Adminmenuverify();
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers",Admin);
		Dashboard.Back();
	}
	
	

}
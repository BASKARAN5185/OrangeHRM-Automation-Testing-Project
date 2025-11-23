package pageObjectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomeMenuPage  {
	private RemoteWebDriver driver;
	public HomeMenuPage(RemoteWebDriver driver) {
		this.driver=driver;		
	}

    // Locators for the demo menu items (You can adjust these based on the actual HTML of the page)
    
     By adminMenu = By.id("menu_admin_viewAdminModule");
     By pimMenu = By.id("menu_pim_viewPimModule");
     By leaveMenu = By.xpath("//*[@href='/web/index.php/leave/viewLeaveModule']");
     By timeMenu = By.xpath("//span[text()='Time']");
     By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
     By myInfoMenu = By.id("menu_pim_viewMyDetails");
     By performanceMenu = By.xpath("//span[text()='Performance']");
     By dashboardMenu = By.id("menu_dashboard_index");
     By directoryMenu = By.id("menu_directory_viewDirectory");
     By maintenanceMenu = By.id("menu_maintenance_purgeEmployee");
    
    // Locators for sub-menu items (if any) under each main menu
     By adminUserManagement = By.id("menu_admin_UserManagement");
     By pimEmployeeList = By.id("menu_pim_viewEmployeeList");
     By leaveApplyLeave = By.id("menu_leave_applyLeave");
     By timeAttendance = By.id("menu_time_Attendance");
     By recruitmentCandidates = By.id("menu_recruitment_viewCandidates");
     By myInfoPersonalDetails = By.id("menu_pim_viewPersonalDetails");
     By performanceTrack = By.id("menu_performance_viewTrack");
     By dashboardView = By.id("menu_dashboard_viewDashboard");
     By directorySearch = By.id("menu_directory_viewSearchDirectory");
     By maintenanceManageEmployees = By.id("menu_maintenance_ManageEmployees");
    
    // Methods to interact with the menu items (clicking, etc.)
    
    public void clickAdminMenu() {
        driver.findElement(adminMenu).click();
    }
    
    public void clickPimMenu() {
        driver.findElement(pimMenu).click();
    }

    public void clickLeaveMenu() {
        driver.findElement(leaveMenu).click();
    }

    public void clickTimeMenu() {
        driver.findElement(timeMenu).click();
    }

    public void clickRecruitmentMenu() {
        driver.findElement(recruitmentMenu).click();
    }

    public void clickMyInfoMenu() {
        driver.findElement(myInfoMenu).click();
    }

    public void clickPerformanceMenu() {
        driver.findElement(performanceMenu).click();
    }

    public void clickDashboardMenu() {
        driver.findElement(dashboardMenu).click();
    }

    public void clickDirectoryMenu() {
        driver.findElement(directoryMenu).click();
    }

    public void clickMaintenanceMenu() {
        driver.findElement(maintenanceMenu).click();
    }
    
    // Methods to interact with sub-menu items
    public void clickAdminUserManagement() {
        driver.findElement(adminUserManagement).click();
    }
    
    public void clickPimEmployeeList() {
        driver.findElement(pimEmployeeList).click();
    }

    public void clickLeaveApplyLeave() {
        driver.findElement(leaveApplyLeave).click();
    }

    public void clickTimeAttendance() {
        driver.findElement(timeAttendance).click();
    }

    public void clickRecruitmentCandidates() {
        driver.findElement(recruitmentCandidates).click();
    }

    public void clickMyInfoPersonalDetails() {
        driver.findElement(myInfoPersonalDetails).click();
    }

    public void clickPerformanceTrack() {
        driver.findElement(performanceTrack).click();
    }

    public void clickDashboardView() {
        driver.findElement(dashboardView).click();
    }

    public void clickDirectorySearch() {
        driver.findElement(directorySearch).click();
    }

    public void clickMaintenanceManageEmployees() {
        driver.findElement(maintenanceManageEmployees).click();
    }
}

package pageObjectClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DashboardPage  {
	
	private RemoteWebDriver driver;
	public DashboardPage(RemoteWebDriver driver) {
		
		this.driver=driver;
		
	}
	
	// DashboardPage Locators
	By NameOfThePage=By.xpath("//h6[text()='Dashboard']");
	By TimeToWork=By.xpath("//p[text()='Time at Work']");
	By employeeimage=By.xpath("(//img[@alt='profile picture'])[2]");
	By Clockimage=By.xpath("//i[@class='oxd-icon bi-stopwatch']");
	By TimetoworkBox=By.xpath("(//div[contains(@class,'oxd-sheet oxd-sheet--rounded')])[1]");
	By MyActionsBox=By.xpath("(//div[contains(@class,'oxd-sheet oxd-sheet--rounded')])[2]");
	By MyAction=By.xpath("//p[text()='My Actions']");
	By MyActionicon=By.className("oxd-icon");
	By MyActionNotification=By.xpath("//button[contains(@class,'oxd-icon-button oxd-icon-button--danger')]/following-sibling::p[1]");
	By Helpicon=By.xpath("//button[@title='Help']");
	By QuickLunchBox=By.xpath("(//div[contains(@class,'oxd-sheet oxd-sheet--rounded')])[3]");
	By QuickLunch=By.xpath("//*[text() = \"Quick Launch\"]");
    By AssignLeave=By.xpath("//*[@title = \"Assign Leave\"]");
    By LeaveList=By.xpath("//*[@title = \"Leave List\"]");
    By Timesheets=By.xpath("//*[@title = \"Timesheets\"]");
    By ApplyLeave=By.xpath("//*[@title = \"Apply Leave\"]");
    By MyLeave=By.xpath("//*[@title = \"My Leave\"]");
    By MyTimesheet=By.xpath("//*[@title = \"My Timesheet\"]");
    By BuzzLatestPostsbox=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div");
    By Buzpage=By.xpath("(//div[@class='orangehrm-buzz-profile-image']//img)[1]");
    By EmployeesonLeaveToday=By.xpath("//*[text() = \"Employees on Leave Today\"]");
    By EployeeLeaveSettingivon=By.xpath("//i[contains(@class,'oxd-icon bi-gear-fill')]");
    By Employerleavecheckbox=By.xpath("//span[contains(@class,'oxd-switch-input oxd-switch-input--active')]");
    By Employeeleavecloseicon=By.xpath("//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']");
    By Employeeleavecancel=By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[1]");
    By Employeeleavesave=By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[2]");
    By orangehrmleavecardicon=By.cssSelector("i.oxd-icon.bi-gear-fill.orangehrm-leave-card-icon");
    By EmployeeDistributionbox=By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]");
    By Engineering=By.xpath("//span[@title = \"Engineering\"]");
    By HumanResource=By.xpath("//span[@title = \"Human Resources\"]");
    By ClientServices=By.xpath("//span[@title = \"Client Services\"]");
    By Administration=By.xpath("//span[@title = \"Administration\"]");
    By TexasRD=By.xpath("//span[@title = \"Texas R&D\"]");
    By Unassigned=By.xpath("(//span[@title='Unassigned'])[2]");
    By NewYorkSalesOffice=By.xpath("//span[@title = \"New York Sales Office\"]");
    By app=By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div[7]/div/div[2]/div/ul/li[3]/span[2]");
    
    //MenuLocators 
    By Adminmenu=By.xpath("(//a[@class='oxd-main-menu-item']//span)[1]");
    By PIMMenu=By.xpath("//a[@class='oxd-main-menu-item active']//span[1]");
    By LeaveMenu =By.xpath("//a[@class='oxd-main-menu-item active']");
    By TimeMenu=By.xpath("//span[text()='Time']");
    By Recurietment=By.xpath("//span[text()='Recruitment']");
    
    public String adminMenuVerify() {
    	driver.findElement(Adminmenu).click();
    	String Adminpage=driver.getCurrentUrl();
    	return Adminpage;
    }
	
    public String nameOfThePageGet() {
    	String pagename=driver.findElement(NameOfThePage).getText();
    	return pagename;
    }
    
    public String timeToWork() {
    	String pagename=driver.findElement(TimeToWork).getText();
    	return pagename;
    	
    }
    
    public void getEmployeeImage() throws IOException {
		String path=System.getProperty("user.dir")+File.separator+"screenshot";
		//Create folder if missing
		File directory=new File(path);
		if(!directory.exists()) {
			directory.mkdirs();
		}
    	WebElement employeeimg=driver.findElement(employeeimage);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File(path+File.separator+"employeeimg.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }
    
    public void timeToWorkBoxImg() throws IOException {
		String path=System.getProperty("user.dir")+File.separator+"screenshot";
		//Create folder if missing
		File directory=new File(path);
		if(!directory.exists()) {
			directory.mkdirs();
		}
    	WebElement employeeimg=driver.findElement(TimetoworkBox);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File(path+File.separator+"timetoworkbox.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }


    public String clockIconClick() {
    	driver.findElement(Clockimage).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }

    public void myActionsBoximg() throws IOException {
		String path=System.getProperty("User.dir")+File.separator+"screenshot";
		//Create folder if missing
		File directory=new File(path);
		if(!directory.exists()) {
			directory.mkdirs();
		}
    	WebElement employeeimg=driver.findElement(MyActionsBox);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File(path+File.separator+"myactionboximg.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }


    public String myNotification() {
    	driver.findElement(MyActionNotification).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String buzPage() {
    	driver.findElement(Buzpage).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String helpIconClick() {
    	driver.findElement(Helpicon).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public void quickLunchBoxImg() throws IOException {
		String path=System.getProperty("user.dir")+File.separator+"screenshot";
		//Create folder if missing
		File directory=new File(path);
		if(!directory.exists()) {	
			directory.mkdirs();
		}
    	WebElement employeeimg=driver.findElement(QuickLunchBox);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File(path+File.separator+"Quicklunchboximg.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }
    
    public String assignLeaveClick() {
    	driver.findElement(AssignLeave).click();
    	String pageurl=driver.getTitle();
    	return pageurl;
    	
    }
    
    public void back() {
    	
    	driver.navigate().back();
    }
    
    public String leaveListClick() {
    	driver.findElement(LeaveList).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String timesheetClicking() {
    	driver.findElement(Timesheets).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String applyLeaveClicking() {
    	driver.findElement(ApplyLeave).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String myLeave() {
    	driver.findElement(MyLeave).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String myTimeSheet() {
    	driver.findElement(MyTimesheet).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public void buzlaTestPostBoxImg() throws IOException {
    String path = System.getProperty("user.dir") + File.separator + "screenshot";
    // Create folder if missing
    File directory = new File(path);
    if (!directory.exists()) {
        directory.mkdirs();
    }
    WebElement employeeImg = driver.findElement(BuzzLatestPostsbox);
    File screenshot = employeeImg.getScreenshotAs(OutputType.FILE);
    File destination = new File(path + File.separator + "BUZkbox.png");
    FileUtils.copyFile(screenshot, destination);
}

    
    public void employeeLeaveSettingIcon() {
    	
    	driver.findElement(EployeeLeaveSettingivon).click();
    	
     }
    
    public void employeeLeaveCheckbox() {
    	
    	driver.findElement(Employerleavecheckbox).click();
    	
     }
    
   public void employeeLeaveCancel() {
    	
    	driver.findElement(Employeeleavecancel).click();
    	
     }
   
   public void employeeLeaveClose() {
   	
   	driver.findElement(Employeeleavecloseicon).click();
   	
    }
   
   public void employeeLeaveSave() {
	   	
	   	driver.findElement(Employeeleavesave).click();
	   	
	    }
   
   public void humanresoureClicking() {
	   	
	   	driver.findElement(HumanResource).click();
	   	
	    }
   
   public void engineeringClicking() {
	   	
	   	driver.findElement(Engineering).click();
	   	
	    }
   
   public void unassignedClicking() {
	   	
	   	driver.findElement(Unassigned).click();
	   	
	    }
   
   public static void pageScreenshot(RemoteWebDriver driver, String imagename) throws IOException {

    // Create folder: <project>/screenshot/
    String folderPath = System.getProperty("user.dir") 
                        + File.separator + "screenshot";

    File directory = new File(folderPath);
    if (!directory.exists()) {
        directory.mkdirs();
    }

    // Ensure .png extension
    if (!imagename.endsWith(".png")) {
        imagename += ".png";
    }

    // Take screenshot
    TakesScreenshot ts = (TakesScreenshot) driver;
    File screenshot = ts.getScreenshotAs(OutputType.FILE);

    // FIXED: Correct destination path
    File destination = new File(folderPath + File.separator + imagename);

    FileUtils.copyFile(screenshot, destination);
}

   
   public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(300, 500);");

	}


}
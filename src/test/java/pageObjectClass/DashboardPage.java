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
    
    public String Adminmenuverify() {
    	driver.findElement(Adminmenu).click();
    	String Adminpage=driver.getCurrentUrl();
    	return Adminpage;
    }
	
    public String NameofthePageGet() {
    	String pagename=driver.findElement(NameOfThePage).getText();
    	return pagename;
    }
    
    public String timetowork() {
    	String pagename=driver.findElement(TimeToWork).getText();
    	return pagename;
    	
    }
    
    public void getemployeeimage() throws IOException {
    	WebElement employeeimg=driver.findElement(employeeimage);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File("C:\\Users\\xmedia\\eclipse-workspace\\Automation\\screenshots2\\employeeimg.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }
    
    public void timetoworkboximg() throws IOException {
    	WebElement employeeimg=driver.findElement(TimetoworkBox);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File("C:\\Users\\xmedia\\eclipse-workspace\\Automation\\screenshots2\\timetoworkbox.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }


    public String clockiconclicking() {
    	driver.findElement(Clockimage).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }

    public void MyActionsBoximg() throws IOException {
    	WebElement employeeimg=driver.findElement(MyActionsBox);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File("C:\\Users\\xmedia\\eclipse-workspace\\Automation\\screenshots2\\myactionboximg.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }


    public String Mynotification() {
    	driver.findElement(MyActionNotification).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String Buzpage1() {
    	driver.findElement(Buzpage).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String helpiconclic() {
    	driver.findElement(Helpicon).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public void QuicklunchBoximg() throws IOException {
    	WebElement employeeimg=driver.findElement(QuickLunchBox);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File("C:\\Users\\xmedia\\eclipse-workspace\\Automation\\screenshots2\\Quicklunchboximg.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
      }
    
    public String Assignleaveclick() {
    	driver.findElement(AssignLeave).click();
    	String pageurl=driver.getTitle();
    	return pageurl;
    	
    }
    
    public void Back() {
    	
    	driver.navigate().back();
    }
    
    public String Leavelistclick() {
    	driver.findElement(LeaveList).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String Timesheetclicing() {
    	driver.findElement(Timesheets).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String ApplyLeaveclicking() {
    	driver.findElement(ApplyLeave).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String MyLeave() {
    	driver.findElement(MyLeave).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public String MyTimeSheet() {
    	driver.findElement(MyTimesheet).click();
    	String pageurl=driver.getCurrentUrl();
    	return pageurl;
    	
    }
    
    public void BUZlatestpostnoximg() throws IOException {
    	WebElement employeeimg=driver.findElement(BuzzLatestPostsbox);
    	File ScrrenShot=employeeimg.getScreenshotAs(OutputType.FILE);
    	File Destination=new File("C:\\Users\\xmedia\\eclipse-workspace\\Automation\\screenshots2\\BUZkbox.png");
    	FileUtils.copyFile(ScrrenShot, Destination);
    	
     }
    
    public void employeeleavesettingicon() {
    	
    	driver.findElement(EployeeLeaveSettingivon).click();
    	
     }
    
    public void employeeleavecheckbox() {
    	
    	driver.findElement(Employerleavecheckbox).click();
    	
     }
    
   public void employeeleavecancel() {
    	
    	driver.findElement(Employeeleavecancel).click();
    	
     }
   
   public void employeeleaveclose() {
   	
   	driver.findElement(Employeeleavecloseicon).click();
   	
    }
   
   public void employeeleavesave() {
	   	
	   	driver.findElement(Employeeleavesave).click();
	   	
	    }
   
   public void Humanresoureclicking() {
	   	
	   	driver.findElement(HumanResource).click();
	   	
	    }
   
   public void Engineeringclicking() {
	   	
	   	driver.findElement(Engineering).click();
	   	
	    }
   
   public void unassignedclicking() {
	   	
	   	driver.findElement(Unassigned).click();
	   	
	    }
   
   public static void pageScreenshot(RemoteWebDriver driver,  String imagename) throws IOException {
	   TakesScreenshot ts = (TakesScreenshot) driver;
	   File screenshot = ts.getScreenshotAs(OutputType.FILE);
	   File destination = new File("C:\\Users\\xmedia\\eclipse-workspace\\Automation\\screenshots2\\"+imagename);
	   FileUtils.copyFile(screenshot, destination);

   } 
   
   public void Scrollpage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(300, 500);");

	}

   
   

}
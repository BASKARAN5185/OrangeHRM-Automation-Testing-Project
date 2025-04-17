package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static RemoteWebDriver driver;

	@BeforeClass
	public void openTheBrowser() {
		System.setProperty("Webdriver.chrome.driver",
				"C:\\Users\\xmedia\\Downloads\\chromedriver-win64\\chromedriver-win64.exe");
		ChromeOptions options = new ChromeOptions();
		
		// Example 1: Run Chrome in Headless mode
		//options.addArguments("--headless"); // Run Chrome in headless mode (no GUI)
		// options.addArguments("--disable-gpu"); // Disable GPU acceleration (important for headless mode)

		// Example 3: Open Chrome in Incognito Mode
		options.addArguments("--incognito");

		// Example 4: Disable Browser Notifications
		options.addArguments("--disable-notifications");
		
		// Example 6: Set the Window Size
        options.addArguments("window-size=1200x600");

        // Example 7: Disable Chrome Extensions
        options.addArguments("--disable-extensions");


		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@AfterClass
	void teardown() {
		driver.close();
	}

	public String captureScreen(String testName) throws IOException {
		// Take the screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Define the directory where screenshots will be stored
		String screenshotDirectory = "C:\\Users\\xmedia\\Desktop\\Automation Test Report\\Screenshots\\" + testName;

		// Create a new directory if it does not exist
		File directory = new File(screenshotDirectory);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		// Define the file path for the screenshot
		String filePath = screenshotDirectory + "\\screenshot.png";
		File destination = new File(filePath);

		// Copy the screenshot to the destination path
		FileHandler.copy(screenshot, destination);

		return destination.getAbsolutePath(); // Return the path to the screenshot
	}

	public String getCurrentUrlpage() {
		String LoginUrl = driver.getCurrentUrl();
		return LoginUrl;

	}

	public void NavigateBack() {

		driver.navigate().back();

	}

	public void PageRefresh() {

		driver.navigate().refresh();

	}
}

package baseClass;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    protected RemoteWebDriver driver;

    @BeforeClass
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
       // options.addArguments("--headless=new");    
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("window-size=1200x600");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-features=IsolateOrigins,site-per-process");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreenshot(String testName) throws IOException {
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    String screenshotDirectory =
        "C:\\Users\\xmedia\\Desktop\\AutomationTestReport\\Screenshots\\";

    File directory = new File(screenshotDirectory);
    if (!directory.exists()) {
        directory.mkdirs();
    }

    String filePath = screenshotDirectory + testName + "_" + System.currentTimeMillis() + ".png";
    File destination = new File(filePath);
    FileUtils.copyFile(screenshot, destination);

    return filePath;
}

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public WebElement stringsWebElement(String name){
        return driver.findElement(By.xpath("//*[text()='"+name+"']"));
    }

    public void validateBrokenLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Link is null or empty: " + link.getText());
                continue;
            }

            if (!url.startsWith("http")) {
                System.out.println("Skipping non-http link: " + url);
                continue;
            }

            try {
                HttpURLConnection connection =
                    (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int statusCode = connection.getResponseCode();
                if (statusCode >= 400) {
                    System.out.println("Broken link: " + url + " | Status code: " + statusCode);
                } else {
                    System.out.println("Valid link: " + url + " | Status code: " + statusCode);
                }
            } catch (Exception e) {
                System.out.println("Error checking link: " + url + " | Exception: " + e.getMessage());
            }
        }
    }
}

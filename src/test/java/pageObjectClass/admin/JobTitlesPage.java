package pageObjectClass.admin;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobTitlesPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public JobTitlesPage(RemoteWebDriver driver){
         this.driver=driver;
         wait=new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    private final By pageOfTitle=By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title");
    private final By jobTitleAddButton=By.xpath("//button[text()=' Add ']");
    private final By recordsFound=By.className("orangehrm-horizontal-padding orangehrm-vertical-padding");
    private final By jobTitleNames=By.xpath("//div[@role='row']//div[@class='data']");
    private final By deleteIcon=By.className("oxd-icon bi-trash");
    private final By editIcon=By.className("oxd-icon bi-pencil-fill");
}

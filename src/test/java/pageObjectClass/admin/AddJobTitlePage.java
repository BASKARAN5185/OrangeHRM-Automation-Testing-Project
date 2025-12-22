package pageObjectClass.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AddJobTitlePage {
     
    private RemoteWebDriver driver;

    public AddJobTitlePage(RemoteWebDriver driver){
        this.driver=driver;
    }

    // Add Title Page Locators
    By pageOfTitle=By.xpath("//h6[text()='Add Job Title']");
    By jobTiltle=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By description=By.xpath("//textarea[@placeholder='Type description here']");
}

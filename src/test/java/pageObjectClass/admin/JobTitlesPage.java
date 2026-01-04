package pageObjectClass.admin;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public String verifyThePageTitle(){
        String pagename = "";
        try {
           WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(pageOfTitle));
           pagename= title.getText();
        } catch (Exception e) {
          System.err.println("Filed to Retrive the page title"+e.getMessage());
        }
        return pagename;
    }

    public boolean jobTitlePageAddButtonClick(){
      WebElement addButtoElement=wait.until(ExpectedConditions.elementToBeClickable(jobTitleAddButton));
      addButtoElement.click();
      return true;
    }

    public int getNumberOfRecordsFound(){
        String recocrdString=driver.findElement(recordsFound).getText().trim().replaceAll("[^0-9]", "");
        return Integer.parseInt(recocrdString);
    }

    public boolean verifyParticularJobTitlePresent(String jobString){
      if (jobString==null) return false;
      try {
        return  getJobTitleAllNameStrings().stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .anyMatch(title -> title.contains(jobString));
      } catch (Exception e) {
        System.out.println("Finding Job tilte happen to error occur "+e.getMessage());
        return false;
      }
    }
     
    public void deleteParticularJobTitle(String jobString){
      List<String> titlesStrings=getJobTitleAllNameStrings();
      String target=jobString.trim();

      for(int i=0;i<titlesStrings.size();i++){
        if (titlesStrings.get(i).contains(target)) {
          try {
           deleteIconWebElement().get(i).click();
            System.out.println("Success Fully Deleted"+target);  
          } catch (Exception e) {
            System.out.println("Error occcur the clicking actions"+target);
          }
        }
      }
      System.out.println("Job Title target : "+target+" not found in the page");
  }

    // helper methods
    private List<String> getJobTitleAllNameStrings(){
       List<String> allNames = new ArrayList<>();
       List<WebElement> titleElements= driver.findElements(jobTitleNames);
       int sizeOFTitle=titleElements.size();
       for(int i=sizeOFTitle; i >= 0;--i){
           String name=titleElements.get(i).getText().trim();
           allNames.add(name);
       }
       return allNames;
    }

    public List<WebElement> deleteIconWebElement(){
       List<WebElement> iconElement =driver.findElements(deleteIcon);
        return iconElement;
    }

}

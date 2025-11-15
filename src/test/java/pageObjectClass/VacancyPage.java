package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class VacancyPage {
    private RemoteWebDriver driver;
    
    public VacancyPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    // Vacancies Page Locators
	private By vacanciesTitle = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	private By vacanciesVacancy = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	private By vacanciesHiringManager = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
	private By vacanciesStatus = By.xpath("(//div[@class='oxd-select-text-input'])[4]");
	private By vacanciesResetButton = By.xpath("//button[contains(.,'Reset')]");
	private By vacanciesSearchButton = By.xpath("//button[contains(.,'Search')]");
	private By vacanciesAddButton = By.xpath("//button[contains(.,'Add')]");
}

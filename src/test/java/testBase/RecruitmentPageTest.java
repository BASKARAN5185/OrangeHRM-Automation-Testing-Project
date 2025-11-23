package testBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;
import pageObjectClass.RecruitmentPage;

public class RecruitmentPageTest extends BaseClass {
    RecruitmentPage rec;
	OrangeHRMLoginPage lg;
	SoftAssert soft;

	@BeforeClass
	public void setup() {
	rec = new RecruitmentPage(driver);
    lg = new OrangeHRMLoginPage(driver);
	soft = new SoftAssert();
	}
	@Test(groups = { "smoke", "regression" }, priority = 1)
	void loginWithRecruitmentMenuClick() {
		lg.login();
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("/dashboard"), "Login to Application failed");
		String getUrl = rec.requirementMenuClick();
		assertTrue(getUrl.contains("/viewCandidates"), "Recruitment Page navigation failed");
	}

	@Test(dependsOnMethods = "loginWithRecruitmentMenuClick", groups = { "smoke", "regression" }, priority = 2)
	void candidateHeaderClick() {
		String getUrl = rec.headersMenus("candidates");
		assertTrue(getUrl.contains("/viewCandidates"), "Recruitment Page navigation failed");
	}

	@Test(dependsOnMethods = "candidateHeaderClick", groups = { "regression", "sanity" }, priority = 3)
	void candidateVacancyFromDropdownOptionSelection() {
		soft.assertEquals("Automaton Tester", rec.candidateJobTitleSelection("Automaton Tester"),
				"The selected job title option is wrong");
		soft.assertEquals("Junior Account Assistant", rec.vacancySelection("Junior Account Assistant"),
				"The selected vacancy option is wrong");
		soft.assertEquals("Interview Scheduled", rec.statusSelection("Interview Scheduled"),
				"The selected status option is wrong");
		soft.assertAll();
	}

	@Test(groups = { "smoke", "sanity" }, priority = 4)
	void candidateNameEnter() {
		String getEnterName = rec.candidateNameEnter("Guna");
		assertEquals("Guna", getEnterName, "Entered Name is wrong");
	}

	@Test(groups = { "smoke", "regression" }, priority = 5)
	void candidateKeywordEnter() {
		assertEquals("Java", rec.keywordEnter("Java"), "Keyword is wrong");
	}

	@Test(groups = { "sanity" }, priority = 6)
	void candidateApplicationFromAndToDateEnter() {
		assertEquals("20-09-2025", rec.candidateApplicationFromDatePickup("20-09-2025"), "From Date is wrong");
		assertEquals("21-09-2025", rec.candidateApplicationFromDatePickup("21-09-2025"), "To Date is wrong");
	}

	@Test(groups = { "regression" }, priority = 7)
	void methodOfApplicationSelection() {
		assertEquals("Manual", rec.methodOfApplicationSelection("Manual"), "Method of Application selected is wrong");
	}

	@Test(groups = { "sanity" }, priority = 8)
	void searchButtonClick() {
		assertEquals("search", rec.requirmentPageButtons("serach"), "Search Button is not clicked");

	}
	
	@Test(groups = { "sanity" }, priority = 8)
	void addButtonClick() {
		assertEquals("add", rec.requirmentPageButtons("add"), "add Button is not clicked");

	}
	
	@Test(groups = { "sanity" }, priority = 8)
	void resetButtonClick() {
		assertEquals("reset", rec.requirmentPageButtons("reset"), "reset Button is not clicked");

	}
}

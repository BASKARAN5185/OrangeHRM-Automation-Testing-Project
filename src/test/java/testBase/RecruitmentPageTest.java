package testBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;
import pageObjectClass.OrangeHRMLoginPage;
import pageObjectClass.RecruitmentPage;

public class RecruitmentPageTest extends BaseClass {

	RecruitmentPage rec = new RecruitmentPage(driver);
	OrangeHRMLoginPage lg = new OrangeHRMLoginPage(driver);
	SoftAssert soft = new SoftAssert();

	@Test(groups = { "smoke", "regression" })
	void loginWithRecruitmentMenuClick() {
		lg.login("Admin", "admin123");
		String url = getCurrentUrlpage();
		assertTrue(url.contains("/dashboard"), "Login the Appication is Failed");
		String getUrl = rec.requirementMenuClick();
		assertTrue(getUrl.contains("/viewCandidates"), "Recruitment Page navigation is failed");
	}

	@Test(dependsOnMethods = "loginWithRecruitmentMenuClick", groups = { "smoke", "regression" })
	void candidateHeaderClick() {
		String getUrl = rec.headersMenus("candidates");
		assertTrue(getUrl.contains("/viewCandidates"), "Recruitment Page navigation is failed");
	}

	@Test(dependsOnMethods = "candidateHeaderClick", groups = { "regression", "sanity" })
	void candidateVacanyfromdropdownoptionslection() {
		soft.assertEquals("Automaton Tester", rec.candidateJobTitleSelection("Automaton Tester"),
				"The selected in wrong job title option");
		soft.assertEquals("Junior Account Assistant", rec.vacancySelection("Junior Account Assistant"),
				"The selected in wrong vacancy option");
		assertEquals(("Salma Reyes"), rec.hiringManagerSelection("Salma Reyes"),
				"The selected in wrong hiring manager name option");
		soft.assertEquals("Interview Scheduled", rec.statusSelection("Interview Scheduled"),
				"the selected in wrong status option");
		soft.assertAll();
	}

}

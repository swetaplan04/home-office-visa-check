package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {

    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ResultPage resultPage;
    ReasonForTravelPage reasonForTravelPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    DurationOfStayPage durationOfStayPage;
    WorkTypePage workTypePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        resultPage = new ResultPage();
        reasonForTravelPage = new ReasonForTravelPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        durationOfStayPage = new DurationOfStayPage();
        workTypePage = new WorkTypePage();
    }

    @Test(groups = {"smoke","sanity","regression"})
    public void anAustralianComingToUKForTourism() {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        reasonForTravelPage.clickNextStepButton();
        resultPage.getResultMessage();
    }

    @Test(groups = {"regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        reasonForTravelPage.clickNextStepButton();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType("Health and care professional");
        workTypePage.clickNextStepButton();
        resultPage.getResultMessage();
    }

    @Test(groups = {"smoke","regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Colombia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        reasonForTravelPage.clickNextStepButton();
        familyImmigrationStatusPage.selectImmigrationStatus("Yes");
        familyImmigrationStatusPage.clickNextStepButton();
        resultPage.getResultMessage();
    }
}


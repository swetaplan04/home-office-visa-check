package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class FamilyImmigrationStatusPage extends Utility {

    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> immigrationStatus;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;


    public void selectImmigrationStatus(String status) {
        for (WebElement menu : immigrationStatus) {
            if (menu.getText().equals(status)) {
                clickOnElement(menu);
                CustomListeners.test.log(Status.PASS, "Select immiguration status: '" + status + "' radio button");
                Reporter.log("Select immiguration status '" + status + "' radio button <br>");
                break;
            }
        }
    }

    public void clickNextStepButton() {
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on next step");
        Reporter.log("Click on next step" + "<br>");

    }
}


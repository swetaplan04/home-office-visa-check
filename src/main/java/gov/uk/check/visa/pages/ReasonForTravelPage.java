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

public class ReasonForTravelPage extends Utility {

    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> needUKVisa;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    public void selectReasonForVisit(String reason) {
        for (WebElement menu : needUKVisa) {
            if (menu.getText().equals(reason)) {
                clickOnElement(menu);
                CustomListeners.test.log(Status.PASS, "Select reason for visit '" + reason + "' tab");
                Reporter.log("Select reason for visit '" + reason + "' tab <br>");
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


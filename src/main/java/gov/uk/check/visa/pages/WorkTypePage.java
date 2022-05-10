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

public class WorkTypePage extends Utility {

    public WorkTypePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> jobType;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    public void selectJobType(String job) {
        for (WebElement menu : jobType) {
            if (menu.getText().equals(job)) {
                clickOnElement(menu);
                CustomListeners.test.log(Status.PASS, "Select Job Type '" + job + "' tab");
                Reporter.log("Select Job type '" + job + "' tab <br>");
                break;
            }
        }
    }

    public void clickNextStepButton() {
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
        Reporter.log("Click on continue button " + "<br>");
    }

}


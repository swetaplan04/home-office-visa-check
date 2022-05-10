package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {

    public ResultPage() {
        PageFactory.initElements(driver, this);}

    @CacheLookup
    @FindBy(xpath = "//*[@id='result-info']/div[2]/h2")
    WebElement getMessage;


    public String getResultMessage() {

        String result = getTextFromElement(getMessage);
        return result;
    }

    public void verifyIfResultMessage(String expMsg) {
        if (getResultMessage().equalsIgnoreCase(expMsg)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        CustomListeners.test.log(Status.PASS, "Confirm message displayed : " + getMessage.getText());
        Reporter.log("Confirm message displayed : " + getMessage.getText() + "<br>");
    }
}


package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {

    public SelectNationalityPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement findNationality;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;



    public void selectNationality(String nationality){
        selectByVisibleTextFromDropDown(findNationality, nationality);
        CustomListeners.test.log(Status.PASS, "Select nationality '" + nationality + "' tab");
        Reporter.log("Select nationality '" + nationality + "' tab <br>");
    }

    public void clickNextStepButton(){
        clickOnElement(nextStepButton);
        CustomListeners.test.log(Status.PASS, "Click on next step");
        Reporter.log("Click on next step" + "<br>");
    }
}


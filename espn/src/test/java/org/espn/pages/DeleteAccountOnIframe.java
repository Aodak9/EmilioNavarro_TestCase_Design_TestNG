package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountOnIframe extends WebOperations {
    @FindBy(css = "#Title > span")
    private WebElement areYouSureLabel;

    @FindBy(css = ".form-section > #BtnSubmit")
    private WebElement deletingConfirmButton;

    @FindBy(css = ".form-section > #BtnCancel")
    private WebElement keepAccountButton;

    public DeleteAccountOnIframe(WebDriver driver) {
        super(driver);
    }

    public String getSureMessage() {
        if (isElementDisplayed(areYouSureLabel) &&
                isElementDisplayed(deletingConfirmButton) &&
                isElementDisplayed(keepAccountButton)) {
            return areYouSureLabel.getText();
        }
        return "";
    }

    public void executeClickOnDeleteConfirmationButton(){
        super.clickElement(deletingConfirmButton);
    }
}

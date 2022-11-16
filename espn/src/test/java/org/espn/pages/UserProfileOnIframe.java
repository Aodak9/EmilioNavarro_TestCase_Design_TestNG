package org.espn.pages;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfileOnIframe extends WebOperations {

    @FindBy(css = "#Title > span")
    private WebElement userUpdateAccountLabel;

    @FindBy(css = "#AccountDeleteLink")
    private WebElement deleteLink;

    public UserProfileOnIframe(WebDriver driver) {
        super(driver);
    }

    public DeleteAccountOnIframe executeClickOnDeleteButton(){
        isElementDisplayed(userUpdateAccountLabel);
        super.clickElement(deleteLink);
        return new DeleteAccountOnIframe(super.getDriver());
    }
}

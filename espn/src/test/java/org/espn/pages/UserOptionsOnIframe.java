package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserOptionsOnIframe extends WebOperations{
    @FindBy(css = ".display-user")
    private WebElement userLabelOffline;

    @FindBy(css = ".display-user span")
    private WebElement userLabelOnline;

    @FindBy(css = "a[tref$='login']")
    private WebElement loginButton;

    @FindBy(css = "ul.account-management li:nth-child(5)")
    private WebElement espnProfileButton;

    @FindBy(css = "ul.account-management li:nth-child(9)")
    private WebElement logoutButton;

    @FindBy(id = "oneid-iframe")
    private WebElement iframe;




    public UserOptionsOnIframe(WebDriver driver) {
        super(driver);
    }

    private void switchToIframe(){
        isElementDisplayed(iframe);
        super.getDriver().switchTo().frame(iframe);
    }

    public LoginOnIframe executeClickOnLoginButton(){
        super.clickElement(loginButton);
        switchToIframe();
        return new LoginOnIframe(super.getDriver());
    }

    public void executeClickOnLogOutButton(){
        super.clickElement(logoutButton);
    }

    public boolean userOffline(){
        return isElementDisplayed(userLabelOffline) && isElementDisplayed(loginButton);
    }
    public String getUsernameLogged(){
        if(isElementDisplayed(userLabelOnline)){
            return userLabelOnline.getText();
        }

        return "";
    }
    public UserProfileOnIframe executeClickOnEspnProfileButton(){
        super.clickElement(espnProfileButton);
        switchToIframe();
        return new UserProfileOnIframe(super.getDriver());
    }


}

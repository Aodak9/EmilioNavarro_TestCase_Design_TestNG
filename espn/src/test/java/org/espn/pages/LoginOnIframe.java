package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOnIframe extends WebOperations {
    @FindBy(id = "logo")
    private WebElement espnLogoIframe;

    @FindBy(id = "InputLoginValue")
    private WebElement emailInputIframe;

    @FindBy(id = "InputPassword")
    private WebElement passwordInputIframe;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButtonIframe;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButtonIframe;

    @FindBy(id = "oneid-iframe")
    private WebElement iframe;

    @FindBy(css = "#Title > span")
    private WebElement accountDeactivatedSpan;

    @FindBy(css = "#TextBlock > strong")
    private WebElement emailAccountDeactivated;


    public LoginOnIframe(WebDriver driver) {
        super(driver);
    }

    public boolean loginFormElementsDisplayed(){
        return isElementDisplayed(espnLogoIframe) && isElementDisplayed(emailInputIframe) && isElementDisplayed(passwordInputIframe) && isElementDisplayed(loginButtonIframe) && isElementDisplayed(signUpButtonIframe);
    }

    public void typeOnEmailInput(String text) {
        super.typeOnInput(this.emailInputIframe, text);
    }

    public void typeOnPasswordInput(String text) {
        super.typeOnInput(this.passwordInputIframe, text);
    }

    public void clickOnLoginButtonIframe() {
        super.clickElement(this.loginButtonIframe);
    }

    public SignUpOnIframe executeClickOnSignUpButton(){
        super.clickElement(signUpButtonIframe);
        return new SignUpOnIframe(super.getDriver());
    }

    public String emailDeactivated(){
        if(isElementDisplayed(accountDeactivatedSpan) && isElementDisplayed(emailAccountDeactivated)){
            return emailAccountDeactivated.getText();
        }
        return "";
    }
}

package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpOnIframe extends WebOperations {

    @FindBy(id = "InputFirstName")
    private WebElement firstNameInputSingUpIframe;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInputSingUpIframe;

    @FindBy(id = "InputEmail")
    private WebElement emailInputSingUpFormIframe;

    @FindBy(id = "password-new")
    private WebElement passwordInputSingUpIframe;

    @FindBy(id = "BtnSubmit")
    private WebElement singUpButtonIframe;

    public SignUpOnIframe(WebDriver driver) {
        super(driver);
    }

    public void typeOnFirstNameInput(String text) {
        super.typeOnInput(this.firstNameInputSingUpIframe, text);
    }

    public void typeOnLastNameInput(String text) {
        super.typeOnInput(this.lastNameInputSingUpIframe, text);
    }

    public void typeOnEmailInputForSignUp(String text) {
        super.typeOnInput(this.emailInputSingUpFormIframe, text);
    }

    public void typeOnPasswordInputForSignUp(String text) {
        super.typeOnInput(this.passwordInputSingUpIframe, text);
    }

    public void signUpButtonSubmitForm() {
        super.clickElement(this.singUpButtonIframe);
    }


}


package org.espn.tests;


import org.espn.configuration.Driver;
import org.espn.pages.*;
import org.espn.reporting.Reporter;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class UserDeleteAccount extends BaseTest {

    @Test(priority = 4)
    public void createNewAccountToDeactivate(){
        setEmail();
        navigationBar.closeBanner();
        UserOptionsOnIframe userOptionsOnIframe = navigationBar.clickOnUserOptions();
        LoginOnIframe loginOnIframe = userOptionsOnIframe.executeClickOnLoginButton();
        SignUpOnIframe signUpOnIframe = loginOnIframe.executeClickOnSignUpButton();
        signUpOnIframe.typeOnFirstNameInput(USER);
        signUpOnIframe.typeOnLastNameInput(USER);
        signUpOnIframe.typeOnEmailInputForSignUp(email);
        signUpOnIframe.typeOnPasswordInputForSignUp(PASSWORD);
        signUpOnIframe.signUpButtonSubmitForm();
        userOptionsOnIframe = navigationBar.clickOnUserOptions();
        userOptionsOnIframe.executeClickOnLogOutButton();
        userOptionsOnIframe.reloadPage();
    }

    @Test(priority = 5)
    public void deactivateUser(){
        UserOptionsOnIframe userOptionsOnIframe = super.navigationBar.clickOnUserOptions();
        LoginOnIframe loginOnIframe = userOptionsOnIframe.executeClickOnLoginButton();
        loginOnIframe.typeOnEmailInput(email);
        loginOnIframe.typeOnPasswordInput(PASSWORD);
        loginOnIframe.clickOnLoginButtonIframe();
        userOptionsOnIframe = super.navigationBar.clickOnUserOptions();
        UserProfileOnIframe userProfileOnIframe = userOptionsOnIframe.executeClickOnEspnProfileButton();
        DeleteAccountOnIframe deleteAccountOnIframe = userProfileOnIframe.executeClickOnDeleteButton();
        checkThat("Modal for confirm account delete is present", deleteAccountOnIframe.getSureMessage(), is(true));
        deleteAccountOnIframe.executeClickOnDeleteConfirmationButton();
        deleteAccountOnIframe.reloadPage();
        userOptionsOnIframe = super.navigationBar.clickOnUserOptions();
        userOptionsOnIframe.executeClickOnLogOutButton();
        userOptionsOnIframe.reloadPage();
    }

    @Test(priority = 6)
    public void confirmationUserAccountDeleted(){
        UserOptionsOnIframe userOptionsOnIframe = super.navigationBar.clickOnUserOptions();
        LoginOnIframe loginOnIframe = userOptionsOnIframe.executeClickOnLoginButton();
        loginOnIframe.typeOnEmailInput(email);
        loginOnIframe.typeOnPasswordInput(PASSWORD);
        loginOnIframe.clickOnLoginButtonIframe();
        checkThat("user is deactivated", loginOnIframe.emailDeactivated(), is(true));
    }
}

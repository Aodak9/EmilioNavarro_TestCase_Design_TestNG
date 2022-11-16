package org.espn.tests;

import org.espn.configuration.Driver;
import org.espn.pages.LoginOnIframe;
import org.espn.pages.NavigationBar;
import org.espn.pages.SignUpOnIframe;
import org.espn.pages.UserOptionsOnIframe;
import org.espn.reporting.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;
import static org.hamcrest.Matchers.is;

public class BaseTest {
    private Driver driver;
    protected NavigationBar navigationBar;

    protected final String USER = "User";
    protected static String email;
    protected final String PASSWORD = "Hormiguita123";
    protected final String USER_WELCOME = "Welcome" + USER + "!";

    @BeforeSuite
    public void createAccount(){
        String BROWSER = "chrome";
        String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

        driver = new Driver(BROWSER);
        setEmail();
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + URL);
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        this.navigationBar = new NavigationBar(driver.getDriver());
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


    @BeforeClass
    public void classSetUp(){
        String BROWSER = "chrome";
        String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

        driver = new Driver(BROWSER);
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + URL);
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        this.navigationBar = new NavigationBar(driver.getDriver());
        navigationBar.closeBanner();
    }

    @AfterClass
    public void tearDown(){
        Reporter.info("Exit from driver");
        driver.getDriver().quit();
    }

    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue) {
        Reporter.info(format("Checking that " + description.toLowerCase() + " [Expectation: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e) {
            Reporter.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }

    public void setEmail() {
        int randomValue = (int)(Math.random() * 1000);
        email = "test.email.espn" + randomValue + "@gmail.com";
    }
}

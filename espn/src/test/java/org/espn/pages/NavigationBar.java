package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends WebOperations {

    @FindBy(id = "global-user-trigger")
    private WebElement userIconButton;

    @FindBy(css = ".container h1")
    private WebElement espnLogoIframe;

    @FindBy(css = ".pillar.watch")
    private WebElement watchLink;

    @FindBy(css = ".promo-banner-container iframe")
    private WebElement iframeBanner;

    @FindBy(css = "section.PromoBanner")
    private WebElement banner;

    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void clickOnUserButtonIframe() {
        super.clickElement(userIconButton);
    }

    public UserOptionsOnIframe clickOnUserOptions() {
        isElementDisplayed(espnLogoIframe);
        clickOnUserButtonIframe();
        return new UserOptionsOnIframe(super.getDriver());
    }

    public WatchPage ClickOnWatchPage() {
        super.clickElement(watchLink);
        return new WatchPage(super.getDriver());
    }

    public boolean verifyBannerIframe() {
        boolean isBanner = true;
        try {
            super.waitForPresenceOfElement(".promo-banner-container iframe");
        } catch (TimeoutException e) {
            isBanner = false;
        }
        return isBanner;
    }

    public void closeBanner() {
        if (this.verifyBannerIframe()) {
            super.getDriver().switchTo().frame(this.iframeBanner);
            super.clickElement(this.bannerCloseButton);
        }
    }
}

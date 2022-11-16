package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends WebOperations {
    @FindBy(css = "section.Carousel")
    private List<WebElement> carouselsContainer;

    @FindBy(css = "section[aria-labelledby^='bucket-40'] li")
    private List<WebElement> carouselCards;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement exitFromChooseSupplierBtn;
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean carouselsContainerDisplayed(){
        isElementDisplayed(carouselsContainer.get(0));
        return carouselsContainer.size() > 0;
    }

    public boolean carouselsCardsDisplayed(){
        isElementDisplayed(carouselCards.get(0));
        return carouselCards.size() > 0;
    }
    public boolean watchPageElementsDisplayed(){
      return carouselsContainerDisplayed() && carouselsCardsDisplayed();
    }

    public void clickOnSecondCardOfCarousel(){
        super.clickElement(carouselCards.get(1));
    }

    public boolean exitFromChooseSupplierButtonDisplayed(){
        return isElementDisplayed(exitFromChooseSupplierBtn);
    }

    public void navToBasePage(){
        super.goToPreviousPage();
    }
}

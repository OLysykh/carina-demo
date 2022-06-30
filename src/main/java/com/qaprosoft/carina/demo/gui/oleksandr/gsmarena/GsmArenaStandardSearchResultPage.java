package com.qaprosoft.carina.demo.gui.oleksandr.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.components.GsmHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class GsmArenaStandardSearchResultPage extends GsmArenaAbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class=\"top-bar clearfix\"]")
    private GsmHeader gsmHeader;

    @FindBy(xpath = "//div[@class=\"makers\"]//a")
    private ExtendedWebElement searchedPhone;

    @FindBy(xpath = "//h1[contains(text(),\"Search results\")]")
    private ExtendedWebElement searchResult;


    public GsmArenaStandardSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public GsmArenaStandardPhonePage toProceedtoSearchedPhonePage(){
        searchedPhone.click();
        return new GsmArenaStandardPhonePage(driver);
    }

    @Override
    public boolean isPageOpened() {
        return searchResult.isPresent();
    }
}


package com.qaprosoft.carina.demo.gui.oleksandr.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.components.GsmHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class GsmArenaStandardPhonePage extends GsmArenaAbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class=\"top-bar clearfix\"]")
    private GsmHeader gsmHeader;

    @FindBy(xpath = "//h1[@class = \"specs-phone-name-title\"]")
    private ExtendedWebElement phoneName;


    public GsmArenaStandardPhonePage(WebDriver driver) {
        super(driver);
    }

    public GsmHeader getGsmHeader() {
        return gsmHeader;
    }

    @Override
    public boolean isPageOpened() {
        return phoneName.isPresent();
    }
}




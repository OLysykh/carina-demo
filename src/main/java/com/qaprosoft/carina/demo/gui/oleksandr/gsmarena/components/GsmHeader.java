package com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.components;/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.GsmArenaHomePage;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.GsmArenaStandardSearchResultPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GsmHeader extends AbstractUIObject {

    @FindBy(xpath = ".//input[@ id = \"topsearch-text\"]")
//    @FindBy(xpath = "//div[@class=\"wrapper clearfix\"]//form[@action]//input[@ id = \"topsearch-text\"]")
    private ExtendedWebElement searchBarTextBox;

    @FindBy(xpath = ".//div[@id =\"logo\"]")
    // @FindBy(xpath = "//div[@class=\"wrapper clearfix\"]//div[@id =\"logo\"]")
    private ExtendedWebElement gsmArenaLogo;

    @FindBy(xpath = ".//button")
    // @FindBy(xpath = "//div[@class=\"wrapper clearfix\"]//div[@id =\"logo\"]")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = ".//ul[@ id =\"menu\"]//a")
    private List<ExtendedWebElement> dropDownHaburgerOptions;

//    @FindBy(linkText = "Home")
//    private ExtendedWebElement homeLink;

//    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
//    private ExtendedWebElement compareLink;
//
//    @FindBy(linkText = "News")
//    private ExtendedWebElement newsLink;

    public GsmHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getDropDownHaburgerOptions() {
        return dropDownHaburgerOptions;
    }

    public void enterTextToAsearchBox(String searchText) {
        searchBarTextBox.type(searchText);
    }

    public void pushEnterKeyOnSearchBarTextBox() {
        searchBarTextBox.sendKeys(Keys.ENTER);
    }

    public GsmArenaStandardSearchResultPage returnSearchPage() {
        searchBarTextBox.sendKeys(Keys.ENTER);
        return new GsmArenaStandardSearchResultPage(driver);
    }

    public GsmArenaHomePage returnToHomePageFromHeader() {
        gsmArenaLogo.click();
        return new GsmArenaHomePage(driver);
    }

    public void clickOnHamburgerButton(){
        hamburgerMenu.click();
    }
}

//    public GsmArenaSearchResultPage clickOnSearchButton (){
//        searchButton.click();
//        return new GsmArenaSearchResultPage(driver);
//    }

//    public GsmArenaSearchResultPage enterTextToAsearchBox(String searchText){
//        searchBarTextBox.type(searchText);
//        searchBarTextBox.sendKeys(Keys.ENTER);
//        return new GsmArenaSearchResultPage(driver);
//    }

//    public HomePage openHomePage() {
//        homeLink.click();
//        return new HomePage(driver);
//    }
//
//    public CompareModelsPage openComparePage() {
//        compareLink.click();
//        return new CompareModelsPage(driver);
//    }
//
//    public NewsPage openNewsPage() {
//        newsLink.click();
//        return new NewsPage(driver);
//    }


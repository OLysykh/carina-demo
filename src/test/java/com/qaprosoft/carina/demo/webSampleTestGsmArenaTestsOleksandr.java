package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.GsmArenaHomePage;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.GsmArenaStandardPhonePage;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.GsmArenaStandardSearchResultPage;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.enums.MobileBrands;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.enums.MobilePhones;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class webSampleTestGsmArenaTestsOleksandr implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isSpecificBrandisPresentedOnPage() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.isBrandPresentedInTheBrandList(MobileBrands.NOKIA.toString()), "Brand is not specified in the List");

    }

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void areAllBrandsPresentedsonPage() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.areAllBrandsPresented(), "Not all brands are presented on the Home Page");
    }

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isNothingPhoneitTopList() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.isSearchedPhoneInTop10List("Nothing phone (1)"), "Nope Nothing phone is not in a Top10 list");
    }

/* does not work. can`t figure out why i can`t click on href attribute
    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isNothingPhonePageExists() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.isSearchedPhoneInTop10List("Nothing phone (1)"), "Nope Nothing phone is not in a Top10 list");
        NothingPhonePage nothingPhonePage =  homePage.toOpenPageofTop10Phone("Nothing phone (1)");
        Assert.assertTrue(nothingPhonePage.isPageOpened());
    }
*/

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isNothingPhoneCanBeSearched() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getGsmHeader().enterTextToAsearchBox(MobilePhones.NOTHINGPHONE.getName());
        GsmArenaStandardSearchResultPage searchResultPage = homePage.getGsmHeader().returnSearchPage();
        Assert.assertTrue(searchResultPage.isPageOpened(), "Nope ");
    }

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isNothingPhonePageExists() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getGsmHeader().enterTextToAsearchBox(MobilePhones.NOTHINGPHONE.getName());
        GsmArenaStandardSearchResultPage searchResultPage = homePage.getGsmHeader().returnSearchPage();
        Assert.assertTrue(searchResultPage.isPageOpened(), "Nope ");
        GsmArenaStandardPhonePage phonePage = searchResultPage.toProceedtoSearchedPhonePage();
        Assert.assertTrue(phonePage.isPageOpened());
    }

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void canWeProceedfromPagetoHomePageUsingHeader() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getGsmHeader().enterTextToAsearchBox("pixel 6a");
        GsmArenaStandardSearchResultPage searchResultPage = homePage.getGsmHeader().returnSearchPage();
        Assert.assertTrue(searchResultPage.isPageOpened(), "Nope page is not open ");
        GsmArenaStandardPhonePage phonePage = searchResultPage.toProceedtoSearchedPhonePage();
        Assert.assertTrue(phonePage.isPageOpened());
        homePage = phonePage.getGsmHeader().returnToHomePageFromHeader();
        Assert.assertTrue(homePage.isPageOpened());
    }

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void areAllPhonesFromListHaveTheirOwnPages() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.areAllPhonesFromTheLIstHavePages(), "not all phones have pages");
    }

    @Test()
    @MethodOwner(owner = "o.lyssykh")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void areAllDefaultOptionsInHamburgerMenuAreAvailable() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        homePage.getGsmHeader().clickOnHamburgerButton();
        Assert.assertTrue(homePage.isAllFieldInBurgerMenuAreExisting());
    }





}





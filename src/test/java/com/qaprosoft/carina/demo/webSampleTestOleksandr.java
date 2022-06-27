package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.oleksandr.pages.CartPage;
import com.qaprosoft.carina.demo.gui.oleksandr.pages.HomePage;
import com.qaprosoft.carina.demo.gui.oleksandr.pages.ProductsPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class webSampleTestOleksandr implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Himars")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isElementsPositionsHomePageAreRight() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        // to check if HomePage is open
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        //to check what is higher ? login vs pass
        Assert.assertTrue(homePage.isUserNameAbovePassword(), "password is above username");
        //to check what is higher ? pass vs button
        Assert.assertTrue(homePage.isPasswordAboveLoginButton(), "password is below login button");
    }

    @Test()
    @MethodOwner(owner = "MLRS")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isProductCardContainsAllElements() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        // to check if HomePage is open
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        // to check if Product Page is open
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        Assert.assertTrue(productsPage.productFieldsCheck(), "Not all fields exist");
        Thread.sleep(1000);// for testing should be deleted
    }

    @Test()
    @MethodOwner(owner = "Harpoon")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isDropDownMenuContainsAllElements() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        //to check for compliance of option Menu Items with standard meanings
        Assert.assertTrue(productsPage.isAllFieldsFromOptionMenuExist(), "not all standard fields are existing");
    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isAnotherFilterFromOptionMenuCanBeChosen() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
        //to check default filter
        Assert.assertTrue(productsPage.isDefaultFilterIsAtoZ(), "Default filter iz not A to Z");
        Assert.assertTrue(productsPage.isAnotherFilterInOptionMenuCanBeChoosen(), "It is not possible to choose another filter from option Menu");
    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P5)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isProductAreSortedAtoZ() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
        //to check default filter
        Assert.assertTrue(productsPage.isDefaultFilterIsAtoZ(), "Default filter iz not A to Z");
        Assert.assertTrue(productsPage.isProductsAreFilteredAtoZ(), "Products are sorted not A to Z");
    }


    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P6)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isProductAreSortedZtoA() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
        //to check default filter
        Assert.assertTrue(productsPage.isZtoAFilteropened(), "Filter Z to A is not been chosen");
        Assert.assertTrue(productsPage.isProductsAreFilteredZtoA(), "Products are not sorted from Z to A");
    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isCartPageOpen() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
        CartPage cartPage = productsPage.proceedToCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart Page is not open");

    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isBackPackCanBeAddedToShopBag() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
        Assert.assertTrue(productsPage.isBackPackAddedtoShoppingBag(), "Nope not been added backpack!");
    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void IsBagPackinCartPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
        Assert.assertTrue(productsPage.isBackPackAddedtoShoppingBag(), "Nope not been added backpack!");
        CartPage cartPage = productsPage.proceedToCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart Page is not open");
        Assert.assertTrue(cartPage.isBagSpecifriedOnThePage(), "Bag is not on the Page");
    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void isAuthorizationFailed() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isAuthoriztionsFailed(), "You`ve passed authorization with bad username and password");

    }


}


//    @Test()
//    @MethodOwner(owner = "777")
//    @TestPriority(Priority.Px)
//    @TestLabel(name = "feature", value = {"web", "regression"})
//    public void productPageMenuListTest(){
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        ProductsPage productsPage = homePage.loginMethod();
////        Assert.assertTrue(productsPage.productPageCheck());
//        Assert.assertTrue(productsPage.productMenuBarCheck(), "Not all fields exist");
//    }


//    @Test()
//    @MethodOwner(owner = "Neptoon")
//    @TestPriority(Priority.P1)
//    @TestLabel(name = "feature", value = {"web", "regression"})
//    public void isBackpackCanBeRemovedFromShoppingBag() {
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
//        ProductsPage productsPage = homePage.loginMethod();
//        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
//        Assert.assertTrue(productsPage.isBackPackAddedtoShoppingBag(),"Nope not been added backpack!");
//        Assert.assertTrue(productsPage.isBackPackRTemovedFromSAhoppingBag(), "Nope it can`t be removed");



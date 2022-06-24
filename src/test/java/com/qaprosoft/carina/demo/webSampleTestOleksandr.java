package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
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
    public void homePageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        //to check what is higher ? login vs pass
        Assert.assertTrue(homePage.checkElementsLocation(homePage.getUserName(), homePage.getPassword()), "password is above username");
        //to check what is higher ? pass vs button
        Assert.assertTrue(homePage.checkElementsLocation(homePage.getPassword(), homePage.getLoginButton()), "password is below login button");
    }

    @Test()
    @MethodOwner(owner = "MLRS")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void productrPageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.productPageCheck());
        Assert.assertTrue(productsPage.productFieldsCheck(), "Not all fields exist");
    }

    @Test()
    @MethodOwner(owner = "Harpoon")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void productPageFilterMenuCheck() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.productPageCheck());
        Assert.assertTrue(productsPage.checkOptionElement(productsPage.getOptionNameAToZ()), "Nope no such element!");
        Assert.assertTrue(productsPage.checkOptionElement(productsPage.getOptionNameZToA()), "Nope no such element!");
        Assert.assertTrue(productsPage.checkOptionElement(productsPage.getOptionPriceHighToLow()), "Nope no such element!");
        Assert.assertTrue(productsPage.checkOptionElement(productsPage.getOptionPriceLowToHigh()), "Nope no such element!");
    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void productDefaultOprionCheck() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.productPageCheck());
        Assert.assertTrue(productsPage.checkDefaultTextInOption());
    }

    @Test()
    @MethodOwner(owner = "Neptoon")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void clickOnOPtionMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductsPage productsPage = homePage.loginMethod();
        Assert.assertTrue(productsPage.productPageCheck());
        Assert.assertTrue(productsPage.clickOnOptionMenu());
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




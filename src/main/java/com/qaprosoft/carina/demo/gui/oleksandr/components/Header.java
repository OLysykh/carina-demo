//package com.qaprosoft.carina.demo.gui.oleksandr.components;
//
//import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
//import com.qaprosoft.carina.core.gui.AbstractUIObject;
//import com.qaprosoft.carina.demo.gui.oleksandr.pages.CartPage;
//import org.openqa.selenium.SearchContext;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.invoke.MethodHandles;
//
//public class Header extends AbstractUIObject {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//    @FindBy(xpath = ".//a[@class=\"shopping_cart_link\"]")
//    private ExtendedWebElement toCart;
//
//
//    public Header(WebDriver driver, SearchContext searchContext) {
//        super(driver, searchContext);
//    }
//
//    public CartPage goToCartPage(){
//        toCart.click();
//        return new CartPage(driver);
//    }
//
//
//
//
//}

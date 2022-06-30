//package com.qaprosoft.carina.demo.gui.oleksandr.components;
//
//import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
//import com.qaprosoft.carina.core.gui.AbstractUIObject;
//import org.openqa.selenium.SearchContext;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.invoke.MethodHandles;
//
//public class ProductItem extends AbstractUIObject {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//    @FindBy(xpath = ".//div[@class=\"inventory_item_name\"]")
//    private ExtendedWebElement productName;
//
//    @FindBy(xpath = ".//button[@class =\"btn btn_primary btn_small btn_inventory\"]")
//    private ExtendedWebElement addButton;
//
//    @FindBy(xpath = "//button[@class=\"btn btn_primary btn_small btn_inventory\"]")
//    private ExtendedWebElement productsInTheBag;
//
//
//    public ProductItem(WebDriver driver, SearchContext searchContext) {
//        super(driver, searchContext);
//    }
//
//    public String getProductinTheBagNumber(){
//        LOGGER.info(productsInTheBag.getText());
//        return productsInTheBag.getText();
//    }
//
//    public String readProductName() {
//        return productName.getText();
//    }
//
//    public void addToCart() {
//        if (addButton.getText().equalsIgnoreCase("Add to cart")){
//            addButton.click();
//        }else{
//            LOGGER.info("product ios already added to the basket");
//        }
//    }
//
//
//
//
//
//}

package com.qaprosoft.carina.demo.gui.oleksandr.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductsPage extends SaucedemoAbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//a[@id= \"item_4_img_link\"]")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//div[text() = \"Sauce Labs Backpack\"]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[contains(text(), \"carry.allTheThings\")]")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = "//div[text()= \"29.99\"]")
    private ExtendedWebElement productPrice;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private ExtendedWebElement productButtonAddToCart;

    @FindBy(xpath = "//span[@class =\"active_option\"]")
    private ExtendedWebElement activeOptionInOptionMenu;

    @FindBy(xpath = "//option[@value = \"za\"]")
    private ExtendedWebElement optionNameZToA;

    @FindBy(xpath = "//option[@value = \"lohi\"]")
    private ExtendedWebElement optionPriceLowToHigh;

    @FindBy(xpath = "//option")
    private List<ExtendedWebElement> optionItemsList;

    @FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
    private List<ExtendedWebElement> listOFProductNames;

    @FindBy(xpath = "//button[@data-test=\"add-to-cart-sauce-labs-backpack\"]")
    private ExtendedWebElement backPackAddToCartButton;


//    @FindBy(xpath = "//div[@class=\"inventory_item\"]")
//    private List<ProductItem> productItem;

    @FindBy(xpath = ".//a[@class=\"shopping_cart_link\"]")
    private ExtendedWebElement toCartPage;  //span[@class="shopping_cart_badge"]

    @FindBy(xpath = "//span[@class=\"shopping_cart_badge\"]")
    private ExtendedWebElement shoppingBag;

    private final static List<String> list = new ArrayList<>() {
        {
            add("ALL ITEMS");
            add("ABOUT");
            add("LOGOUT");
            add("RESET APP STATE");
        }
    };
    private static final List<String> standardOptionItemsList = new ArrayList<>() {
        {
            add("Name (A to Z)");
            add("Name (Z to A)");
            add("Price (low to high)");
            add("Price (high to low)");
        }
    };

    private static List<String> standardProductNamesAZfilter = new ArrayList<>() {
        {
            add("Sauce Labs Backpack");
            add("Sauce Labs Bike Light");
            add("Sauce Labs Bolt T-Shirt");
            add("Sauce Labs Fleece Jacket");
            add("Sauce Labs Onesie");
            add("Test.allTheThings() T-Shirt (Red)");

        }
    };

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

    public static List<String> getStandardProductNamesAZfilter() {
        return standardProductNamesAZfilter;
    }

    //to check all fields in one method
    public boolean productFieldsCheck() {
        return productImage.isPresent() && productName.isPresent() && productDescription.isPresent() && productPrice.isPresent() && productButtonAddToCart.isPresent();
    }

    public boolean isAllFieldsFromOptionMenuExist() {
        List<String> tempList = new ArrayList<>();
        for (ExtendedWebElement element : optionItemsList) {
            tempList.add(element.getText());
        }

        return CollectionUtils.isEqualCollection(standardOptionItemsList, tempList);
    }

    public boolean isDefaultFilterIsAtoZ() {
        return activeOptionInOptionMenu.getText().equalsIgnoreCase(standardOptionItemsList.get(0));
    }

    public boolean isAnotherFilterInOptionMenuCanBeChoosen() {
        optionPriceLowToHigh.click();
        return activeOptionInOptionMenu.getText().equalsIgnoreCase(optionPriceLowToHigh.getText());
    }

    public boolean isProductsAreFilteredAtoZ() {
        List<String> tempList = new ArrayList<>();
        for (ExtendedWebElement element : listOFProductNames) {
            tempList.add(element.getText());
        }
        return standardProductNamesAZfilter.equals(tempList);
    }

    public boolean isZtoAFilteropened() {
        optionNameZToA.click();
        return activeOptionInOptionMenu.getText().equalsIgnoreCase(standardOptionItemsList.get(1));
    }


    public boolean isProductsAreFilteredZtoA() {
        List<String> tempList = new ArrayList<>();
        for (ExtendedWebElement element : listOFProductNames) {
            tempList.add(element.getText());
        }
        standardProductNamesAZfilter.sort(Collections.reverseOrder());
        return standardProductNamesAZfilter.equals(tempList);
    }

    public CartPage proceedToCartPage() {
        toCartPage.click();
        return new CartPage(driver);
    }

    public boolean isBackPackAddedtoShoppingBag() {
        if (backPackAddToCartButton.getText().equalsIgnoreCase("Add to cart")) {
            backPackAddToCartButton.click();
        } else {
            LOGGER.info("Bag is already added!");
        }
        return shoppingBag.getText().equalsIgnoreCase("1");
    }

}
    /*
    From the javadoc:
Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. (Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).) In other words, two lists are defined to be equal if they contain the same elements in the same order. This definition ensures that the equals method works properly across different implementations of the List interface.
     */





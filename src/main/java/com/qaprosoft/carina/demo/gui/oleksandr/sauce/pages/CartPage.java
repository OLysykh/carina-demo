package com.qaprosoft.carina.demo.gui.oleksandr.sauce.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends SaucedemoAbstractPage {

    @FindBy(xpath = "//a[@id= \"item_4_img_link\"]")
    private ExtendedWebElement productImage; //  //div[@class = "inventory_item_name"]

    @FindBy(xpath = "//div[@class = \"inventory_item_name\"]")
    private ExtendedWebElement productInBagName;


    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("/cart.html");
    }

    public boolean isBagSpecifriedOnThePage(){
        return productInBagName.getText().equalsIgnoreCase(ProductsPage.getStandardProductNamesAZfilter().get(0));
    }

}

    /*
    From the javadoc:
Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. (Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).) In other words, two lists are defined to be equal if they contain the same elements in the same order. This definition ensures that the equals method works properly across different implementations of the List interface.
     */





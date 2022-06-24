package com.qaprosoft.carina.demo.gui.oleksandr.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.xjc.reader.Ring.add;

public class ProductsPage extends SaucedemoAbstractPage {

    @FindBy(xpath = "//span[text() =  \"Products\"]")
    private ExtendedWebElement productPageCheck;

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

    @FindBy(id = "//div[@class = \"bm-menu\"]")
    private List<ExtendedWebElement> menuList;

    @FindBy(xpath = "//option[@value = \"az\"]")
    private ExtendedWebElement optionNameAToZ;

    @FindBy(xpath = "//option[@value = \"za\"]")
    private ExtendedWebElement optionNameZToA;

    @FindBy(xpath = "//option[@value = \"lohi\"]")
    private ExtendedWebElement optionPriceLowToHigh;

    @FindBy(xpath = "//option[@value = \"hilo\"]")
    private ExtendedWebElement optionPriceHighToLow;

    @FindBy(xpath = "//span[@class = \"active_option\"]")
    private ExtendedWebElement optionDefault;

    @FindBy(xpath = "//select[@class =\"product_sort_container\"]")
    private ExtendedWebElement optionButton;



    private final static List<String> list =new ArrayList<>() {
        {
            add("ALL ITEMS");
            add("ABOUT");
            add("LOGOUT");
            add("RESET APP STATE");
        }
    };


//    @FindBy(xpath = "//div[@class =  \"inventory_list\"]")
//    private List<ExtendedWebElement> inventoryList;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getProductPageCheck() {
        return productPageCheck;
    }

    public void setProductPageCheck(ExtendedWebElement productPageCheck) {
        this.productPageCheck = productPageCheck;
    }

    public ExtendedWebElement getProductImage() {
        return productImage;
    }

    public void setProductImage(ExtendedWebElement productImage) {
        this.productImage = productImage;
    }

    public ExtendedWebElement getProductName() {
        return productName;
    }

    public void setProductName(ExtendedWebElement productName) {
        this.productName = productName;
    }

    public ExtendedWebElement getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ExtendedWebElement productDescription) {
        this.productDescription = productDescription;
    }

    public ExtendedWebElement getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ExtendedWebElement productPrice) {
        this.productPrice = productPrice;
    }

    public ExtendedWebElement getProductButtonAddToCart() {
        return productButtonAddToCart;
    }

    public void setProductButtonAddToCart(ExtendedWebElement productButtonAddToCart) {
        this.productButtonAddToCart = productButtonAddToCart;
    }

    public List<ExtendedWebElement> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<ExtendedWebElement> menuList) {
        this.menuList = menuList;
    }

    public ExtendedWebElement getOptionNameAToZ() {
        return optionNameAToZ;
    }

    public void setOptionNameAToZ(ExtendedWebElement optionNameAToZ) {
        this.optionNameAToZ = optionNameAToZ;
    }

    public ExtendedWebElement getOptionNameZToA() {
        return optionNameZToA;
    }

    public void setOptionNameZToA(ExtendedWebElement optionNameZToA) {
        this.optionNameZToA = optionNameZToA;
    }

    public ExtendedWebElement getOptionPriceLowToHigh() {
        return optionPriceLowToHigh;
    }

    public void setOptionPriceLowToHigh(ExtendedWebElement optionPriceLowToHigh) {
        this.optionPriceLowToHigh = optionPriceLowToHigh;
    }

    public ExtendedWebElement getOptionPriceHighToLow() {
        return optionPriceHighToLow;
    }

    public void setOptionPriceHighToLow(ExtendedWebElement optionPriceHighToLow) {
        this.optionPriceHighToLow = optionPriceHighToLow;
    }

    public ExtendedWebElement getOptionDefault() {
        return optionDefault;
    }

    public void setOptionDefault(ExtendedWebElement optionDefault) {
        this.optionDefault = optionDefault;
    }

    public ExtendedWebElement getOptionButton() {
        return optionButton;
    }

    public void setOptionButton(ExtendedWebElement optionButton) {
        this.optionButton = optionButton;
    }

    //to check if we a appropriate page
    public boolean productPageCheck() {
        return productPageCheck.isPresent();
    }

    //to check all fields in one method
    public boolean productFieldsCheck() {
        return productImage.isPresent() && productName.isPresent() && productDescription.isPresent() && productPrice.isPresent() && productButtonAddToCart.isPresent();
    }

    //to check if element ius present
    public boolean checkOptionElement (ExtendedWebElement element){
        return element.isPresent();
    }

    public boolean checkDefaultTextInOption(){
        return optionDefault.getText().equalsIgnoreCase(optionNameAToZ.getText());
    }

    public boolean clickOnOptionMenu(){
        optionButton.click();
        optionPriceHighToLow.click();
        return optionDefault.getText().equalsIgnoreCase(optionPriceHighToLow.getText());
    }

//    public boolean checkSortrAZ(){
//        List<ExtendedWebElement> list = driver.findElements(By.xpath("//select[@class =\"product_sort_container\"]"));
//
//        return true;
//    }


    //to check menu options for availability DOES NOT WORK menulist is empty(((((((( why?
    public boolean productMenuBarCheck(){
        boolean flag = false;
        for(String element: list){
            for (ExtendedWebElement webelement : menuList){
                if(webelement.getText().equalsIgnoreCase(element)){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }





}

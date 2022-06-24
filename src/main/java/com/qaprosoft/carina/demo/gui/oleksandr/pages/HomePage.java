package com.qaprosoft.carina.demo.gui.oleksandr.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends SaucedemoAbstractPage {
    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    private ExtendedWebElement userName;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
//        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public ExtendedWebElement getUserName() {
        return userName;
    }

    public void setUserName(ExtendedWebElement userName) {
        this.userName = userName;
    }

    public ExtendedWebElement getPassword() {
        return password;
    }

    public void setPassword(ExtendedWebElement password) {
        this.password = password;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(ExtendedWebElement loginButton) {
        this.loginButton = loginButton;
    }

    public boolean checkElementsLocation(ExtendedWebElement above, ExtendedWebElement below) {
        Point locAbove = above.getLocation();
        Point locBelow = below.getLocation();
        return locAbove.getY() < locBelow.getY();
    }

    public ProductsPage loginMethod(){
        userName.type("performance_glitch_user");
        password.type("secret_sauce");
        loginButton.click();
        return new ProductsPage(driver);
    }
}
//
//    public void getCoordinates(ExtendedWebElement element){
//        Point loc = element.getLocation();
//        System.out.printf("x is %s and y is %s", loc.getX(), loc.getY());
//    }
//
//    public String getCoordinatesInString(ExtendedWebElement element){
//        Point loc = element.getLocation();
//        String sb = loc.getX() +
//                " <- this is x, and y is -> " +
//                loc.getY();
//        return sb;
//    }

//    public void loginMethod(){
//        userName.type("performance_glitch_user");
//        password.type("secret_sauce");
//        loginButton.click();
//    }
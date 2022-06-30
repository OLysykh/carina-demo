package com.qaprosoft.carina.demo.gui.oleksandr.sauce.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends SaucedemoAbstractPage {
    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    private ExtendedWebElement userName;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//h3[@data-test = \"error\"]")
    private ExtendedWebElement errorMessage;

    public HomePage(WebDriver driver) {
        super(driver);
//        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }


    public boolean isUserNameAbovePassword() {
        return userName.getLocation().getY() < password.getLocation().getY();
    }

    public boolean isPasswordAboveLoginButton() {
        return password.getLocation().getY() < loginButton.getLocation().getY();
    }

    public ProductsPage loginMethod(){
        userName.type("performance_glitch_user");
        password.type("secret_sauce");
        loginButton.click();
        return new ProductsPage(driver);
    }

    public boolean isAuthoriztionsFailed(){
        userName.type("performance_glitch_user2222");
        password.type("secret_sauce222");
        loginButton.click();
        return errorMessage.getText().equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service");
    }
}

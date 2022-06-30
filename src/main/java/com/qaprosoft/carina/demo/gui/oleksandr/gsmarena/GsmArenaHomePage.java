package com.qaprosoft.carina.demo.gui.oleksandr.gsmarena;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.components.GsmHeader;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.enums.HamburgerMenuOptions;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.enums.MobileBrands;
import com.qaprosoft.carina.demo.gui.oleksandr.gsmarena.enums.MobilePhones;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GsmArenaHomePage extends GsmArenaAbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class = \"brandmenu-v2 light l-box clearfix\"]//li")
    private List<ExtendedWebElement> listOfPhoneBrands;

    @FindBy(xpath = "//div[@class=\"wrapper clearfix\"]")
//    @FindBy(xpath = "//div[@class=\"top-bar clearfix\"]")
    private GsmHeader gsmHeader;

    @FindBy(xpath = "//table [@class =\"module-fit green\"]//a[@href]")
    private List<ExtendedWebElement> listOfTop10DailyInterest;


    public GsmArenaHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

//    public List<String> getExtendedWebElementsAsAList(List<ExtendedWebElement> list){
//        return list.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
//    }


    public GsmHeader getGsmHeader() {
        return gsmHeader;
    }

    public boolean isBrandPresentedInTheBrandList(String brand) {
        return listOfPhoneBrands.stream().anyMatch(x -> x.getText().equalsIgnoreCase(brand));
    }

    //this method compares webElement list of brands name(text) with enum list
    public boolean areAllBrandsPresented() {
        List<String> enumOfBrands = Stream.of(MobileBrands.values())
                .map(MobileBrands::toString)
                .collect(Collectors.toList());
   /*   to check visually
        enumOfBrands.forEach(LOGGER::info);
        LOGGER.info("_______________________________________");
        listOfPhoneBrands.forEach(x->LOGGER.info(x.getText()));

    */
        return CollectionUtils.isEqualCollection(enumOfBrands, listOfPhoneBrands.stream().map(ExtendedWebElement::getText).collect(Collectors.toList()));
    }

    public boolean isSearchedPhoneInTop10List(String phoneName) {
        return listOfTop10DailyInterest.stream().anyMatch(x -> x.getText().equalsIgnoreCase(phoneName));
    }

    public boolean areAllPhonesFromTheLIstHavePages (){
        int tempListsize = MobilePhones.values().length;
        int flag = 0;
        for(MobilePhones element: MobilePhones.values()){
            getGsmHeader().enterTextToAsearchBox(element.getName());
            getGsmHeader().pushEnterKeyOnSearchBarTextBox();
            GsmArenaStandardSearchResultPage resultPage = new GsmArenaStandardSearchResultPage(driver);
            if (resultPage.isPageOpened()){
            flag++;
            getGsmHeader().returnToHomePageFromHeader();
            }else
                LOGGER.info("No such Phone in GSM arena site");
        }
        return flag == tempListsize;
    }

    public boolean isAllFieldInBurgerMenuAreExisting (){
        List<String> tempList = getGsmHeader().getDropDownHaburgerOptions().stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
//        List<String> tempList = new ArrayList<>();
//        for(ExtendedWebElement element:getGsmHeader().getDropDownHaburgerOptions()){
//            LOGGER.info(element.getText());
//            tempList.add(element.getText());
//        }

        List<String> defaultListNamesForHamburgerMenu = Arrays.stream(HamburgerMenuOptions.values()).map(HamburgerMenuOptions::getName).map(String::toUpperCase).collect(Collectors.toList());
//        LOGGER.info("tempLisTEXtended size :"+ tempList.size());
////        tempListNamesFromWebElement.forEach(LOGGER::info);
//        LOGGER.info("----------------------------------------------------------------------");
//        LOGGER.info("ENUMS :"+ defaultListNamesForHamburgerMenu.size());
//        defaultListNamesForHamburgerMenu.forEach(LOGGER::info);
        return tempList.equals(defaultListNamesForHamburgerMenu);

    }
}

    /*
    public NothingPhonePage toOpenPageofTop10Phone(String phoneName){

        for(ExtendedWebElement element:listOfTop10DailyInterest){
            LOGGER.info(element.getText());
            if(element.getText().equalsIgnoreCase(phoneName)){
                element.click();
                LOGGER.info("-------------------------------------------------");
            }
        }
        return new NothingPhonePage(driver);

     */


//        ExtendedWebElement temp= listOfTop10DailyInterest.stream()
//                .filter(x->x.getText().equalsIgnoreCase(phoneName))
//                .findFirst().get()






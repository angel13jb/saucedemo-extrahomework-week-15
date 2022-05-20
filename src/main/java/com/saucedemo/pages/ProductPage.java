package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends Utility {
    private static final Logger log= LogManager.getLogger(ProductPage.class.getName());
    public ProductPage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortByDropDownList;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    List<WebElement> addToCartList;
    @CacheLookup
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOutButton;

    public void sortByProductHighToLow(String hightolow){
        selectByVisibleTextFromDropDown(sortByDropDownList,hightolow);
        log.info("Select from dropdown :"+hightolow);
    }
    public void selectCheapestAndCostliestProductsAndAddToBasket(){
        addToCartList.get(0).click();
        addToCartList.get(addToCartList.size()-1).click();
        log.info("select cheapest and costliest products :");
    }
    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCartLink);
        log.info("Clicking On shopping cart link :"+shoppingCartLink.toString());
    }
    public void clickOnCheckOutButton(){
        clickOnElement(checkOutButton);
        log.info("Clicking on checkout button :"+checkOutButton.toString());
    }

}

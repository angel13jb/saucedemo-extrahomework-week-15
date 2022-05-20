package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Utility {
    private static final Logger log= LogManager.getLogger(CheckOutPage.class.getName());
    public CheckOutPage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCodeField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    WebElement thankYouText;

    public void enterFirstName(String firstname){
        sendTextToElement(firstNameField,firstname);
        log.info("Enter firstname :"+firstname);
    }
    public void enterLastName(String lastname){
        sendTextToElement(lastNameField,lastname);
        log.info("Enter lastname :"+lastname);
    }
    public void enterZipCode(String zipcode){
        sendTextToElement(zipCodeField,zipcode);
        log.info("Enter zipcode :"+zipcode);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
        log.info("Clicking on continuebutton :"+continueButton);
    }
    public void clickOnFinishButton(){
        clickOnElement(finishButton);
        log.info("Clicking on finishbutton :"+finishButton);
    }
    public String getThankYouText(){
        log.info("Get thankyou text :"+thankYouText.toString());
        return getTextFromElement(thankYouText);
    }
}

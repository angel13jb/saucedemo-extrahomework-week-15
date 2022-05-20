package com.saucedemo.cucumber.steps;

import com.saucedemo.pages.CheckOutPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ProductPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PurchaseSteps {
    @Given("^I am on saucedemo page$")
    public void iAmOnSaucedemoPage() {
    }

    @When("^I login with credential username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithCredentialUsernameAndPassword(String username, String password) {
        new HomePage().enterUserName(username);
        new HomePage().enterPassword(password);
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {
        new HomePage().clickONLoginButton();
    }

    @And("^I filter the products by \"([^\"]*)\"$")
    public void iFilterTheProductsBy(String hightolow) {
        new ProductPage().sortByProductHighToLow(hightolow);
    }

    @And("^I select cheapest & costliest products and add to basket$")
    public void iSelectCheapestCostliestProductsAndAddToBasket() {
        new ProductPage().selectCheapestAndCostliestProductsAndAddToBasket();
    }

    @And("^I open shopping cart$")
    public void iOpenShoppingCart() {
        new ProductPage().clickOnShoppingCartLink();
    }

    @And("^I go to checkout$")
    public void iGoToCheckout() {
        new ProductPage().clickOnCheckOutButton();
    }

    @And("^I enter details firstname \"([^\"]*)\", lastName \"([^\"]*)\" and zipPostalCode \"([^\"]*)\"$")
    public void iEnterDetailsFirstnameLastNameAndZipPostalCode(String firstname, String lastname, String zipcode) {
        new CheckOutPage().enterFirstName(firstname);
        new CheckOutPage().enterLastName(lastname);
        new CheckOutPage().enterZipCode(zipcode);
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        new CheckOutPage().clickOnContinueButton();
    }

    @And("^I click on finish button$")
    public void iClickOnFinishButton() {
        new CheckOutPage().clickOnFinishButton();
    }

    @Then("^I should be able to see message 'Thank you for your order'$")
    public void iShouldBeAbleToSeeMessageThankYouForYourOrder() {
        Assert.assertEquals("Text not match", "THANK YOU FOR YOUR ORDER", new CheckOutPage().getThankYouText());
    }
}

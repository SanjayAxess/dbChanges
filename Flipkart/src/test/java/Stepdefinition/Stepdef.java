package Stepdefinition;

import Base.Baseclass;
import io.cucumber.java.en.*;
import pom.E2Etesting;
import pom.Flipkartyoutubepage;

public class Stepdef extends Baseclass {

    E2Etesting fk = new E2Etesting(driver);
    Flipkartyoutubepage obj = new Flipkartyoutubepage(driver);

    @Given("the user is on Flipkart home")
    public void the_user_is_on_flipkart_home() {

      launchbrowser("https://www.flipkart.com/");
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String Product) throws InterruptedException {
      fk.enterproduct();

    }

    @When("the user opens Apple mobiles")
    public void the_user_opens_apple_mobiles() throws InterruptedException {
        fk.clickbox();
        fk.Applephone();
    }

    @When("the user opens the first product and starts purchase")
    public void the_user_opens_the_first_product_and_starts_purchase() throws InterruptedException {
        Switchtomain(driver);
        fk.buynow();
    }

    @When("the user returns to home")
    public void the_user_returns_to_home() {
     fk.homepage();
    }

    @When("the user opens YouTube from footer and plays a video")
    public void the_user_opens_you_tube_from_footer_and_plays_a_video() throws InterruptedException {
    obj.youtubepage();
    obj.youtube();
   Back();
    }

    @When("the user returns to Flipkart")
    public void the_user_returns_to_flipkart() {

    }

    @When("the user opens Instagram from footer")
    public void the_user_opens_instagram_from_footer() {

    }

    @Then("Flipkart home is accessible again after returning")
    public void flipkart_home_is_accessible_again_after_returning() {

    }



}

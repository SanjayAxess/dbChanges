package StepDefination;

import BaseMethod.Baseclass;
import PageObjectModel.UserDetailsPO;
import PageObjectModel.BusResultsPagePO;
import PageObjectModel.HomePagePO;
import PageObjectModel.PaymentPagePO;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Objects;


public class makemytripSteps extends Baseclass {
    HomePagePO homepage;
    BusResultsPagePO cheapest;
    UserDetailsPO validFields;
    PaymentPagePO payment;

    @Given("I am on the MakeMyTrip homepage")
    public void i_am_on_the_make_my_trip_homepage() {
        WebPageurl("https://www.makemytrip.com/");
        String actual = driver.getTitle();
        String expected = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
        Assert.assertEquals("Title is MissMatch", expected, actual);

    }

    @When("I navigate to the Bus booking section")
    public void i_navigate_to_the_bus_booking_section() {
        homepage = new HomePagePO(driver);
        homepage.busBooking();
        String BusBooking = driver.getCurrentUrl();
        String expectedURL = "https://www.makemytrip.com/bus-tickets/";
        Assert.assertEquals("url MissMatch", expectedURL, BusBooking);
    }

    @When("I enter {string} as the pickup location and {string} as the drop location")
    public void i_enter_as_the_pickup_location_and_as_the_drop_location(String departure, String arrival) throws InterruptedException {

        homepage = new HomePagePO(driver);
        homepage.FromCity_ToCity(departure, arrival);
    }

    @When("I select a travel date")
    public void i_select_a_travel_date() {
        homepage = new HomePagePO(driver);
        homepage.TravelDate();
    }

    @When("I search for available buses")
    public void i_search_for_available_buses() {
       homepage = new HomePagePO(driver);
       homepage.SearchBus();
    }

    @Then("the bus search results page should be displayed")
    public void the_bus_search_results_page_should_be_displayed() {
      driver.getCurrentUrl();
      Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("bus-ticket"));

    }

    @When("I filter the bus results to find the cheapest bus")
    public void i_filter_the_bus_results_to_find_the_bus() {
        cheapest = new BusResultsPagePO(driver);
        cheapest.seatType();
    }

    @When("I select the cheapest bus available")
    public void i_select_the_cheapest_bus_available() throws InterruptedException {
        cheapest = new BusResultsPagePO(driver);
        cheapest.cheapestPrice();
    }

    @When("I click to select a seat")
    public void i_click_to_select_a_seat() throws InterruptedException {
        cheapest = new BusResultsPagePO(driver);
        cheapest.setSelectSete();
    }

    @And("I select Pickup as {string} & Drop Points as {string}")
    public void iSelectPickupAsDropPointsAs(String pickupLocation, String dropLocation) throws InterruptedException {
        cheapest = new BusResultsPagePO(driver);
        cheapest.BodingPoint(pickupLocation);
        cheapest.DropingPoint(dropLocation);
    }

    @When("I reserve a berth seat")
    public void i_reserve_a_berth_seat() {

    }

    @When("I proceed to continue")
    public void i_proceed_to_continue() {
        cheapest = new BusResultsPagePO(driver);
        cheapest.confirmButton();
    }

    @When("I enter valid traveller details")
    public void i_enter_valid_traveller_details() throws InterruptedException {
        validFields = new UserDetailsPO(driver);
        validFields.Contectdetails();
        validFields.mandatoryfields();
        validFields.paymentPage();
    }

    @Then("I should be navigated to the payment page")
    public void i_should_be_navigated_to_the_payment_page() {
        payment = new PaymentPagePO(driver);
        payment.isPaymentPageReached();
    }


}

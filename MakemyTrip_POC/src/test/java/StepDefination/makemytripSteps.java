package StepDefination;

import BaseMethod.Baseclass;
import PageObjectModel.*;
import io.cucumber.java.en.*;
import org.junit.Assert;


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
        String actualUrl = driver.getCurrentUrl();
        String expectedURL = "https://www.makemytrip.com/bus-tickets/";
        Assert.assertEquals("url MissMatch", expectedURL, actualUrl);
    }

    @When("I enter {string} as the pickup location and {string} as the drop location")
    public void pickup_location_drop_location(String departure, String arrival) throws InterruptedException {

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
        boolean contains = driver.getCurrentUrl().contains("bus-ticket");
        Assert.assertTrue(contains);

    }

    @When("I filter the bus results to find the cheapest bus")
    public void i_filter_the_bus_results_to_find_the_bus() {
        cheapest = new BusResultsPagePO(driver);
        cheapest.seatType();
    }

    @When("I select the cheapest bus available")
    public void cheapest_bus_available() throws InterruptedException {
        cheapest = new BusResultsPagePO(driver);
        cheapest.cheapestPrice();
    }

    @When("I click to select a seat")
    public void select_a_seat() {
        cheapest = new BusResultsPagePO(driver);
        cheapest.setSelectSete();
    }

    @And("I select Pickup as {string} & Drop Points as {string}")
    public void PickupAsDropPointsAs(String pickupLocation, String dropLocation) throws InterruptedException {
        cheapest = new BusResultsPagePO(driver);
        cheapest.BodingPoint(pickupLocation);
        cheapest.DropingPoint(dropLocation);
    }

    @When("I reserve a berth seat")
    public void i_reserve_a_berth_seat() {

    }

    @When("I proceed to continue")
    public void proceed_to_continue() {
        cheapest = new BusResultsPagePO(driver);
        cheapest.confirmButton();
    }

    @And("I enter valid traveller details {string} {string} {string} {string}")
    public void UserDetails(String name, String age, String email, String mobileNumber) throws InterruptedException {
        validFields = new UserDetailsPO(driver);
        validFields.Contectdetails(name,age,email,mobileNumber);
        validFields.mandatoryfields();
        validFields.paymentPage();
    }
    @Then("I should be navigated to the payment page")
    public void payment_page() {

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Actual URL: " + currentUrl);
        System.out.println("Expected to contain: 'payments'");

        assert currentUrl != null;
        boolean contains = currentUrl.contains("payments");
        System.out.println("Contains 'payments': " + contains);

        Assert.assertTrue("URL should contain 'payments' but was: " + currentUrl, contains);
        payment = new PaymentPagePO(driver);
        payment.isPaymentPageReached();
    }

}

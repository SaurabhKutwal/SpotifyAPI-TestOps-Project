package com.spotify.RunnerFile.StepDefinitions;

import com.spotify.Services.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class UserServiceDef extends Manager{

    UserService userService;

    @Given("^Make a RequestSpecification with (.+) authorization token$")
    public void make_a_request_specification_with_right_authorization_token(String flag) {
        userService = new UserService();
        userService.setToken(flag.equals("correct"));
    }

    @When("Make a Get request for profile")
    public void make_a_get_request_for_profile() {
        response = userService.getCurrentUserProfile();
    }

    @Then("^Verify status code is (.+)$")
    public void verify_status_code_is(Integer statusCode) {
        jsonPath = response.then().extract().jsonPath();
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("Check Name And Id")
    public void check_name_and_id() {

    }

    @Then("^error msg should be (.+)$")
    public void error_msg_should_be_invalid_access_token(String errorMsg) {
        response.then().assertThat()
                .body("error.message", equalTo(errorMsg));
    }

    @When("Make a Get request for followed artists")
    public void make_a_get_request_for_followed_artists() {
        response = userService.getFollowedArtist();
    }

    @When("Make a put request for following artists")
    public void make_a_put_request_for_following_artists() {
        response = userService.followArtist();
    }

    @When("Make a delete request for unfollowing artists")
    public void make_a_delete_request_for_unfollowing_artists() {
        response = userService.unfollowArtist();
    }

    @Then("Verify List of artists")
    public void verify_list_of_artists() {

        List<HashMap> items = jsonPath.getList("artists.items");

        items.forEach(x -> System.out.println(x.get("name")));
    }
}

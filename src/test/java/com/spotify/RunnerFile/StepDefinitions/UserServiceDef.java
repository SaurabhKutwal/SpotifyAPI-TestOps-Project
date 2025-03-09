package com.spotify.RunnerFile.StepDefinitions;

import com.spotify.POJOClasses.ErrorPOJO.ErrorMsg;
import com.spotify.POJOClasses.FollowUnfollowArtist;
import com.spotify.POJOClasses.User;
import com.spotify.Services.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class UserServiceDef extends BaseUtility {
    private static final Logger logger = LogManager.getLogger(UserServiceDef.class);

    UserService userService;


    @Given("Create UserService Entity")
    public void create_user_service_entity() {
        userService = new UserService();
    }

    @Given("^Make a RequestSpecification with (.+) authorization token$")
    public synchronized void make_a_request_specification_with_right_authorization_token(String flag) {
        userService.setToken(flag.equals("correct"));
    }

    @When("Make a Get request for profile")
    public void make_a_get_request_for_profile() {
        response = userService.getCurrentUserProfile();
    }

    @Then("^Verify status code is (.+)$")
    public synchronized void verify_status_code_is(Integer statusCode) {
        jsonPath = response.then().extract().jsonPath();
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("Check Name And Id")
    public void check_name_and_id() {
        User user = response.as(User.class);
        logger.info("User Name : " + user.getDisplay_name() + "\n" +
                "User ID : " + user.getId() + "\n" +
                "User Country : " + user.getCountry() + "\n" +
                "User Email :" + user.getEmail());
    }

    @Then("^error msg should be (.+)$")
    public void error_msg_should_be_invalid_access_token(String expectedErrorMsg) {
        ErrorMsg errorMsg = response.as(ErrorMsg.class);
        Assert.assertEquals(errorMsg.getError().getMessage(),expectedErrorMsg);
    }

    @When("Make a Get request for followed artists")
    public void make_a_get_request_for_followed_artists() {
        response = userService.getFollowedArtist();
    }

    @When("Make a put request for following artists")
    public void make_a_put_request_for_following_artists() {
        FollowUnfollowArtist followUnfollowArtist = new FollowUnfollowArtist.Builder()
                .addToList(artistId)
                .build();

        response = userService.followArtist(followUnfollowArtist);
    }

    @When("Make a delete request for unfollowing artists")
    public void make_a_delete_request_for_unfollowing_artists() {
        FollowUnfollowArtist followUnfollowArtist = new FollowUnfollowArtist.Builder()
                .addToList(artistId)
                .build();

        response = userService.unfollowArtist(followUnfollowArtist);
    }

    @Then("Verify List of artists")
    public void verify_list_of_artists() {
        List<HashMap> items = jsonPath.getList("artists.items");
        logger.info("Artist list :");
        items.forEach(x -> logger.info("Artist Name :" + x.get("name")));
    }
}

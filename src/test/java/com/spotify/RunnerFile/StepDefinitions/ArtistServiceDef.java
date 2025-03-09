package com.spotify.RunnerFile.StepDefinitions;


import com.spotify.Services.ArtistService;
import com.spotify.UtilityClasses.PropertyFileManager.PropertyFileManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;

public class ArtistServiceDef extends BaseUtility {

    private static final Logger logger = LogManager.getLogger(ArtistServiceDef.class);

    ArtistService artistService;

    @Given("Create ArtistService Entity")
    public void create_artist_service_entity() {
        artistService = new ArtistService();
    }

    @Given("^Artist name is (.+)$")
    public synchronized void artist_name_is_shreya_ghoshal(String artistName) {
        artistId = PropertyFileManager.getArtistDataManager().artistProp.getProperty(artistName);

    }
    @When("Make a Get request for info of given artist")
    public void make_a_get_request_for_info_of_given_artist() {
        response = artistService.getArtist(artistId);
    }
    @Then("Check the information")
    public void check_the_information() {
        logger.info("Details of artists:");
        logger.info("\n" +
                "Name : " + jsonPath.get("name") + "\n" +
                "Followers :" + jsonPath.get("followers.total"));
    }

    @When("^Make a Get request for top (.+) of given artist$")
    public synchronized void make_a_get_request_for_top_tracks_of_given_artist(String flag) {
        if(flag.equals("tracks"))response = artistService.getArtistTopTracks(artistId);
        else response = artistService.getArtistAlbums(artistId);
    }


    @Then("Check the list of tracks")
    public void check_the_list_of_tracks() {
        List<LinkedHashMap> tracks = jsonPath.getList("tracks");
        tracks.forEach(x -> logger.info("Track : " + x.get("name")));
    }


    @Then("Check the list of albums")
    public void check_the_list_of_albums() {
        List<LinkedHashMap> albums = jsonPath.getList("items");
        albums.forEach(x -> logger.info("Track : " + x.get("name")));
    }
}

package com.spotify.RunnerFile.StepDefinitions;

import com.spotify.Services.ArtistService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.LinkedHashMap;
import java.util.List;

public class ArtistServiceDef extends Manager{

    ArtistService artistService;
    String artistId;

    @Given("Artist name is Shreya Ghoshal")
    public void artist_name_is_shreya_ghoshal() {
        artistId = "0oOet2f43PA68X5RxKobEy";
    }
    @When("Make a Get request for info of given artist")
    public void make_a_get_request_for_info_of_given_artist() {
        artistService = new ArtistService();
        response = artistService.getArtist(artistId);
    }
    @Then("Check the information")
    public void check_the_information() {
        System.out.println(jsonPath.get("type") + "\n" +
                            jsonPath.get("name") + "\n" +
                            jsonPath.get("followers.total"));
    }

    @When("^Make a Get request for top (.+) of given artist$")
    public void make_a_get_request_for_top_tracks_of_given_artist(String flag) {
        artistService = new ArtistService();
        if(flag.equals("tracks"))response = artistService.getArtistTopTracks(artistId);
        else response = artistService.getArtistAlbums(artistId);
    }


    @Then("Check the list of tracks")
    public void check_the_list_of_tracks() {
        List<LinkedHashMap> tracks = jsonPath.getList("tracks");
        tracks.forEach(x -> System.out.println(x.get("name")));
    }


    @Then("Check the list of albums")
    public void check_the_list_of_albums() {
        List<LinkedHashMap> albums = jsonPath.getList("items");
        albums.forEach(x -> System.out.println(x.get("name")));

    }

}

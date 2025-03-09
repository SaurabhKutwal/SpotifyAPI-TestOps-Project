package com.spotify.RunnerFile.StepDefinitions;

import com.spotify.Services.PlaylistService;
import com.spotify.UtilityClasses.PropertyFileManager.PropertyFileManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.LinkedHashMap;
import java.util.List;

public class PlaylistServiceDef extends BaseUtility {

    PlaylistService playlistService;
    String playListId;
    String songId;

    @Given("Create PlaylistService Entity")
    public void create_playlist_service_entity() {
       playlistService = new PlaylistService();
    }

    @Given("^Name of playlist is (.+)$")
    public synchronized void name_of_playlist_is_my_playlist(String playListName) {
        playListId = PropertyFileManager.getUserDataManager().userProp.getProperty(playListName);
    }

    @Given("^Song name is (.+)$")
    public void songIdByName(String songName){
        songId = PropertyFileManager.getSongDataManager().songDataProp.getProperty(songName);
        System.out.println(songName + " " + songId);
    }


    @When("Make a Get request for playlist details")
    public void make_a_get_request_for_playlist_details() {
        response = playlistService.getPlaylist(playListId);
    }

    @When("Make a Get request for playlist tracks")
    public void make_a_get_request_for_playlist_tracks() {
        response = playlistService.getPlaylistTracks(playListId);
    }

    @When("Make a put request for playlist update")
    public void make_a_put_request_for_playlist_update() {
        String sample = "{\n" +
                "    \"name\": \"MyPlaylist\",\n" +
                "    \"description\": \"Updated playlist description\",\n" +
                "    \"public\": false\n" +
                "}";

        response = playlistService.updatePlaylist(playListId,sample);
    }

    @When("Make a put request to add tracks to given playlist")
    public void make_a_put_request_to_add_tracks_to_given_playlist() {
        String sample = "{\n" +
                "    \"uris\": [\n" +
                "        \"spotify:track:"+songId+"\"\n" +
                "    ],\n" +
                "    \"position\": 0\n" +
                "}";
        response = playlistService.addTracksToPlaylist(playListId, sample);
    }

    @When("Make a delete request to remove tracks from given playlist")
    public void make_a_delete_request_to_remove_tracks_from_given_playlist() {
        String sample = "{\n" +
                "    \"tracks\": [\n" +
                "        {\n" +
                "            \"uri\": \"spotify:track:"+songId+"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        System.out.println(sample);
        response =  playlistService.removeTracksFromPlaylist(playListId,sample);
    }


    @Then("Check the name, id & description of given playlist")
    public void check_the_name_id_description_of_given_playlist() {
        System.out.println("Details of playlist --> \n");
        System.out.println("Name : " + jsonPath.get("name"));
        System.out.println("Description " + jsonPath.get("description"));
        System.out.println("Id : " + jsonPath.get("id"));
        System.out.println("Owner : " + jsonPath.get("owner.display_name"));
    }


    @Then("check the tracks of playlist")
    public void check_the_tracks_of_playlist() {
        List<LinkedHashMap<Object,Object>> trackList = jsonPath.getList("items");
        trackList.forEach(x->System.out.println(((LinkedHashMap)x.get("track")).get("name")));
    }
}

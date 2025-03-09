package com.spotify.Services;

import com.spotify.RunnerFile.StepDefinitions.PlaylistServiceDef;
import io.restassured.response.Response;

public class PlaylistService extends BaseService{
    private static final String BASE_PATH = "/v1/playlists";

    public Response getPlaylist(String playlistId){
        setTokenHeader(true);
        addPathParam("playlist_id",playlistId);
        return getRequest(BASE_PATH + "/{playlist_id}");
    }

    public Response updatePlaylist(String playlistId, String body){
        setTokenHeader(true);
        addPathParam("playlist_id",playlistId);
        setContentType("json");
        setBody(body);
        return putRequest(BASE_PATH + "/{playlist_id}");
    }

    public Response getPlaylistTracks(String playListId){
        setTokenHeader(true);
        addPathParam("playlist_id",playListId);
        return getRequest(BASE_PATH + "/{playlist_id}/tracks");
    }

    public Response addTracksToPlaylist(String playlistId, String body){
        setTokenHeader(true);
        addPathParam("playlist_id",playlistId);
        setContentType("json");
        setBody(body);
        return postRequest(BASE_PATH + "/{playlist_id}/tracks");
    }

    public Response removeTracksFromPlaylist(String playlistId, String body){
        setTokenHeader(true);
        addPathParam("playlist_id",playlistId);
        setContentType("json");
        setBody(body);
        return deleteRequest(BASE_PATH + "/{playlist_id}/tracks");
    }

}

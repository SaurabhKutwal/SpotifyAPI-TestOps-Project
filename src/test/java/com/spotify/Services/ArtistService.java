package com.spotify.Services;

import io.restassured.response.Response;

public class ArtistService extends BaseService{
    private static final String BASE_PATH = "/v1/artists";

    public Response getArtist(String artistId){
        setTokenHeader(true);
        addPathParam("id",artistId);
        return getRequest(BASE_PATH + "/{id}");
    }

    public Response getArtistTopTracks(String artistId){
        setTokenHeader(true);
        addPathParam("id",artistId);
        addQueryParam("market","IN");
        return getRequest(BASE_PATH + "/{id}/top-tracks");
    }

    public Response getArtistAlbums(String artistId){
        setTokenHeader(true);
        addPathParam("id",artistId);
        addQueryParam("market","IN");
        addQueryParam("limit","10");
        return getRequest(BASE_PATH  + "/{id}/albums");
    }

}

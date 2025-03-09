package com.spotify.Services;

import io.restassured.response.Response;

public class UserService extends BaseService{
    private static final String BASE_PATH = "/v1/me";

    public void setToken(Boolean tokenFlag){
        setTokenHeader(tokenFlag);
    }

    public Response getCurrentUserProfile(){
        return getRequest(BASE_PATH);
    }

    public Response getFollowedArtist(){
        addQueryParam("type","artist");
        setContentType("json");
        return getRequest(BASE_PATH + "/following");
    }

    public Response followArtist(Object payLoad){
        addQueryParam("type","artist");
        setContentType("json");
        setBody(payLoad);
        return putRequest(BASE_PATH + "/following");
    }

    public Response unfollowArtist(Object payLoad){
        addQueryParam("type","artist");
        setBody(payLoad);
        return deleteRequest(BASE_PATH + "/following");
    }
}

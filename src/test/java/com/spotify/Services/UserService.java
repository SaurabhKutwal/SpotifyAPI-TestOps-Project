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

    public Response followArtist(){
        addQueryParam("type","artist");
        setContentType("json");

        String sample = "{\n" +
                "    \"ids\": [\n" +
                "        \"4YRxDV8wJFPHPTeXepOstw\",\n" +
                "        \"7uIbLdzzSEqnX0Pkrb56cR\",\n" +
                "        \"0oOet2f43PA68X5RxKobEy\"\n" +
                "    ]\n" +
                "}";
        setBody(sample);
        return putRequest(BASE_PATH + "/following");
    }

    public Response unfollowArtist(){
        addQueryParam("type","artist");

        String sample = "{\n" +
                "    \"ids\": [\n" +
                "        \"0oOet2f43PA68X5RxKobEy\"\n" +
                "    ]\n" +
                "}";
        setBody(sample);

        return deleteRequest(BASE_PATH + "/following");
    }
}

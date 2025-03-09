package com.spotify.Services;

import com.spotify.UtilityClasses.PropertyFileManager.PropertyFileManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    private static final String BASE_URI = "https://api.spotify.com";
    protected RequestSpecification requestSpecification;
    String authToken;

    protected BaseService(){
        authToken = PropertyFileManager.getTokenManager().tokenProp.getProperty("access_token");

        RestAssured.baseURI = BASE_URI;
        this.requestSpecification = RestAssured.given();
    }

    protected void setTokenHeader(Boolean flag){
        if(flag) this.requestSpecification.auth().oauth2(authToken);
        else this.requestSpecification.auth().oauth2("Random fjsadncansdocknasdciadmsc");
    }

    protected void addQueryParam(String key, String value){
        this.requestSpecification.queryParam(key,value);
    }

    protected void addPathParam(String key, String value){
        this.requestSpecification.pathParam(key,value);
    }

    protected void setBody(String body){
        this.requestSpecification.body(body);
    }

    protected void setContentType(String contentType){
        if(contentType.equals("json")) this.requestSpecification.contentType(ContentType.JSON);
    }

    protected Response getRequest(String endpoint){
        return this.requestSpecification.when().get(endpoint);
    }

    protected Response putRequest(String endPoint){
        return this.requestSpecification.when().put(endPoint);
    }

    protected Response deleteRequest(String endPoint){
        return this.requestSpecification.when().delete(endPoint);
    }

    protected Response postRequest(String endpoint){
        return this.requestSpecification.when().post(endpoint);
    }

}

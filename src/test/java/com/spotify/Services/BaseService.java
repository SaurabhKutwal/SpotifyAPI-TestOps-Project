package com.spotify.Services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    private static final String BASE_URI = "https://api.spotify.com";
    protected RequestSpecification requestSpecification;

    protected BaseService(){
        RestAssured.baseURI = BASE_URI;
        this.requestSpecification = RestAssured.given();
    }

    protected void setTokenHeader(Boolean flag){
        if(flag) this.requestSpecification.auth().oauth2("BQCZRZ99fYwerTFOA_rErcKbK7Sh8E75dYb1SXlx1iMXHXEI2gfi8EZ4eZmRQfAbdMjEyBpgwyBWIwX9fNALe4sO5nw2vSBiBFcAjZNyvGtAjLX-FYXtEtDYgcOAcnw2lEtqCogYJ3f8xerymchBetpxkZJXZj_4RkNCC1QPzlAaiYnP3IoXb9NYLpsaHqI2nYDgJzN_jlBkgKnLQubi2bef1VXtmERmtuadGauyKNa5iatsiSoOnlY2vyp9KN0tZuMjbTNO9Hvt0jdvLvsEZkIXKcYGk0OY2YFBdzSfIIlpzD22EXMEp4xx0FfR2lRyOnQ");
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
        return requestSpecification.when().get(endpoint);
    }

    protected Response putRequest(String endPoint){
        return requestSpecification.when().put(endPoint);
    }

    protected Response deleteRequest(String endPoint){
        return this.requestSpecification.when().delete(endPoint);
    }

    protected Response postRequest(String endpoint){
        return this.requestSpecification.log().all().when().post(endpoint);
    }

}

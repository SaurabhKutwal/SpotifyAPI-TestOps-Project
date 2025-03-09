package com.spotify.UtilityClasses.PropertyFileManager;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.given;

public class TokenManager {

    private static TokenManager tokenManager;
    public Properties tokenProp;

    private TokenManager(){
        loadTokenPropertyFile();

        assert tokenProp != null;
        if(!isTokenValid(tokenProp.getProperty("tokenCreationTime"))){
            System.out.println("Token Expired..Requesting new Token");
            renewToken();
            loadTokenPropertyFile();
        }

    }

    protected static synchronized TokenManager getInstance(){
        if(tokenManager == null){
            tokenManager = new TokenManager();
        }
        return tokenManager;
    }

    private boolean isTokenValid(String time){
        Long creationTime = Long.parseLong(time);
        Long currentTime = System.currentTimeMillis()/1000;
        return (currentTime - creationTime) <= 3600;
    }

    private void loadTokenPropertyFile(){
        try {
            InputStream file = Files.newInputStream(Paths.get("src/test/resources/PropertyFiles/token.properties"));
            tokenProp = new Properties();
            tokenProp.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void renewToken(){

        JsonPath jsonPath = given().baseUri("https://accounts.spotify.com")
                .contentType(ContentType.URLENC)
                .formParam("grant_type","refresh_token")
                .formParam("refresh_token",tokenProp.getProperty("refresh_token"))
                .formParam("client_id","2c2cb6497aac493ba689e807323aa42a")
                .formParam("client_secret","5da02064c57a4259baee9d9fdccb6047").
        when().post("/api/token").
                then().assertThat().statusCode(200).extract().jsonPath();

        String newToken = jsonPath.getString("access_token");
        String newRefreshToken = jsonPath.getString("refresh_token");
        Long newTime = System.currentTimeMillis()/1000;

        System.out.println("Token Generation Successful");
        updateTokenProperties(newToken, newRefreshToken, newTime);
    }

    private void updateTokenProperties(String newToken, String newRefreshToken, Long newTime){
        try{

            Properties prop = new Properties();
            prop.load(Files.newInputStream(Paths.get("src/test/resources/PropertyFiles/token.properties")));


            prop.setProperty("access_token",newToken);
            if(newRefreshToken!=null){
                prop.setProperty("refresh_token",newRefreshToken);
            }
            prop.setProperty("tokenCreationTime",String.valueOf(newTime));

            prop.store(new FileOutputStream("src/test/resources/PropertyFiles/token.properties"),null);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.spotify.RunnerFile.StepDefinitions;

import com.spotify.UtilityClasses.PropertyFileManager.TokenManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseUtility {
    public static Response response;
    public static JsonPath jsonPath;
    public static TokenManager tokenManager;
}

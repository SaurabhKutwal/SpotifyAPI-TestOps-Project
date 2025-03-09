package com.spotify.POJOClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("country")
    public String country;
    @JsonProperty("display_name")
    public String display_name;
    @JsonProperty("email")
    public String email;
    @JsonProperty("id")
    public String id;

    public String getCountry() {
        return country;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}

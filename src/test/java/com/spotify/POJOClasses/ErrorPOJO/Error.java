package com.spotify.POJOClasses.ErrorPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("status")
    public int status;
    @JsonProperty("message")
    public String message;

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

}

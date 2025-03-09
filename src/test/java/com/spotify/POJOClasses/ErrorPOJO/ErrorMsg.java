package com.spotify.POJOClasses.ErrorPOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ErrorMsg {
    @JsonProperty("error")
    public Error error;

    public Error getError() {
        return error;
    }
}

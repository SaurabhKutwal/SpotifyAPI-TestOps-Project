package com.spotify.POJOClasses.PlaylistPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
    public String name;
    public String id;
    public String type;
}

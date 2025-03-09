package com.spotify.POJOClasses.PlaylistPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlist {
    public String description;
    public String id;
    public String name;
    public Tracks tracks;
}

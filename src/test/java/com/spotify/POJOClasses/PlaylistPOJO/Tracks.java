package com.spotify.POJOClasses.PlaylistPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracks {
    public List<Item> items;
}

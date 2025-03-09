package com.spotify.UtilityClasses.PropertyFileManager;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.spotify.Services.ArtistService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ArtistDataManger {
    private static ArtistDataManger artistDataManger;
    public Properties artistProp;

    private ArtistDataManger(){
        loadArtistProperties();
    }

    public static ArtistDataManger getInstance(){
        if(artistDataManger == null) artistDataManger = new ArtistDataManger();
        return artistDataManger;
    }

    void loadArtistProperties(){
        try {
            InputStream file = Files.newInputStream(Paths.get("src/test/resources/PropertyFiles/artistsData.properties"));
            artistProp = new Properties();
            artistProp.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

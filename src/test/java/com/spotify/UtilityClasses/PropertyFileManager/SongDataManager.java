package com.spotify.UtilityClasses.PropertyFileManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class SongDataManager {
    private static SongDataManager songDataManager;
    public Properties songDataProp;

    private SongDataManager(){
        loadSongDataProperties();
    }

    protected static SongDataManager getInstance(){
        if(songDataManager == null) songDataManager = new SongDataManager();
        return songDataManager;
    }

    private void loadSongDataProperties(){
        try {
            InputStream file = Files.newInputStream(Paths.get("src/test/resources/PropertyFiles/SongsData.properties"));
            songDataProp = new Properties();
            songDataProp.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

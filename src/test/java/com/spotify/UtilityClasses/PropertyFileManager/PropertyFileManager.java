package com.spotify.UtilityClasses.PropertyFileManager;

public class PropertyFileManager {

    public static TokenManager getTokenManager(){
        return TokenManager.getInstance();
    }

    public static UserDataManager getUserDataManager(){
        return  UserDataManager.getInstance();
    }

    public static ArtistDataManger getArtistDataManager(){
        return ArtistDataManger.getInstance();
    }

    public static SongDataManager getSongDataManager(){
        return SongDataManager.getInstance();
    }
}

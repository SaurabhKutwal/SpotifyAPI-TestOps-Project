package com.spotify.UtilityClasses.PropertyFileManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class UserDataManager {
    private static UserDataManager userDataManager;
    public Properties userProp;

    private UserDataManager(){
        loadUserProperties();
    }

    public static UserDataManager getInstance(){
        if(userDataManager == null) userDataManager = new UserDataManager();
        return userDataManager;
    }

    void loadUserProperties(){
        try {
            InputStream file = Files.newInputStream(Paths.get("src/test/resources/PropertyFiles/UserData.properties"));
            userProp = new Properties();
            userProp.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

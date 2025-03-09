package com.spotify.POJOClasses;


import java.util.ArrayList;
import java.util.List;

public class FollowUnfollowArtist {
    private List<String> ids;

    private FollowUnfollowArtist(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }

    public static class Builder{
        List<String> ids;

        public Builder(){
            ids = new ArrayList<>();
        }

        public Builder setList(List<String> ids){
            this.ids = ids;
            return this;
        }

        public Builder addToList(String id){
            ids.add(id);
            return this;
        }

        public FollowUnfollowArtist build(){
            return new FollowUnfollowArtist(this.ids);
        }
    }
}

package com.example.secretassassin.model.lobby.gamestat;

public class Vote {
    private String voteTrack;
    private boolean marker;


    public Vote(String voteTrack, boolean marker) {
        this.voteTrack = voteTrack;
        this.marker = marker;
    }

    public String getVoteTrack() {
        return voteTrack;
    }

    public void setVoteTrack(String voteTrack) {
        this.voteTrack = voteTrack;
    }

    public boolean isMarker() {
        return marker;
    }

    public void setMarker(boolean marker) {
        this.marker = marker;
    }
}

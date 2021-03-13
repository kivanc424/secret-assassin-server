package com.example.secretassassin.model.lobby.gamestat;

public class Quest {
    private String questText;
    private int questTrack;
    private boolean goodGuysPoint;
    private boolean badGuysPoint;
    private int maxPlayersForQuest;

    public Quest(String questText, int questTrack, boolean goodGuysPoint, boolean badGuysPoint, int maxPlayersForQuest) {
        this.questText = questText;
        this.questTrack = questTrack;
        this.goodGuysPoint = goodGuysPoint;
        this.badGuysPoint = badGuysPoint;
        this.maxPlayersForQuest = maxPlayersForQuest;
    }

    public int getMaxPlayersForQuest() {
        return maxPlayersForQuest;
    }

    public void setMaxPlayersForQuest(int maxPlayersForQuest) {
        this.maxPlayersForQuest = maxPlayersForQuest;
    }

    public String getQuestText() {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }

    public int getQuestTrack() {
        return questTrack;
    }

    public void setQuestTrack(int questTrack) {
        this.questTrack = questTrack;
    }

    public boolean isGoodGuysPoint() {
        return goodGuysPoint;
    }

    public void setGoodGuysPoint(boolean goodGuysPoint) {
        this.goodGuysPoint = goodGuysPoint;
    }

    public boolean isBadGuysPoint() {
        return badGuysPoint;
    }

    public void setBadGuysPoint(boolean badGuysPoint) {
        this.badGuysPoint = badGuysPoint;
    }
}

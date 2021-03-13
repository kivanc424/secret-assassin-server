package com.example.secretassassin.model.lobby;

import com.example.secretassassin.model.lobby.gamestat.Quest;
import com.example.secretassassin.model.lobby.gamestat.Vote;

import java.util.List;

public class GameStatus {
    private List<Quest> quest;
    private List<Vote> vote;

    public GameStatus(List<Quest> quest, List<Vote> vote) {
        this.quest = quest;
        this.vote = vote;
    }

    public List<Quest> getQuest() {
        return quest;
    }

    public void setQuest(List<Quest> quest) {
        this.quest = quest;
    }

    public List<Vote> getVote() {
        return vote;
    }

    public void setVote(List<Vote> vote) {
        this.vote = vote;
    }
}

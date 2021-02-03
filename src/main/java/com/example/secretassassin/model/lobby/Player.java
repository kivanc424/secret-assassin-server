package com.example.secretassassin.model.lobby;

public class Player {
    private String id;
    private String lobbyId;
    private String username;

    public Player(String id, String lobbyId, String username) {
        this.id = id;
        this.lobbyId = lobbyId;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLobbyId() {
        return lobbyId;
    }

    public void setLobbyId(String lobbyId) {
        this.lobbyId = lobbyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

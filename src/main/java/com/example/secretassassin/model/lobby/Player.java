package com.example.secretassassin.model.lobby;

public class Player {
    private String id;
    private String lobbyId;
    private String username;
    private Boolean gameMaster;
    private String readyState;

    public Player(String id, String lobbyId, String username, Boolean gameMaster, String readyState) {
        this.id = id;
        this.lobbyId = lobbyId;
        this.username = username;
        this.gameMaster = gameMaster;
        this.readyState = readyState;
    }

    public String getReadyState() {
        return readyState;
    }

    public void setReadyState(String readyState) {
        this.readyState = readyState;
    }

    public Boolean getGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(Boolean gameMaster) {
        this.gameMaster = gameMaster;
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

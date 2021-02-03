package com.example.secretassassin.model;

import com.example.secretassassin.model.lobby.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "rooms")
public class CreateRoom {
    @Id
    private String id;
    private String roomName;
    private String roomPassword;
    private int totalPlayers;
    private boolean percival;
    private boolean merlin;
    private boolean morgana;
    private boolean oberon;
    private boolean mordred;
    private List<Player> players;


    public CreateRoom() {
    }

    public CreateRoom(String id, String roomName, String roomPassword, int totalPlayers, boolean percival, boolean merlin, boolean morgana, boolean oberon, boolean mordred, List<Player> players) {
        this.id = id;
        this.roomName = roomName;
        this.roomPassword = roomPassword;
        this.totalPlayers = totalPlayers;
        this.percival = percival;
        this.merlin = merlin;
        this.morgana = morgana;
        this.oberon = oberon;
        this.mordred = mordred;
        this.players = players;

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPassword() {
        return roomPassword;
    }

    public void setRoomPassword(String roomPassword) {
        this.roomPassword = roomPassword;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public boolean isPercival() {
        return percival;
    }

    public void setPercival(boolean percival) {
        this.percival = percival;
    }

    public boolean isMerlin() {
        return merlin;
    }

    public void setMerlin(boolean merlin) {
        this.merlin = merlin;
    }

    public boolean isMorgana() {
        return morgana;
    }

    public void setMorgana(boolean morgana) {
        this.morgana = morgana;
    }

    public boolean isOberon() {
        return oberon;
    }

    public void setOberon(boolean oberon) {
        this.oberon = oberon;
    }

    public boolean isMordred() {
        return mordred;
    }

    public void setMordred(boolean mordred) {
        this.mordred = mordred;
    }




}



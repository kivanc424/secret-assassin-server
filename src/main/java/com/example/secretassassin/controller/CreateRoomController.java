package com.example.secretassassin.controller;

import com.example.secretassassin.model.CreateRoom;
import com.example.secretassassin.model.lobby.Player;
import com.example.secretassassin.repository.CreateRoomRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CreateRoomController {

    public final CreateRoomRepository createRoomRepository;

    public CreateRoomController(CreateRoomRepository createRoomRepository) {
        this.createRoomRepository = createRoomRepository;
    }

    /**
     * When creating the game
     * @param createRoom
     * @return
     */
    @PostMapping("/create-game")
    public CreateRoom createRoom(@RequestBody CreateRoom createRoom) {
        return createRoomRepository.insert(createRoom);
    }

    /**
     * Getting specific lobby data by its id
     * @param id
     * @return
     */
    @GetMapping("/get-lobby/{id}")
    public Optional<CreateRoom> getLobby(@PathVariable String id) {
        return createRoomRepository.findById(id);
    }

    /**
     * Getting specific players data
     * @param id
     * @param playerId
     * @return
     */
    @GetMapping("/get-player-information/{id}/{playerId}")
    public Player getPlayerInformation(@PathVariable String id, @PathVariable String playerId) {
        Optional<CreateRoom> room = createRoomRepository.findById(id);

        List<Player> playerList = room.get().getPlayers();

        for (Player player : playerList) {
            if (player.getId().equals(playerId)) {
                return player;
            }
        }

        return null;
    }

    /**
     * When player joins the lobby
     * @param player
     * @return
     */
    @MessageMapping("/lobby")
    @SendTo("/rooms/join-lobby")
    public Player joinLobby(@RequestBody Player player) {
         Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
         List<Player> playerList = room.get().getPlayers();
         playerList.add(new Player(player.getId(), player.getLobbyId(),
                 player.getUsername(), player.getGameMaster(), player.getReadyState(), player.getRole()));

         createRoomRepository.save(room.get());

        return player;
    }

    /**
     * When player leaves lobby
     * @param player
     * @return
     */
    @MessageMapping("/leave-lobby")
    @SendTo("/rooms/leave-lobby")
    public Player leaveLobby(@RequestBody Player player) {
        Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
        List<Player> playerList = room.get().getPlayers();
        playerList.removeIf(playerIterator -> playerIterator.getId().equals(player.getId()));

        createRoomRepository.save(room.get());

        return player;
    }

    /**
     * When player is pressing ready button it changes players status
     * @param player
     * @return
     */
    @MessageMapping("/ready")
    @SendTo("/rooms/player-ready")
    public CreateRoom playerReady(@RequestBody Player player) {
        Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
        List<Player> playerList = room.get().getPlayers();

        for (Player playerIterator : playerList) {
            if (playerIterator.getId().equals(player.getId())) {
                playerIterator.setReadyState("ready");
                break;
            }
        }

        createRoomRepository.save(room.get());

        return room.get();
    }

    /**
     * When player presses not ready the code changes the status of player
     * @param player
     * @return
     */
    @MessageMapping("/not-ready")
    @SendTo("/rooms/player-not-ready")
    public CreateRoom playerNotReady(@RequestBody Player player) {
        Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
        List<Player> playerList = room.get().getPlayers();

        for (Player playerIterator : playerList) {
            if (playerIterator.getId().equals(player.getId())) {
                playerIterator.setReadyState("not ready");
            }
        }

        return room.get();
    }


    /**
     * Initializes the game with handing out roles to player
     * @param player
     * @return
     */
    @MessageMapping("/start-game")
    @SendTo("/rooms/start-game")
    public CreateRoom startGame(@RequestBody Player player) {
        Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
        //TODO implement start game function with giving out roles to player

        List<Player> players = room.get().getPlayers();

        String[] roles = {"Minion", "Minion", "Merlin", "Assassin", "Murderer"};

        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < roles.length; j++) {
                players.get(i).setRole(roles[i]);
            }
        }

        room.get().setGameStartStatus(true);

        createRoomRepository.save(room.get());
        return room.get();
    }

    /**
     * When game master destroys lobby the lobby gets deleted from database
     * @param player
     * @return
     */
    @MessageMapping("/destroy-lobby")
    @SendTo("/rooms/destroy-lobby")
    public String destroyLobby(@RequestBody Player player) {
        Optional<CreateRoom> room = createRoomRepository.findById(player.getLobbyId());
        createRoomRepository.delete(room.get());

        return "Lobby was Destroyed";
    }


    /**
     * Get all rooms so players can see which lobby to join
     * @return
     */
    @GetMapping(value = "/get-all-rooms")
    public List<CreateRoom> getAllRooms() {
        return createRoomRepository.findAll();
    }


}

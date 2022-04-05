package Models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static common.Constants.BOARD_DESTINATION;

public class Board {

    private final HashSet<Player> players;
    HashMap<Integer, Integer> movements;
    int start, destination;
    private boolean isGameCompleted;
    private Player winner;

    public Board() {
        players = new HashSet<>();
        movements = new HashMap<>() {{
            put(13, 65);
            put(34,78);
            put(69,15);
            put(19, 38);
            put(83, 22);
            put(23, 87);
            put(62,96);
            put(68,2);
        }};

        start = 0;
        destination = 100;
        isGameCompleted = false;
    }

    public Board(HashSet<Player> players) {
        this.players = players;
        this.movements = new HashMap<>();
        start = 0;
        destination = BOARD_DESTINATION;
        isGameCompleted = false;
    }

    public boolean getIsGameCompleted() {
        return isGameCompleted;
    }

    public void addPlayers(List<Player> player) {
        this.players.addAll(player);
    }

    public void completeGame(Player winner) {
        this.isGameCompleted = true;
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    public void movePlayerPosition(Player player, int diceValue) {
        int playerDiceMovement = player.getPosition()+diceValue;
        if(playerDiceMovement > BOARD_DESTINATION) {
            return;
        }
        int playerFinalPosition = playerDiceMovement;
        if(movements.containsKey(playerDiceMovement)) {
            playerFinalPosition = movements.get(playerDiceMovement);
        }
        if(playerFinalPosition == BOARD_DESTINATION) {
            completeGame(player);
        }
        player.setPosition(playerFinalPosition);
    }
}


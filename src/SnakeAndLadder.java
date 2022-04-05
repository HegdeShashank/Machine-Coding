import Models.Board;
import Models.Dice;
import Models.Player;

import java.util.List;

public class SnakeAndLadder {
    public static void main(String[] args) {
        List<Player> players = List.of(new Player("Shashank"), new Player("Divakar"));
        Board board = new Board();
        board.addPlayers(players);

        while (!board.getIsGameCompleted()) {
            for(Player player: players) {
                int diceValue = Dice.throwDice();
                board.movePlayerPosition(player, diceValue);
                System.out.println("Player name:"+ player.getName()+", Dice value:"+diceValue+", Player position:"+player.getPosition());
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Hurray! The Winner is "+board.getWinner().getName());
    }
}

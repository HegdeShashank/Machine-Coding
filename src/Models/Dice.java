package Models;

import java.util.Random;

public class Dice {
    private static final int NUMBER_OF_FACES = 6;
    public static int throwDice() {
        Random random = new Random();
        return random.nextInt(NUMBER_OF_FACES)+1;
    }
}

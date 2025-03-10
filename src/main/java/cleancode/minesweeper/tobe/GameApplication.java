package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Advanced;

public class GameApplication {

    public static void main(String[] args) {
        Minesweaper minesweeper = new Minesweaper(new Advanced());
        minesweeper.run();
    }

}

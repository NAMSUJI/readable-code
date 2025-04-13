package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.minesweeper.Minesweaper;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Advanced;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.VeryBeginner;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(
                new Advanced(),
                new ConsoleInputHandler(),
                new ConsoleOutputHandler()
        );

        Minesweaper minesweeper = new Minesweaper(gameConfig);
        minesweeper.initialize();
        minesweeper.run();
    }

}

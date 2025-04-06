package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.config.GameConfig;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.gamelevel.VeryBeginner;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(
                new VeryBeginner(),
                new ConsoleInputHandler(),
                new ConsoleOutputHandler()
        );

        Minesweaper minesweeper = new Minesweaper(gameConfig);
        minesweeper.initialize();
        minesweeper.run();
    }

}

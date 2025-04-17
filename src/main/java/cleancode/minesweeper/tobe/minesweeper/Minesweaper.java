package cleancode.minesweeper.tobe.minesweeper;

import cleancode.minesweeper.tobe.game.GameInitializable;
import cleancode.minesweeper.tobe.game.GameRunnable;
import cleancode.minesweeper.tobe.minesweeper.board.GameBoard;
import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.exception.GameException;
import cleancode.minesweeper.tobe.minesweeper.io.InputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.OutputHandler;
import cleancode.minesweeper.tobe.minesweeper.user.UserAction;

public class Minesweaper implements GameInitializable, GameRunnable {
    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Minesweaper(GameConfig gameConfig) {
        gameBoard = new GameBoard(gameConfig.getGameLevel());
        this.inputHandler = gameConfig.getInputHandler();
        this.outputHandler = gameConfig.getOutputHandler();
    }

    @Override
    public void initialize() {
        gameBoard.initializeGame();
    }


    @Override
    public void run() {
        outputHandler.showGameStartComments();
        while (gameBoard.isInProgress()) {
            try {
                outputHandler.showBoard(gameBoard);

                CellPosition cellInput = getCellInputFromUser();
                UserAction userActionInput = getUserActionInputFromUser();
                actOnCell(cellInput, userActionInput);
            } catch (GameException e) {
                outputHandler.showExceptionMessage(e);
            } catch (Exception e) {
                // 의도하지 않은 에러인 경우
                outputHandler.showSimpleMessage("프로그램에 문제가 생겼습니다.");
                e.printStackTrace();
            }

            outputHandler.showBoard(gameBoard);

            if (gameBoard.isWinStatus()) {
                outputHandler.showGameWinningComment();
            } else if (gameBoard.isLoseStatus()) {
                outputHandler.showGameLosingComment();
            }
        }
    }

    private CellPosition getCellInputFromUser() {
        outputHandler.showCommentForSelectingCell();
        CellPosition cellPosition = inputHandler.getCellPositionFromUser();
        if (gameBoard.isInvalidCellPosition(cellPosition)) {
            throw new GameException("잘못된 좌표를 선택하셨습니다.");
        }
        return cellPosition;
    }

    private UserAction getUserActionInputFromUser() {
        outputHandler.showCommentForUserAction();
        return inputHandler.getUserActionFromUser();
    }

    private void actOnCell(CellPosition cellPosition, UserAction userActionInput) {
        if (doesUserChooseToPlantFlag(userActionInput)) {
            gameBoard.flagAt(cellPosition);
            return;
        }

        if (doesUserChooseToOpenCell(userActionInput)) {
            gameBoard.openAt(cellPosition);
            return;
        }

//        System.out.println("잘못된 번호를 선택하셨습니다.");
//        throw new IllegalStateException("잘못된 번호를 선택하셨습니다."); // 의도하지 않은 에러
        throw new GameException("잘못된 번호를 선택하셨습니다.");
    }

    private boolean doesUserChooseToPlantFlag(UserAction userAction) {
        return userAction == UserAction.FLAG;
    }

    private boolean doesUserChooseToOpenCell(UserAction userAction) {
        return userAction == UserAction.OPEN;
    }

}

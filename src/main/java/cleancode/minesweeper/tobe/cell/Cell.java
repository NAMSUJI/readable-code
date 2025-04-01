package cleancode.minesweeper.tobe.cell;

public interface Cell {

    void flag();

    void open();

    boolean isChecked();

    boolean isLandMine();

    boolean isOpened();

    boolean hasLandMineCount();

    CellSnapshot getSnapshot();
}

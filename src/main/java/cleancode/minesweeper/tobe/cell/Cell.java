package cleancode.minesweeper.tobe.cell;

public interface Cell {
    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

    void flag();

    void open();

    boolean isChecked();

    boolean isLandMine();

    boolean isOpened();

    boolean hasLandMineCount();

    String getSign();
}

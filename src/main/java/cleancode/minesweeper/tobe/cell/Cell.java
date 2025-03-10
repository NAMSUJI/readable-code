package cleancode.minesweeper.tobe.cell;

public abstract class Cell {
    protected static final String FLAG_SIGN = "⚑";
    protected static final String UNCHECKED_SIGN = "□";

    protected boolean isFlagged;
    protected boolean isOpened;

    public void flag() {
        this.isFlagged = true;
    }

    public void open() {
        this.isOpened = true;
    }

    public boolean isChecked() {
        return this.isFlagged || isOpened;
    }

    public abstract boolean isLandMine();

    public boolean isOpened() {
        return this.isOpened;
    }

    public abstract boolean hasLandMineCount();

    public abstract String getSign();
}

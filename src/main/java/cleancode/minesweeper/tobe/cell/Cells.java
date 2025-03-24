package cleancode.minesweeper.tobe.cell;

import java.util.Arrays;
import java.util.List;

public class Cells {
    // 일급 컬렉션은 단 하나의 컬렉션만 가짐
    private final List<Cell> cells;

    private Cells(List<Cell> cells) {
        this.cells = cells;
    }

    public static Cells of(List<Cell> cells) {
        return new Cells(cells);
    }

    public static Cells from(Cell[][] cells) {
        List<Cell> cellList = Arrays.stream(cells).flatMap(Arrays::stream).toList();
        return of(cellList);
    }

    public boolean isAllChecked() {
        return cells.stream().allMatch(Cell::isChecked);
    }
}

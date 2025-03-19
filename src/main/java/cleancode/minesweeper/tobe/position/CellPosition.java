package cleancode.minesweeper.tobe.position;

import java.util.Objects;

public class CellPosition {
    // final로 불변성 보장
    private final int rowIndex;
    private final int colIndex;

    public CellPosition(int rowIndex, int colIndex) {
        // 유효성 검증
        if (rowIndex < 0 || colIndex < 0) {
            throw new IllegalArgumentException("올바르지 않은 좌표입니다.");
        }

        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public static CellPosition of(int rowIndex, int colIndex) {
        return new CellPosition(rowIndex, colIndex);
    }

    // 동등성 보장
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPosition that = (CellPosition) o;
        return rowIndex == that.rowIndex && colIndex == that.colIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, colIndex);
    }

    public boolean isRowIndexMoreThanOrEqual(int rowIndex) {
        return this.rowIndex >= rowIndex;
    }

    public boolean isColIndexMoreThanOrEqual(int colSize) {
        return this.colIndex >= colSize;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public CellPosition calculatePositionBy(RelativePosition relativePosition) {
        return CellPosition.of(this.rowIndex + relativePosition.getDeltaRow(), this.colIndex + relativePosition.getDeltaCol());
    }

    public boolean canCalculatePositionBy(RelativePosition relativePosition) {
        if (this.canCalculatePositionBy(relativePosition)) {
            return this.rowIndex + relativePosition.getDeltaRow() > 0 && this.colIndex + relativePosition.getDeltaCol() > 0;
        }
        throw new IllegalArgumentException("움직일 수 있는 좌표가 아닙니다.");
    }

    public boolean isRowIndexLessThan(int rowSize) {
        return !this.isRowIndexMoreThanOrEqual(rowSize);
    }

    public boolean isColIndexLessThan(int colSize) {
        return !this.isColIndexMoreThanOrEqual(colSize);
    }
}

package cleancode.minesweeper.tobe.minesweeper.user;

public enum UserAction {
    OPEN("셀 오픈"),
    FLAG("깃발 뽑기"),
    UNKNOWN("해당 없음");

    private final String description;

    UserAction(String description) {
        this.description = description;
    }
}

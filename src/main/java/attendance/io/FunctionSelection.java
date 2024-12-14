package attendance.io;

public enum FunctionSelection {
    CONFIRMATION("1", "출석 확인"),
    MODIFICATION("2", "출석 수정"),
    CREW_HISTORY("3", "크루별 출석 기록 확인"),
    WARNING_CREW_CHECK("4", "제적 위험자 확인"),
    QUIT("Q", "종료");

    private final String id;
    private final String name;

    FunctionSelection(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

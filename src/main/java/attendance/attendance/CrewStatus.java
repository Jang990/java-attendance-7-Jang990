package attendance.attendance;

public enum CrewStatus {
    NORMAL(""),
    WARNING("경고"),
    MEETING("면담"),
    EXPELLED("제적");

    private final String name;

    CrewStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

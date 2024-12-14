package attendance.attendance;

public enum CrewStatus {
    EXPELLED("제적"),
    MEETING("면담"),
    WARNING("경고"),
    NORMAL("");

    private final String name;

    CrewStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

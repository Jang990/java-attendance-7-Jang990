package attendance.attendance;

public enum AttendanceStatus {
    ATTENDANCE("출석"),
    TARDINESS("지각"),
    ABSENCE("결석");

    private final String name;

    AttendanceStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

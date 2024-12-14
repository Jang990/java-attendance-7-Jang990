package attendance.io.attendance;

import java.time.LocalDateTime;

public class AttendancesDto {
    private final String name;
    private final LocalDateTime attendancesTime;

    public AttendancesDto(String name, LocalDateTime attendancesTime) {
        this.name = name;
        this.attendancesTime = attendancesTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getAttendancesTime() {
        return attendancesTime;
    }

    @Override
    public String toString() {
        return "AttendancesDto{" +
                "name='" + name + '\'' +
                ", attendancesTime=" + attendancesTime +
                '}';
    }
}

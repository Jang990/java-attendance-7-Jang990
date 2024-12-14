package attendance.attendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class AttendanceHistory {
    private final String name;
    private final List<AttendanceTime> history;

    public AttendanceHistory(String name) {
        this.name = name;
        this.history = new LinkedList<>();
    }

    public void add(LocalDateTime attendanceTime) {
        if(isAlreadyAttended(attendanceTime.toLocalDate()))
            throw new IllegalArgumentException("");
        history.add(new AttendanceTime(attendanceTime));
    }

    public boolean isAlreadyAttended(LocalDate date) {
        return history.stream()
                .anyMatch((attendanceTime -> attendanceTime.isSameDate(date)));
    }
}

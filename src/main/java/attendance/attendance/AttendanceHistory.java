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

    public int countAttendance() {
        return (int) history.stream()
                .filter(attendanceTime ->
                        AttendanceStatus.ATTENDANCE.equals(attendanceTime.getStatus()))
                .count();
    }

    public int countTardiness() {
        return (int) history.stream()
                .filter(attendanceTime ->
                        AttendanceStatus.TARDINESS.equals(attendanceTime.getStatus()))
                .count();
    }

    public int countAbsence() {
        return (int) history.stream()
                .filter(attendanceTime ->
                        AttendanceStatus.ABSENCE.equals(attendanceTime.getStatus()))
                .count();
    }

    public CrewStatus getCrewStatus() {
        int absence = countTardiness() / 3 + countAbsence();
        if(absence < 2)
            return CrewStatus.NORMAL;
        if(absence < 3)
            return CrewStatus.WARNING;
        if(absence <= 5)
            return CrewStatus.MEETING;
        return CrewStatus.EXPELLED;
    }

    @Override
    public String toString() {
        return "- %s: 결석 %d회, 지각 %d회 (%s)"
                .formatted(
                        name,
                        countAbsence(),
                        countTardiness(),
                        getCrewStatus().getName());
    }
}

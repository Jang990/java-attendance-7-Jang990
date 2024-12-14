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
            throw new IllegalArgumentException("[ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.");
        AttendanceTime result = new AttendanceTime(attendanceTime);
        history.add(result);
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

    public AttendanceTime getSameDate(LocalDateTime time) {
        Integer idx = findSameDateIdx(time);
        if(idx == null) return null;
        return history.get(idx);
    }

    public void modify(LocalDateTime time) {
        AttendanceTime sameDateTime = getSameDate(time);
        history.remove(sameDateTime);
        AttendanceTime after = new AttendanceTime(time);
        history.add(after);

        System.out.println("%s -> %02d:%02d (%s) 수정 완료!".formatted(
                sameDateTime, after.getTime().getHour(), after.getTime().getMinute(),
                after.getStatus().getName()));
    }

    private Integer findSameDateIdx(LocalDateTime time) {
        for (int i = 0; i < history.size(); i++) {
            if(history.get(i).isSameDate(time.toLocalDate()))
                return i;
        }
        return null;
    }
}

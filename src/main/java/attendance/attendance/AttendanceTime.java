package attendance.attendance;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AttendanceTime {
    private static final int TARDINESS_MINUTE = 5;
    private static final int ABSENCE_MINUTE = 30;

    private static final LocalTime MONDAY_TARDINESS = LocalTime.of(13, TARDINESS_MINUTE);
    private static final LocalTime MONDAY_ABSENCE = LocalTime.of(13, ABSENCE_MINUTE);
    private static final LocalTime NORMAL_TARDINESS = LocalTime.of(10, TARDINESS_MINUTE);
    private static final LocalTime NORMAL_ABSENCE = LocalTime.of(10, ABSENCE_MINUTE);
    private static final LocalTime NORMAL_END = LocalTime.of(18, 0);

    private final LocalDateTime dateTime;

    public AttendanceTime(LocalDateTime dateTime) {
        if(dateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || dateTime.getDayOfWeek().equals(DayOfWeek.SUNDAY))
            throw new IllegalArgumentException();
        this.dateTime = dateTime;
    }

    public boolean isSameDate(LocalDate date) {
        return dateTime.toLocalDate().equals(date);
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "%02d월 %02d일 %s %02d:%02d (%s)".formatted(
                dateTime.getMonthValue(),
                dateTime.getDayOfMonth(),
                toDayOfWeekString(dateTime.getDayOfWeek()),
                dateTime.getHour(),
                dateTime.getMinute(),
                getStatus().getName()
        );
    }

    private Object toDayOfWeekString(DayOfWeek dayOfWeek) {
        if(dayOfWeek.equals(DayOfWeek.MONDAY))
            return "월요일";
        if(dayOfWeek.equals(DayOfWeek.TUESDAY))
            return "화요일";
        if(dayOfWeek.equals(DayOfWeek.WEDNESDAY))
            return "수요일";
        if(dayOfWeek.equals(DayOfWeek.THURSDAY))
            return "목요일";
        return "금요일";
    }

    public AttendanceStatus getStatus() {
        if(dateTime == null)
            return AttendanceStatus.ABSENCE;
        if(dateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))
            return getMondayStatus();
        return getNormalStatus();
    }

    private AttendanceStatus getNormalStatus() {
        if(time().isBefore(NORMAL_TARDINESS))
            return AttendanceStatus.ATTENDANCE;
        if(time().isBefore(NORMAL_ABSENCE))
            return AttendanceStatus.TARDINESS;
        return AttendanceStatus.ABSENCE;
    }

    private AttendanceStatus getMondayStatus() {
        if(time().isBefore(MONDAY_TARDINESS))
            return AttendanceStatus.ATTENDANCE;
        if(time().isBefore(MONDAY_ABSENCE))
            return AttendanceStatus.TARDINESS;
        return AttendanceStatus.ABSENCE;
    }

    private LocalTime time() {
        return dateTime.toLocalTime();
    }
}

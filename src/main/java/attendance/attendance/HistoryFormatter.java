package attendance.attendance;

import attendance.DateFormatUtils;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HistoryFormatter {
    public String formatted(AttendanceHistory history) {
        StringBuilder sb = new StringBuilder();

        sb.append("이번 달 %s의 출석 기록입니다.".formatted(history.getName()))
                .append(System.lineSeparator());
        appendDate(history, sb);
        sb.append("출석: ").append(history.countAttendance()).append(System.lineSeparator());
        sb.append("지각: ").append(history.countTardiness()).append(System.lineSeparator());
        sb.append("결석: ").append(history.countAbsence()).append(System.lineSeparator());
        if(history.getCrewStatus().equals(CrewStatus.MEETING))
            sb.append("면담 대상자입니다.");
        return sb.toString();
    }

    private void appendDate(AttendanceHistory history, StringBuilder sb) {
        LocalDateTime now = DateTimes.now();
        int historyIdx = 0;
        List<AttendanceTime> times = history.getHistory().stream().sorted().toList();
        for (int i = 1; i <= now.getDayOfMonth(); i++) {
            LocalDate current = LocalDate.of(now.getYear(), now.getMonthValue(), i);
            if(current.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                    || current.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                continue;

            if (historyIdx >= history.getHistory().size()
                    || times.get(historyIdx).getDayOfMonth() != i) {
                appendEmptyDate(sb, current);
                continue;
            }
            sb.append(times.get(historyIdx++).toString()).append(System.lineSeparator());
        }
    }

    private void appendEmptyDate(StringBuilder sb, LocalDate empty) {
        sb.append("%02d월 %02d일 %s --:-- (결석)".formatted(
                empty.getMonthValue(), empty.getDayOfMonth(),
                DateFormatUtils.toDayOfWeekString(
                        LocalDate.of(empty.getYear(), empty.getMonthValue(), empty.getDayOfMonth()).getDayOfWeek())
        )).append(System.lineSeparator());
        return;
    }
}

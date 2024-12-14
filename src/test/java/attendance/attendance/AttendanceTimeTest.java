package attendance.attendance;

import camp.nextstep.edu.missionutils.DateTimes;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceTimeTest {
    private final LocalDate MONDAY = LocalDate.of(2024, 12, 9);
    private final LocalDate NORMAL = LocalDate.of(2024, 12, 10);

    @Test
    void 주말에_출석시간을_기록할_수_없다() {
        assertThrows(IllegalArgumentException.class,
                () -> new AttendanceTime(LocalDateTime.of(2024, 12, 14, 0, 0)));
    }

    @Test
    void 시작시간보다_5분이하로_늦으면_출석_처리한다() {
        assertEquals(AttendanceStatus.ATTENDANCE,
                new AttendanceTime(LocalDateTime.of(MONDAY, LocalTime.of(13, 4))).getStatus());
        assertEquals(AttendanceStatus.ATTENDANCE,
                new AttendanceTime(LocalDateTime.of(NORMAL, LocalTime.of(10, 4))).getStatus());
    }

    @Test
    void 시작시간보다_5분초과로_늦으면_지각_처리한다() {
        assertEquals(AttendanceStatus.TARDINESS,
                new AttendanceTime(LocalDateTime.of(MONDAY, LocalTime.of(13, 5))).getStatus());
        assertEquals(AttendanceStatus.TARDINESS,
                new AttendanceTime(LocalDateTime.of(NORMAL, LocalTime.of(10, 5))).getStatus());
    }

    @Test
    void 시작시간보다_30분이하로_늦으면_지각_처리한다() {
        assertEquals(AttendanceStatus.TARDINESS,
                new AttendanceTime(LocalDateTime.of(MONDAY, LocalTime.of(13, 29))).getStatus());
        assertEquals(AttendanceStatus.TARDINESS,
                new AttendanceTime(LocalDateTime.of(NORMAL, LocalTime.of(10, 29))).getStatus());
    }

    @Test
    void 시작시간보다_30분이상으로_늦으면_결석_처리한다() {
        assertEquals(AttendanceStatus.ABSENCE,
                new AttendanceTime(LocalDateTime.of(MONDAY, LocalTime.of(13, 30))).getStatus());
        assertEquals(AttendanceStatus.ABSENCE,
                new AttendanceTime(LocalDateTime.of(NORMAL, LocalTime.of(10, 30))).getStatus());
    }

    @Test
    void 출석_시간을_문자열로_확인할_수_있다() {
        assertEquals("12월 02일 월요일 13:00 (출석)",
                new AttendanceTime(LocalDateTime.of(2024, 12, 2, 13,0))
                        .toString());
    }

}
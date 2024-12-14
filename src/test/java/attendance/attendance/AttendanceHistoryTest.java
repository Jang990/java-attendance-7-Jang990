package attendance.attendance;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceHistoryTest {

    @Test
    void 이미_출석한_날인지_확인할_수_있음() {
        AttendanceHistory history = new AttendanceHistory("ABC");
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 13, 14, 0, 0);

        history.add(dateTime);
        assertTrue(history.isAlreadyAttended(dateTime.toLocalDate()));
    }

    @Test
    void 출석_기록_추가시_이미_출석한_날을_추가하려면_예외발생() {
        AttendanceHistory history = new AttendanceHistory("ABC");
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 13, 14, 0, 0);

        history.add(dateTime);
        assertThrows(IllegalArgumentException.class, () -> history.add(dateTime));
    }

    @Test
    void 출석_지각_결석_수를_파악할_수_있음() {
        AttendanceHistory history = new AttendanceHistory("ABC");

        // 결석
        history.add(LocalDateTime.of(2024, 12, 13, 14, 0, 0));
        history.add(LocalDateTime.of(2024, 12, 12, 14, 0, 0));

        // 지각
        history.add(LocalDateTime.of(2024, 12, 11, 10, 29, 0));

        // 출석
        history.add(LocalDateTime.of(2024, 12, 10, 10, 0, 0));
        history.add(LocalDateTime.of(2024, 12, 9, 13, 0, 0));

        assertEquals(2, history.countAbsence());
        assertEquals(1, history.countTardiness());
        assertEquals(2, history.countAttendance());
    }

}
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

}
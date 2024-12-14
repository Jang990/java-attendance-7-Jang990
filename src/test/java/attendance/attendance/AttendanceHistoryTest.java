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
        AttendanceHistory history = create023History();

        assertEquals(0, history.countAttendance());
        assertEquals(2, history.countTardiness());
        assertEquals(3, history.countAbsence());
    }

    // TODO: 테스트 빈약
    @Test
    void 학생_상태_조회_가능() {
        AttendanceHistory history = create023History();
        assertEquals(CrewStatus.MEETING, history.getCrewStatus());
    }

    @Test
    void 학생_상태_toString() {
        AttendanceHistory history = create023History();
        assertEquals("- 빙티: 결석 3회, 지각 2회 (면담)", history.toString());
    }

    private AttendanceHistory create023History() {
        AttendanceHistory history = new AttendanceHistory("빙티");

        // 지각
        history.add(LocalDateTime.of(2024, 12, 9, 13, 6, 0));
        history.add(LocalDateTime.of(2024, 12, 10, 10, 29, 0));

        // 결석
        history.add(LocalDateTime.of(2024, 12, 11, 14, 0, 0));
        history.add(LocalDateTime.of(2024, 12, 12, 14, 0, 0));
        history.add(LocalDateTime.of(2024, 12, 13, 14, 0, 0));

        return history;
    }

}
package attendance.attendance;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HistoryFormatterTest {

    @Test
    void 포매팅() {
        HistoryFormatter formatter = new HistoryFormatter();
        AttendanceHistory history = new AttendanceHistory("ABC");
        history.add(LocalDateTime.of(2024, 12, 2, 14, 1));
        history.add(LocalDateTime.of(2024, 12, 3, 10, 1));
        history.add(LocalDateTime.of(2024, 12, 4, 10, 29));

        String result = formatter.formatted(history);
        System.out.println(result);
    }

}
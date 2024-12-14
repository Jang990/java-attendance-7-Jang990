package attendance.io.attendance;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttendancesFileReaderTest {

    @Test
    void csv파일을_읽어올_수_있다() {
        AttendancesFileReader reader = new AttendancesFileReader();
        List<AttendancesDto> result = reader.read();
        System.out.println(result);

        assertEquals(41, result.size());
        assertEquals("쿠키",result.getFirst().getName());
        assertEquals(LocalDateTime.of(2024, 12, 13, 10, 8, 0),
                result.getFirst().getAttendancesTime());

        assertEquals("짱수",result.getLast().getName());
        assertEquals(LocalDateTime.of(2024, 12, 2, 13, 0, 0),
                result.getLast().getAttendancesTime());
    }

}
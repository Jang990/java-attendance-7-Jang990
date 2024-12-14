package attendance;

import attendance.io.attendance.AttendancesFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrewAttendanceRepositoryTest {

    @Test
    void 파일을_읽어서_Map에_저장함() {
        CrewAttendanceRepository repository = new CrewAttendanceRepository(
                new AttendancesFileReader());
        assertNotNull(repository.get("쿠키"));
        assertNotNull(repository.get("짱수"));
    }

}
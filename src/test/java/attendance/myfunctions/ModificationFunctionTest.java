package attendance.myfunctions;

import attendance.CrewAttendanceRepository;
import attendance.io.InputReader;
import attendance.io.attendance.AttendancesFileReader;
import attendance.io.modification.ModificationDto;
import attendance.io.modification.ModificationReader;
import attendance.io.modification.ModificationReaderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ModificationFunctionTest {
    CrewAttendanceRepository repository;

    @BeforeEach
    void beforeEach() {
        AttendancesFileReader fileReader = new AttendancesFileReader();
        repository = new CrewAttendanceRepository(fileReader);
    }
    @Test
    void 수정기능() {
        ModificationDto dto = new ModificationDto("쿠키", LocalDateTime.of(2024, 12, 13, 10, 1, 0));
        ModificationFunction function = new ModificationFunction(new ModificationReaderStub(dto), repository);
        function.apply();

        assertEquals(LocalTime.of(10, 1, 0), repository.get("쿠키").getSameDate(dto.getModificationTime()).getTime());
    }

}
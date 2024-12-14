package attendance.confirmation;

import attendance.CrewAttendanceRepository;
import attendance.io.attendance.AttendancesFileReader;
import attendance.io.confirmation.ConfirmationDto;
import attendance.io.confirmation.ConfirmationReader;
import attendance.io.confirmation.ConfirmationReaderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ConfirmationFunctionTest {
    CrewAttendanceRepository repository;

    @BeforeEach
    void beforeEach() {
        AttendancesFileReader fileReader = new AttendancesFileReader();
        repository = new CrewAttendanceRepository(fileReader);
    }

    @Test
    void 출석_확인_기능() {
        LocalDateTime time = LocalDateTime.of(2024, 12, 6, 10, 0, 0);
        ConfirmationReaderStub confirmationReaderStub = new ConfirmationReaderStub(
                new ConfirmationDto("쿠키", time));
        ConfirmationFunction function = new ConfirmationFunction(confirmationReaderStub, repository);

        function.apply();

        assertTrue(repository.get("쿠키").isAlreadyAttended(time.toLocalDate()));
    }

    @Test
    void 출석_확인_기능() {
        LocalDateTime time = LocalDateTime.of(2024, 12, 6, 10, 0, 0);
        ConfirmationReaderStub confirmationReaderStub = new ConfirmationReaderStub(
                new ConfirmationDto("쿠키", time));
        ConfirmationFunction function = new ConfirmationFunction(confirmationReaderStub, repository);

        function.apply();

        assertTrue(repository.get("쿠키").isAlreadyAttended(time.toLocalDate()));
    }

}
package attendance.io.confirmation;

import attendance.CrewAttendanceRepository;
import attendance.io.InputReader;

import static org.junit.jupiter.api.Assertions.*;

public class ConfirmationReaderStub extends ConfirmationReader {

    private ConfirmationDto testValue;

    public ConfirmationReaderStub(ConfirmationDto value) {
        super(null, null);
        testValue = value;
    }

    @Override
    public ConfirmationDto read() {
        return testValue;
    }
}
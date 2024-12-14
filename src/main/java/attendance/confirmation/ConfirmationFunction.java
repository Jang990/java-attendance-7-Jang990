package attendance.confirmation;

import attendance.CrewAttendanceRepository;
import attendance.attendance.AttendanceHistory;
import attendance.io.confirmation.ConfirmationDto;
import attendance.io.confirmation.ConfirmationReader;

public class ConfirmationFunction {
    private final ConfirmationReader reader;
    private final CrewAttendanceRepository repository;

    public ConfirmationFunction(ConfirmationReader reader, CrewAttendanceRepository repository) {
        this.reader = reader;
        this.repository = repository;
    }

    public void apply() {
        ConfirmationDto input = reader.read();
        AttendanceHistory history = repository.get(input.getName());
        history.add(input.getTime());
    }
}

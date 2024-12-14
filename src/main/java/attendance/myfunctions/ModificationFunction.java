package attendance.myfunctions;

import attendance.CrewAttendanceRepository;
import attendance.attendance.AttendanceHistory;
import attendance.io.modification.ModificationDto;
import attendance.io.modification.ModificationReader;

public class ModificationFunction {
    private final ModificationReader reader;
    private final CrewAttendanceRepository repository;

    public ModificationFunction(ModificationReader reader, CrewAttendanceRepository repository) {
        this.reader = reader;
        this.repository = repository;
    }

    public void apply() {
        ModificationDto input = reader.read();
        AttendanceHistory history = repository.get(input.getCrewName());
        history.modify(input.getModificationTime());
    }

}

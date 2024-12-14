package attendance.myfunctions;

import attendance.CrewAttendanceRepository;
import attendance.attendance.HistoryFormatter;
import attendance.io.NicknameReader;

public class CrewHistoryFunction {
    private final NicknameReader nicknameReader;
    private final CrewAttendanceRepository repository;
    private final HistoryFormatter formatter;

    public CrewHistoryFunction(NicknameReader nicknameReader, CrewAttendanceRepository repository, HistoryFormatter formatter) {
        this.nicknameReader = nicknameReader;
        this.repository = repository;
        this.formatter = formatter;
    }

    public void apply() {
        String input = nicknameReader.read();
        System.out.println(formatter.formatted(repository.get(input)));
    }
}

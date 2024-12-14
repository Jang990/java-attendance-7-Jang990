package attendance;

import attendance.attendance.AttendanceHistory;
import attendance.io.attendance.AttendancesDto;
import attendance.io.attendance.AttendancesFileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrewAttendanceRepository {
    private final Map<String, AttendanceHistory> map;

    public CrewAttendanceRepository(AttendancesFileReader fileReader) {
        map = new HashMap<>();
        List<AttendancesDto> attendances = fileReader.read();
        for (AttendancesDto data : attendances) {
            String crewName = data.getName();
            if (!map.containsKey(crewName)) {
                map.put(crewName, new AttendanceHistory(crewName));
            }
            map.get(crewName).add(data.getAttendancesTime());
        }
    }

    public AttendanceHistory get(String crwName) {
        return map.get(crwName);
    }
}

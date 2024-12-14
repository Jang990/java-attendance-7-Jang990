package attendance.myfunctions;

import attendance.CrewAttendanceRepository;
import attendance.attendance.AttendanceHistory;
import attendance.attendance.CrewStatus;

import java.util.List;

public class WarningCrewCheckFunction {
    private final CrewAttendanceRepository repository;

    public WarningCrewCheckFunction(CrewAttendanceRepository repository) {
        this.repository = repository;
    }


    public void apply() {
        /*
        제적 위험자 조회 결과
- 빙티: 결석 3회, 지각 2회 (면담)
- 이든: 결석 2회, 지각 4회 (면담)
- 쿠키: 결석 2회, 지각 2회 (경고)
- 빙봉: 결석 1회, 지각 5회 (경고)
         */
        System.out.println("제적 위험자 조회 결과");
        List<AttendanceHistory> result = repository.findAll();
        for (AttendanceHistory history : sort(result)) {
            System.out.println(history);
        }
    }

    private List<AttendanceHistory> sort(List<AttendanceHistory> result) {
        return result.stream()
                .filter(history ->
                        history.getCrewStatus() != CrewStatus.NORMAL)
                .sorted((h1, h2) -> {
                    if (!h1.getCrewStatus().equals(h2.getCrewStatus())) {
                        return h1.getCrewStatus().compareTo(h2.getCrewStatus());
                    }
                    int h1Sum = h1.countTardiness() + h1.countAbsence();
                    int h2Sum = h2.countTardiness() + h2.countAbsence();
                    if(h1Sum == h2Sum)
                        return h1.getName().compareTo(h2.getName());
                    return Integer.compare(h1Sum, h2Sum);
                }).toList();
    }
}

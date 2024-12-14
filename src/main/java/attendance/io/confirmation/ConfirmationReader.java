package attendance.io.confirmation;

import attendance.CrewAttendanceRepository;
import attendance.io.InputReader;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ConfirmationReader {
    private final InputReader reader;
    private final CrewAttendanceRepository repository;

    public ConfirmationReader(InputReader reader, CrewAttendanceRepository repository) {
        this.reader = reader;
        this.repository = repository;
    }

    public ConfirmationDto read() {
        if(getNow().equals(DayOfWeek.SATURDAY)
                || getNow().equals(DayOfWeek.SUNDAY))
            throw new IllegalArgumentException("[ERROR] 12월 14일 토요일은 등교일이 아닙니다.");
        return new ConfirmationDto(readName(), readTime());
    }

    private LocalDateTime getNow() {
        return LocalDateTime.of(2024, 12, 13, 10, 0, 0);
//        return DateTimes.now();
    }

    private String readName() {
        System.out.println("닉네임을 입력해주세요.");
        String name = reader.readLine();
        if(!repository.hasCrew(name))
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 닉네임입니다.");
        return name;
    }

    private LocalDateTime readTime() {
        try {
            System.out.println("등교 시간을 입력해 주세요.");
            LocalTime time = parseTime();
            return LocalDateTime.of(
                    getNow().toLocalDate(),
                    time
            );
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.", e);
        }
    }

    private LocalTime parseTime() {
        String line = reader.readLine();
        String[] args = line.split(":");
        return LocalTime.of(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1])
        );
    }
}

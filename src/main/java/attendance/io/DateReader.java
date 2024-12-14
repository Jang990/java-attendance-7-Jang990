package attendance.io;

import camp.nextstep.edu.missionutils.DateTimes;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateReader {
    private final InputReader reader;

    public DateReader(InputReader reader) {
        this.reader = reader;
    }

    public LocalDateTime readTime(String prompt) {
        try {
            System.out.println(prompt);
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

    private LocalDateTime getNow() {
//        return LocalDateTime.of(2024, 12, 13, 10, 0, 0);
        return DateTimes.now();
    }
}

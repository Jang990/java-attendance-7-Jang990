package attendance.io.modification;

import attendance.io.DateReader;
import attendance.io.InputReader;
import attendance.io.NicknameReader;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ModificationReader {
    private final InputReader reader;
    private final NicknameReader nicknameReader;
    private final DateReader dateReader;

    public ModificationReader(InputReader reader, NicknameReader nicknameReader, DateReader dateReader) {
        this.reader = reader;
        this.nicknameReader = nicknameReader;
        this.dateReader = dateReader;
    }

    public ModificationDto read() {
        return new ModificationDto(
                nicknameReader.read(),
                readModificationDateTime());
    }

    private LocalDateTime readModificationDateTime() {
        System.out.println("수정하려는 날짜(일)를 입력해 주세요.");
        int day = reader.readInt();
        return LocalDateTime.of(
                LocalDate.of(getNow().getYear(), getNow().getMonth(), day),
                dateReader.readTime("언제로 변경하겠습니까?").toLocalTime()
        );
    }

    private LocalDateTime getNow() {
        return DateTimes.now();
    }
}

package attendance.io;

import attendance.CrewAttendanceRepository;

public class NicknameReader {
    private final InputReader reader;
    private final CrewAttendanceRepository repository;

    public NicknameReader(InputReader reader, CrewAttendanceRepository repository) {
        this.reader = reader;
        this.repository = repository;
    }

    public String read() {
        System.out.println("닉네임을 입력해주세요.");
        String name = reader.readLine();
        if(!repository.hasCrew(name))
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 닉네임입니다.");
        return name;
    }
}

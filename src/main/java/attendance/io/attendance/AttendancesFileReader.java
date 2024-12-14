package attendance.io.attendance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class AttendancesFileReader {
    private static final String path = "src/main/resources/attendances.csv";
    private final String DELIMITER = ",";
    private final int NAME_IDX = 0;
    private final int TIME_IDX = 1;

    public List<AttendancesDto> read() {
        try(BufferedReader br =  new BufferedReader(new FileReader(path))) {
            return readFile(br);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private List<AttendancesDto> readFile(BufferedReader br) throws IOException {
        br.readLine();

        List<AttendancesDto> result = new LinkedList<>();
        String lien;
        while ((lien = br.readLine()) != null) {
            String[] args = lien.split(DELIMITER);
            result.add(new AttendancesDto(args[NAME_IDX], parseLocalDateTime(args[TIME_IDX])));
        }
        return result;
    }

    private LocalDateTime parseLocalDateTime(String value) {
        return LocalDateTime.parse(value,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

}

package attendance.io.confirmation;

import java.time.LocalDateTime;

public class ConfirmationDto {
    private final String name;
    private final LocalDateTime time;

    public ConfirmationDto(String name, LocalDateTime time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ConfirmationDto{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}

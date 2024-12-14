package attendance.io.modification;

import java.time.LocalDateTime;

public class ModificationDto {
    private final String crewName;
    private final LocalDateTime modificationTime;

    public ModificationDto(String crewName, LocalDateTime modificationTime) {
        this.crewName = crewName;
        this.modificationTime = modificationTime;
    }

    public String getCrewName() {
        return crewName;
    }

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }
}

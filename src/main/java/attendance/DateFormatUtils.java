package attendance;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateFormatUtils {
    public static String toMonthString(LocalDate date) {
        return "%d월 %d일 %s".formatted(
                date.getMonthValue(),
                date.getDayOfMonth(),
                toDayOfWeekString(date.getDayOfWeek())
        );
    }

    public static String toDayOfWeekString(DayOfWeek dayOfWeek) {
        if(dayOfWeek.equals(DayOfWeek.MONDAY))
            return "월요일";
        if(dayOfWeek.equals(DayOfWeek.TUESDAY))
            return "화요일";
        if(dayOfWeek.equals(DayOfWeek.WEDNESDAY))
            return "수요일";
        if(dayOfWeek.equals(DayOfWeek.THURSDAY))
            return "목요일";
        return "금요일";
    }
}

package attendance.io.function;

import attendance.DateFormatUtils;
import attendance.io.InputReader;
import camp.nextstep.edu.missionutils.DateTimes;

public class FunctionSelectionReader {
    private final InputReader reader;

    public FunctionSelectionReader(InputReader reader) {
        this.reader = reader;
    }

    public FunctionSelection read() {
        System.out.println("""
                오늘은 %s입니다. 기능을 선택해 주세요.
                1. 출석 확인
                2. 출석 수정
                3. 크루별 출석 기록 확인
                4. 제적 위험자 확인
                Q. 종료
                """.formatted(DateFormatUtils.toMonthString(
                        DateTimes.now().toLocalDate())));
        return toFunctionSelection(reader.readLine());
    }

    private FunctionSelection toFunctionSelection(String id) {
        for (FunctionSelection selection : FunctionSelection.values()) {
            if (id.equals(selection.getId())) {
                return selection;
            }
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
    }
}

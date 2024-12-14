package attendance.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    public String readLine() {
        return Console.readLine();
    }

    public int readInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException  e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.", e);
        }
    }
}

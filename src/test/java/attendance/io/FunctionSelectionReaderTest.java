package attendance.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionSelectionReaderTest {
    @Test
    void 사용자_기능_선택을_읽어들임() {
        assertEquals(FunctionSelection.CONFIRMATION,
                new FunctionSelectionReader(new InputReaderStub("1")).read());
        assertEquals(FunctionSelection.MODIFICATION,
                new FunctionSelectionReader(new InputReaderStub("2")).read());
        assertEquals(FunctionSelection.CREW_HISTORY,
                new FunctionSelectionReader(new InputReaderStub("3")).read());
        assertEquals(FunctionSelection.WARNING_CREW_CHECK,
                new FunctionSelectionReader(new InputReaderStub("4")).read());
        assertEquals(FunctionSelection.QUIT,
                new FunctionSelectionReader(new InputReaderStub("Q")).read());
    }

    @Test
    void 잘못된_값을_입력하면_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> new FunctionSelectionReader(new InputReaderStub("KK")).read());
    }

}
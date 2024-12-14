package attendance.io.modification;

public class ModificationReaderStub extends ModificationReader {
    private ModificationDto testValue;

    public ModificationReaderStub(ModificationDto value) {
        super(null, null, null);
        testValue = value;
    }

    @Override
    public ModificationDto read() {
        return testValue;
    }
}
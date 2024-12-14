package attendance.io;

class InputReaderStub extends InputReader{
    private String testValue;

    public InputReaderStub(String testValue) {
        this.testValue = testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public String readLine() {
        return testValue;
    }
}
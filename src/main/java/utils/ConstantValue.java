package utils;

public enum ConstantValue {
    EXPRESSION_START(5),
    SEPARATOR_POS(2);

    private final int value;

    ConstantValue(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}

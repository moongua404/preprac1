package calculator.model;

public enum Operator {
    ADD(){
        @Override
        public int calculate(int left, int right) {
            return left + right;
        }
    },
    SUB(){
        @Override
        public int calculate(int left, int right) {
            return left - right;
        }
    };

    public abstract int calculate(int left, int right);
}

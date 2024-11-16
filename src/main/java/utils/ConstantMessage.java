package utils;

public enum ConstantMessage {
    START_GUIDE_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT_GUIDE_MESSAGE("결과 : %d"),
    INVALID_SEPARATOR("[ERROR] 부적절한 구분자 입력입니다. "),
    INVALID_NUMBER("[ERROR] 부적절한 수식의 입력입니다. "),
    EMPTY_INPUT("[ERROR] 빈 값이 입력되어 프로그램을 종료합니다. ");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

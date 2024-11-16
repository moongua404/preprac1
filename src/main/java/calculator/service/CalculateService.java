package calculator.service;

import calculator.model.Separator;
import utils.ConstantMessage;
import utils.ConstantValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateService {

    public boolean getSeparator(String sentence, Separator separator) {
        try {
            separator.add(extractSeparator(sentence));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private char extractSeparator(String sentence) {
        /*
        String regex = "^//.\\\\";
        boolean isMatch = Pattern.compile(regex).matcher(sentence).find();
        System.out.println(isMatch);
        System.out.println(Pattern.compile(regex).matcher(sentence).group());
        */
        //나중에 Matcher 로 고치자...
        if (sentence.length() >= ConstantValue.EXPRESSION_START.get()) {
            if (sentence.charAt(0) == '/' && sentence.charAt(1) == '/'
                    && sentence.charAt(3) == '\\' && sentence.charAt(4) == 'n') {
                return sentence.charAt(ConstantValue.SEPARATOR_POS.get());
            }
        }
        throw new IllegalArgumentException(ConstantMessage.INVALID_SEPARATOR.getMessage());
    }

}

package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    List<Character> separators;

    public Separator(List<Character> separators) {
        this.separators = new ArrayList<>();
        this.separators.addAll(separators);
    }

    public Separator() {
        this.separators = new ArrayList<>();
    }

    public void add(char separator) {
        this.separators.add(separator);
    }

    public String getRegex() {
        List<String> separator = new ArrayList<>();
        separators.forEach((item)->separator.add("\\"+item.toString()));
        return String.join("|", separator);
    }
}

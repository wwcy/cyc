package cyc.parser;

import java.util.Arrays;
import java.util.List;

public class Token {

    private static final List<String> token = Arrays.asList(
            "@class",
                 "@main",
                 "(",
                 ")",
                 "{",
                 "}",
                 "[",
                 "]",
                 ";"
    );

    public static List<String> getCommand() {
        return token;
    }
}

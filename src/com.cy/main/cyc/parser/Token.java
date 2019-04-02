package cyc.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Token {

    private static final Map<String,String> token = new HashMap<>();

    static {
        token.put("CLASS","@class");
        token.put("MAIN","@main");
        token.put("LP","(");
        token.put("RP",")");
        token.put("LBP","{");
        token.put("RBP","}");
        token.put("LSB","[");
        token.put("RSB","]");
        token.put("SEMICOLON",";");
    }

    public static Map<String,String> getCommand() {
        return token;
    }
}

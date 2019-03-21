package cyc;

import cyc.parser.Token;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        if(args.length > 0){
            System.exit(compile(args));
        }else{
            System.out.println("请输入参数!");
        }
    }

    public static int compile(String[] args){
        return new cyc.main.Main() .compile(args);
    }
}

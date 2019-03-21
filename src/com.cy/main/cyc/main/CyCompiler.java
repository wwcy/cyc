package cyc.main;

import cyc.file.DefaultFileObject;
import cyc.parser.Scanner;
import cyc.parser.Token;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcy on 2019/3/20.
 */
public class CyCompiler {


    public void compile(List<String> sourceFiles){
        parserChar(parseFiles(sourceFiles));
    }

    /**
     * 源文件读取
     * @param sourceFiles
     * @return
     */
    public List<CharBuffer> parseFiles(List<String> sourceFiles){
        List<CharBuffer> sourceChar = new ArrayList<>();
        for (String sourceFile :sourceFiles) {
            sourceChar.add(DefaultFileObject.getCharContent(sourceFile));
        }
        return sourceChar;
    }

    public List<char[]> parserChar(List<CharBuffer> sourceChar){
        List<char[]> charBufferList = new ArrayList<>();
        for (CharBuffer c :sourceChar) {
            charBufferList.add(new Scanner().checkChar(c.array()));
        }
        return charBufferList;
    }

}

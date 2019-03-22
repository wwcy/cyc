package cyc.parser;

import java.nio.CharBuffer;

/**
 * Created by wcy on 2019/3/21.
 */
public class Scanner {

    private char[] buf;
    private int index;
    private int clearIndex;

    /**
     * 检测字符
     * @param chars
     * @return
     */
    public char[] checkChar(char[] chars){
        if(chars.length > 0){
            buf = chars;
            index = 0;
        }
        boolean error = false;
        do{
            if (error) break;
            char c = buf[index];

            switch (c){
                case 'A': case 'B': case 'C': case 'D': case 'E':
                case 'F': case 'G': case 'H': case 'I': case 'J':
                case 'K': case 'L': case 'M': case 'N': case 'O':
                case 'P': case 'Q': case 'R': case 'S': case 'T':
                case 'U': case 'V': case 'W': case 'X': case 'Y':
                case 'Z':
                case 'a': case 'b': case 'c': case 'd': case 'e':
                case 'f': case 'g': case 'h': case 'i': case 'j':
                case 'k': case 'l': case 'm': case 'n': case 'o':
                case 'p': case 'q': case 'r': case 's': case 't':
                case 'u': case 'v': case 'w': case 'x': case 'y':
                case 'z':
                case '$': case '_':case '@':
                case '0': case '1': case '2': case '3': case '4':
                case '5': case '6': case '7': case '8': case '9':
                case ' ': case '\r': case '\n': case '\t':
                case '{': case '}': case '[': case ']': case '(':
                case ')':
                case '\u0000': case '\u0001': case '\u0002': case '\u0003':
                case '\u0004': case '\u0005': case '\u0006': case '\u0007':
                case '\u0008': case '\u000E': case '\u000F': case '\u0010':
                case '\u0011': case '\u0012': case '\u0013': case '\u0014':
                case '\u0015': case '\u0016': case '\u0017':
                case '\u0018': case '\u0019': case '\u001B':
                case '\u007F':
                    break;
                case '/':
                    clearAnnotation();
                    break;
                default:
                    error = true;
                    System.out.println("位置"+index+"未知符号! "+c);
                    break;
            }
            index++;
        }while (index < buf.length);
        return buf;
    }

    /**
     * 清除注释
     */
    public void clearAnnotation(){
        clearIndex = index;
        do {
            char c = buf[clearIndex];
            if(c == '\r'){
                if(index == 0) {//去掉开头注释
                    int length = buf.length - clearIndex -2;
                    char[] newChars = new char[length];
                    System.arraycopy(buf,clearIndex+2,newChars,0,length);
                    buf = newChars;
                }else{//去掉中间注释
                    char[] header = new char[index];
                    int endSize = buf.length - clearIndex;
                    char[] end = new char[endSize];

                    System.arraycopy(buf,0,header,0,index);
                    System.arraycopy(buf,clearIndex,end,0,endSize);

                    buf = new char[index+endSize];
                    System.arraycopy(header,0,buf,0,index);
                    System.arraycopy(end,0,buf,index,endSize);
                }
                break;
            }else if(clearIndex == buf.length){//去掉尾注释
                char[] header = new char[index];
                System.arraycopy(buf,0,header,0,index);
                buf = new char[index];
                System.arraycopy(header,0,buf,0,index);
                break;
            }
            clearIndex++;
        }while (true);
    }
}
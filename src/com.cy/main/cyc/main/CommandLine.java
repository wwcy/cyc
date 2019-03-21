package cyc.main;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wcy on 2019/3/20.
 */
public class CommandLine {

    private static final List<String> command = Arrays.asList(
                            "-help",
                                "-version",
                                "-sourcePath"
    );

    /**
     * 命令解析
     * @param args
     * @return
     */
    public static String[] processArgs(String [] args){
        List<String> list = Arrays.asList(args).stream().filter(
                    str -> !str.isEmpty()).collect(Collectors.toList());

        Optional<List<String>> commandlistOp = Optional.ofNullable(list.stream().filter(
                    str -> str.startsWith("-")).filter(
                            str -> command.contains(str)).collect(Collectors.toList()));


        List<String> commandlist = commandlistOp.get();
        if(commandlist.size() > 0){
            //暂时提供 -help -sourcePath，两者并存，只处理第一个
            //需要优化，1、错误命令提示 2、 提供命令多的话，if else太多
            String key = commandlist.get(0);
            if(key.equals(command.get(0))){
                helpPrintln();
            }else if(key.equals(command.get(1))){
                versionPrintln();
            }else if(key.equals(command.get(2))){
                String value = list.get(list.indexOf(command.get(2))+1);
                if(!value.startsWith("-")){
                    return new String[]{value};
                }
            }
        }
        return null;
    }

    public static void versionPrintln(){
        System.out.println("cyc \"0.1\"");
    }

    public static void helpPrintln(){
        System.out.println("用法：cyc <选项> <源文件>");
        System.out.println("    -help：                      输出标准选项的提要");
        System.out.println("    -version：                   版本信息");
        System.out.println("    -sourcepath：                指定查找输入源文件的位置");
    }
}

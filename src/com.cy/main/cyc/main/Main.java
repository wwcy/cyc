package cyc.main;

import java.io.File;
import java.util.Arrays;

/**
 * Created by wcy on 2019/3/20.
 */
public class Main {

        public int compile(String[] args){
            String[] file = CommandLine.processArgs(args);
            if(file == null){
                System.out.println("参数错误！");
                return 0;
            }
            if ( !checkDirectory(file[0])){
                return 0;
            }
            new CyCompiler().compile(Arrays.asList(file));
            return 0;
        }

        private boolean checkDirectory(String value) {
            File file = new File(value);
            if (!file.exists()) {
                System.out.println("找不到文件："+value);
                return false;
            }
            if (file.isDirectory()) {
                System.out.println("不能为文件夹："+value);
                return false;
            }
            return true;
        }

}

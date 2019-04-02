package cyc.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wcy on 2019/4/2.
 */
public abstract class AbstractTree implements Tree{

    protected Map<String,String> token = Token.getCommand();


    final class ClassTree{

        private String className;//类名
        private List methods = new ArrayList();//方法列表
        //private List internals = new ArrayList();//内部类 暂不考虑








    }

    public abstract void symbolRedirect(char[] chars);

}

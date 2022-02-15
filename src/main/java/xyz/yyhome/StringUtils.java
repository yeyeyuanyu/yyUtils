package xyz.yyhome;

/**
 * @ClassName StringUtils
 * @Description TODO 字符串工具类
 * @Author yy
 * @Date 2021/12/22 21:50
 * @Version 1.0
 */

public class StringUtils {

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    /**
     * 字符串是否为空白
     * @param str
     * @return 一般认为 字符串为null或者值为空,值为null时是空白字符串，返回true
     */
    public static boolean isBlank(String str){
        return null == str || "".equals(str) || "null".equalsIgnoreCase(str);
    }

    /**
     *字符串是否为不为空白
     * @param str
     * @return
     */
    public static boolean notBlank(String str){
        return !isBlank(str);
    }
}

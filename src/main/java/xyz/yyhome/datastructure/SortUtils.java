package xyz.yyhome.datastructure;

/**
 * @ClassName SortUtils
 * @Description TODO 常用排序工具类
 * @Author yy
 * @Date 2021/12/22 23:01
 * @Version 1.0
 */

public class SortUtils {
    public static void main(String[] args) {
        sort(new String[]{"111","222"});
        sort(new Integer[]{111,222});
        sort(new Character[]{'1','2'});
    }
    public static  <T> T[] sort(T[] value ){
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i].toString());
        }
        return value;
    }
}

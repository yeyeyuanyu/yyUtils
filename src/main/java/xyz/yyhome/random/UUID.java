package xyz.yyhome.random;

import java.util.Random;

/**
 * @ClassName UUID
 * @Description TODO 生成随机字符串
 * @Author yy
 * @Date 2021/12/22 23:24
 * @Version 1.0
 */

public class UUID {

    /**
     * 使用java原生的UUID类，直接返回随机字符串
     * @return
     */
    public static String randomUUID(){
        return java.util.UUID.randomUUID().toString();
    }
}

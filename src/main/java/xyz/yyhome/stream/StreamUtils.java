package xyz.yyhome.stream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName StreamUtils
 * @Description TODO 数据流相关工具类
 * @Author yy
 * @Date 2021/12/23 22:24
 * @Version 1.0
 */

public class StreamUtils {
    public static void close(InputStream is){
        if (null != is){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(OutputStream os){
        if (null != os){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Writer w){
        if (null != w){
            try {
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Reader r){
        if (null != r){
            try {
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Socket s) {
        if (null != s){
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ServerSocket ss) {
        if (null != ss){
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

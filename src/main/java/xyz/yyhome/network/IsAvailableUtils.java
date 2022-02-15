package xyz.yyhome.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName isAvailableUtils
 * @Description TODO 测试url，ip是否可达
 * @Author yy
 * @Date 2022/1/19 21:48
 * @Version 1.0
 */

public class IsAvailableUtils {
    public static void main(String[] args) throws IOException {
        String url = "https://blog.csdn.net/qq_38819293/article/details/81570751";
        url = url.substring(url.indexOf("//")+2);
        if (url.contains("/")){
            url = url.substring(0,url.indexOf("/"));
        }
        if (url.contains(":")){
            url = url.substring(0,url.indexOf(":"));
        }
        System.out.println(url);
        InetAddress ip=InetAddress.getByName(url);
        System.out.println(ip.toString());
        System.out.println("Address:"+ip.getHostAddress());
        System.out.println("Name:"+ip.getHostName());
        if(ip.isReachable(5000)){
            System.out.println("SUCCESS - ping " + ip + " with no interface specified");
        }else{
            System.out.println("FAILURE - ping " + ip + " with no interface specified");
        }
        System.out.println(IsAvailableUtils.getIP("http://127.0.0.1:9040"));
        //IsAvailableUtils.isAddressAvailable(ip.getHostAddress());
    }
    public static String getIP(String url) {
        //使用正则表达式过滤，
        String re = "((http|ftp|https)://)(([a-zA-Z0-9._-]+)|([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}))(([a-zA-Z]{2,6})?)";
        String str = "";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(re);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        //若url==http://127.0.0.1:9040或www.baidu.com的，正则表达式表示匹配
        if (matcher.matches()) {
            str = url;
        } else {
            String[] split2 = url.split(re);
            if (split2.length > 1) {
                String substring = url.substring(0, url.length() - split2[1].length());
                str = substring;
            } else {
                str = split2[0];
            }
        }
        return str;
    }
    public static void isAddressAvailable(String ip){
        try{
            //ping this IP
            InetAddress address = InetAddress.getByName(ip);

            if(address instanceof java.net.Inet4Address){
                System.out.println(ip + " is ipv4 address");
            }else
            if(address instanceof java.net.Inet6Address){
                System.out.println(ip + " is ipv6 address");
            }else{
                System.out.println(ip + " is unrecongized");
            }

            if(address.isReachable(5000)){
                System.out.println("SUCCESS - ping " + ip + " with no interface specified");
            }else{
                System.out.println("FAILURE - ping " + ip + " with no interface specified");
            }

            System.out.println("\n-------Trying different interfaces--------\n");

            Enumeration<NetworkInterface> netInterfaces =
                    NetworkInterface.getNetworkInterfaces();
            while(((Enumeration<?>) netInterfaces).hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                System.out.println(
                        "Checking interface, DisplayName:" + ni.getDisplayName() + ", Name:" + ni.getName());
                if(address.isReachable(ni, 0, 5000)){
                    System.out.println("SUCCESS - ping " + ip);
                }else{
                    System.out.println("FAILURE - ping " + ip);
                }

                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while(ips.hasMoreElements()) {
                    System.out.println("IP: " + ips.nextElement().getHostAddress());
                }
                System.out.println("-------------------------------------------");
            }
        }catch(Exception e){
            System.out.println("error occurs.");
            e.printStackTrace();
        }
    }
}

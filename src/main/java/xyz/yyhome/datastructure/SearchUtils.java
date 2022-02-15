package xyz.yyhome.datastructure;

/**
 * @ClassName SearchUtils
 * @Description TODO 常用查找工具类
 * @Author yy
 * @Date 2021/12/22 23:03
 * @Version 1.0
 */

public class SearchUtils {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3},1));
    }
    /**
     * 二分查找，返回数组下标
     * @param arr
     * @param target
     * @return  -1表示没有找到
     */
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (left <= right){
            mid = (left+right) >> 1;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

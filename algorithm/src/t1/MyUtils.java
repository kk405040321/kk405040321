package t1;

/**
 * 工具类
 */
public class MyUtils{
    /**
     * 两个数组元素交换交换
     * @param a 数组
     * @param index1 要交换的第一个元素的下标
     * @param index2 要交换的第二个元素的下标
     */
    public static void exch(int[] a,int index1,int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    /**
     * 比较两数的大小
     * @param a1 第一个数
     * @param a2 第二个数
     * @return 前者大于等于后者返回true，否则返回false
     */
    public static boolean compare(int a1,int a2){
        return a1 >= a2;
    }

}

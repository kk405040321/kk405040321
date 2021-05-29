package t1;

/**
 * 其他算法
 */
public class OtherAlgorithm {
    /**
     * 求a1和a2的最大公约数
     * @param a1 第一个数
     * @param a2 第二个数
     * @return a1和a2的最大公约数
     */
    public static int euclid(int a1, int a2){
        if(a2==0){
            return a1;
        }
        int t = a1%a2;
        return euclid(a2,t);
    }
}

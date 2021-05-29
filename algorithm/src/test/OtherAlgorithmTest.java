package test;

import org.junit.Test;
import t1.OtherAlgorithm;

/**
 * 其他算法测试类
 */
public class OtherAlgorithmTest {

    @Test
    public void euclidTest() {
        int a1 = 54,a2 = 68;
        System.out.println(a1+"和"+a2+"的最大公约数为："+ OtherAlgorithm.euclid(a1,a2));
    }
}
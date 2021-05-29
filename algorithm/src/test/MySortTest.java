package test;

import org.junit.Before;
import org.junit.Test;

import t1.MySort;

import java.util.Arrays;

/**
 * 排序算法测试类
 */
public class MySortTest {
    int[] array = {5,9,19,3,4,7,6,10,84,21,2,66,55,47,89,52,41,47,555,20};
    int lo = 0;
    int hi = this.array.length-1;

    @Before
    public void before(){
        System.out.println("测试用例为：\n"+ Arrays.toString(array));
    }

    @Test
    public void selectSortTest() {
        MySort.selectSort(array);
    }

    @Test
    public void insertSortTestTest(){
        MySort.insertSort(array);
    }

    @Test
    public void shellSortTest(){
        MySort.shellSort(array);
    }

    @Test
    public void mergeSortTest(){
        int[] arr = {2, 3, 4, 5, 6, 7, 9, 10, 19, 21, 47, 52, 55, 66, 84, 89, 20, 41, 47, 555};
        MySort.initAux(arr.length);
        MySort.mergeSort(arr,0,16,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void topDown_MergeTest(){
        MySort.initAux(array.length);
        MySort.topDown_merge(array,lo,hi);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void bottomUp_MergeTest(){
        MySort.initAux(array.length);
        MySort.bottomUp_Merge(array,lo,hi);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void quickSortTest(){
        MySort.quickSort(array,lo,hi);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void d_quickSortTest(){
        MySort.D_quickSort(array,lo,hi);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void t_quickSortTest(){
        MySort.T_quickSort(array,lo,hi);
        System.out.println(Arrays.toString(array));
    }
}
package t1;

import java.util.Arrays;

/**
 * 排序算法
 */
public class MySort {

    /**
     * 辅助数组
     */
    private static int[] aux;

    /**
     * 初始化辅助数组
     * @param length 分配的空间大小
     */
    public static void initAux(int length){
        aux = new int[length];
    }

    /**
     *选择排序
     * @param array 要排序的数组
     */
    public static void selectSort(int[] array){
        int length = array.length;
        System.out.println("这是选择排序：");
        long startTime = System.currentTimeMillis();
        for (int i=0;i<length;i++){
            int minIndex = i;
            for (int j=i;j<length;j++){
                if (array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            MyUtils.exch(array,i,minIndex);
            System.out.println(Arrays.toString(array));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序的运行时间为："+(endTime-startTime)+"毫秒");
    }

    /**
     * 插入排序
     * @param array 要排序的数组
     */
    public static void insertSort(int[] array){
        int length = array.length;
        System.out.println("这是插入排序：");
        long startTime = System.currentTimeMillis();
        for (int i = 1;i<length;i++){
            for (int j=i;j>0;j--){
                if (array[j]<array[j-1]){
                    MyUtils.exch(array,j,j-1);
                }
            }
            System.out.println(Arrays.toString(array));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序的运行时间为："+(endTime-startTime)+"毫秒");
    }

    /**
     * 希尔排序
     * @param array 要排序的数组
     */
    public static void shellSort(int[] array){
        int length = array.length;
        System.out.println("这是希尔排序：");
        long startTime = System.currentTimeMillis();
        int h = 1;//增量h
        while (h<length/3) h=h*3+1;
        while (h>0){
            System.out.println("当前增量为："+h);
            for(int i=h;i<length;i++){
                for (int j=i;j>=h;j-=h){
                    if (array[j-h]>array[j]) MyUtils.exch(array,j,j-h);
                }
                System.out.println(Arrays.toString(array));
            }
            h/=3;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序的运行时间为："+(endTime-startTime)+"毫秒");
    }

    /**
     * 原地归并排序（将数组切分为两个数组，是这两个有序数组变成一个有序数组）
     * @param array 要排序的数组
     * @param lo 低位
     * @param hi 高位
     */
    public static void mergeSort(int[] array,int lo,int mid,int hi){
        int i = lo,j = mid+1;
        int length = array.length;
        System.arraycopy(array, 0, aux, 0, length);
        for (int k=lo;k<=hi;k++){
            if (i>mid){
                array[k] = aux[j++];
            }
            else if (j>hi){
                array[k] = aux[i++];
            }
            else if(aux[i]< aux[j]){
                array[k] = aux[i++];
            }
            else{
                array[k] = aux[j++];
            }
        }
    }

    /**
     * 自顶向下的归并排序
     * @param array 要排序的数组
     * @param lo 地位
     * @param hi 高位
     */
    public static void topDown_merge(int[] array, int lo, int hi){
        if (hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        topDown_merge(array,lo,mid);
        topDown_merge(array,mid+1,hi);
        mergeSort(array,lo,mid,hi);
    }

    /**
     * 自底向上的归并排序
     * @param array 需要排序的数组
     * @param lo 低位
     * @param hi 高位
     */
    public static void bottomUp_Merge(int[] array, int lo, int hi){
        int length = array.length;
        for (int sa=1;sa<length;sa=sa+sa){//sa为子数组的大小
            for (int index=lo;index<length-sa;index+=sa+sa){//index为每归并数组的头索引
                mergeSort(array,index,index+sa-1,Math.min(index+sa+sa-1,length-1));
            }
        }
    }

    /**
     * 原地快速排序（切分）
     * @param array 需要排序的数组
     * @param lo 低位
     * @param hi 高位
     */
    public static int quickSort(int[] array,int lo,int hi){
        int v = array[lo];
        int i = lo,j = array.length;
        while (true){
            while (array[++i]<v){if (i==hi)break;}
            while (array[--j]>v){if(j==lo)break;}
            if (i>=j){break;}
            MyUtils.exch(array,i,j);
        }
        MyUtils.exch(array,lo,j);
        return j;
    }

    /**
     * 普通快速排序
     * @param array 需要排序的数组
     * @param lo 低位
     * @param hi 高位
     */
    public static void D_quickSort(int[] array,int lo,int hi){
        if (lo>=hi){return;}
        int point = quickSort(array,lo,hi);
        D_quickSort(array,lo,point-1);
        D_quickSort(array,point+1,hi);
    }

    /**
     * 三向快速排序
     * @param array 需要排序的数组
     * @param lo 低位
     * @param hi 高位
     */
    public static void T_quickSort(int[] array,int lo,int hi){
        if (lo>=hi)return;
        int v = array[lo];
        /*
            i为检查位，lt为v相同元素的低位，gt为v相同元素的低位
            **************************
            i
            lt                      gt
            5   2   4   5   6   8   7
            ***************************
            ==>
            **************************
                    lt  gt
            2   4   5   5   6   7   8
            ***************************
         */
        int i = lo+1,lt = lo,gt = hi;
        while (i<=gt){
            if (array[i]<v){
                MyUtils.exch(array,i++,lt++);
            }
            else if (array[i]>v){
                MyUtils.exch(array,i,gt--);
            }
            else{
                i++;
            }
        }
        T_quickSort(array,lo,lt-1);
        T_quickSort(array,gt+1,hi);
    }
}

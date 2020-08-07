package com.xiaofan0408.mergetest;

import com.xiaofan0408.other.sort.SortUtil;
import com.xiaofan0408.other.sort.merge.MergeSort;
import com.xiaofan0408.other.sort.merge.MultiMergeSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author xuzefan  2020/8/4 15:27
 */
public class MergeTest {

//    lens := []int{1, 3, 5, 7, 11, 13, 17, 19, 23, 29, 1024, 1 << 13, 1 << 17, 1 << 19, 1 << 20}
//
//	for i := range lens {
//        src := make([]int64, lens[i])
//        expect := make([]int64, lens[i])
//        prepare(src)
//        copy(expect, src)
//        MergeSort(src)
//        sort.Slice(expect, func(i, j int) bool { return expect[i] < expect[j] })
//        for i := 0; i < len(src); i++ {
//            c.Assert(src[i], check.Equals, expect[i])
//        }
//    }

    private int[] lens = new int[]{1, 3, 5, 7, 11, 13, 17, 19, 23, 29, 1024, 1 << 13, 1 << 17, 1 << 19, 1 << 20};

    private int[] lens2 = new int[]{7};

    private MergeSort mergeSort = new MergeSort();

    private MultiMergeSort multiMergeSort = new MultiMergeSort();

    @Test
    public void runTest(){
        for (int i = 0;i<lens.length;i++){
            int[] src = new int[lens[i]];
            src = SortUtil.prepare(src);
            int[] expect = Arrays.copyOf(src,src.length);
            mergeSort.sort(src);
            Arrays.sort(expect);
            for (int j=0; j<src.length; j++) {
                Assert.assertEquals(src[j],expect[j]);
            }
        }
    }

    @Test
    public void runMultiTest(){
        for (int i = 0;i<lens.length;i++){
            int[] src = new int[lens[i]];
            src = SortUtil.prepare(src);
            int[] expect = Arrays.copyOf(src,src.length);
            multiMergeSort.sort(src);
            Arrays.sort(expect);
            for (int j=0; j<src.length; j++) {
                Assert.assertEquals(src[j],expect[j]);
            }
        }
    }

}

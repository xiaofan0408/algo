package com.xiaofan0408.other.sort;

import java.util.Random;

/**
 * @author xuzefan  2020/8/4 14:43
 */
public class SortUtil {

    public static int[] prepare(int[] src){
        Random random = new Random(System.currentTimeMillis());
        for (int i =0; i < src.length ;i++) {
            src[i] = random.nextInt();
        }
        return src;
    }

}

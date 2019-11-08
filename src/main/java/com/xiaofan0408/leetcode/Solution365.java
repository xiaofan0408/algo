package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/8 10:47
 */
public class Solution365 {

    public int GCD(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return GCD(n, m%n);
        }
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if ((x + y) < z) {
            return false;
        }
        return (z % GCD(x, y)) == 0;
    }

}

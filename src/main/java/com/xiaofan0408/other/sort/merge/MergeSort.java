package com.xiaofan0408.other.sort.merge;

import java.util.Arrays;

/**
 * @author xuzefan  2020/8/4 15:27
 */
public class MergeSort {

    public void sort(int[] src){
        int l = 0;
        int r = src.length - 1;
        mergeSort(l,r,src);
    }

    private void mergeSort(int l,int r,int[] src) {
        if (l == r) {
            return;
        }
        int mid = (l + r)/2;
        mergeSort(l,mid,src);
        mergeSort(mid + 1,r,src);
        merge(src,l,mid,r);
    }

    private void merge(int[] src, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(src,l, r+1);
        int left = l;
        int right = mid + 1;
        for (int k=l; k <= r; k++) {
            if (left > mid){
                src[k] = aux[right-l];
                right++;
            } else if (right > r) {
                src[k] = aux[left-l];
                left ++;
            } else if (aux[left-l] > aux[right - l]) {
                src[k] = aux[right-l];
                right++;
            } else {
                src[k] = aux[left-l];
                left++;
            }
        }
    }
}

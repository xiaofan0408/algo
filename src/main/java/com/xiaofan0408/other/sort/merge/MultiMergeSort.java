package com.xiaofan0408.other.sort.merge;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author xuzefan  2020/8/7 11:16
 */
public class MultiMergeSort {

    private ForkJoinPool forkJoinPool = new ForkJoinPool(16);

    public void sort(int[] src){
        int threads = 8;
        int l = 0;
        int r = src.length - 1;
        multiMergeSort(src,l,r,threads);
    }

    private void multiMergeSort(int[] src,int l,int r, int threadCount){
        if (threadCount <= 1) {
            mergeSort(l,r,src);
        } else {
            int mid = (l + r)/2;
            ForkJoinTask forkJoinTaskL = forkJoinPool.submit(() ->{
                multiMergeSort(src,l,mid,threadCount/2);
            });
            ForkJoinTask forkJoinTaskR = forkJoinPool.submit(() ->{
                multiMergeSort(src,mid+1,r,threadCount/2);
            });
//            Thread lThread = new Thread(() ->{
//                multiMergeSort(src,l,mid,threadCount/2);
//            });
//            Thread rThread = new Thread(() ->{
//                multiMergeSort(src,mid+1,r,threadCount/2);
//            });
//            lThread.start();
//            rThread.start();
//
//            try {
//                lThread.join();
//                rThread.join();
//            } catch (InterruptedException ie) {}
            // merge them back together
            try {
                forkJoinTaskL.get();
                forkJoinTaskR.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            merge(src,l,mid,r);
        }
    }

    private void mergeSort(int l,int r,int[] src) {
        if (l >= r) {
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

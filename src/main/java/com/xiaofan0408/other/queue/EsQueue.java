package com.xiaofan0408.other.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xuzefan  2019/7/26 15:18
 */

public class EsQueue {

    private int capaciity;
    private int capMod;
    private AtomicInteger putPos;
    private AtomicInteger getPos;
    private EsCache[] cache;


    public EsQueue(int capaciity) {
        this.capaciity = minQuantity(capaciity);
        this.capMod = this.capaciity - 1;
        this.putPos = new AtomicInteger(0);
        this.getPos = new AtomicInteger(0);
        this.cache = new EsCache[this.capaciity];
        for (int i=0;i< this.capaciity;i++) {
            this.cache[i] = new EsCache(i,i);
        }
        this.cache[0].getPutNo().set(this.capaciity);
        this.cache[0].getGetNo().set(this.capaciity);
    }

    @Override
    public String toString() {
        return String.format("Queue{capaciity: %v, capMod: %v, putPos: %v, getPos: %v}", capaciity, capMod, putPos, getPos);
    }

    private int  capaciity() {
        return capaciity;
    }

    private int Quantity()  {
        int  quantity;
        int putPos = this.putPos.get();
        int getPos = this.getPos.get();
        if (putPos >= getPos) {
            quantity = putPos - getPos;
        } else {
            quantity = this.capMod + (putPos - getPos);
        }

        return quantity;
    }

     public Result Put(Object val) {
         int putPos, putPosNew, getPos, posCnt;
         EsCache cache;
         int capMod = this.capMod;
         getPos = this.getPos.get();
         putPos = this.putPos.get();

         if (putPos >= getPos) {
             posCnt = putPos - getPos;
         } else {
             posCnt = capMod + (putPos - getPos);
         }

         if (posCnt >= capMod - 1) {
             LockSupport.parkNanos(4);
//             return new Result(false,posCnt,null);
         }

         putPosNew = putPos + 1;
         if (!this.putPos.compareAndSet(putPos, putPosNew)) {
             LockSupport.parkNanos(4);
//             return new Result(false,posCnt,null);
         }

         cache = this.cache[putPosNew & capMod];
         for (; ; ) {
             int getNo = cache.getGetNo().get();
             int putNo = cache.getPutNo().get();
             if (putPosNew == putNo && getNo == putNo) {
                 cache.setValue(val);
                 cache.getPutNo().getAndAdd(this.capaciity);
                 return new Result(true,posCnt + 1,null);
             } else {
                 LockSupport.parkNanos(4);
             }
         }
     }

    public Result Get() {
        int putPos, getPos, getPosNew, posCnt;
        Object val;
        EsCache cache;
        int capMod = this.capMod;

        putPos = this.putPos.get();
        getPos = this.getPos.get();

        if (putPos >= getPos){
            posCnt = putPos - getPos;
        } else {
            posCnt = capMod + (putPos - getPos);
        }

        if (posCnt < 1){
            LockSupport.parkNanos(4);
//            return new Result(false,posCnt,null);
        }

        getPosNew = getPos + 1;
        if (!this.getPos.compareAndSet(getPos,getPosNew)) {
            LockSupport.parkNanos(4);
//            return new Result(false,posCnt,null);
        }

        cache = this.cache[getPosNew&capMod];

        for (;;) {
            int getNo = cache.getGetNo().get();
            int putNo = cache.getPutNo().get();
            if (getPosNew == getNo && getNo == putNo-this.capaciity) {
                val = cache.getValue();
                cache.setValue(null);
                cache.getGetNo().getAndAdd(this.capaciity);
                return new Result(true,posCnt - 1,val);
            } else {
                LockSupport.parkNanos(4);
            }
        }
    }

    private int minQuantity(int v) {
        v--;
        v |= v >> 1;
        v |= v >> 2;
        v |= v >> 4;
        v |= v >> 8;
        v |= v >> 16;
        v++;
        return v;
    }
}

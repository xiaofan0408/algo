package com.xiaofan0408.other.queue;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuzefan  2019/7/26 15:17
 */

@Getter
public class EsCache {

    private AtomicInteger getNo;

    private AtomicInteger putNo;

    @Setter
    private Object value;

    public EsCache(int getNo,int putNo,Object value) {
        this.getNo = new AtomicInteger(getNo);
        this.putNo = new AtomicInteger(putNo);
        this.value = value;
    }

    public EsCache(int getNo,int putNo) {
        this(getNo,putNo,null);
    }
}

package com.xiaofan0408.other.queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xuzefan  2019/7/26 15:52
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Result {
    private boolean ok;
    private int posCnt;
    private Object value;
}
